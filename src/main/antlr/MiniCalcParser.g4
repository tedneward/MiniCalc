parser grammar MiniCalcParser;

options { tokenVocab=MiniCalcLexer; }

miniCalcFile : lines = line+;

line : statement (NEWLINE | EOF);

statement : inputDecl
            | varDecl
            | assignment
            | print ;

print : PRINT LPAREN expr RPAREN ;

inputDecl : INPUT type name=ID ;

varDecl : VAR assignment ;

assignment : ID ASSIGN expr ;

expr : left=expr operator=(DIVISION|ASTERISK) right=expr
        | left=expr operator=(PLUS|MINUS) right=expr
        | left=expr AS targetType=type
        | LPAREN expr RPAREN
        | ID
        | MINUS expr
        | STRING_OPEN (parts += stringLiteralContent)* STRING_CLOSE
        | INTLIT
        | DECLIT ;

stringLiteralContent : STRING_CONTENT
        | INTERPOLATION_OPEN expr INTERPOLATION_CLOSE ;

type : INT
        | DECIMAL
        | STRING ;
