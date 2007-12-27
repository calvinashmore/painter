/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fn;

import fn.parser.ASTFnDefinition;
import jd.ClassDescriptor;

/**
 *
 * @author Calvin Ashmore
 */
public class CommandFnNode extends FnNode {

    public CommandFnNode(ASTFnDefinition fn) {
        super(fn);
    }

    @Override
    String getSuperclassName() {
        return "Command";
    }

    @Override
    ClassDescriptor make_class() {
        ClassDescriptor c = super.make_class();

        c.addMethod(make_exec());

        return c;
    }
}
