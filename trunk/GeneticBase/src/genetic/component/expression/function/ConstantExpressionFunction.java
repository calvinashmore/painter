/*
 * VariableExpressionFunction.java
 * 
 * Created on Nov 3, 2007, 2:00:07 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.expression.function;

import genetic.component.context.Context;

/**
 *
 * @author Calvin Ashmore
 */
public class ConstantExpressionFunction<Type> extends ExpressionFunction {

    private Type value;
    private Class<Type> type;
    public ConstantExpressionFunction(Type value, Class<Type> type) {
        this.value = value;
        this.type = type;
    }
    
    public Object evaluate(Context context, Object[] inputs) {
        return value;
    }

    public int getNumberParameters() {return 1;}
    public Object getParameter(int i) {if(i == 0) return value; else return null;}
    public String getParameterName(int i) {if(i == 0) return "constant value"; else return null;}
    public Class getParameterType(int i) {if(i == 0) return value.getClass(); else return null;}

    public int getNumberInputs() {return 0;}
    public Class getInputType(int i) {return null;}

    public Class getReturnType() {
        return type;
    }

}
