grammar tiger;

@header {
	package main.java.parser;
}

program: exp EOF;

exp: orExp ( ':=' orExp)?;

orExp: andExp ( '|' andExp ('|' andExp)*)?;

andExp: eqExp ('&' eqExp ('&' eqExp)*)?;

eqExp: addExp ( ('=' | '<>' | '>' | '<' | '>=' | '>=') addExp)?;

addExp: multExp ( ('+' | '-') multExp)*;

multExp: simpleExp ( ('*' | '/') simpleExp)*;

simpleExp:
	seqExp
	| neg
	| idExp
	| ifThen
	| whileExp
	| forExp
	| letExp
	| INT
	| STRING
	| 'nil'
	| 'break';

idExp:
	ID (
		'(' ( exp ( ',' exp)*)? ')'
		| '[' exp ']' (( '[' exp ']' | '.' ID)* | 'of' simpleExp)
		| '.' ID ( '[' exp ']' | '.' ID)*
		| '{' ( ID '=' exp ( ',' ID '=' exp)*)? '}'
	)?;

seqExp: '(' (exp (';' exp)*)? ')';

neg: '-' simpleExp;

ifThen: 'if' exp 'then' simpleExp ('else' simpleExp)?;

whileExp: 'while' exp 'do' simpleExp;

forExp: 'for' ID ':=' exp 'to' exp 'do' simpleExp;

letExp: 'let' (dec)+ 'in' (exp (';' exp)*)? 'end';

fieldCreate:
	ID '=' exp; // Problème avec les règles callExp/ID ':' ID /lvalue

dec: typeDec | varDec | funDec;

typeDec: 'type' ID '=' type;

varDec: 'var' ID varDecFact;

varDecFact: ':=' exp | ':' ID ':=' exp;

funDec:
	'function' ID '(' (ID ':' ID (',' ID ':' ID)*)? ')' endDec;

endDec: '=' exp | ':' ID '=' exp;

type: ID | arrType | recType;

arrType: 'array of' ID;

recType: '{' (ID ':' ID (',' ID ':' ID)*)? '}';

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

fragment TEXT: [a-zA-Z0-9!?\-_.:;,/@#$%^&()={}[\]<>' ]*;

STRING: '"' TEXT '"';

COMMENT: '/*' TEXT '*/' -> skip;

WS: [ \t\r\n]+ -> skip;
