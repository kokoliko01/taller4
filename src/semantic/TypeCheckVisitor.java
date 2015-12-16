/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantic;

import AbstractSyntaxTree.NodeCall;
import AbstractSyntaxTree.NodeCompoundStmt;
import AbstractSyntaxTree.NodeExpression;
import AbstractSyntaxTree.NodeFunDeclaration;
import AbstractSyntaxTree.NodeParam;
import AbstractSyntaxTree.NodeProgram;
import AbstractSyntaxTree.NodeStatement;
import AbstractSyntaxTree.NodeTree;
import AbstractSyntaxTree.NodeVar;
import AbstractSyntaxTree.NodeVarDeclaration;
import Visitor.ExtendedVisitorInterface;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 *
 * @author heave
 */
public class TypeCheckVisitor implements ExtendedVisitorInterface{
    
    public static int contadorProfundidad;
    public static NodeFunDeclaration nf;
    public String mensajes = "";

    @Override
    public void toVisit(NodeCall nodoCall, Symbol _symbol) {
        System.err.println("CALL");
        //mensajes = mensajes + "CALL\n";
        
        boolean bool = SymbolTable.nueva().nuevaFuncion(_symbol.alcance, nodoCall.identificador);
        if(bool == false){
            System.err.println("llamado a funcion que no existe\n");
            mensajes = mensajes + "llamado a funcion que no existe\n";
        }else{
            Symbol sAux = SymbolTable.nueva().busquedaImplacable(nodoCall.identificador, _symbol.alcance);
            Deque<String> d1 = new ArrayDeque<>();
            Deque<String> d2 = sAux.parametros;
            for(String d: d2){
                d1.offerLast(d);
            }
            if(d1.isEmpty() == true){
                if(sAux.parametros.isEmpty() == false){
                    System.err.println("ERROR, SOBRAN PARAMETROS");
                    mensajes = mensajes + "ERROR, SOBRAN PARAMETROS\n";
                }
            }
            ArrayList<NodeTree> parametros = nodoCall.listaNodos;
            for(NodeTree nt: parametros){
                nt.accept(this, _symbol);
            }
        }
    }

    @Override
    public void toVisit(NodeCompoundStmt nodeCompStmt, Symbol _symbol) {
        ArrayList<NodeTree> listaParametros = nodeCompStmt.listaLocalDecl;
        for(NodeTree nt: listaParametros){
            if(nt != null){
                nt.accept(this, null);
            }
        }
    }

