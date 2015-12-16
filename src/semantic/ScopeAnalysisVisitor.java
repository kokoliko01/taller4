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
import java.util.ArrayList;


/**
 *
 * @author heave
 */
public class ScopeAnalysisVisitor implements ExtendedVisitorInterface{
    
    public static int contadorProfundidad;
    public static NodeFunDeclaration nf;
    public String mensajes = "";

    @Override
    public void toVisit(NodeCall nodoCall, Symbol _symbol) {
        _symbol.nfd = nf;
        System.err.println("NODE CALL");
        //mensajes = mensajes + "NODE CALL\n";
        
        ArrayList<NodeTree> parametros = nodoCall.listaNodos;
        System.err.println(nodoCall.listaNodos.size());
        for(NodeTree nt: parametros){
            if(nt.identificador != null){
                nt.accept(this, _symbol);
            }
        }
    }

    @Override
    public void toVisit(NodeCompoundStmt nodeCompStmt, Symbol _symbol) {
        _symbol.nfd = nf;
        System.err.println("NODE COMPOUNT STATEMENT");
        //mensajes = mensajes + "NODE COMPOUNT STATEMENT\n";
        
        Scope _scope = new Scope(contadorProfundidad, _symbol.alcance);
        contadorProfundidad++;
        Symbol sAux = new Symbol(_symbol.tipo,_scope);
        nodeCompStmt.simbolito = _symbol;
        ArrayList<NodeTree> compoundDeclarations = nodeCompStmt.listaLocalDecl;
        for(NodeTree nt: compoundDeclarations){
            if(nt != null){
                nt.accept(this, _symbol);
            }
        }
    }

    @Override
    public void toVisit(NodeExpression nodeExpression, Symbol _symbol) {
        _symbol.nfd = nf;
        System.err.println("NODE EXPRESSION");
        //mensajes = mensajes + "NODE EXPRESSION\n";
        
        nodeExpression.simbolito = _symbol;
        NodeTree op1 = nodeExpression.operando1;
        if(op1 != null){
            op1.accept(this, _symbol);        
        }
        NodeTree op2 = nodeExpression.operando2;
        if(op2 != null && op2 instanceof NodeTree){
            op2.accept(this, _symbol);
        }
    }

    @Override
    public void toVisit(NodeFunDeclaration nodeFunDecl, Symbol _symbol) {
        _symbol.nfd = nf;
        System.err.println("NODE FUNCTION DECLARATION");
        //mensajes = mensajes + "NODE FUNCTION DECLARATION\n";
        
        Scope _scope = new Scope(contadorProfundidad, _symbol.alcance);
        contadorProfundidad++;
        nf = nodeFunDecl;
        Symbol symActual = SymbolTable.nueva().insertarSymbol(_symbol.alcance, nodeFunDecl.identificador, nodeFunDecl.typeSpecifier);
        nodeFunDecl.simbolito = symActual;
        if(symActual != null){
            ArrayList<NodeTree> parametros = nodeFunDecl.listaParam;
            for(NodeTree nt: parametros){
                if(nt.identificador != null){
                    nt.accept(this, _symbol);
                }
            }
            NodeTree nt = nodeFunDecl.nodoCompStmt;
            Symbol sAux = new Symbol(0,_scope);
            System.err.println(" -----------> " + _symbol.alcance.identificador + " <-------------");
            nt.accept(this, sAux);
        }else{
            System.err.println("FUNCIÓN REPETIDA");//    <----------------------------------- FUNCION YA EXISTE -------------------------
            mensajes = mensajes + "FUNCIÓN REPETIDA\n";
            System.err.println("\tFunción " + nodeFunDecl.identificador + " ya existe");
            mensajes = mensajes + "\tFunción " + nodeFunDecl.identificador + " ya existe\n";
            System.err.println("\tAlcance " + _symbol.alcance.identificador);
            mensajes = mensajes + "\tAlcance " + _symbol.alcance.identificador +"\n";
        }
        nf = null; //final de funcion
    }

    @Override
    public void toVisit(NodeParam nodeParam, Symbol _symbol) {
        _symbol.nfd = nf;
        System.err.println("NODE PARAMETER");
        //mensajes = mensajes + "NODE PARAMETER\n";
        
        Symbol sAux = SymbolTable.symTab.insertarSymbol(_symbol.alcance, nodeParam.identificador, 25);
        if(sAux != null){
            nf.simbolito.parametros.addLast("int");
        }else{
            System.err.println("repeticion de parametro " + nodeParam.identificador);//    <----------------------------------- PARAMETRO YA EXISTE -------------------------
            mensajes = mensajes + "repeticion de parametro " + nodeParam.identificador + "\n";
        }
    }

