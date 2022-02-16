grammar Grammar;

s : name body ;
body : line* ;
name : 'grammar' Name ';';
line : left ':' right ';' ;
left : RuleName Args? ;
right : term ('|' term)* ;
term : (left | Literal | Action)* ;

Name : [A-Z][a-z0-9]* ;
RuleName : [a-z][a-z0-9]* ;
Literal : '\'' ('\\\'' | ~['])* '\'' ;
Action : '{' (~[{}]+ | '{' Action '}')+ '}' ;
Args : '[' (~[[\]]+ | '[' Args ']')+ ']' ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
COMMENT : '#' ~[\r\n]* '\r'? '\n' -> skip ; //skip comments