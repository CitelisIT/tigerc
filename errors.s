.data    
	ERROR_MESSAGE_divide_by_0: .asciz "ERROR : divide by 0 \n" 
	ERROR_MESSAGE_wrong_ascii_code: .asciz "ERROR : chr : the integer parameter must be a positiv value between 0 and 127 \n" 
	ERROR_MESSAGE_index_out_of_range: .asciz "ERROR : index out of range \n" 
	ERROR_MESSAGE_getrandom_invalid_bound: .asciz "ERROR : getrandom : invalid bounds, superior bound should be greater than the lower one \n" 


.text


ERROR_getrandom_invalid_bound:
	
	LDR	r0,=ERROR_MESSAGE_getrandom_invalid_bound
	PUSH	{r0}
	BL	printer
	
	@ exit with error : return value = 1

	MOV	r0,#1	
	PUSH	{r0}
	BL	exit 

ERROR_index_out_of_range:
	
	LDR	r0,=ERROR_MESSAGE_index_out_of_range
	PUSH	{r0}
	BL	printer
	
	@ exit with error : return value = 1

	MOV	r0,#1	
	PUSH	{r0}
	BL	exit	
 
ERROR_divide_by_zero:
	
	LDR	r0,=ERROR_MESSAGE_divide_by_0
	PUSH	{r0}
	BL	printer
	
	@ exit with error : return value = 1

	MOV	r0,#1	
	PUSH	{r0}
	BL	exit

ERROR_wrong_acii_code:
	
	LDR	r0,=ERROR_MESSAGE_wrong_ascii_code
	PUSH	{r0}
	BL	printer
	
	@ exit with error : return value = 1

	MOV	r0,#1	
	PUSH	{r0}
	BL	exit