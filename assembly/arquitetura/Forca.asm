; multi-segment executable file template.
extra segment
    palavra db "ABACAXI$"
ends

data segment
    ;tracos para a palavra, 13,10 para quebrar linha e "$" para identificar final de palavra 
    tracos db "_______",13,10,"$" 
    MENSAGEM DB "Digite uma tecla",13,10,"$"
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
    mov ax, extra
    mov es, ax      
 
 ;add your code here
    
    MOV CH,0 ;CONTADOR DE ACERTOS 
    
NOVO_CICLO:

    MOV DI, OFFSET PALAVRA
                            
    MOV AH,9
    MOV DX, OFFSET TRACOS           
    INT 21H
    
    CMP CH,7
    JE FINAL

    MOV AH,9
    MOV DX, OFFSET MENSAGEM
    INT 21H                   

    MOV AH,7   ;le a tecla e retorna em AL
    INT 21H    
                          
COMPARA:
    MOV AH,ES:[DI] 
    CMP AH,"$"
    JE SAI  
    CMP AL,AH
    JE TRANSFERE 
    INC DI
    JMP COMPARA
           
                 
TRANSFERE:
    CMP DS:DI,AL
    JE NAO_INCREMENTA_ACERTOS
    INC CH
NAO_INCREMENTA_ACERTOS:
    MOV DS:[DI],AL   
    INC DI
    JMP COMPARA                     
                 
SAI: 
    JMP NOVO_CICLO

FINAL:  

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
