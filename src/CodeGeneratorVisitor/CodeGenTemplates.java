/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeGeneratorVisitor;

import AbstractSyntaxTree.*;
import semantic.Scope;
import semantic.Symbol;
import semantic.SymbolTable;

/**
 *
 * @author _______
 */
public class CodeGenTemplates {
    
    //registros principales de la maquina
    public static int registroAx;
    public static int registroBx;
    public static int registroCx;
    
    public static int BP;
    
    //pointers
    public static int programCounter;
    public static int globalPointer;
    public static int stackPointer;
    
    public static int zero = 0;
    public static int ignore = 0;
    
    //label actual
    public static int label;
    //label mas profundo
    public static int labelMaximo;
    
    //mensajes de información
    public static String mensajes = "";
    
    //metodo encargado de iniciar la contruccion de codigo TM
    public static void codeGenStart()
    {
        label = 0; //label inicial
        labelMaximo = -1; //label maximo
        
        //asignacion de numeros a registros y punteros
        registroAx = 1;
        registroBx = 2;
        registroCx = 3;
        
        programCounter = 7;
        globalPointer = 6;
        stackPointer = 5;
        
        BP = 4;
        
        System.out.println(" Setup registros ");
        mensajesCodigo("Setup registros");
        
        int size = 0; // <-------------------------------------------------------
        
        pseudo_mov_const(zero, 0, " zero = 0");
        emit_RM("LD", globalPointer, 0, zero, "Global pointer = data[0] (maxaddress)");
        emit_RM("ST", zero, 0, zero, "data[0] = 0");
        pseudo_mov_reg(stackPointer, globalPointer, -size + 1, "stack pointer = global pointer - global var size +1");
        System.out.println(" FIN SETUP REGISTROS ");
        mensajesCodigo(" FIN SETUP REGISTROS ");
    }
    
    //metodo encargado de almacenar los comandos de TM
    public static void mensajesCodigo(String msg)
    {
        mensajes = mensajes + msg + "\n";
    }
    
    //Metodo encargado de los saltos entre lineas de codigo
    public static int emit_skip(int cantidad)
    {
        int i = label;
        label += cantidad;
        if (labelMaximo < label) {
          labelMaximo = label;
        }
        return i;
    }
    
    //metodo encargada de hacer realizar las instrucciones RM o memoria de registro
    public static void emit_RM(String op, int r, int d, int s, String mensaje)
    {
        mensajes = mensajes + String.format("%4d: %5s %d, %d(%d) \t %s \n", label++, op, r, d, s, mensaje );
        if (labelMaximo < label) {
          labelMaximo = label;
        }
    }
    
    
    public static void emit_restore()
    {
        label = labelMaximo;
    }
    
    //metodo encargado de lacarga de dconstantes
    public static void pseudo_mov_const(int dst, int x, String c)
    {
        emit_RM("LDC", dst, x, 0, c);
    }
    
    //se almacena valor de r a registro Ax
    public static void emit_push(int registro, String texto)
    {
        //se verifica que no se agregen los punteros
        if( registro == stackPointer){
            System.out.println(" CUIDADO: PUSH STACK POINTER"); //error
            mensajesCodigo(" CUIDADO: PUSH STACK POINTER");
        }else if(registro == programCounter){
            System.out.println(" CUIDADO: PUSH PROGRAM COUNTER"); //error
            mensajesCodigo(" CUIDADO: PUSH PROGRAM COUNTER");
        }
        pseudo_mov_reg(stackPointer, stackPointer, -1, texto);
        emit_RM("ST", registro, 0, stackPointer, "");
    }
    
    //metodo que carga lo que está en Ax directamente en r
    public static void pseudo_mov_reg(int dst, int src, int x, String c)
    {
        emit_RM("LDA", dst, x, src, c);
    }
    
    
    public static void emit_backup(int loc)
    {
        if (loc > labelMaximo) {
          System.out.println("loc > highEmitLoc in emit_backup()");
        }
        label = loc;
    }
    
