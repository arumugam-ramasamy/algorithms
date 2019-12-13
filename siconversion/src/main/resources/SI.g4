grammar SI;

expr : '(' expr ')' | expr op=(OP_MUL | OP_DIV) expr | TOKEN ;
TOKEN : MIN | HOUR | DAY | DEG | ARCMIN | ARCSEC | HEC | LIT | TON ;

OP_MUL : '*' ;
OP_DIV : '/' ;

MIN : 'minute' | 'min' ;
HOUR : 'hour' | 'h' ;
DAY : 'day' | 'd' ;
DEG : 'degree' |  'o' ;
ARCMIN : 'arcminute' | '\'' ;
ARCSEC : 'arcsecond' | '"' ;
HEC : 'hectare' | 'ha' ;
LIT : 'litre' | 'L' ;
TON : 'tonne' | 't' ;
WS: [ \t]+ -> skip;