/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractSyntaxTree;

import semantic.Symbol;

/**
 *
 * @author heave
 */
public abstract class NodeTree implements Node {
    public String identificador;
    public double numero;
    public boolean booleano;
    public NodeTree hermanito;
    public Symbol simbolito;
    public int cantidadParametros;
    public NodeFunDeclaration funcionReferencia;
    public String codigo;
    public int direccion;
}