    //metodo encargado de realizar las operaciones solo de registros
    public static void emit_RO(String op, int r, int s, int t, String mensaje)
    {
       mensajesCodigo(String.format("%4d: %5s %d, %d, %d \t %s \n", label++, op, r, s, t, mensaje));
        if (labelMaximo < label) {
            labelMaximo = label;
        }
    }
    
    
    public static void emit_pop(int registro, String mensaje){
        //se verifica no hacer POP a stack pointer
        if(registro == stackPointer){
            System.err.println("CUIDADO, POP Stack Pointer");
            mensajesCodigo("CUIDADO, POP Stack Pointer");
            pseudo_mov_reg(stackPointer, stackPointer, 1, mensaje);
            emit_RM("LD", registro, -1, stackPointer, "");
        }
    }
    
    
    public static void pseudo_fun_head(String name)
    {
        NodeFunDeclaration nfd = new NodeFunDeclaration();
        Symbol sym = nfd.simbolito;
        Scope sco = sym.alcance;
        SymbolTable st = new SymbolTable();
        st.busquedaImplacable(name, sco);
        
        System.out.println(" INICIO FUNCION " + name);
        mensajesCodigo(" INICIO FUNCION: "+ name);
        emit_push(BP, "push BP");
        pseudo_mov_reg(BP, stackPointer, 0, "BP = stack Pointer");
        //int tamanioMemoria = memoria reservada para variables y demas; <------------------------------------------------------
        pseudo_mov_reg(stackPointer, stackPointer,/* tamanioMemoria */ -13, "stack Pointer = stack Pointer - param_size");
        System.out.println(" FIN FUNCION ");
        mensajesCodigo("FINAL FUNCION");
    }
    
    //template para funciones return
    public static void pseudo_return()
    {
//      emit_comment("-> [pseudo] return");
//	pseudo_mov_reg(sp, bp, 0, "sp = bp");
//	pseudo_pop(bp, "pop bp");
//	pseudo_pop(pc, "pop pc");
//	emit_comment("<- [pseudo] return");
        
        System.out.println(" INICIO RETURN ");
        mensajesCodigo(" INICIO RETURN ");
        
        pseudo_mov_reg(stackPointer, BP, 0, " stack Pointer = BP");
        emit_pop(BP, "pop bp");
        emit_pop(programCounter, "pop pc");
        
        System.out.println(" FIN RETURN ");
        mensajesCodigo(" FIN RETURN ");
    }
    
    //metodo encargado de generar la funcion input
    public static void prelude_input()
    {
        System.out.println(" FUNCION INPUT ");
        mensajesCodigo(" FUNCION INPUT ");
        pseudo_fun_head("input");
        emit_RO("IN", registroAx, ignore, ignore, "input Ax");
        pseudo_return();
        System.out.println(" FIN FUNCION INPUT");
        mensajesCodigo(" FIN FUNCION INPUT ");
    }
    
    //metodo encargado de genenrar la funcion output
    public static void prelude_output()
    {
//        emit_comment("-> prelude function: output");
//        pseudo_fun_head("output");
//        emit_RM("LD", ax, 2, bp, "ax = data[bp+2] (param 0)");
//        emit_RO("OUT", ax, ignore, ignore, "output ax");
//        pseudo_return();
//        emit_comment("<- prelude function: output");
        System.out.println(" FUNCION OUTPUT ");
        mensajesCodigo(" FUNCION OUTPUT ");
        pseudo_fun_head("output");
        emit_RM("LD", registroAx, 2, BP, "ax = data[DP+2] (param 0)");
        emit_RO("OUT", registroAx, ignore, ignore, "output Ax");
        pseudo_return();
        System.out.println(" FIN DUNCION OUTPUT");
        mensajesCodigo(" FIN FUNCION OUTPUT");
    }
    
    //metodo encargado de las comparaciones
    public static void pseudo_compare(String comando){
        emit_RO("SUB", registroAx, registroBx, registroAx, "Ax =  Bx - Ax");
        emit_RM(comando, registroAx, 2, programCounter, "SALTO CONDICIONAL SI ES TRUE");
        pseudo_mov_const(registroAx, 0, "Ax = 0 (caso False)");
        pseudo_mov_reg(programCounter, programCounter, 1, "SALTO INCONDICIONAL");
        pseudo_mov_const(registroAx, 1, "Ax = 1 (caso true)");
    }
    
    //metodo encargado de las llamas a funciones
    public static void emit_call(NodeFunDeclaration nfd){
        String identificador = nfd.identificador;// = stFunction.getName(); <---------------------------------------------------------
        int direccion = 0;// = stFunction.getAddress(); <---------------------------------------------------------
        int cantidad = nfd.listaParam.size();// = stFunction.getParam_size(); <---------------------------------------------------------
        
        if (direccion < 0) {
            System.err.println("DIRECCIÓN DE FUNCION NO VALIDA"); //error
        }
        
        System.out.println("LLAMADO A FUNCION");
        mensajesCodigo("LLAMADO " + identificador);

        pseudo_mov_reg(registroAx, programCounter, 3, "ac = program Counter + 3 (NEXT program Counter)");
        emit_push(registroAx, "push Ax (return address)");
        pseudo_mov_const(programCounter, direccion, "program Counter = Direccion (jmp)");

        pseudo_mov_reg(stackPointer, stackPointer, cantidad, "stack Pointer = stack Pointer + param_size");

        System.out.println("FIN LLAMADO");
        mensajesCodigo("FIN LLAMADO");
    }
}
