/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;


/**
 * Clase donde se declaran todos los posibles Tokens que existen en el lenguaje
 * @author _______
 */
public enum Token {
    /**
     * EOF: representa final de archivo
     * ERROR: representa los caracteres no reconocidos
     * ID: representa los nombres de variables o identificadores
     * NUM: representa los numeros ''
     * SUMA: representa el caracter de operacion matematica suma '+'
     * RESTA: representa el caracter de operacion matematica resta '-'
     * MULT: representa el caracter de operacion matematica multiplicacion '*'
     * DIV: representa el caracter de operacion matematica division '/'
     * EXPO1: representa el caracter de operacion matematica exponente '^'
     * EXPO2: representa el caracter de operacion matematica exponente '**'
     * ASSIGN: representa el caracter de asignacion '::='
     * ELSE: representa el caracter de condicion 'else'
     * IF: representa el caracter de condicion 'if'
     * INT: representa una variable numero
     * VOID: representa una palabra reservada del lenguaje, dato vacio 'void'
     * RETURN: representa una palabra reservada del lenguaje  'return'
     * WHILE: representa una palabra reservada para ciclo  'while'
     * FOR: repersenta una palabra reservada para ciclo 'for'
     * LCIRCLEB: representa un parentesis circular izquierdo '('
     * RCIRCLEB: representa un parentesis circular derecho ')'
     * LSQUAREB: representa un parentesis cuadrado o corchete izquierdo '['
     * RSQUAREB: representa un parentesis cuadrado o corchete derecho ']'
     * LCURLYB: representa un parentesis curvo o llave izquierda '{'
     * RCURLYB: representa un parentesis curvo o llave derecha '}'
     * LT: representa operador relacional menor a 
     * LEQ: representa operador relacional menor o igual ''
     * GT: representa operador relacional mayor a '>'
     * GEQ: representa operador relacional mayor o igual '>='
     * EQ: representa operador relacional equivalente '=='
     * NEQ: representa operador relacional no equivalente o distinto '!='
     * COMMENT1: representa tipo de comentario de linea simple '%...'
     * COMMENT2: representa tipo de comentario de multi linea '/#...#/
     * SEMICOLON: representa signo de puntacion punto y coma ';'
     * COMMA: representa signo de puntuacion coma ','
     * NEWLINE: representa un salto de linea 'enter'
     */ EOF, ERROR, ID, NUM, SUMA, RESTA, MULT, DIV, EXPO1, EXPO2, ASSIGN, ELSE, IF, INT, VOID, RETURN, WHILE, FOR, LCIRCLEB, RCIRCLEB, LSQUAREB, RSQUAREB, LCURLYB, RCURLYB, LT, LEQ, GT, GEQ, EQ, NEQ, COMMENT1, COMMENT2, SEMICOLON, COMMA, NEWLINE
}
