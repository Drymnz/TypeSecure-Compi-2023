/*primer seccion: codigo de usuario*/

package com.cunoc.Logic.Parser;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
import java.util.List;


%%
/*segunda seccion: configuracion*/

%class Lexema
%unicode
%line
%column
%cup
%public
%{
    /*CODE*/
        public void print() {
            //System.out.println("\n<" + yytext() + "><Linea\"" + (yyline + 1) + "\">" + "<Columna\"" + yycolumn + "\">");
        }
    /*CODE*/
%}
ENTERO =[0-9]+
DECIMAL = {ENTERO}[.]{ENTERO}
espacio =[\r|\t|\f|\n|\s| ]+
no_pertenece = ("~"|"`"|"&"|"!"|"@"|"#"|"$"|"%"|"_"|"\\"|"<"|">"|"\?"|"."|"^")+
%%

/*tercer seccion: reglase lexicas*/
/*INGNORAR*/
//Comentarios de linea
[//].*[\n]?         {
                        //System.out.println("Comentarios de linea ->"+this.yytext());
                    }
//Comentarios multilinea / otro comentario multilinea
"/*" ~"*/"          {
                        //System.out.println("Comentarios multilinea / otro comentario multilinea ->"+this.yytext() +" <-- Termino");
                    }
{espacio}           {/*nada*/}
/*SIMBOLOS DE PUNTUACION*/
";"                 {
                   print(); return new Symbol(sym.PUNTOYCOMA,yyline,yycolumn);
                    }
/*SIMBOLOS ARIMETICOS*/
"+"                 {
                   print(); return new Symbol(sym.SUMAR,yyline,yycolumn);
                    }
"-"                 {
                   print(); return new Symbol(sym.RESTAR,yyline,yycolumn);
                    }
"/"                 {
                   print(); return new Symbol(sym.DIVIDIR,yyline,yycolumn);
                    }
"*"                 {
                   print(); return new Symbol(sym.MULTIPLICAR,yyline,yycolumn);
                    }
/*SIMBOLOS DE AGRUPACION*/
"("                 {
                   print(); return new Symbol(sym.PARENTESIS_A,yyline,yycolumn);
                    }
")"                 {
                   print(); return new Symbol(sym.PARENTESIS_C,yyline,yycolumn);
                    }
/*PALABRAS RESERVADAS*/
"up"                {
                   print(); return new Symbol(sym.UP,yyline,yycolumn);
                    }

/*Token*/
{ENTERO}            {
                   print(); return new Symbol(sym.ENTERO,yyline,yycolumn, (yytext()));
                    }
{DECIMAL}           {
                   print(); return new Symbol(sym.DECIMAL,yyline,yycolumn, (yytext()));
                    }
/*ERROR LEXICO*/
.                   {
                   print(); System.out.println("¡¡¡¡¡¡NO PERTENECE AL ALFABETO -> ERROR LEXICO!!!!!!!!!"+(yytext()));
                    }