/*
 * VariableExpressionFunction.java
 * 
 * Created on Nov 3, 2007, 2:00:07 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.expression;

import genetic.Context;

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
    
    public String getVariableName() {
        return variableName;
    }
    
    public Object evaluate(Context context, Object[] inputs) {
        return context.getVariable(variableName);
    }

    public int getNumberInputs() {return 0;}
    public Class getInputType(int i) {return null;}

    public Class getReturnType() {
        return type;
    }

}
