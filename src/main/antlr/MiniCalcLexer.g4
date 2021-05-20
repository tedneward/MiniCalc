lexer grammar MiniCalcLexer;

channels { WHITESPACE }

NEWLINE : '\r\n' | '\r' | '\n' ;
WS : [\t]+ -> channel(WHITESPACE);

INPUT : 'input' ;
VAR : 'var' ;
PRINT : 'print' ;
AS : 'as' ;
INT : 'Int' ;
STRING : 'String' ;

INTLIT : '0'|[1-9][0-9]* ;

PLUS : '+';
MINUS : '-';
ASTERISK : '*';
DIVISION : '/';
ASSIGN : '=';
LPAREN : '(';
RPAREN : ')';

ID : [_]*[a-z][A-Za-z0-9_]* ;

STRING_OPEN : '"' -> pushMode(MODE_IN_STRING);

UNAMTCHED : . ;

mode MODE_IN_STRING;

ESCAPE_STRING_DELIMITER : '\\"' ;
ESCAPE_SLASH : '\\\\';
ESCAPE_NEWLINE : '\\n';
ESCAPE_SHARP : '\\#';
STRING_CLOSE : '"' -> popMode ;
INTERPOLATION_OPEN : '#{' -> pushMode(MODE_IN_INTERPOLATION);
STRING_CONTENT : ~["\n\r\t\\#]+ ;

mode MODE_IN_INTERPOLATION;

INTERPOLATION_CLOSE : '}' -> popMode;

INTERP_WS : [\t ]+ -> skip;

INTERP_AS : 'as' -> type(AS);
INTERP_INT : 'Int' -> type(INT);
INTERP_STRING : 'String' -> type(STRING);

INTERP_INTLIT : ('0'|[1-9][0-9]*) -> type(INTLIT);

INTERP_PLUS : '+' -> type(PLUS);
INTERP_MINUS : '-' -> type(MINUS);
INTERP_ASTERISK : '*' -> type(ASTERISK);
INTERP_DIVISION : '/' -> type(DIVISION);
INTERP_ASSIGN : '=' -> type(ASSIGN);
INTERP_LPAREN : '(' -> type(LPAREN);
INTERP_RPAREN : ')' -> type(RPAREN);

INTERP_ID : [_]*[a-z][A-Za-z0-9_]* -> type(ID);

INTERP_STRING_OPEN : '"' -> type(STRING_OPEN), pushMode(MODE_IN_STRING);
