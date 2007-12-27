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
public class CommandFnGroup extends FnGroup<ExpressionFnNode> {

    public CommandFnGroup(ASTFnTopLevel top) {
        super(top);
    }

    @Override
    FnNode getNode(ASTFnDefinition fn) {
        return new CommandFnNode(fn);
    }

    @Override
    String getFnClassName() {
        return "Command";
    }

    
}