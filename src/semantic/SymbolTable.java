    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantic;

import java.util.Hashtable;
import java.util.Stack;

/**
 *
 * @author heave
 */
public class SymbolTable {
    public static SymbolTable symTab = null;
    public Hashtable<String, Stack <Symbol>> Tabla;
    
    public SymbolTable(){
        this.Tabla = new Hashtable<>();
    }
    
    public static SymbolTable nueva(){
        if(symTab != null){
            return symTab;
        }else{
            symTab = new SymbolTable();
            return symTab;
        }
    }
    
    public Symbol insertarSymbol(Scope _scope, String _symbol, int _tipo){
        Symbol simboloNuevo = new Symbol(_tipo,_scope);
        boolean bool;
        if(checkSymbolo(simboloNuevo, _symbol) == true){
            return null;
        }else{
            if(this.Tabla.containsKey(_symbol) == false){
                
                Stack<Symbol> nuevoAlcance = new Stack<>();
                this.Tabla.put(_symbol, nuevoAlcance);
            }
            Stack<Symbol> stack1 = this.Tabla.get(_symbol);
            stack1.push(simboloNuevo);
            return simboloNuevo;
        }
    }
    
    //Metodo utilizado en la sobrecarga de metodos
    //no funcionando aun
    public Symbol insertarSymbol(Scope _scope, String _symbol, int _tipo, int cantidad){
        Symbol simboloNuevo = new Symbol(_tipo,_scope);
        boolean bool;
        if(checkSymbolo(simboloNuevo, _symbol) == true){
            return null;
        }else{
            if(this.Tabla.containsKey(_symbol) == false){
                Stack<Symbol> nuevoAlcance = new Stack<>();
                this.Tabla.put(_symbol, nuevoAlcance);
            }
            Stack<Symbol> stack1 = this.Tabla.get(_symbol);
            stack1.push(simboloNuevo);
            return simboloNuevo;
        }
    }
    
    public boolean checkSymbolo(Symbol _symbol, String identificador){
        if(this.Tabla.containsKey(identificador) == false){
            return false;
        }else{
            Stack<Symbol> stack1 = (Stack<Symbol>)this.Tabla.get(identificador);
            Stack<Symbol> stack2 = new Stack<>();
            while(stack1.isEmpty() == false){
                Symbol symboloAux = stack1.pop();
                stack2.add(symboloAux);
                if(symboloAux.alcance == _symbol.alcance){
                    //System.err.println("cant 1: " + symboloAux.alcance. + "        cant 2: " + _symbol.parametros.size());
                    if(symboloAux.parametros.size() != _symbol.parametros.size()){
                        System.err.println("XXXXXXXXXXXXXXXXXXXXXX");
                        //return false;
                    }
                    break;
                }
            }
            while(stack2.isEmpty() == false){
                stack1.add(stack2.pop());
            }
            return true;
        }
    }
    
    //Metodo utilizado en la sobrecarga de metodos
    //no funcionando aun
    public boolean checkSymbolo(Symbol _symbol, String identificador, int cantidad1, int cantidad2){
        if(this.Tabla.containsKey(identificador) == false){
            return false;
        }else{
            Stack<Symbol> stack1 = (Stack<Symbol>)this.Tabla.get(identificador);
            Stack<Symbol> stack2 = new Stack<>();
            while(stack1.isEmpty() == false){
                Symbol symboloAux = stack1.pop();
                stack2.add(symboloAux);
                if(symboloAux.alcance == _symbol.alcance){
                    //System.err.println("cant 1: " + symboloAux.alcance. + "        cant 2: " + _symbol.parametros.size());
                    if(cantidad1 != cantidad2){
                        System.err.println("XXXXXXXXXXXXXXXXXXXXXX");
                        return false;
                    }
                    break;
                }
            }
            while(stack2.isEmpty() == false){
                stack1.add(stack2.pop());
            }
            return true;
        }
    }
    
    public Symbol busquedaImplacable(String _symbol, Scope _scope){
        Stack<Symbol> stack1 = Tabla.get(_symbol);
        Stack<Symbol> stack2 = new Stack<>();
        
        Scope s = _scope;
        Symbol simboloAux = null;
        if(Tabla.containsKey(_symbol) == false){
            return null;
        }else{
            while(stack1.isEmpty() == false){
                if(stack2.peek().alcance == s){
                    simboloAux = stack2.peek();
                    while(stack2.isEmpty() == false){
                        stack1.add(stack2.pop()); //se da vuelta el stack
                    }
                    return simboloAux;
                }
                s = s.alcanceSuperior;//se busca mas arriba/afuera
            }
        }
        while(stack2.isEmpty() == false){
            stack1.add(stack2.pop());
        }
        return simboloAux;
    }
    
    public boolean nuevaFuncion(Scope _scope, String identificador){
        if(this.Tabla.containsKey(identificador) == false){
            return false;
        }else{
            Stack<Symbol> stack1 = this.Tabla.get(identificador);
            Stack<Symbol> stack2 = new Stack<>();
            while(stack1.isEmpty() == false){
                Symbol s1 = stack1.pop();
                stack2.add(s1);
                Scope alcanceAux = _scope;
                while(alcanceAux != null){
                    if(stack2.peek().alcance == alcanceAux){
                        while(stack2.isEmpty() == false){
                            Symbol symbolAux = stack2.pop();
                            stack1.add(symbolAux);
                        }
                        return true;
                    }
                    alcanceAux = alcanceAux.alcanceSuperior;
                }
            }
            while(stack2.isEmpty() == false){
                Symbol symbolAux = stack2.pop();
                stack1.push(symbolAux);
            }
            return true;
        }
    }
    
}