    @Override
    public void toVisit(NodeExpression nodeExpression, Symbol _symbol) {
        if(nodeExpression.operando1 != null){
            nodeExpression.operando1.accept(this, _symbol);
        }
        if(nodeExpression.operando2 != null){
            nodeExpression.operando2.accept(this, _symbol);
        }
        boolean comparación;
        double resultado = 0;
        String numero1;
        String numero2;
        Boolean bool1;
        Boolean bool2;
        System.err.println(" YYYYYYYYYYYYYYYYYYYYYYY ");
        switch(nodeExpression.operador){
            case 5:
                numero1 = nodeExpression.operando1.numero + "";
                numero2 = nodeExpression.operando2.numero + "";
                if(numero1 == null){
                    System.err.println("LADO IZQUIERDO NO ES NÚMERO");
                    mensajes = mensajes + "LADO IZQUIERDO NO ES NÚMERO";
                }
                if(numero2 == null){
                    System.err.println("LADO DERECHO NO ES NÚMERO");
                    mensajes = mensajes + "LADO DERECHO NO ES NÚMERO";
                }
                if(numero1 != null && numero2 != null){
                    System.err.println("SUMA DE NÚMEROS CORRECTA");
                    mensajes = mensajes + "SUMA DE NÚMEROS CORRECTA";
                }
                break;
            case 7:
                numero1 = nodeExpression.operando1.numero + "";
                numero2 = nodeExpression.operando2.numero + "";
                if(numero1 == null){
                    System.err.println("LADO IZQUIERDO NO ES NÚMERO");
                    mensajes = mensajes + "LADO IZQUIERDO NO ES NÚMERO";
                }
                if(numero2 == null){
                    System.err.println("LADO DERECHO NO ES NÚMERO");
                    mensajes = mensajes + "LADO DERECHO NO ES NÚMERO";
                }
                if(numero1 != null && numero2 != null){
                    System.err.println("RESTA DE NÚMEROS CORRECTA");
                    mensajes = mensajes + "RESTA DE NÚMEROS CORRECTA";
                }
                break;
            case 6:
                numero1 = nodeExpression.operando1.numero + "";
                numero2 = nodeExpression.operando2.numero + "";
                if(numero1 == null){
                    System.err.println("LADO IZQUIERDO NO ES NÚMERO");
                    mensajes = mensajes + "LADO IZQUIERDO NO ES NÚMERO";
                }
                if(numero2 == null){
                    System.err.println("LADO DERECHO NO ES NÚMERO");
                    mensajes = mensajes + "LADO DERECHO NO ES NÚMERO";
                }
                if(numero1 != null && numero2 != null){
                    System.err.println("MULTIPLICACIÓN DE NÚMEROS CORRECTA");
                    mensajes = mensajes + "MULTIPLICACIÓN DE NÚMEROS CORRECTA";
                }
                break;
            case 8:
                numero1 = nodeExpression.operando1.numero + "";
                numero2 = nodeExpression.operando2.numero + "";
                System.err.println(numero1);
                System.err.println(numero2);
                if(numero1.equals("")){
                    System.err.println("LADO IZQUIERDO NO ES NÚMERO");
                    mensajes = mensajes + "LADO IZQUIERDO NO ES NÚMERO";
                }
                if(numero2 == null){
                    System.err.println("LADO DERECHO NO ES NÚMERO");
                    mensajes = mensajes + "LADO DERECHO NO ES NÚMERO";
                }
                if(numero1 != null && numero2 != null){
                    System.err.println("DIVISIÓN DE NÚMEROS CORRECTA");
                    mensajes = mensajes + "DIVISIÓN DE NÚMEROS CORRECTA";
                }
                break;
            case 3:
                numero1 = nodeExpression.operando1.numero + "";
                numero2 = nodeExpression.operando2.numero + "";
                if(numero1 == null){
                    System.err.println("LADO IZQUIERDO NO ES NÚMERO");
                    mensajes = mensajes + "LADO IZQUIERDO NO ES NÚMERO";
                }
                if(numero2 == null){
                    System.err.println("LADO DERECHO NO ES NÚMERO");
                    mensajes = mensajes + "LADO DERECHO NO ES NÚMERO";
                }
                if(numero1 != null && numero2 != null){
                    System.err.println("EXPONENCIACIÓN 1 DE NÚMEROS CORRECTA");
                    mensajes = mensajes + "EXPONENCIACIÓN 1 DE NÚMEROS CORRECTA";
                }
                break;
            case 4:
                numero1 = nodeExpression.operando1.numero + "";
                numero2 = nodeExpression.operando2.numero + "";
                if(numero1 == null){
                    System.err.println("LADO IZQUIERDO NO ES NÚMERO");
                    mensajes = mensajes + "LADO IZQUIERDO NO ES NÚMERO";
                }
                if(numero2 == null){
                    System.err.println("LADO DERECHO NO ES NÚMERO");
                    mensajes = mensajes + "LADO DERECHO NO ES NÚMERO";
                }
                if(numero1 != null && numero2 != null){
                    System.err.println("EXPONENCIACIÓN 2 DE NÚMEROS CORRECTA");
                    mensajes = mensajes + "EXPONENCIACIÓN 2 DE NÚMEROS CORRECTA";
                }
                break;
            case 10:
                numero1 = nodeExpression.operando1.numero + "";
                numero2 = nodeExpression.operando2.numero + "";
                if(numero1 == null){
                    System.err.println("LADO IZQUIERDO NO ES NÚMERO");
                    mensajes = mensajes + "LADO IZQUIERDO NO ES NÚMERO";
                }
                if(numero2 == null){
                    System.err.println("LADO DERECHO NO ES NÚMERO");
                    mensajes = mensajes + "LADO DERECHO NO ES NÚMERO";
                }
                if(numero1 != null && numero2 != null){
                    System.err.println("COMPARACIÓN (LT) DE NÚMEROS CORRECTA");
                    mensajes = mensajes + "COMPARACIÓN (LT) DE NÚMEROS CORRECTA";
                }
                break;
            case 13:
                numero1 = nodeExpression.operando1.numero + "";
                numero2 = nodeExpression.operando2.numero + "";
                if(numero1 == null){
                    System.err.println("LADO IZQUIERDO NO ES NÚMERO");
                    mensajes = mensajes + "LADO IZQUIERDO NO ES NÚMERO";
                }
                if(numero2 == null){
                    System.err.println("LADO DERECHO NO ES NÚMERO");
                    mensajes = mensajes + "LADO DERECHO NO ES NÚMERO";
                }
                if(numero1 != null && numero2 != null){
                    System.err.println("COMPARACIÓN (LEQ) DE NÚMEROS CORRECTA");
                    mensajes = mensajes + "COMPARACIÓN (LEQ) DE NÚMEROS CORRECTA";
                }
                break;
            case 12:
                numero1 = nodeExpression.operando1.numero + "";
                numero2 = nodeExpression.operando2.numero + "";
                if(numero1 == null){
                    System.err.println("LADO IZQUIERDO NO ES NÚMERO");
                    mensajes = mensajes + "LADO IZQUIERDO NO ES NÚMERO";
                }
                if(numero2 == null){
                    System.err.println("LADO DERECHO NO ES NÚMERO");
                    mensajes = mensajes + "LADO DERECHO NO ES NÚMERO";
                }
                if(numero1 != null && numero2 != null){
                    System.err.println("COMPARACIÓN (GT) DE NÚMEROS CORRECTA");
                    mensajes = mensajes + "COMPARACIÓN (GT) DE NÚMEROS CORRECTA";
                }
                break;
            case 9:
                numero1 = nodeExpression.operando1.numero + "";
                numero2 = nodeExpression.operando2.numero + "";
                if(numero1 == null){
                    System.err.println("LADO IZQUIERDO NO ES NÚMERO");
                    mensajes = mensajes + "LADO IZQUIERDO NO ES NÚMERO";
                }
                if(numero2 == null){
                    System.err.println("LADO DERECHO NO ES NÚMERO");
                    mensajes = mensajes + "LADO DERECHO NO ES NÚMERO";
                }
                if(numero1 != null && numero2 != null){
                    System.err.println("COMPARACIÓN (EQ) DE NÚMEROS CORRECTA");
                    mensajes = mensajes + "COMPARACIÓN (EQ) DE NÚMEROS CORRECTA";
                }
                break;
            case 11:
                numero1 = nodeExpression.operando1.numero + "";
                numero2 = nodeExpression.operando2.numero + "";
                if(numero1 == null){
                    System.err.println("LADO IZQUIERDO NO ES NÚMERO");
                    mensajes = mensajes + "LADO IZQUIERDO NO ES NÚMERO";
                }
                if(numero2 == null){
                    System.err.println("LADO DERECHO NO ES NÚMERO");
                    mensajes = mensajes + "LADO DERECHO NO ES NÚMERO";
                }
                if(numero1 != null && numero2 != null){
                    System.err.println("COMPARACIÓN (GEQ) DE NÚMEROS CORRECTA");
                    mensajes = mensajes + "COMPARACIÓN (GEQ) DE NÚMEROS CORRECTA";
                }
                break;
            case 14:
                numero1 = nodeExpression.operando1.numero + "";
                numero2 = nodeExpression.operando2.numero + "";
                if(numero1 == null){
                    System.err.println("LADO IZQUIERDO NO ES NÚMERO");
                    mensajes = mensajes + "LADO IZQUIERDO NO ES NÚMERO";
                }
                if(numero2 == null){
                    System.err.println("LADO DERECHO NO ES NÚMERO");
                    mensajes = mensajes + "LADO DERECHO NO ES NÚMERO";
                }
                if(numero1 != null && numero2 != null){
                    System.err.println("COMPARACIÓN (NEQ) DE NÚMEROS CORRECTA");
                    mensajes = mensajes + "COMPARACIÓN (NEQ) DE NÚMEROS CORRECTA";
                }
                break;
            case 2:
                numero1 = nodeExpression.operando1.numero + "";
                numero2 = nodeExpression.operando2.numero + "";
                if(numero1 == null){
                    System.err.println("LADO IZQUIERDO NO ES NÚMERO");
                    mensajes = mensajes + "LADO IZQUIERDO NO ES NÚMERO";
                }
                if(numero2 == null){
                    System.err.println("LADO DERECHO NO ES NÚMERO");
                    mensajes = mensajes + "LADO DERECHO NO ES NÚMERO";
                }
                if(numero1 != null && numero2 != null){
                    System.err.println("ASIGNACIÓN");
                    mensajes = mensajes + "ASIGNACIÓN";
                }
                break;
            default:
                System.err.println("ERROR FATAL");
                mensajes = mensajes + "ERROR FATAL";
                break;
        }
    }

