/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import AbstractSyntaxTree.*;
import semantic.Symbol;

/**
 *
 * @author heave
 */
public interface ExtendedVisitorInterface {
    public void toVisit(NodeCall nodoCall, Symbol _symbol);
    public void toVisit(NodeCompoundStmt nodeCompStmt, Symbol _symbol);
    public void toVisit(NodeExpression nodeExpression, Symbol _symbol);
    public void toVisit(NodeFunDeclaration nodeFunDecl, Symbol _symbol);
    public void toVisit(NodeParam nodeParam, Symbol _symbol);
    public void toVisit(NodeProgram nodeProgram, Symbol _symbol);
    public void toVisit(NodeStatement nodeStmt, Symbol _symbol);
    public void toVisit(NodeVar nodeVar, Symbol _symbol);
    public void toVisit(NodeVarDeclaration nodeVarDecl, Symbol _symbol);
}
