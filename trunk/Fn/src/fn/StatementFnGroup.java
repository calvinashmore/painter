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
public class StatementFnGroup extends FnGroup<StatementFnNode> {

    public StatementFnGroup(ASTFnTopLevel top) {
        super(top);
    }
    
    @Override
    FnNode getNode(ASTFnDefinition fn) {
        return new StatementFnNode(fn);
    }

    @Override
    String getFnClassName() {
        return "StatementFunction";
    }

}
