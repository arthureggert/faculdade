data segment 
    
    ZERO    DB "#####",0
            DB "#   #",0
            DB "#   #",0
            DB "#   #",0
            DB "#####","$"

    UM      DB "    #",0
            DB "   ##",0
            DB "  # #",0
            DB "    #",0
            DB "    #","$"

    DOIS    DB "#####",0
            DB "    #",0
            DB "#####",0
            DB "#    ",0
            DB "#####","$"

    TRES    DB "#####",0
            DB "    #",0
            DB "#####",0
            DB "    #",0
            DB "#####","$"

    QUATRO  DB "#   #",0     
            DB "#   #",0
            DB "#####",0
            DB "    #",0
            DB "    #","$" 

    CINCO   DB "#####",0
            DB "#    ",0
            DB "#####",0
            DB "    #",0
            DB "#####","$"

    SEIS    DB "#####",0
            DB "#    ",0
            DB "#####",0
            DB "#   #",0
            DB "#####","$"

    SETE    DB "#####",0
            DB "    #",0
            DB "    #",0
            DB "    #",0
            DB "    #","$"

    OITO    DB "#####",0
            DB "#   #",0
            DB "#####",0
            DB "#   #",0
            DB "#####","$"

    NOVE    DB "#####",0
            DB "#   #",0
            DB "#####",0
            DB "    #",0
            DB "    #","$" 
   
                                    
ends                                
stack segment
    dw   128  dup(0)
ends

code segment
start:    
; add your code here 

    MOV AX,data
    MOV DS,AX  

    MOV AH, 0      ; define modo de video 24x80
    MOV AL, 3  
    INT 10H     

    MOV AH,02H        ;request set cursor function 
    MOV BH,0          ;page 0 
    MOV DX,200FH      ;row 8 column 15 
    INT 10H 

    MOV AX,0b800H     ;SETA O DISPOSITIVO DE SAIDA
    MOV ES,AX         ;EM ES  
        
iniLoop:

    CALL getHora
    CALL convHora
    CALL impTela  
    JMP iniLoop

getHora:              ;pergunta pra BIOS a hora do sistema
    
    MOV AH,2CH
    INT 21H
    RET 
    ; a hora esta no CH
    ; os minutos  no CL
    ; os segundos no DH

convHora:
   
    POP BX
    MOV AH, 0
    MOV AL, DH
    MOV DL, 10
    DIV DL           ; agora a dezena dos segundos esta em AL e a unidade esta no AH       
    PUSH AX          ; armazena segundos na pilha    
    MOV AH, 0
    MOV AL, CL 
    MOV DL, 10
    DIV DL           ; agora a dezena dos minutos esta em AL e a unidade esta no AH.
    PUSH AX          ; armazena minutos na pilha
    MOV AH, 0
    MOV AL, CH 
    MOV DL, 10
    DIV DL           ; agora a dezena das horas esta no AL e a unidade esta em AH.
    PUSH AX          ; armazena horas na pilha
    PUSH BX
    RET    

impTela: 

    POP DX      ;pega retorno
    POP AX      ;pega dezena e unidade de horas
    POP BX      ;pega dezena e unidade de minutos
    POP CX      ;pega dezena e unidade de segundos
    PUSH DX     ;salva retorno
    PUSH CX     ;salva dezena e unidade de segundos
    PUSH BX     ;salva dezena e unidade de minutos

;como vamos utilizar as dezenas e unidade de horas,nao colocamos na pilha.

;imprime dezena da hora   
                                                    
    MOV DX,1620           ;1620 pra colocar CURSOR na linha 10 e coluna 10
    CALL capNumero   
    MOV CX,0              ;contador    
    CALL impNumero
       
;imprime unidade da hora    

    MOV AL,AH    ;move unidade que esta em ah, para al para capturar unidade da hora
    MOV DX,1634  ;1620 + 14 posicoes da memoria
                 ;pra colocar CURSOR na linha 10 e sete colunas a direita
    CALL capNumero
    MOV CX,0        
    CALL impNumero
    
