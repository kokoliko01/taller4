/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeGeneratorVisitor;

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
import static CodeGeneratorVisitor.CodeGenTemplates.*;
import Visitor.ExtendedVisitorInterface;
import java.util.ArrayList;
import semantic.Scope;
import semantic.Symbol;
import semantic.SymbolTable;

/**
 *
 * @author _______
 */
public class CodeGeneration implements ExtendedVisitorInterface {
    
    public static int contadorProfundidad;
    public static NodeFunDeclaration nf;
    public String mensajes = "";
    public int lineaCodigo = 1;

    @Override
    public void toVisit(NodeCall nodoCall, Symbol _symbol) {
        System.out.println(" LLAMADO A FUNCION " + nodoCall.identificador);
        mensajesCodigo(" LLAMADO A FUNCION ");
        
        NodeFunDeclaration nfd = new NodeFunDeclaration();
        Symbol sym = nfd.simbolito;
        Scope sco = sym.alcance;
        SymbolTable st = new SymbolTable();
        sym = st.busquedaImplacable(nodoCall.identificador, sco); //se busca la funcion llamada
        nfd = sym.nfd;
        
        int contador = 1;
        //se reocrre los parametros del llamado de funcion
        for(NodeTree nt : nodoCall.listaNodos){
            //se verifica que el nodo no sea nulo
            if(nt.identificador != null){
                nt.accept(this, null); //se recorre el parametro
                //se agrega el parametro n-esimo
                emit_push(registroAx, "Push Ax , parametro " + contador);
                contador++; //cantidad de parametros aumenta
            }
            //n.accept(this);
        }
        emit_call(nfd);
        mensajesCodigo(" FIN LLAMADO FUNCION " + nodoCall.identificador);
        //nodoCall.accept(this, null);
    }

    @Override
    public void toVisit(NodeCompoundStmt nodeCompStmt, Symbol _symbol) {
        System.out.println(" COMPOUND STMT");
        mensajesCodigo(" COMPOUND STMT");
        //se obtienen los nodos de declaraciones
        ArrayList<NodeTree> listaParametros = nodeCompStmt.listaLocalDecl;
        for(NodeTree nt: listaParametros){
            //se verifica que el nodo no sea nulo
            if(nt != null){
                nt.accept(this, null);//se visita el nodo
            }
        }
        System.out.println(" COMPOUND STMT ");
        mensajesCodigo(" COMPOUND STMT ");
    }

