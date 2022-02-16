grammar TestGram;

s : {int x = 2fa} gg[xafds, !@#&( f] ;
gg[int res] : {System.out.println(res)} ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
COMMENT : '#' ~[\r\n]* '\r'? '\n' -> skip ; //skip comments