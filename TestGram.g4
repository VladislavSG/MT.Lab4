grammar TestGram;

s : a {System.out.println($a::res)} ;
a locals[Integer res = 7] : ;

ID : [a-z]+ ;
INT : [0-9]+ ;
WS : [ \t\r\n]+ -> skip ;