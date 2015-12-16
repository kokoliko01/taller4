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
public class NodeStatement extends NodeTree implements Node {
    public String tipoProduccion = "";
    public NodeTree nodo1;
    public NodeTree nodo2;
    public NodeTree nodo3;
    public NodeTree nodo4;
    
    //metodo encargado de mandar el codigo para GraphViz del nodo fun-declaration
    public String toGraph(int contadorNodos){
        return "\"NodeTree" + contadorNodos + "\"[label = \"" + this.tipoProduccion + "\"]; \n";
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
