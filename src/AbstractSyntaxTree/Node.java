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
public interface Node {
    //public String identificador = "";
    public void accept(GrapherVisitor gv);
    public void accept(ExtendedVisitorInterface egv, Symbol _symbol);
}
