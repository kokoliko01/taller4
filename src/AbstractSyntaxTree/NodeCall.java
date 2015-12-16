/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree;

import SyntaxVisitor.GrapherVisitor;
import Visitor.ExtendedVisitorInterface;
import java.util.ArrayList;
import semantic.Symbol;

/**
 *
 * @author heave
 */
public class NodeCall extends NodeTree implements Node{
    //lista que contiene los argumentos involucrados en la llamada de procedimiento
    public ArrayList<NodeTree> listaNodos = new ArrayList<>();
    
    //metodo encargado de mandar el codigo para GraphViz del nodo Call
    public String toGraph(int contadorNodos){
        return "\"NodeTree" + contadorNodos + "\"[label = \" Call : " + this.identificador + "\"]; \n";
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
