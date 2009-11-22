/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.expression.function.cx;

import genetic.component.context.Context;
import genetic.component.context.ContextModel;
import genetic.component.expression.Expression;
import genetic.component.expression.function.ExpressionFunction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class ContextDependentExpressionFunction extends ExpressionFunction {

    @Override
    @Deprecated
    public Object evaluate(Context context, Object[] inputs) {
        throw new UnsupportedOperationException("Cannot do basic evaluate on context dependent expression function.");
    }

    private ContextModel contextModel;
    protected ContextModel getContextModel() {return contextModel;}
    public void setContextModel(ContextModel contextModel) {this.contextModel = contextModel;}

    abstract public Object evaluate(Context context, Object inputs[], List<Expression> contextExpressions);
    public int getNumberContextInputs() {return 0;}
    public Class getContextInputType(int i) {return null;}
    public String getContextInputName(int i) {return "context input "+i;}

    public int getNumberContextVariables() {return 0;}
    public String getContextVariableIntendedName(int i) {return null;}
    public Class getContextVariableType(int i) {return null;}

    private Map<String, String> variableMap = new HashMap();
    public void setContextVariableActualName(String intendedName, String actualName) {
        variableMap.put(intendedName, actualName);
    }
    public String getContextVariableActualName(String intendedName) {
        return variableMap.get(intendedName);
    }
}
