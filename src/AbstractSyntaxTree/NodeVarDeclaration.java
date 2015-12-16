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
public class NodeVarDeclaration extends NodeTree implements Node {
    public boolean arreglo; //variable para determinar si la declaracion es tipo arreglo o no
    public int typeSpecifier; //tipo de variable, int o void
    public int tamanoArreglo = 0; //numero que representa el tamaño del arreglo

    //metodo encargado de mandar el codigo para GraphViz del nodo Call
    public String toGraph(int contadorNodos, String nodoPadre){
        String codigo = "\"NodeTree" + contadorNodos + "\"[label = \"" + this.identificador + ":"; //variable que contiene el codigo para GraphViz
        
        //se verifica si la variable es tipo arreglo o no
        if(arreglo == false){
            switch(typeSpecifier){
                case 25:
                    codigo = codigo + "INT\"]; \n";
                    break;
                case 29:
                    codigo = codigo + "VOID\"]; \n";
                    break;
            }
            //variable no es arreglo
            //codigo = "\"NodeTree" + contadorNodos + "\"[label = \"" + this.identificador + ":" + this.typeSpecifier +"\"]; \n";
        }else{
            switch(typeSpecifier){
                case 25:
                    codigo = codigo + "INT[" + this.tamanoArreglo +"]\"]; \n";
                    break;
                case 29:
                    codigo = codigo + "VOID[" + this.tamanoArreglo +"]\"]; \n";
                    break;
            }
            //variable es tipo arreglo
            //codigo = "\"NodeTree" + contadorNodos + "\"[label = \"" + this.identificador + ":" + this.typeSpecifier + "[" + this.tamanoArreglo +"]\"]; \n";
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
