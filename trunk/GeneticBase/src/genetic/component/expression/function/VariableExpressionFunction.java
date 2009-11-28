/*
 * VariableExpressionFunction.java
 * 
 * Created on Nov 3, 2007, 2:00:07 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.expression.function;

import genetic.BuildException;
import genetic.component.context.Context;

/**
 *
 * @author Calvin Ashmore
 */
public class VariableExpressionFunction<Type> extends ExpressionFunction {

    private String variableName;
    private Class<Type> type;

    public VariableExpressionFunction(String variableName, Class<Type> type) {
        this.variableName = variableName;
        this.type = type;
    }

    @Override
    public VariableExpressionFunction<Type> cloneFunction() throws BuildException {
        VariableExpressionFunction<Type> clone = new VariableExpressionFunction(variableName, type);
        clone.setup();
        return clone;
    }

    public String getVariableName() {
        return variableName;
    }

    public Object evaluate(Context context, Object[] inputs) {
        Object value = context.getVariable(variableName);
        if (value == null) {
            System.err.println("WARNING: " + variableName + " is not defined in context!");
            System.err.println("Context variables: " + context.allVariables());
        }
        return value;
    }

    public int getNumberInputs() {
        return 0;
    }

    public Class getInputType(int i) {
        return null;
    }

    public Class getReturnType() {
        return type;
    }
}
