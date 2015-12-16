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
public class NodeVar extends NodeTree implements Node {
    public int valorNumero = 0;//valor de la variable en caso de ser numero
    public String tipo = ""; //tipo de nodo
    public NodeTree nodeTree;

    //metodo encargado de mandar el codigo para GraphViz del nodo fun-declaration
    public String toGraph(int contadorNodos){
        String codigo = ""; //variable que contiene el codigo para GraphViz
        
        //severifica que tipo de nodo es
        switch(this.tipo){
            case "variable":
                codigo = "\"NodeTree" + contadorNodos + "\"[label = \" Variable: " + this.identificador + "\"]; \n";
                break;
            case "arreglo":
                codigo = "\"NodeTree" + contadorNodos + "\"[label = \" Arreglo: " + this.identificador + "\"[]]; \n";
                break;
            case "numero":
                codigo = "\"NodeTree" + contadorNodos + "\"[label = \" Constante: " + this.valorNumero + "\"]; \n";
                break;
            default:
                codigo = "\"NodeTree" + contadorNodos + "\"[label = \" Variable: " + this.identificador + "\"]; \n";
                break;
        }
        //se retorna el codigo para GraphViz
        return codigo;
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
