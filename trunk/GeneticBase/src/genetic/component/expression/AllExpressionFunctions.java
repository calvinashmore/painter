/*
 * AllFunctions.java
 *
 * Created on February 26, 2006, 12:35 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package genetic.component.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Calvin Ashmore
 */
public class AllExpressionFunctions implements FunctionGroup {
    
    public List<ExpressionFunction> getFunctions() {
        
        List<ExpressionFunction> allFunctions = new ArrayList<ExpressionFunction>();
        allFunctions.addAll(new AllFn().getFunctions());
        return allFunctions;
    }
    
    static private Map<Class, ExpressionFunction> variables = new HashMap<Class, ExpressionFunction>();
    static private Map<Class, ExpressionFunction> constants = new HashMap<Class, ExpressionFunction>();
    
    public static Class<ExpressionFunction> getVariableFunction(Class type) {
        ExpressionFunction f = variables.get(type);
        if(f == null) return null;
        return (Class<ExpressionFunction>) f.getClass();
    }
    
    public static Class<ExpressionFunction> getConstantFunction(Class type) {
        ExpressionFunction f = constants.get(type);
        if(f == null) return null;
        return (Class<ExpressionFunction>) f.getClass();
    }

    public ExpressionFunction build(Class<?extends ExpressionFunction> nfClass,
        ExpressionFunctionFactory nff) {
        // this is not supported for this class...
        return null;
    }
}
