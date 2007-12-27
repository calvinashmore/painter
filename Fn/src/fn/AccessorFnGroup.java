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
public class AccessorFnGroup extends FnGroup<ExpressionFnNode> {

    public AccessorFnGroup(ASTFnTopLevel top) {
        super(top);
    }

    @Override
    FnNode getNode(ASTFnDefinition fn) {
        return new AccessorFnNode(fn);
    }

    @Override
    String getFnClassName() {
        return "Accessor";
    }

    
}