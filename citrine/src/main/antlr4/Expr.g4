grammar Expr;

expr: expr op=(OP_MUL | OP_DIV) expr # arithmetic
	| expr op=(OP_ADD | OP_SUB) expr # arithmetic
	| INT # int
	| '(' expr ')' # parens
	;

OP_ADD: '+';
OP_SUB: '-';
OP_MUL: '*';
OP_DIV: '/';

INT: [1-9];
WS: [ \t\r]+ -> skip;
