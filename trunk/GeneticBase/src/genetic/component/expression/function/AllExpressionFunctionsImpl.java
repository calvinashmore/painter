/*
 * AllFunctions.java
 *
 * Created on February 26, 2006, 12:35 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package genetic.component.expression.function;

import genetic.ContextModel;
import genetic.Foundation;
import genetic.util.BuildException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Calvin Ashmore
 */
public class AllExpressionFunctionsImpl implements AllExpressionFunctions {
    
    public VariableExpressionFunction getVariableFunction(Class type, ContextModel cm) throws BuildException {
        List<String> variables = cm.getVariablesByType(type);
        if(variables.size() == 0)
            throw new BuildException("No variables of type "+type);
        String name = variables.get(Foundation.getInstance().getBuilderRandom().nextInt(variables.size()));
        return new VariableExpressionFunction(name, type);
    }
    
    public ConstantExpressionFunction getConstantFunction(Class type) {
        Object result = Foundation.getInstance().getTypeSystem().createRandom(type);
        return new ConstantExpressionFunction(result,type);
    }

    public List<ExpressionFunction> allInstances(ContextModel cm) {
        List<ExpressionFunction> allFunctions = new ArrayList<ExpressionFunction>();
        return allFunctions;
    }

}
