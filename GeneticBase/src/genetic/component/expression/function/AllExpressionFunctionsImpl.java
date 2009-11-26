/*
 * AllFunctions.java
 *
 * Created on February 26, 2006, 12:35 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package genetic.component.expression.function;

import genetic.component.context.ContextModel;
import genetic.Foundation;
import genetic.component.accessor.Accessor;
import genetic.BuildException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class AllExpressionFunctionsImpl implements AllExpressionFunctions {

    public VariableExpressionFunction getVariableFunction(Class type, ContextModel cm) throws BuildException {
        List<String> variables = cm.getVariablesByType(type);
        if (variables.size() == 0) {
            throw new BuildException("No variables of type " + type);
        }
        String name = variables.get(Foundation.getInstance().getBuilderRandom().nextInt(variables.size()));
        return new VariableExpressionFunction(name, type);
    }

    public ConstantExpressionFunction getConstantFunction(Class type) {
        Object result = Foundation.getInstance().getTypeSystem().createRandom(type);
        return new ConstantExpressionFunction(result, type);
    }

    /**
     * The default implementation of this returns the variable and constant functions,
     * as well as the accessors. These are all type or context dependent.
     * @param cm
     * @return
     */
    public List<ExpressionFunction> allInstances(ContextModel cm) {
        List<ExpressionFunction> allFunctions = new ArrayList<ExpressionFunction>();

        for (Class type : Foundation.getInstance().getTypeSystem().allTypes()) {
            try {
                // add a variable function if we can, otherwise ignore
                ExpressionFunction function = getVariableFunction(type, cm);
                allFunctions.add(function);
            } catch (BuildException e) {
            }
            allFunctions.add(getConstantFunction(type));
        }

        for (Accessor accessor : Foundation.getInstance().getAllAccessors().allInstances(cm)) {
            allFunctions.add(new AccessorFunction(accessor));
        }

        return allFunctions;
    }

    public List<ExpressionFunction> allFunctionsByType(Class type, ContextModel cm) throws BuildException {

        List<ExpressionFunction> allByType = new ArrayList<ExpressionFunction>();

        if (Foundation.getInstance().getTypeSystem().allTypes().contains(type)) {
            try {
                ExpressionFunction variableFunction = getVariableFunction(type, cm);
                if (variableFunction != null) {
                    allByType.add(variableFunction);
                }
            } catch (BuildException ex) {
            }

            ExpressionFunction constantFunction = getConstantFunction(type);
            if (constantFunction != null) {
                allByType.add(constantFunction);
            }
        }

        for (Accessor accessor : Foundation.getInstance().getAllAccessors().allInstances(cm)) {
            if (accessor.getReturnType() == type) {
                allByType.add(new AccessorFunction(accessor));
            }
        }

        return allByType;
    }
}
