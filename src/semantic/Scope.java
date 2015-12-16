/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantic;

/**
 *
 * @author heave
 */
public class Scope {
    public static int identificador;
    public static Scope alcanceSuperior;
    
    public Scope(int id, Scope alcance){
        Scope.identificador = id;
        Scope.alcanceSuperior = alcance;
    }
}
