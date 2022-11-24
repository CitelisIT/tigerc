grammar tiger;

@header {
package parser;
}

program: exp EOF;

exp: first=orExp ( ':=' right+=orExp)?;

orExp: first=andExp ( '|' right+=andExp ('|' right+=andExp)*)?;

andExp: first=eqExp ('&' right+=eqExp ('&' right+=eqExp)*)?;

eqExp: first=addExp ( ops+=('=' | '<>' | '>' | '<' | '>=' | '>=') right+=addExp)?;

addExp: first=multExp ( ops+=('+' | '-') right+=multExp)*;

multExp: first=simpleExp ( ops+=('*' | '/') right+=simpleExp)*;

simpleExp:
	seqExp
	| neg
	| idExp
	| ifThen
	| whileExp
	| forExp
	| letExp
	| litteralExp;

litteralExp: 
	INT 			#IntLitteral
	| STRING 		#StringLitteral
	| 'nil'			#NilLitteral
	| 'break'		#BreakLitteral
;

idExp:
	idName=ID ( exprEnd=idEndExp )?;

idEndExp: 
	callExp
	| bracketExp
	| recAccessExp
	| recCreateExp 
	;

callExp: '(' ( args+=exp ( ',' args+=exp)*)? ')' ;

bracketExp:
	'[' accessExpr=exp ']' ( exprEnd=bracketExpEnd)*;

bracketExpEnd:
	access							#BracketExpAccess
	| 'of' arrTypeExp=simpleExp 	#ArrCreateEnd
	;

access:
	'[' accessExpr=exp ']'	#ArrayAccess
	| '.' accessId=ID		#RecordAccess
	;

recAccessExp: '.' accessId=ID ( succAccess=access )*;

recCreateExp: '{' ( fieldIds+=ID '=' fieldValues+=exp ( ',' fieldIds+=ID '=' fieldValues+=exp)*)? '}';	

seqExp: '(' (exprs+=exp (';' exprs+=exp)*)? ')';

neg: '-' expr=simpleExp;

ifThen: 'if' condition=exp 'then' thenExpr=simpleExp ('else' elseExpr=simpleExp)?;

whileExp: 'while' condition=exp 'do' doExpr=simpleExp;

forExp: 'for' forId=ID ':=' startValue=exp 'to' endValue=exp 'do' doExp=simpleExp;

letExp: 'let' (decls+=dec)+ 'in' (inExprs+=exp (';' inExprs+=exp)*)? 'end';

fieldCreate:
	fieldId=ID '=' fieldExpr=exp; 

dec: typeDec | varDec | funDec;

typeDec: 'type' typeId=ID '=' typeValue=type;

varDec: 'var' varId=ID varValue=varDecEnd;

varDecEnd:
	':=' expr=exp 					#VarDecNoType
	| ':' typeId=ID ':=' expr=exp	#VarDecWithType
	;

funDec:
	'function'
	functionId=ID '(' (argNames+=ID ':' argTypes+=ID (',' argNames+=ID ':' argTypes+=ID)*)? ')'
	functionBody=funEndDec;

funEndDec:
	'=' expr=exp					#FunDecNoType
	| ':' typeId=ID '=' expr=exp	#FunDecWithType
	;

type:
	ID 			
	| arrType	
	| recType	
	;

arrType: 'array of' typeId=ID;

recType: '{' (fieldIds+=ID ':' filedTypes+=ID (',' fieldIds+=ID ':' fieldTypes+=ID)*)? '}';

KEYWORD:
	'array'
	| 'break'
	| 'do'
	| 'else'
	| 'end'
	| 'for'
	| 'function'
	| 'if'
	| 'in'
	| 'let'
	| 'nil'
	| 'of'
	| 'then'
	| 'to'
	| 'type'
	| 'var'
	| 'while';

ID: [a-zA-Z][a-zA-Z0-9_]*;

INT: [0-9]+;

fragment TEXT: [a-zA-Z0-9!?\-_.:;,/@#$%^&()={}[\]<>'| ]*;

STRING: '"' ( '\\' [tnr"'\\] | ~[\r\n\\"] )* '"';

COMMENT: '/*' TEXT '*/' -> skip;

WS: [ \t\r\n]+ -> skip;
