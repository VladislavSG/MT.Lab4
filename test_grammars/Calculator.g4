grammar Calculator;

e[Integer res] : {Integer a = 0;} s[a] s0[a] {res = a};

s0[Integer a] : '+' {Integer next = 0;} s[next] {a += next;} s0[a] | ;
s[Integer res] : {Integer b = 1;} m[b] m0[b] {res += b;} ;

m0[Integer a] : '*' {Integer b = 1;} m[b] {a *= b;} m0[a] | ;
m[Integer res] : {res = 0;} int0[res]
               | '(' e[res] ')' ;

int0[Integer res] : {Integer f;} digit[f] int1[f, res];
int1[Integer pref, Integer res] : {Integer f;} digit[f] {pref = pref * 10 + f} int1[pref, res]
                                | {res = pref} ;
digit[Integer res] : '0' {res = 0;}
                   | '1' {res = 1;}
                   | '2' {res = 2;}
                   | '3' {res = 3;}
                   | '4' {res = 4;}
                   | '5' {res = 5;}
                   | '6' {res = 6;}
                   | '7' {res = 7;}
                   | '8' {res = 8;}
                   | '9' {res = 9;} ;
