; multi-segment executable file template.

data segment
    ; add your data here!
    pkey db "press any key...$"
    cr_lf db 13,10,"$"
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
    mov al,0
INCREM:              
    call print_al     
    call pula_linha
    cmp al,255
    jz FIM             
    inc al
    jmp INCREM
    
FIM:
    lea dx, pkey
    mov ah, 9
    int 21h        ; output string at ds:dx
        
    ; wait for any key....    
    mov ah, 1
    int 21h
    
    mov ax, 4c00h ; exit to operating system.
    int 21h 
    
    print_al proc
cmp al, 0
jne print_al_r
    push ax
    mov al, '0'
    mov ah, 0eh
    int 10h
    pop ax
    ret 
print_al_r:    
    pusha
    mov ah, 0
    cmp ax, 0
    je pn_done
    mov dl, 10
    div dl    
    call print_al_r
    mov al, ah
    add al, 30h
    mov ah, 0eh
    int 10h    
    jmp pn_done
pn_done:
    popa  
    ret   
    
pula_linha:
    push ax
    mov ah,9
    mov dx, OFFSET cr_lf
    int 21h     
    pop ax
    ret    

ends

end start ; set entry point and stop the assembler.