    @Override
    public void toVisit(NodeProgram nodeProgram, Symbol _symbol) {
        _symbol.nfd = nf;
        System.err.println("NODE PROGRAM");
        //mensajes = mensajes + "NODE PROGRAM\n";
        
        Scope _scope = new Scope(contadorProfundidad,null);
        contadorProfundidad++;
        ArrayList<NodeTree> listaDeclaraciones = nodeProgram.listaDeclarationList;
        nodeProgram.simbolito = _symbol;
        _symbol.alcance = _scope;
        for(NodeTree nt: listaDeclaraciones){
            if(nt != null){
                nt.accept(this, _symbol);
            }
        }
    }

    @Override
    public void toVisit(NodeStatement nodeStmt, Symbol _symbol) {
        _symbol.nfd = nf;
        System.err.println("NODE STATEMENT");
        //mensajes = mensajes + "NODE STATEMENT\n";
        
        nodeStmt.simbolito = _symbol;
        switch(nodeStmt.tipoProduccion){
            case "IF":
                if(nodeStmt.nodo3 == null){
                    nodeStmt.nodo1.accept(this, _symbol);
                    if(nodeStmt.nodo2 != null){
                        nodeStmt.nodo2.accept(this, _symbol);
                    }
                }
                break;
            case "IF-ELSE":
                if(nodeStmt.nodo3 != null){
                    if(nodeStmt.nodo2 != null){
                        nodeStmt.nodo2.accept(this, _symbol);
                        if(nodeStmt.nodo3 != null){
                            nodeStmt.nodo3.accept(this, _symbol);
                        }
                        else{
                            System.err.println("node 3 de NodeStatement es null");
                        }
                    }
                }
                break;
            case "FOR":
                nodeStmt.nodo1.accept(this, _symbol);
                nodeStmt.nodo2.accept(this, _symbol);
                nodeStmt.nodo3.accept(this, _symbol);
                nodeStmt.nodo4.accept(this, _symbol);
                break;
            case "WHILE":
                nodeStmt.nodo1.accept(this, _symbol);
                if(nodeStmt.nodo2 != null){
                    nodeStmt.nodo2.accept(this, _symbol);
                }
                break;
            case "RETURN":
                nodeStmt.nodo1.accept(this, _symbol);
                break;
        }
    }

    @Override
    public void toVisit(NodeVar nodeVar, Symbol _symbol) {
        _symbol.nfd = nf;
        System.err.println("NODE VARIABLE");
        //mensajes = mensajes + "NODE VARIABLE\n";
        nodeVar.simbolito = _symbol;
        if(nodeVar.nodeTree != null){
            //nodeVar.simbolito = _symbol;
            //boolean check = SymbolTable.symTab.nuevaFuncion(_symbol.alcance, nodeVar.identificador);
            boolean check = SymbolTable.nueva().nuevaFuncion(_symbol.alcance, nodeVar.identificador);
            if(check == true){
                //variable "visible"
                //System.err.println("VARIABLE REPETIDA"); // <--------------------------- VARIABLE ES VISIBLE --------------------------------
                //System.err.println("variable " + nodeVar.identificador + " ya existe en este alcance");
                //System.err.println(" 1111111111111111111111111111 ");
            }else{
                //variable "invisible"
                //System.err.println("VARIABLE REPETIDA"); // <--------------------------- VARIABLE NO ES VISIBLE --------------------------------
                //System.err.println("variable " + nodeVar.identificador + " ya existe en este alcance");
                //System.err.println(" 2222222222222222222222222222 ");
            }
            if(nodeVar.nodeTree != null){
                nodeVar.nodeTree.accept(this, _symbol);
            }
        }
    }

    /**
     *
     * @param nodeVarDecl
     * @param _symbol
     */
    @Override
    public void toVisit(NodeVarDeclaration nodeVarDecl, Symbol _symbol) {
        _symbol.nfd = nf;
        System.err.println("NODE VARIABLE DECLARATION");
        //mensajes = mensajes + "NODE VARIABLE DECLARATION\n";
        
        if(nodeVarDecl.typeSpecifier == 29){
            //System.err.println("\tvariable " + nodeVarDecl.identificador + " de tipo void"); // <-------------------------- VARIABLE VOID -------------------------------
            //mensajes = mensajes + "\tvariable " + nodeVarDecl.identificador + " de tipo void\n";
        }else{
            Symbol sAux = SymbolTable.nueva().insertarSymbol(_symbol.alcance, nodeVarDecl.identificador, nodeVarDecl.typeSpecifier);
            if(sAux != null){
                nodeVarDecl.simbolito = _symbol;
            }else{
                System.err.println("VARIABLE REPETIDA"); // <------------------------ VARIABLE YA EXISTE ---------------------------
                mensajes = mensajes + "VARIABLE REPETIDA\n";
                System.err.println("\tvariable " + nodeVarDecl.identificador + " ya existe en este alcance");
                mensajes = mensajes + "\tvariable " + nodeVarDecl.identificador + " ya existe en este alcance\n";
            }
        }
    }
}
