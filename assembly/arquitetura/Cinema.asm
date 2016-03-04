; multi-segment executable file template.

data segment 
    filename DB 'C:\TEMP\start.txt'
    handler  DW ?
    buffer   DB 128 DUP(?)
    ; add your data here!
    pkey db "press any key...$"
ends

stack segment
    dw   128  dup(0)
ends

code segment
start:
; set segment registers:
    mov ax, data
    mov ds, ax
    mov es, ax

    ; add your code here
    
    MOV SI,0
    
    MOV AH,3DH  ; SERVICO ABRIR ARQUIVO
    MOV AL,0    ; ABRE APENAS PARA LEITURA
    MOV DX, OFFSET FILENAME ;PEGA NOME ARQUIVO
    INT 21H     ; CHAMA SERVICO D.O.S PARA ABRIR ARQUIVO
    
    MOV handler,AX  ; RETORNA EM AX HANDLER DO ARQUIVO
    
LEIA:

    MOV AH,3FH  ; SERVICO LER REGISTRO
    MOV DX, OFFSET BUFFER ; ENDERECO GUARDAR REGISTRO
    MOV CX,1 ; REGISTRO DE QUANTOS BYTES
    MOV BX, HANDLER ; INFORMA QUAL HANDLER
    INT 21H ; LE REGITRO E RETORNA NUMERO BYTES LIDOS
            ; EM AX
    CMP AX,CX
    JNE EOF
    
    MOV AL, BUFFER ; PEGA BYTE LIDO, DO BUFFER

    CMP AL,10 ; LINE FEED
    JE  CONTA_LINHAS

    JMP IMPRIME


CONTA_LINHAS:
    INC SI
    CMP SI,13
    JE  VOLTA_CURSOR_0_0
    JMP IMPRIME
        
    
VOLTA_CURSOR_0_0:

    PUSH AX
    PUSH BX
    PUSH DX
    
    MOV AH,2 ; SERVICO POSICIONA CURSOR
    MOV BH,0 ; PAGINA TEXTO
    MOV DH,0 ; LINHA 0
    MOV DL,0 ; COLUNA 0
    INT 10H
    XOR SI,SI ; ZERA SI
    
    POP DX 
    POP BX
    POP AX

IMPRIME:
        
    MOV AH,2  ;SEVICO QUE UIMPRIME CARACTER CONTIDO EM DL
    MOV DL, AL
    INT 21H
    JMP LEIA           
        
EOF:
    lea dx, pkey
    mov ah, 9
    int 21h        ; output string at ds:dx
    
    ; wait for any key....    
    mov ah, 1
    int 21h
    
    mov ax, 4c00h ; exit to operating system.
    int 21h    
ends

end start ; set entry point and stop the assembler.