;imprime dezena de minutos    
    
    POP AX                ;desempilha dezena e unidade de minutos em AX.
    MOV DX,1652           ;1634 + 18 posicoes da memoria 
                          ;pra colocar CURSOR na linha 10 e nove colunas a direita.    
    CALL capNumero    
    MOV CX,0              ;contador    
    CALL impNumero

;imprime unidade de minutos    
    
    MOV AL,AH    ;move unidade que esta em ah, para al para capturar unidade dos minutos                              
    MOV DX,1666  ;1652 + 14 posicoes da memoria 
                 ;pra colocar CURSOR na linha 10 e sete colunas a direita.    
    CALL capNumero   
    MOV CX,0              ;contador    
    CALL impNumero

;imprime dezena de segundos    

    POP AX                ;desempilha dezena e unidade de segundos em AX.  
    MOV DX,1684           ;1666 + 18 posicoes da memoria 
                          ;pra colocar CURSOR na linha 10 e nove colunas a direita
    CALL capNumero       
    MOV CX,0              ;contador     
    CALL impNumero

;imprime unidade de segundos    

    MOV AL,AH    ;move unidade que esta em ah, para al para capturar unidade dos segundos
    MOV DX,1698  ;1684 + 14 posicoes da memoria 
                 ;para colocar CURSOR na linha 10 e sete colunas a direita.
    CALL capNumero       
    MOV CX,0              ;contador     
    CALL impNumero      
    
    RET          ;fim do call impTela
            
impNumero:
    
    MOV AL,[BX]           ;move pra al o conteudo apontado por bx
    CMP AL,0              ;compara se eh final linha
    JE desceLinha        ;se eh final, pula desce linha
    
impCar:
    
    CMP AL,"$"            ;compara se eh final do numero                          
    JE fimImpNum        ;se for, pula pro fim desse processo    
    PUSH BX               ;salva o ponteiro para o numero, para liberar o bx        
    MOV BX,DX             ;move a posicao definida do cursor para bx   
    MOV ES:[BX],AL        ;move pra saida, na posicao bx o conteudo al
                          ;al contem o caracter da posicao onde esta o numero
    ADD DX,2              ;avanca 2 posicoes na memoria de video
    POP BX                ;restaura o bx que aponta o offset numero
    JMP continua
    
continua:
    
    ADD CX,1              ;incrementa contador de posicoes do offset numero
    ADD BX,1              ;incremente o ponteiro do offset
    JMP impNumero

fimImpNum:              ;retorna do imprime numero

    RET

desceLinha:
              
    ADD DX, 150           ;adiciona 150, avancando 150 posicoes de memoria de video
    JMP continua          ;pula para continua, e nao imprime caracter

capNumero:           ;verifica qual o numero a ser impresso
    CMP AL,0
    JE numero_zero
    CMP AL,1
    JE numero_um
    CMP AL,2
    JE numero_dois
    CMP AL,3
    JE numero_tres
    CMP AL,4
    JE numero_quatro
    CMP AL,5
    JE numero_cinco
    CMP AL,6
    JE numero_seis
    CMP AL,7
    JE numero_sete
    CMP AL,8
    JE numero_oito
    CMP AL,9
    JE numero_nove

fimCapNum:

    RET

numero_zero:              ;bx vai apontar para o offset do numero a ser impresso

    MOV BX,offset zero    
    JMP fimCapNum 
    
numero_um:
    
    MOV BX,offset um      
    JMP fimCapNum
    
numero_dois:
    
    MOV BX,offset dois    
    JMP fimCapNum
    
numero_tres:
    
    MOV BX,offset tres    
    JMP fimCapNum
    
numero_quatro:
    
    MOV BX,offset quatro  
    JMP fimCapNum
    
numero_cinco:
    
    MOV BX,offset cinco   
    JMP fimCapNum
    
numero_seis:
    
    MOV BX,offset seis    
    JMP fimCapNum 
    
numero_sete:        

    MOV BX,offset sete    
    JMP fimCapNum
    
numero_oito:  
  
    MOV BX,offset oito    
    JMP fimCapNum 
    
numero_nove:       

    MOV BX,offset nove    
    JMP fimCapNum
    
terminar:

    MOV ax,4c00h
    INT 21h  

ends

end start
