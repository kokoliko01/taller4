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
public class NodeFunDeclaration extends NodeTree implements Node {
    public ArrayList<NodeTree> listaParam = new ArrayList<>(); //lista de los parametros de la funcion
    public NodeTree tioTito;
    public NodeCompoundStmt nodoCompStmt; //nodo para el compound-stmt
    public int typeSpecifier; //tipo de la funcion, int o void
    
    //metodo encargado de mandar el codigo para GraphViz del nodo fun-declaration
    public String toGraph(int contadorNodos){
        String cadena = "\"NodeTree" + contadorNodos + "\"[label = \" Fun_Declaration: " + this.identificador +",";
        switch(typeSpecifier){
            case 25:
                cadena = cadena + "INT \"]; \n";
                break;
            case 29:
                cadena = cadena + "VOID \"]; \n";
                break;
        }
        //se retorna el codigo para el GraphViz
        //return "\"NodeTree" + contadorNodos + "\"[label = \" Fun_Declaration: " + this.identificador +","+ this.typeSpecifier +"\"]; \n";
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
