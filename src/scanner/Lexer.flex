package scanner;

import java_cup.runtime.*;
import parser.sym;

%%
%class Scanner
%ignorecase
%public

%line
%column

%cup

%{
    /* Se retorna el simbolo encontrado*/
    public Symbol symbol(int tipoToken){
        return new Symbol(tipoToken, yyline, yycolumn);
    }
    /* Se retorna el simbolo y su valor*/
    public Symbol symbol(int tipoToken, Object objetoToken){
        return new Symbol(tipoToken, yyline, yycolumn, objetoToken);
    }
%}

/**
 * DEFINICION DE PATRONES:
 */
L1 = [a-z]
L2 = [a-zA-Z]
D1 = [0-9]
D2 = [1-9]

ID = {L1}{L2}*(_?)({L2}*)(({D1}|{D2}{D1}*)|({L2}*))
NUM = {D2}{D1}*|{D1}

white=[ \t\r\n]
LineTerminator = \r|\n|\r\n

i=i|I
f=f|F
w=w|W
h=h|H
l=l|L
e=e|E
n=n|N
t=t|T
v=v|V
o=o|O
d=d|D
s=s|S
r=r|R
u=u|U

commentSimple = [%].*
commentMulti = \/\#([^\#]|[\r\n]|(\#+([^\#\/]|[\r\n])))*\#\/

%eofval{
    System.out.println("eofval -> Lexer");
    return new Symbol(sym.EOF, null);
%eofval}

%eof{
    System.out.println("Final de archivo -> Lexer");
%eof}
%%


<YYINITIAL> {

"+" {return symbol(sym.SUMA);}
"-" {return symbol(sym.RESTA);}
"*" {return symbol(sym.MULT);}
"/" {return symbol(sym.DIV);}
"**" {return symbol(sym.EXPO1);}
"^" {return symbol(sym.EXPO2);}
"::=" {return symbol(sym.ASSIGN);}
"(" {return symbol(sym.LCIRCLEB);}
")" {return symbol(sym.RCIRCLEB);}
"[" {return symbol(sym.LSQUAREB);}
"]" {return symbol(sym.RSQUAREB);}
"{" {return symbol(sym.LCURLYB);}
"}" {return symbol(sym.RCURLYB);}
"LT" {return symbol(sym.LT);}
"LEQ" {return symbol(sym.LEQ);}
"GT" {return symbol(sym.GT);}
"GEQ" {return symbol(sym.GEQ);}
"EQ" {return symbol(sym.EQ);}
"NEQ" {return symbol(sym.NEQ);}
";" {return symbol(sym.SEMICOLON);}
"," {return symbol(sym.COMMA);}

{i}{n}{t} {return symbol(sym.INT);}
{i}{f} {return symbol(sym.IF);}
{w}{h}{i}{l}{e} {return symbol(sym.WHILE);}
{f}{o}{r} {return symbol(sym.FOR);}
{e}{l}{s}{e} {return symbol(sym.ELSE);}
{v}{o}{i}{d} {return symbol(sym.VOID);}
{r}{e}{t}{u}{r}{n} {return symbol(sym.RETURN);}

{ID} {return new Symbol(sym.ID,yyline, yycolumn,yytext());}
{NUM} {return new Symbol(sym.NUM,yyline, yycolumn,new Integer(yytext()));}

<<EOF>> {return symbol(sym.EOF);}

{white} {/*return symbol(sym.NEWLINE);*/}
{LineTerminator} {/*return symbol(sym.NEWLINE);*/}
{commentSimple} {/*Ignore*/}
{commentMulti} {/*Ignore*/}

}
. {throw new Error("Caracter ilegal <"+yytext()+">");}
