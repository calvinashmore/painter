/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fn;

import fn.parser.ASTFnDefinition;
import jd.ClassDescriptor;
import jd.CodeStringDescriptor;
import jd.Compilable;
import jd.MethodDescriptor;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class FnNode implements Compilable {
    
    private ASTFnDefinition fn;
    
    abstract String getClassName();
    
    
    CodeStringDescriptor make_metaInitializer() {}
    
    // implements Parameterized
    MethodDescriptor make_getNumberParameters() {}
    MethodDescriptor make_getParameter() {}
    MethodDescriptor make_getParameterName() {}
    MethodDescriptor make_getParameterType() {}
    MethodDescriptor make_setParameter() {}
    
    MethodDescriptor make_constructor() {}
    
    MethodDescriptor make_setup() {}
    
    MethodDescriptor make_getOutputType() {}
    MethodDescriptor make_getNumberInputs() {}
    MethodDescriptor make_getInputName() {}
    MethodDescriptor make_getInputType() {}
    
    MethodDescriptor make_eval() {} // this is exec for exec nodes
    
    ClassDescriptor make_class() {}
    
    //getNumberTypes(String id);
    //getType()
}
