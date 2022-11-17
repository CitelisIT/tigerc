grammar tiger;

@header {
	package main.java.parser;
}

program: exp EOF;

exp: orExp ( ':=' orExp)?;

orExp: andExp ( '|' orExp)?;

andExp:
	eqExp ('&' andExp)?; // On doit pouvoir mieux gérer les priorités ici

eqExp: addExp ( ('=' | '<>' | '>' | '<' | '>=' | '>=') addExp)?;

addExp: multExp ( ('+' | '-') multExp)?;

multExp: simpleExp ( ('*' | '/') simpleExp)?;

simpleExp:
	seqexp
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
		| '[' exp ']' ( ( '[' exp ']' | '.' ID)* | 'of' exp)
		| '.' ID ( '[' exp ']' | '.' ID)*
		| '{' ( ID '=' exp ( ',' ID '=' exp)*)? '}'
	)?;

seqexp: '(' (exp (';' exp)*)? ')';

neg: '-' exp;

ifThen: 'if' exp 'then' exp elseRule;

elseRule:
	'else' exp
	| '^'; //attention : if a then if b then c else d

whileExp: 'while' exp 'do' exp;

forExp: 'for' ID ':=' exp 'to' exp 'do' exp;

letExp: 'let' (dec)+ 'in' (exp (';' exp)*)? 'end';

fieldCreate:
	ID '=' exp; // Problème avec les règles callExp/ID ':' ID /lvalue

dec: typeDec | varDec | funDec;

typeDec: 'type' ID '=' type;

varDec: 'var' ID varDecFact;

varDecFact: ':=' exp | ':' ID ':=' exp;

funDec:
	'function' ID '(' (ID ':' ID (',' ID ':' ID)*)? ')' '=' exp
	| 'function' ID '(' (ID ':' ID (',' ID ':' ID)*)? ')' ':' ID '=' exp; // A factoriser

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

STRING: '"' [a-zA-Z0-9!?\-_.:;,]* '"';

WS: [ \t\r\n]+ -> skip;
