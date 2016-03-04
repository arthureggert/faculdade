; multi-segment executable file template.

data segment
    ; add your data here!
rilf db 0 ;rotaciona direita ou esquerda (0 = esquerda, 1 = direita)
rlef db 0 ;numero rotacoes direita
rrig db 0 ;numero rotacoes esquerda
clef db 0 ;numero rotacoes canhao esquerda
crig db 0 ;numero rotacoes canhao direita

ovni db "      +      -      /      \      %                                             "
     db "     +*+    -*-    /*/    \*\    %*%                                            "
     db "      +      +      /      \      %                                             ","$"

canh db "                                                                                "
     db "                                      __^__                                     "
     db "                                      |   |                                     ","$"

qnt_interrupts db 0
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

    ; seta video para 80x25
    mov ah, 0
    mov al, 3
    int 10h
    
    ;apaga tela
    CALL CLRSCR               
                       
;desenha ovni
    MOV AH,2  ; POSICIONA CURSOR
    MOV BH,0
    MOV DH,0 ; LINHA  1
    MOV DL,0 ; COLUNA 1
    INT 10H
    
    mov dx,offset ovni
    mov ah,9
    int 21h
    
;desenha canhao

    call desenha_canhao
            
;valores iniciais para variaveis

    mov al,0
    mov qnt_interrupts,al

    mov al,1
    mov byte ptr rilf,al ; indica rotacao direita
   
    mov al,0
    mov byte ptr rlef,al ; quantidade rotacoes esquerda       
    mov al,0
    mov byte ptr rrig,al ; quantidade rotacoes direita
    
        
    ;mov ax, 4c00h ; exit to operating system.
    ;int 21h    

    ; seta es para segmento "0000":
    mov ax, 0       
    mov es, ax
    ; calcula endereco vetor para interrucao hardware 1ch (TIMER TICK, 18.2 TIMES SECOND)
    mov al, 1ch    
    ; multiplique 1ch por 4, guarde resultado em AX
    mov bl, 4h       
    mul bl          
    mov bx, ax
    ; copie offset dentro do vetor de interrupcao
    mov si, offset [Timer_Stick]
    mov es:[bx], si
    add bx, 2   
    ; copie segmento dentro do vertor de interrupcao
    mov ax, cs     
    mov es:[bx], ax

;/////////////////////////////////////////////
;thead principal
;/////////////////////////////////////////////

wait_for_key:

; check for keystroke in
; keyboard buffer:
        mov     ah, 1
        int     16h
        jz      wait_for_key
; get keystroke from keyboard:
; (remove from the buffer)
        mov     ah, 0
        int     16h
; press 'E' ou 'e' para sair
        cmp     al, 'E'
        jz      exit  
        cmp     al, 'e'
        jz      exit  
        jmp     wait_for_key
exit:
        mov ax, 4c00h ; exit to operating system.
        int 21h    

; tratador de interrupcao 1ch se encontra aqui...
Timer_Stick: 
       pusha  ; salve todos os registradores

       inc byte ptr qnt_interrupts
       mov al,4 ; 0.25 segundos
       cmp byte ptr qnt_interrupts,al
       jne stop

       mov al,0
       mov qnt_interrupts,al

; set segment register to video memory:
       mov     ax, 0b800h
       mov     es, ax

       mov al,0                     ;compara se deve rotacionar direita ou esquerda
       cmp byte ptr rilf,al         ;1 = right, 0 = left
       je left
       jmp right

left:
      mov di, 0        ; ponteiro para offset 0 do segmento video b800h
      
rotaciona_left:
      mov al,es:[di+2] ;pega conteudo apontado por offset posterior
      mov es:[di],al   ;e joga na posicao atual
      add di,2         ;avanca 2 posicoes
      cmp di,478       ;avancou 3 linhas = 3*160
      je inc_left      ;verifique se rotacionou tudo 40 vezes
      jmp rotaciona_left

inc_left:
       inc byte ptr rlef ; soma uma rotacao esquerda
       mov al,40         ;verifique se rotacionou tudo 40 vezes
       cmp byte ptr rlef,al
       je rotacionou_40_vezes_left ;se rotacionou 40 vezes...
       jmp stop

rotacionou_40_vezes_left:
       mov al,0        ; zera contador
       mov byte ptr rlef,al
       
       mov al,1
       mov byte ptr rilf,al ; indica rotacao direita...       
       
       jmp stop
       
right:
      mov di, 478      ; ponteiro para offset 378 do segmento video b800h
      
rotaciona_right:
      mov bx,di
      sub bx,2
      mov al,es:[bx] ;pega conteudo apontado por offset anterior
      mov es:[di],al   ;e joga na posicao atual
      sub di,2         ;volta 2 posicoes
      cmp di,0         ;voltou 3 linhas = 3*160
      je inc_right      ;verifique se rotacionou tudo 40 vezes
      jmp rotaciona_right

inc_right:
       inc byte ptr rrig ; soma uma rotacao direita
       mov al,40         ;verifique se rotacionou tudo 40 vezes
       cmp byte ptr rrig,al
       je rotacionou_40_vezes_right ;se rotacionou 40 vezes...
       jmp stop

rotacionou_40_vezes_right:
       mov al,0        ; zera contador
       mov byte ptr rrig,al
       
       mov al,0
       mov byte ptr rilf,al ; indica rotacao esquerda...       
              
stop:
       popa  ; re-store all registers.
       iret  ; return from interrupt.
       
      
CLRSCR:
        MOV AX,0B800H
        MOV ES,AX
        MOV DI,0
APAGANDO:
        MOV AL," "
        MOV ES:[DI],AL
        ADD DI,2
        CMP DI, 3840   ; 24X80 + ATRIBUTO DE COR PARA CADA BYTE
        JG SAI
        JMP APAGANDO
SAI:        
        RET


desenha_canhao:
        MOV AX,0B800H
        MOV ES,AX
        MOV DI,3520  ; 22x160
        MOV SI,offset canh
imprime_canhao:
        MOV al,[si]           ; imprime ate achar "$" 
        cmp al,"$"
        je sai_canhao
        mov es:[di],al
        add di,2
        inc si
        jmp imprime_canhao
sai_canhao:        
        ret

ends

end start ; set entry point and stop the assembler.