    @Override
    public void toVisit(NodeFunDeclaration nodeFunDecl, Symbol _symbol) {
        nf = nodeFunDecl;
        ArrayList<NodeTree> listaParametros = nodeFunDecl.listaParam;
        for(NodeTree nt: listaParametros){
            if(nt != null){
                nt.accept(this, null);
            }
        }
        nodeFunDecl.nodoCompStmt.accept(this, null);
        int tipoFun = nodeFunDecl.typeSpecifier; //25 = int, 29 = void
        //verificar tipo del Return;
    }

    @Override
    public void toVisit(NodeParam nodeParam, Symbol _symbol) {
        if(nodeParam.typeSpecifier == 29 && nodeParam.identificador != null){
            System.err.println("parametro " + nodeParam.identificador + " no puede ser void");//    <----------------------------------- PARAMETRO VOID -------------------------
            mensajes = mensajes + "parametro " + nodeParam.identificador + " no puede ser void\n";
        }
    }

    @Override
    public void toVisit(NodeProgram nodeProgram, Symbol _symbol) {
        ArrayList<NodeTree> listaDeclaraciones = nodeProgram.listaDeclarationList;
        nodeProgram.simbolito = _symbol;
        
        for(NodeTree nt: listaDeclaraciones){
            if(nt != null){
                nt.accept(this, _symbol);
            }
        }
    }

