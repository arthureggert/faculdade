; multi-segment executable file template.
; Filipe Franz Barreto e Jonathan Rodrigues Ev

data segment   ; add your data here!
    jogo db "   °   °    ",13,10
         db " 1 ° 2 ° 3  ",13,10 
         db "°°°°°°°°°°° ",13,10
         db "   °   °    ",13,10
         db " 4 ° 5 ° 6  ",13,10 
         db "°°°°°°°°°°° ",13,10
         db "   °   °    ",13,10
         db " 7 ° 8 ° 9  ",13,10
         db "   °   °    ",13,10,"$"
    pulaLinha db 13,10,"$"
    jogadorX db "Jogador 1, escolha a posisao do X...",13,10,"$"
    jogadorO db "Jogador 2, escolha a posisao do O...",13,10,"$"
    erro db "Digite apenas numeros em local valido!",13,10,"$" 
    empate db "O jogo empatou...  :(",13,10,"$" 
    sair db "Pressione uma tecla para sair...",13,10,"$" 
    X_ganhou db "Parabens jogador 1, voce venceu!",13,10,"$"
    O_ganhou db "Parabens jogador 2, voce venceu!",13,10,"$"
    
ends

stack segment
    dw   128  dup(0)
ends

code segment
start:       ; set segment registers:
    
    mov ax, data
    mov ds, ax
    mov es, ax

; add your code here
   mov al, 0  
   mov ah, 0
   int 10h  
   mov di,0 

continua: 
   call verifica
   call imprime_jogo
   call imprime_vezx 
   call procura_letra 
continua2: 
   call verifica
   call imprime_jogo
   call imprime_vezO
   call procura_letra 

verifica: 
    cmp di, 9
    je imprime_empate
    cmp di, 5
    jge verifica_vitoria
    ret

verifica_vitoria:
    mov bx, offset jogo  
    cmp [bx+15], 49
    jne verifica_2a 
    jmp verifica_4b

verifica_2a:
    mov si,[bx+15]
    cmp [bx+19],si
    je  verifica_3 
    jne verifica_4               

verifica_3:
    cmp [bx+23],si
    je  imprime_vitoria
    jne verifica_4

verifica_4:
    cmp [bx+57],si
    je verifica_7
    jne verifica_5
    
verifica_5:
    cmp [bx+61],si
    je verifica_9 
    jne verifica_4b
    
verifica_7: 
    cmp [bx+99],si
    je  imprime_vitoria 
    jne verifica_4b
    
verifica_9:
    cmp [bx+107],si
    je  imprime_vitoria
    jne verifica_4b    ;Ate aqui primeiras verificacoes

verifica_4b:
    cmp [bx+57], 52
    jne verifica_5b
    jmp verifica_2c
    
verifica_5b:
    mov si,[bx+57]
    cmp [bx+61], si   
    je  verifica_6b
    jne verifica_2c

verifica_6b:
    cmp [bx+65], si
    je  imprime_vitoria
    jne verifica_2c

verifica_2c:
    cmp [bx+19],50
    jne verifica_5c
    jmp verifica_3d

verifica_5c:
    mov si, [bx+19]
    cmp [bx+61], si
    je verifica_8c
    jne verifica_3d
      
verifica_8c:
    cmp [bx+103],si
    je  imprime_vitoria
    jne verifica_3d
                 
verifica_3d: 
    cmp [bx+23],51
    jne verifica_6d
    jmp verifica_7e

verifica_6d:
    mov si, [bx+23]
    cmp [bx+65],si
    je  verifica_9d
    jne verifica_5d
                   
verifica_5d:
    cmp [bx+61],si
    je  verifica_7d
    jne verifica_7e
                       
verifica_7d:
    cmp [bx+99],si
    je  imprime_vitoria
    jne verifica_7e
    
verifica_9d:
    cmp [bx+107],si
    je  imprime_vitoria
    jne verifica_7e  
    
verifica_7e:  
    cmp [bx+99],55
    jne verifica_8e
    ret

verifica_8e: 
    mov si, [bx+99]
    cmp [bx+103],si
    je  verifica_9e
    ret
    
verifica_9e:
    cmp [bx+107],si
    je  imprime_vitoria
    ret
     
imprime_vitoria:
    cmp si, 2058h  ;Valor do si quando tem X pegado do offset [bx+si] 
    je  vitoria_X
    jne vitoria_O
    
vitoria_X:
    mov dx, offset pulaLinha
    mov ah,9
    int 21h 
    call imprime_jogo
    mov dx, offset X_ganhou
    int 21h
    mov dx, offset pulaLinha
    int 21h
    mov dx, offset sair
    int 21h
    mov ah,1
    int 21h 
    mov ax, 4c00h ; exit to operating system.
    int 21h  

vitoria_O:
    mov dx, offset pulaLinha
    mov ah,9
    int 21h 
    call imprime_jogo
    mov dx, offset O_ganhou
    int 21h
    mov dx, offset pulaLinha
    int 21h
    mov dx, offset sair
    int 21h
    mov ah,1
    int 21h 
    mov ax, 4c00h ; exit to operating system.
    int 21h
                           
imprime_empate:
   mov dx, offset pulaLinha 
   mov ah,9
   int 21h 
   mov dx, offset pulaLinha 
   int 21h 
   mov dx, offset pulaLinha  
   int 21h
   call imprime_jogo
   mov dx, offset empate
   int 21h 
   mov dx, offset sair
   mov ah,1
   int 21h 
   mov ax, 4c00h ; exit to operating system.
   int 21h   

imprime_jogo:  
   mov dx, offset jogo 
   mov ah,9
   int 21h 
   mov dx, offset pulaLinha 
   mov ah,9
   int 21h 
   ret
   
imprime_vezX: 
   mov ch,88
   mov dx, offset jogadorX
   mov ah,9
   int 21h
   call entra_letra
   ret 

imprime_vezO:
   mov ch, 79
   mov dx, offset jogadorO
   mov ah,9
   int 21h
   call entra_letra
   ret 
   
entra_letra:  ; RETORNA EM AL o caracter teclado
    mov ah,8
    int 21h 
    mov dl, al 
    ret    
        
procura_letra:
    MOV SI,0
    MOV BX, OFFSET jogo
PROXIMA:        
    MOV CL,'$'  
    CMP [BX+SI],CL
    JE  FIM_PROCURA
    CMP [BX+SI],AL 
    JE  MOVIMENTA 
    INC SI  
    JMP PROXIMA
fim_procura:
    jmp escreve_erro                   
    
MOVIMENTA:  
    cmp al,49
    jl escreve_erro
    cmp al, 57
    jg escreve_erro 
    cmp ch,88
    je  escreveX
    jne escreveO
       
escreveX:          
    mov al, 88 
    mov [BX+SI],AL 
    inc di
    jmp continua2
    
escreveO:
    mov al, 79
    MOV [BX+SI],AL 
    inc di
    jmp continua
      
escreve_erro:
    mov dx, offset erro
    mov ah, 9
    int 21h  
    cmp ch, 88
    je continua
    jne continua2
   
ends
end start ; set entry point and stop the assembler.