    @Override
    public void toVisit(NodeExpression nodeExpression, Symbol _symbol) {
        mensajesCodigo("NODO EXPRESSION");
        System.out.println(" NODO EXPRESSION ");
        switch(nodeExpression.operador){
            case 5:
                nodeExpression.operando1.accept(this, null);
                emit_push(CodeGenTemplates.registroAx, "push Ax");
                mensajes = mensajes + "push Ax\n";
                nodeExpression.operando2.accept(this, null);
                emit_push(CodeGenTemplates.registroBx, "push Bx");
                mensajes = mensajes + "push Bx\n";
                
                emit_RO("ADD", CodeGenTemplates.registroAx, CodeGenTemplates.registroBx, CodeGenTemplates.registroAx, "ax = ax + bx");
                mensajes = mensajes + "add -> ax = ax + bx\n";
                break;
            case 7:
                //resta
                nodeExpression.operando1.accept(this, null);
                emit_push(CodeGenTemplates.registroAx, "push Ax");
                mensajes = mensajes + "push Ax\n";
                nodeExpression.operando2.accept(this, null);
                emit_push(CodeGenTemplates.registroBx, "push Bx");
                mensajes = mensajes + "push Bx\n";
                
                emit_RO("SUB", CodeGenTemplates.registroAx, CodeGenTemplates.registroBx, CodeGenTemplates.registroAx, "ax = ax - bx");
                mensajes = mensajes + "sub -> ax = ax - bx\n";
                break;
            case 6:
                //mult
                nodeExpression.operando1.accept(this, null);
                emit_push(CodeGenTemplates.registroAx, "push Ax");
                mensajes = mensajes + "push Ax\n";
                nodeExpression.operando2.accept(this, null);
                emit_push(CodeGenTemplates.registroBx, "push Bx");
                mensajes = mensajes + "push Bx\n";
                
                emit_RO("MUL", CodeGenTemplates.registroAx, CodeGenTemplates.registroBx, CodeGenTemplates.registroAx, "ax = ax * bx");
                mensajes = mensajes + "mul -> ax = ax * bx\n";
                break;
            case 8:
                //div
                nodeExpression.operando1.accept(this, null);
                emit_push(CodeGenTemplates.registroAx, "push Ax");
                mensajes = mensajes + "push Ax\n";
                nodeExpression.operando2.accept(this, null);
                emit_push(CodeGenTemplates.registroBx, "push Bx");
                mensajes = mensajes + "push Bx\n";
                
                emit_RO("DIV", CodeGenTemplates.registroAx, CodeGenTemplates.registroBx, CodeGenTemplates.registroAx, "ax = ax / bx");
                mensajes = mensajes + "div -> ax = ax / bx\n";
                break;
            case 3:
                //expo1 raiz
                nodeExpression.operando1.accept(this, null);
                for(int i=0;i<nodeExpression.operando2.numero;i++){
                    emit_push(CodeGenTemplates.registroAx, "push Ax");
                    mensajes = mensajes + "push Ax\n";
                    nodeExpression.operando2.accept(this, null);
                    emit_push(CodeGenTemplates.registroBx, "push Bx");
                    mensajes = mensajes + "push Bx\n";

                    emit_RO("MUL", CodeGenTemplates.registroAx, CodeGenTemplates.registroBx, CodeGenTemplates.registroAx, "ax = ax * bx");
                    mensajes = mensajes + "mul -> ax = ax * bx\n";
                }
                break;
            case 4:
                //expo2 potencia
                nodeExpression.operando1.accept(this, null);
                for(int i=0;i<nodeExpression.operando2.numero;i++){
                    emit_push(CodeGenTemplates.registroAx, "push Ax");
                    mensajes = mensajes + "push Ax\n";
                    nodeExpression.operando2.accept(this, null);
                    emit_push(CodeGenTemplates.registroBx, "push Bx");
                    mensajes = mensajes + "push Bx\n";

                    emit_RO("MUL", CodeGenTemplates.registroAx, CodeGenTemplates.registroBx, CodeGenTemplates.registroAx, "ax = ax * bx");
                    mensajes = mensajes + "mul -> ax = ax * bx\n";
                }
                break;
            case 10:
                //LT
                pseudo_compare("JLT");
                break;
            case 13:
                //LEQ
                pseudo_compare("JLE");
                break;
            case 12:
                //GT
                pseudo_compare("JGT");
                break;
            case 9:
                //EQ
                pseudo_compare("JEQ");
                break;
            case 11:
                //GEQ
                pseudo_compare("JGE");
                break;
            case 14:
                //NEQ
                pseudo_compare("JNE");
                break;
            case 2:
                //ASSIGN
                System.out.println(" ASIGNACIÓN ");
                mensajesCodigo(" ASIGNACIÓN ");
                nodeExpression.operando1.accept(this, null);
                emit_push(registroAx, "PUSH Ax");
                //donot_fetch_var_value = FALSE;
                nodeExpression.operando2.accept(this, null);
                emit_pop(registroBx, "POP Bx");
                emit_RM("ST", registroAx, 0, registroBx, "data[Bx] = Ax");
                mensajesCodigo(" FIN ASIGNACIÓN ");                
                break;
        }
        System.out.println(" FIN EXPRESSION");
        mensajesCodigo("FIN EXPRESSION");
    }

    @Override
    public void toVisit(NodeFunDeclaration nodeFunDecl, Symbol _symbol) {
        System.out.println(" INICIO DE FUNCION");
        mensajes = mensajes + " INICIO DE FUNCION\n";
        
        pseudo_fun_head(nodeFunDecl.identificador);
        nodeFunDecl.nodoCompStmt.accept(this, null);
        pseudo_return();
        
        System.out.println(" FIN DE FUNCION");
        mensajes = mensajes + " FIN DE FUNCION\n";
    }

    @Override
    public void toVisit(NodeParam nodeParam, Symbol _symbol) {
        //se verifica que el nodo no sea nulo
        if(nodeParam != null){
            nodeParam.accept(this, null); //se visita el nodo 
        }
    }

    @Override
    public void toVisit(NodeProgram nodeProgram, Symbol _symbol) {
        System.err.println("Generación código");
        mensajesCodigo("Generación código ");
        
        CodeGenTemplates.codeGenStart();
        mensajesCodigo("LLAMADA MAIN, ESPERA POR DIRECCION DE MAIN()");
        int localizacionMain = emit_skip(5);
        emit_RO("HALT", ignore, ignore, ignore, "SE DETIENE PROGRAMA");
        prelude_input();
        prelude_output();
        
        NodeFunDeclaration nfd = new NodeFunDeclaration();
        
        ArrayList<NodeTree> listaDeclaraciones = nodeProgram.listaDeclarationList;
        for(NodeTree nt: listaDeclaraciones){
            if(nt != null){
                if(nt.identificador.equalsIgnoreCase("main")){
                    //((NodeTree)nfd) = nt;
                }
                nt.accept(this, null);
            }
            
        }
//        emit_backup(localizacionMain);
//        NodeFunDeclaration nfd = new NodeFunDeclaration();
//        Symbol sym = nfd.simbolito;
//        Scope sco = sym.alcance;
//        SymbolTable st = new SymbolTable();
//        sym = st.busquedaImplacable("main", sco);
//        nfd = sym.nfd;
//        emit_call(nfd);
        emit_restore();
        
        mensajesCodigo("fin de generación\n");
    }

