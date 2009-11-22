/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fn;

import fn.parser.ASTFnDefinition;
import fn.parser.ASTFnTopLevel;

/**
 *
 * @author Calvin Ashmore
 */
public class ExpressionFnGroup extends FnGroup<ExpressionFnNode> {

    public ExpressionFnGroup(ASTFnTopLevel top) {
        super(top);
    }

    @Override
    FnNode getNode(ASTFnDefinition fn) {

        if (fn.getTypeAndNames("exin").size() > 0) {
            return new ExpressionContextDependentFnNode(fn);
        } else {
            return new ExpressionFnNode(fn);
        }
    }

    @Override
    String getFnClassName() {
        return "ExpressionFunction";
    }
}
