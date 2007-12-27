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
public class AccessorFnNode extends FnNode {

    public AccessorFnNode(ASTFnDefinition fn) {
        super(fn);
    }

    @Override
    String getSuperclassName() {
        return "Accessor";
    }

    @Override
    ClassDescriptor make_class() {
        ClassDescriptor c = super.make_class();

        c.addMethod(make_eval());

        return c;
    }
}