    @Override
    public void toVisit(NodeStatement nodeStmt, Symbol _symbol) {
        System.err.println("NODO STATEMENT");
        mensajes = mensajes + "NODO  STATEMENT\n";
        
        int actual;
        int aux1;
        int aux2;
        
        switch(nodeStmt.tipoProduccion){
            case "IF":
                //estamento para IF
                System.out.println(" IF ");
                mensajes = mensajes + " IF \n";

                nodeStmt.nodo1.accept(this, null);//se visita el nodo
                aux1 = emit_skip(1); //salto de linea
                System.out.println(" SALTO A ELSE ");
                mensajes = mensajes + " SALTO A ELSE \n";
                nodeStmt.nodo2.accept(this, null); //se visita el siguiente nodo
                aux2 = emit_skip(1); //salto de linea
                System.out.println(" SALTO A FINAL DE IF ");
                mensajes = mensajes + " SALTO A FINAL DE IF \n";
                actual = emit_skip(1);//salto de linea
                emit_backup(aux1);
                emit_RM("JEQ", CodeGenTemplates.registroAx, actual, CodeGenTemplates.zero,"SI AX == 0, PC = Direccion del ELSE");
                emit_restore();
                break;
                
            case "IF-ELSE":
                //estamento para IF-ELSE
                nodeStmt.nodo1.accept(this, null);//se visita el nodo
                aux1 = emit_skip(1); //salto de linea
                System.out.println(" SALTO A ELSE ");
                mensajes = mensajes + " SALTO A ELSE \n";
                nodeStmt.nodo2.accept(this, null);
                aux2 = emit_skip(1);//salto de linea
                System.out.println(" SALTO A FINAL DE IF ");
                mensajes = mensajes + " SALTO A FINAL DE IF \n";

                actual = emit_skip(1); //salto de linea
                emit_backup(aux1);
                emit_RM("JEQ", CodeGenTemplates.registroAx, actual, CodeGenTemplates.zero,"SI AX == 0, PC = Direccion del ELSE");
                emit_restore();
                nodeStmt.nodo3.accept(this, null); //se visita nodo
                actual = emit_skip(0);//se recupera la direccion
                emit_backup(aux2);

                pseudo_mov_const(CodeGenTemplates.programCounter, actual, " Program Counter = direccion de END-IF");
                emit_restore();
                System.out.println(" FINAL DE IF ");
                mensajes = mensajes + " FINAL DE IF \n";
                break;
                
            case "FOR":
                System.out.println(" CICLO FOR ");
                mensajesCodigo(" CICLO FOR ");
                nodeStmt.nodo1.accept(this, null);
                nodeStmt.nodo2.accept(this, null);
                nodeStmt.nodo3.accept(this, null);
                nodeStmt.nodo4.accept(this, null);
                
                break;
            case "WHILE":
                
                System.out.println(" CICLO WHILE ");
                mensajesCodigo(" CICLO WHILE ");
                aux1 = emit_skip(0);
                nodeStmt.nodo1.accept(this, null);
                
                aux2 = emit_skip(1);
                mensajesCodigo("SALTO A FINAL DE WHILE");
                if(nodeStmt.nodo2 != null){
                    nodeStmt.nodo2.accept(this, null);
                    pseudo_mov_const(programCounter, aux1, "pc = direccion de while");
                    
                    actual = emit_skip(0);
                    emit_backup(aux2);
                    emit_RM("JEQ", registroAx, actual, zero, "if Ax == 0, pc = direccion FIN WHILE");
                    emit_restore();
                    
                    mensajesCodigo(" FIN WHILE");
                }
                
                break;
            case "RETURN":
                System.out.println(" RETURN ");
                mensajes = mensajes + " RETURN \n";
                nodeStmt.nodo1.accept(this, null); //se visita el nodo
                System.out.println(" FINAL RETURN ");
                mensajes = mensajes + " FINAL RETURN \n";
                break;
        }
        
    }

    @Override
    public void toVisit(NodeVar nodeVar, Symbol _symbol) {
        System.out.println("NODO VAR");
        
        switch(nodeVar.tipo){
            case "variable":
                
                break;
            case "arreglo":
                
                break;
            case "numero":
                System.out.println(" VARIABLE CONSTANTE ");
                mensajes = mensajes + "VARIABLE CONSTANTE\n";
                pseudo_mov_const(CodeGenTemplates.registroAx, (int)nodeVar.numero, "Ax = constante");
                break;
            default:
                
                break;
        }
        
    }

    @Override
    public void toVisit(NodeVarDeclaration nodeVarDecl, Symbol _symbol) {
        if( nodeVarDecl != null){
            //nodeVarDecl.accept(this, null);
        }
    }
    
}
