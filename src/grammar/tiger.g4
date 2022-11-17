grammar tiger;

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

ifThen: 'if' exp 'then' exp Else;

Else:
	'else' exp
	| '^'; //attention : if a then if b then c else d

whileExp: 'while' exp 'do' exp;

forExp: 'for' ID ':=' exp 'to' exp 'do' exp;

letExp: 'let' (dec)+ 'in' (exp (';' exp)*)? 'end';

fieldCreate:
	ID '=' exp; // Problème avec les règles callExp/fieldDec/lvalue

dec: typeDec | varDec | funDec;

typeDec: 'type' ID '=' type;

varDec: 'var' ID varDecFact;

varDecFact: ':=' exp | ':' TYPEID ':=' exp;

funDec:
	'function' ID '(' (fieldDec (',' fieldDec)*)? '=' exp
	| 'function' ID '(' (fieldDec (',' fieldDec)*)? ':' TYPEID '=' exp; // A factoriser

type: TYPEID | arrType | recType;

fieldDec:
	ID ':' TYPEID; // Problème avec les règles lvalue/callExp/fieldCreate

arrType: 'array of' TYPEID;

recType: '{' (fieldDec (',' fieldDec)*)? '}';

WS: [ \t\r\n]+ -> skip;
