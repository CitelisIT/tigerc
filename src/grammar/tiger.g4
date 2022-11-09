grammar tiger;

program: exp EOF;

exp:
	lvalue
	| seqexp
	| neg
	| callExp
	| infixExp
	| arrCreate
	| recCreate
	| assign
	| ifThen
	| whileExp
	| forExp
	| letExp
	| 'break'
	| 'nil'
	| INT
	| STRING; // Problème avec les règles assign/subscipt/fieldExp/

lvalue:
	ID
	| subscript
	| fieldExp; // Problème avec les règles callExp/fieldCreate/fieldDec

seqexp: '(' (exp (';' exp)*)? ')';

neg: '-' exp;

callExp:
	ID '(' (exp (';' exp)*)? ')'; // Problème avec les règles fieldCreate/fieldDec/lvalue

infixExp:
	exp INFIXOP exp; // Diviser cette règle pour chaque INFIXOP ? + problème avec la règle program

arrCreate:
	TYPEID '[' exp ']' 'of' exp; // Problème avec les règles recCreate/type

recCreate:
	TYPEID '{' (fieldCreate (';' fieldCreate)*) '}'; // Problème avec les règles arrCreate/type

assign:
	lvalue ':=' exp; // Problème avec les règles exp/subscript/fieldExp

ifThen: 'if' exp 'then' exp Else;

Else:
	'else' exp
	| '^'; //attention : if a then if b then c else d

whileExp: 'while' exp 'do' exp;

forExp: 'for' ID ':=' exp 'to' exp 'do' exp;

letExp: 'let' (dec)+ 'in' (exp (';' exp)*)? 'end';

subscript:
	lvalue '[' exp ']'; // Problème avec les règles fieldExp/exp

fieldExp:
	lvalue '.' ID; // Problème avec les règles subscript/exp

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
