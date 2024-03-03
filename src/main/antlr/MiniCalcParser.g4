parser grammar MiniCalcParser;

options { tokenVocab=MiniCalcLexer; }

miniCalcFile : lines = line+;

line : statement (NEWLINE | EOF);

statement : inputDecl # inputDeclarationStatement
            | varDecl # varDeclarationStatement
            | assignment # assignmentStatement
            | print # printStatement ;

print : PRINT LPAREN expr RPAREN ;

inputDecl : INPUT type name=ID # inputDeclaration;

varDecl : VAR assignment # varDeclaration;

assignment : ID ASSIGN expr ;

expr : left=expr operator=(DIVISION|ASTERISK) right=expr # binaryOperaton
        | left=expr operator=(PLUS|MINUS) right=expr # binaryOperation
        | left=expr AS targetType=type # typeConversion
        | LPAREN expr RPAREN # parenExpression
        | ID # varReference
        | MINUS expr # unaryMinusExpression
        | STRING_OPEN (parts += stringLiteralContent)* STRING_CLOSE # stringLiteral
        | INTLIT # intLiteral
        | DECLIT # decimalLiteral ;

stringLiteralContent : STRING_CONTENT # constantString
        | INTERPOLATION_OPEN expr INTERPOLATION_CLOSE # interopolatedValue ;

type : INT # integer
        | DECIMAL # decimal
        | STRING # string ;
