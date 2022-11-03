grammar tiger;

program : exp EOF;

exp : lvalue | seqexp | neg | callExp | infixExp | arrCreate | recCreate | assign | ifThenElse | ifThen | whileExp | forExp | letExp | BREAK | NIL | INT | STRING;

lvalue : ID | subscript | fieldExp;

seqexp : '(' (exp (';' exp)*)? ')'; 

neg : '-' exp;

callExp : ID '(' (exp (';' exp)*)? ')';

infixExp : exp INFIXOP exp; // Diviser cette règle pour chaque INFIXOP ? 

arrCreate : TYPEID '[' exp ']' 'of' exp; 

recCreate : TYPEID '{' (fieldCreate (';' fieldCreate)*) '}';



