.include "errors.s"

.data
	random_buffer:.space 32
	printi_buffer:.space 1024
	stdin_buffer:.space 1024
	RETURNLINE: .asciz "\n" 

.text


@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@ 		BUILT IN FUNCTIONS                  @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


@OK
exit:
	mov	r11,r13
	LDR	r0,[r11,#4]
	mov	r7,#1
	swi	#0

chr:
	PUSH 		{r0,r11,LR} 		
	MOV		R11,R13

	MOV			R0,#2
	PUSH		{R0}
	BL			malloc

	LDR		R0,[r11,#4*3]
	CMP		R0,#0
	Blt		ERROR_wrong_acii_code
	CMP		R0,#127
	Bgt		ERROR_wrong_acii_code

	STRb		R0,[R8]

	MOV		R13,R11
	POP		{r0,r11,PC} 


@OK
not:	
	PUSH 		{r0,r11,LR} 		
	MOV		R11,R13
	
	LDR		R0,[r11,#4*3] 
	
	CMP		R0,#0
	MOVEQ		R8,#1
	MOVNE		R8,#0

	MOV		R13,R11
	POP		{r0,r11,PC} 



@OK
getrandom:
	PUSH	{r0,r1,r2,r3,r4,r11,LR} 			
	MOV	R11,R13

	LDR	R3,[r11,#4*8]	@ R3 : arg1=inf 	
	LDR	R4,[r11,#4*7]	@ R4 : arg2=sup
	ADD	R4,R4,#1

	CMP	R3,R4
	BGT	ERROR_getrandom_invalid_bound

	
	SUB	R4,R4,R3	@ R4 : sup - inf

	
	@ syscall getrandom( r0:buffer, r1:buffer_len, r2:flag) 
	
	LDR	r0,=random_buffer 
	mov	r1,#4
	mov	r2,#0
	mov	r7,#384

	swi	#0
	
	LDR	r0,=random_buffer 
	
	@ x = r8%(sup - inf) + inf	

	LDR	r8,[r0]		@ charge la valeur de retour du syscall dans r8

	@ appel de la fonction modulo

	PUSH	{r8}		
	PUSH	{r4}		
	BL	modulo
	

	@ ajout de la borne inf

	ADD	r8,r8,r3
	
	MOV	R13,R11	
	POP	{r0,r1,r2,r3,r4,r11,PC} 				



@OK
getchar:
	PUSH 		{r0,r1,r2,r11,LR} 		
	MOV		R11,R13
	
	
	mov		r0,#0
	LDR		r1,=stdin_buffer	
	mov		r2,#1024
	mov		r7,#3

	SWI		#0

	MOV			R0,#2
	PUSH		{R0}
	BL			malloc

	LDRb		r0,[r1]
	STRb		r0,[r8]

	MOV		R13,R11
	POP		{r0,r1,r2,r11,PC} 

@OK
ord:
	PUSH 		{r0,r1,r2,r11,LR} 		
	MOV		R11,R13
	
	LDR		r0,[r11,#4*5]
	LDRb		r8,[r0]

	MOV		R13,R11
	POP		{r0,r1,r2,r11,PC} 






@OK
printi:
	PUSH	{r0,r1,r2,r11,LR} 			
	MOV	R11,R13
		
	LDR	R0,[r11,#4*5]	@ R0=n : entier a print
	LDR	R1,=printi_buffer
	
	PUSH	{r0,r1}
	BL	int2string

	PUSH	{r1}
	BL	print

	MOV	R13,R11	
	POP	{r0,r1,r2,r11,PC} 				





@OK
int2string:
	
	PUSH	{r0,r1,r2,r3,r4,r5,r11,LR} 		
	MOV	R11,R13
	
	LDR	R0,[r11,#4*8]	@ R0=n : entier en parametre
	LDR	R4,[r11,#4*9]	@ R4=@buffer
	
	mov	R2,#0
	
	CMP	R0,#0
	SUBlt	R0,R2,R0
	MOVlt	R1,#'-'
	STRltb	r1,[R4],#1


	MOV	R5,R4
	MOV	R3,#10


	loopi2str:
	
		PUSH	{r0,r3}
		SUB	R13,#8

		BL	divide

		POP	{r0,r1}
		ADD	R13,#8

		ADD	r1,#'0'
		STRb 	r1,[R4],#1

		CMP	R0,#0
		BNE	loopi2str


	STRb 	r2,[R4],#1

	PUSH	{r5}
	BL	flip
		
	MOV	R8,R5
	
	MOV	R13,R11	
	POP	{r0,r1,r2,r3,r4,r5,r11,PC} 				






divide:
	PUSH	{r0,r1,r2,r3,r11,LR} 		
	MOV	R11,R13	
	
	LDR	R0,[r11,#4*8]	@ r0 : deuxieme arg
	LDR	R1,[r11,#4*9] 	@ r1 : premier arg


	mov	r2,#0		@ R2 : loop counter & Zero-value register for sign compute
	MOV	R3,#0		@ R3 : signe du résultat	


	@ Recuperation du signe dans R3 : 
	@ + -> 0
	@ - -> 1
	
	CMP	r1,#0
	Beq	ERROR_divide_by_zero
	MOVlt	R3,#1
	SUBlt	R1,R2,R1


	CMP	r0,#0
	EORlt	R3,R3,#1
	SUBlt	R0,R2,R0



	@ division : r0/r1			
	

	loop:	
		cmp	r0,r1
	    	addge	r2,r2,#1
	    	subge	r0,r0,r1
	   	bgt	loop


	SUBs	R3,#1
	SUBeq	R2,R3,R2	


	STR	R0,[r11,#4*7]	@ 1er retour : r0%r1
	STR	R2,[r11,#4*6]	@ 2em retour : r0/r1
		

	MOV	R13,R11	
	POP	{r0,r1,r2,r3,r11,PC} 	
	

@OK
modulo:
	PUSH	{r0,r1,r2,r3,r11,LR} 		
	MOV	R11,R13	
	
	LDR	R0,[r11,#4*7]	@ r0 : premier arg
	LDR	R1,[r11,#4*6] 	@ r1 : deuxieme arg


	mov	r2,#0		@ R2 : loop counter & Zero-value register for sign compute
	MOV	R3,#0		@ R3 : signe du résultat	


	@ Recuperation du signe dans R3 : 
	@ + -> 0
	@ - -> 1
	
	CMP	r1,#0
	Beq	ERROR_divide_by_zero
	MOVlt	R3,#1
	SUBlt	R1,R2,R1


	CMP	r0,#0
	EORlt	R3,R3,#1
	SUBlt	R0,R2,R0



	@ division : r0/r1			
	

	loop_Modulo:	
		cmp	r0,r1
	    	addge	r2,r2,#1
	    	subge	r0,r0,r1
	   	bgt	loop_Modulo


	SUBs	R3,#1
	SUBeq	R2,R3,R2	


	MOV	R8,R0		@ retour : r0%r1
		

	MOV	R13,R11	
	POP	{r0,r1,r2,r3,r11,PC} 	
	

@OK
flip:
	PUSH 		{r0,r1,r2,r3,r4,r11,LR} 		
	MOV		R11,R13
		
	LDR		r0,[r11,#4*7]	

	PUSH		{r0}

	BL		strlen

	MOV		R1,R8

	SUB		r1,r1,#1	@ n-1
	MOV		r2,#0		@ 0

    loopflip:
	    
	    CMP		R1,R2
	    Blt		endflip
	    
	    
	    LDRb		R3,[r0,r1]		
	    LDRb		R4,[r0,r2]		
	    
	    STRb		R4,[r0,r1]		
	    STRb		R3,[r0,r2]		

	    SUB		R1,R1,#1
	    ADD		R2,R2,#1


	    B		loopflip	

endflip:	
	MOV		R13,R11
	POP		{r0,r1,r2,r3,r4,r11,PC} 





@OK
strcmp:
	PUSH 		{r0,r1,r2,r3,r4,r11,LR} 		
	MOV		R11,R13

	LDR		r0,[r11,#4*7]	
	LDR		r1,[r11,#4*8]	

    	loopstrcmp:
	    
	    	
	    	LDRb		R3,[r0],#1		
		LDRb		R4,[r1],#1	
	   
	    	MULs		R2,R3,R4	
	    	Beq		endstrcmp	@ if R3 = 0 or R4 = 0
		CMP		R3,R4
	    	Beq		loopstrcmp	@ if R3 == R4
	
endstrcmp:	

	CMP		R3,R4
	MOVeq		R8,#0		@ r0 == r1
	MOVlt		R8,#-1		@ r0 < r1 
	MOVgt		R8,#1		@ r0 > r1

	
	MOV		R13,R11
	POP		{r0,r1,r2,r3,r4,r11,PC} 





@OK
print:
	PUSH 		{r0,r1,r2,r7,r8,r11,LR} 		
	MOV		R11,R13
	
	LDR		r1,[r11,#4*7]	
	
	PUSH		{r1}

	BL		strlen

	MOV		R2,R8
	
	mov		r0,#1
	mov		r7,#4

	SWI		#0	
	
	MOV		R13,R11
	POP		{r0,r1,r2,r7,r8,r11,PC} 



@OK
printer:
	PUSH 		{r0,r1,r2,r7,r8,r11,LR} 		
	MOV		R11,R13
	
	LDR		r1,[r11,#4*7]	
	
	PUSH		{r1}

	BL		strlen

	MOV		R2,R8
	
	mov		r0,#2
	mov		r7,#4

	SWI		#0	
	
	MOV		R13,R11
	POP		{r0,r1,r2,r7,r8,r11,PC} 



@OK
size:		
	PUSH 		{r0,r1,r2,r11,LR} 		
	MOV		R11,R13
		
	LDR		r0,[r11,#4*5]	
	mov		r8,#0

    _loopSize:
	    LDRb	R2,[r0],#1
	    cmp		r2,#0
	    addne	r8,r8,#1
	    bne		_loopSize


	MOV		R13,R11
	POP		{r0,r1,r2,r11,PC} 





@OK
strlen:		
	PUSH 		{r0,r1,r2,r11,LR} 		
	MOV		R11,R13
		
	LDR		r0,[r11,#4*5]	
	mov		r8,#0

    loopC:
	    LDRb	R2,[r0],#1
	    cmp		r2,#0
	    addne	r8,r8,#1
	    bne		loopC


	MOV		R13,R11
	POP		{r0,r1,r2,r11,PC} 



@OK
malloc:		
	PUSH 		{r0,r1,r7,r11,LR} 		
	MOV		R11,R13

	@ Recupere le heap pointer dans R0	
	MOV		R0,#0
	MOV		R7,#45
	swi		#0
	
	MOV		R1,R0	
	
	@ Charge la taille de memoire à allouer dans R0		
	LDR		R0,[r11,#4*5]	 	
	
	@ Calcul la nouvelle adresse dans r0  
	ADD		R0,R0,R1		
	
	@ MAJ la heap pointer pour reserver la memoire
	MOV		R7,#45
	swi		#0

	@ retourne l adresse de debut de la zone reserve
	MOV		R8,R1	
	
	MOV		R13,R11
	POP		{r0,r1,r7,r11,PC} 

