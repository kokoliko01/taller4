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
public class NodeCompoundStmt extends NodeTree implements Node {
    //lista que contiene las local-declarations
    public ArrayList<NodeTree> listaLocalDecl = new ArrayList<>();
    
    //lista que contiene los statement-list
    public ArrayList<NodeTree> listaStmtList = new ArrayList<>();
    
    //metodo encargado de mandar el codigo para GraphViz del nodo compound statement
    public String toGraph(int contadorNodos){
        //se retorna el codigo para GraphViz
        return "\"NodeTree" + contadorNodos + "\"[label = \"Compound_Stmt\"]; \n";
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
