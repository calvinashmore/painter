/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.foundation.warp;

import genetic.BuildException;
import genetic.component.context.Context;
import genetic.component.context.ContextModel;
import genetic.component.expression.function.ExpressionFunction;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class WarpFunction<InType, OutType> extends ExpressionFunction {

    private String variableName;

    public WarpFunction() {
    }

    @Override
    public ExpressionFunction cloneFunction() throws BuildException {
        WarpFunction clone = (WarpFunction) super.cloneFunction();
        clone.variableName = variableName;
        return clone;
    }

    public String getVariableName() {
        return variableName;
    }

    /**
     * This attempts to get a variable of the appropriate type with the given context.
     * If this method returns false, then the warp function cannot be used.
     * @param cm
     * @return
     */
    public boolean setupVariable(ContextModel cm) {
        List<String> variablesByType = cm.getVariablesByType(getVariableType());
        if(variablesByType.isEmpty())
            return false;
        variableName = variablesByType.get(new Random().nextInt(variablesByType.size()));
        return true;
    }

    abstract public OutType warp(InType value);

    abstract public Class<OutType> getReturnType();

    abstract public Class<InType> getVariableType();

    public OutType evaluate(Context context) {
        Object variable = context.getVariable(variableName);
        return warp((InType) variable);
    }
}
