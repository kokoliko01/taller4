/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import AbstractSyntaxTree.*;
/**
 *
 * @author heave
 */
public interface visitorInterface {
    public void toVisit(NodeCall nodoCall);
    public void toVisit(NodeCompoundStmt nodeCompStmt);
    public void toVisit(NodeExpression nodeExpression);
    public void toVisit(NodeFunDeclaration nodeFunDecl);
    public void toVisit(NodeParam nodeParam);
    public void toVisit(NodeProgram nodeProgram);
    public void toVisit(NodeStatement nodeStmt);
    public void toVisit(NodeVar nodeVar);
    public void toVisit(NodeVarDeclaration nodeVarDecl);
}
