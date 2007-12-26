/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fn;

import fn.parser.ASTFnDefinition;
import jd.CompileException;
import jd.JavaCodeDescriptor;

/**
 *
 * @author Calvin Ashmore
 */
public class StatementFnGroup extends FnGroup<StatementFnNode> {

    @Override
    FnNode getNode(ASTFnDefinition fn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    String getFnClassName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public JavaCodeDescriptor compileToJava() throws CompileException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