    @Override
    public void toVisit(NodeStatement nodeStmt, Symbol _symbol) {
        switch(nodeStmt.tipoProduccion){
            case "IF":
                if(nodeStmt.nodo3 == null){
                    nodeStmt.nodo1.accept(this, null);
                    if(nodeStmt.nodo2 != null){
                        nodeStmt.nodo2.accept(this, null);
                    }
                }
                break;
            case "IF-ELSE":
                if(nodeStmt.nodo3 != null){
                    if(nodeStmt.nodo2 != null){
                        nodeStmt.nodo2.accept(this, null);
                        if(nodeStmt.nodo3 != null){ //asdf no necesario e__e
                            nodeStmt.nodo3.accept(this, null);
                        }
                        else{
                            System.err.println("node 3 de NodeStatement es null");
                        }
                    }
                }
                break;
            case "FOR":
                nodeStmt.nodo1.accept(this, null);
                nodeStmt.nodo2.accept(this, null);
                nodeStmt.nodo3.accept(this, null);
                nodeStmt.nodo4.accept(this, null);
                break;
            case "WHILE":
                nodeStmt.nodo1.accept(this, null);
                if(nodeStmt.nodo2 != null){
                    nodeStmt.nodo2.accept(this, null);
                }
                break;
            case "RETURN":
                nodeStmt.nodo1.accept(this, null);
                break;
        }
    }

    @Override
    public void toVisit(NodeVar nodeVar, Symbol _symbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void toVisit(NodeVarDeclaration nodeVarDecl, Symbol _symbol) {
        if(nodeVarDecl.typeSpecifier == 29){
            System.err.println("variable " + nodeVarDecl.identificador + " de tipo void"); // <-------------------------- VARIABLE VOID -------------------------------
            mensajes = mensajes + "variable " + nodeVarDecl.identificador + " de tipo void\n";
        }
    }
    
}
