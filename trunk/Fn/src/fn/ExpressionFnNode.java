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
public class ExpressionFnNode extends FnNode {

    public ExpressionFnNode(ASTFnDefinition fn) {
        super(fn);
    }
    
    @Override
    String getSuperclassName() {
        return "ExpressionFunction";
    }

    @Override
    ClassDescriptor make_class() {
        ClassDescriptor c = super.make_class();
        
        c.addMethod(make_eval());
        
        return c;
    }


}
