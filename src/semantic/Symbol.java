/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantic;

import AbstractSyntaxTree.NodeFunDeclaration;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author heave
 */
public class Symbol {
    public static int tipo; //25 = int, 29 = void, 0 = null, 666 = inicio de programa
    public static Scope alcance;
    public static Deque<String> parametros;
    public NodeFunDeclaration nfd;
    
    public Symbol(int _tipo, Scope _scope){
        Symbol.tipo = _tipo;
        Symbol.alcance = _scope;
        Symbol.parametros = new ArrayDeque<>();
    }
}
