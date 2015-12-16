/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree;

import SyntaxVisitor.GrapherVisitor;
import Visitor.ExtendedVisitorInterface;
import semantic.Symbol;

/**
 *
 * @author heave
 */
public class NodeExpression extends NodeTree implements Node {
    //public NodeExpression operando1; //primer operador de la expression
    public NodeTree operando1; //primer operador de la expression
    //public NodeExpression operando2; //segundo operador de la expression
    public NodeTree operando2; //segundo operador de la expression
    public int operador; //tipo de operador
    public double valorResultado = 0; //resultado de la operacion
    
    //metodo encargado de mandar el codigo para GraphViz del nodo expression
    public String toGraph(int contadorNodos){
        //se retorna el codigo para el GraphViz
        String cadena = "\"NodeTree" + contadorNodos + "\"[label = \"";
        boolean comparacion;
        switch (this.operador){
            case 5:
                cadena = cadena + "SUMA";
                valorResultado = operando1.numero + operando2.numero;
                this.numero = valorResultado;
                System.err.println(this.numero);
                //System.err.println(valorResultado);
                cadena = cadena + " " +valorResultado;
                break;
            case 7:
                cadena = cadena + "RESTA";
                valorResultado = operando1.numero - operando2.numero;
                cadena = cadena + " " +valorResultado;
                break;
            case 6:
                cadena = cadena + "MULT";
                valorResultado = operando1.numero * operando2.numero;
                this.numero = valorResultado;
                System.err.println(this.numero);
                System.err.println(valorResultado);
                cadena = cadena + " " +valorResultado;
                break;
            case 8:
                cadena = cadena + "DIV";
                valorResultado = operando1.numero / operando2.numero;
                if(operando2.numero == 0){
                    cadena = cadena + ": ERROR división por 0";
                }else{
                    cadena = cadena + " " +valorResultado;
                }
                break;
            case 3:
                cadena = cadena + "EXPO1";
                break;
            case 4:
                cadena = cadena + "EXPO2";
                break;
            case 10:
                cadena = cadena + "LT";
                comparacion = operando1.numero < operando2.numero;
                cadena = cadena + " " +comparacion;
                break;   
            case 13:
                cadena = cadena + "LEQ";
                comparacion = operando1.numero <= operando2.numero;
                cadena = cadena + " " +comparacion;
                break;
            case 12:
                cadena = cadena + "GT";
                comparacion = operando1.numero > operando2.numero;
                cadena = cadena + " " +comparacion;
                break;
            case 9:
                cadena = cadena + "EQ";
                comparacion = operando1.numero == operando2.numero;
                cadena = cadena + " " +comparacion;
                break;
            case 11:
                cadena = cadena + "GEQ";
                comparacion = operando1.numero >= operando2.numero;
                cadena = cadena + " " +comparacion;
                break;
            case 14:
                cadena = cadena + "NEQ";
                comparacion = operando1.numero != operando2.numero;
                cadena = cadena + " " +comparacion;
                break;
            case 2:
                cadena = cadena + "ASSIGN";
                break;
        }
        cadena = cadena + "\"]; \n";
        //return "\"NodeTree" + contadorNodos + "\"[label = \"" + this.operador + "\"]; \n";
        return cadena;
    }
    
    @Override
    public void accept(GrapherVisitor gv) {
        gv.toVisit(this);
    }

    @Override
    public void accept(ExtendedVisitorInterface egv, Symbol _symbol) {
        egv.toVisit(this, _symbol);
    }
}
