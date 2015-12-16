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
public class NodeParam extends NodeTree implements Node {
    public int typeSpecifier; //tipo del parametro, int o void
    public boolean parametroVector; //variable para determinar si el parametro es arreglo o no
    
    //metodo encargado de mandar el codigo para GraphViz del nodo param
    public String toGraph(int contadorNodos, String nodoPadre){
        String codigo = ""; //variable para contiener el codigo para GraphViz
        
        //se verifica si el parametro es tipo arreglo o no
        if(parametroVector == true){
            //codigo del parametro para GraphViz
            switch (typeSpecifier){
                case 25:
                    codigo = "\"NodeTree" + contadorNodos + "\"[label = \"Param[" + this.identificador + ",INT[]]\"]; \n";
                    break;
                case 29:
                    codigo = "\"NodeTree" + contadorNodos + "\"[label = \"Param[" + this.identificador + ",VOID[]]\"]; \n";
                    break;
            }
        }else{
            //codigo del parametro para GraphViz
            switch (typeSpecifier){
                case 25:
                    codigo = "\"NodeTree" + contadorNodos + "\"[label = \"Param[" + this.identificador + ", INT]\"]; \n";
                    break;
                case 29:
                    codigo = "\"NodeTree" + contadorNodos + "\"[label = \"Param[" + this.identificador + ", VOID]\"]; \n";
                    break;
            }
        }
        codigo = codigo + nodoPadre + "->\"NodeTree" + contadorNodos + "\"; \n";
        return codigo; //se retorna el codigo para GraphViz
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
