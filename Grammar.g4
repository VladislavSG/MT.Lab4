grammar Grammar;

s : name body ;
body : line* EOF ;
name : 'grammar' Name ';' ;
lexem : Name ':' (Literal | Range) ;
line : (pravilo | lexem) ';';
pravilo : left (Local Args)? ':' right;
left : NTerminal Args? ;
right : term ('|' term)* ;
term : (left | Literal | Action | Name)* ;

Range : '!\'' (~['] | '\\\'')+ '\'' ;
Local : 'local' ;
Name : [A-Z][a-z0-9]* ;
NTerminal : [a-z][a-z0-9]* ;
Literal : '\'' ('\\\'' | ~['])+ '\'' ;
Action : '{' (~[{}]+ | '{' Action '}')+ '}' ;
Args : '[' (~[[\]]+ ('[' Args ']')?)+ ']';

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
COMMENT : '#' ~[\r\n]* '\r'? '\n' -> skip ; //skip comments