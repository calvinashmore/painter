/*
 * AccessorFunction.java
 *
 * Created on October 5, 2006, 2:31 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.expression;

import genetic.component.expression.accessor.Accessor;
import genetic.*;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class AccessorFunction extends ExpressionFunction {
    String name;
    Class[] inputClasses;
    
    /** Creates a new instance of Variable */
    public AccessorFunction() {}
    public AccessorFunction(ContextModel contextModel) {
        List<String> accessors = contextModel.getTopLevel().getAccessorsByType( getReturnType() );
        name = accessors.get(new Random().nextInt(accessors.size()));
        
        Accessor accessor = contextModel.getTopLevel().getAccessor(name);
        if(accessor.getNumberParameters() > 0) {
            inputClasses = new Class[accessor.getNumberParameters()];
            for(int i=0;i< accessor.getNumberParameters();i++)
                inputClasses[i] = accessor.getParameterType(i);
        } else {
            inputClasses = null;
        }
        
    }

    public Object evaluate(Object[] inputs, Context context) {
        //return context.getVariable(name);
        return context.getModel().getTopLevel().getAccessor(name).evaluate(inputs);
    }

    public Class[] getInputClasses() {
        return inputClasses;
    }
    
    public String toString(String... args) {
        String r = "accessor."+name+"(";
        if(args != null && args.length > 0) {
            r += " "+args[0];
            for(int i=1;i<args.length;i++)
                r += ", "+args[i];
            r += " ";
        }
        r += ")";
        return r;
    }
    
}
