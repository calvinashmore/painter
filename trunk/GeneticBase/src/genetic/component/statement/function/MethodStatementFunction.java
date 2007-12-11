/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.statement.function;

import genetic.component.statement.*;
import genetic.Context;
import genetic.ContextModel;
import genetic.GeneticComponent;
import genetic.component.expression.Expression;
import genetic.component.method.Method;
import genetic.BuildException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class MethodStatementFunction extends StatementFunction {

    //private Method method;
    private String methodName;
    //private List<Expression> expressions;
    
    /**
     * This fails if it has been called twice.
     * Should be assigned by the StatementBuilder if or when MethodStatementFunctions are created.
     * @param methodName
     * @throws genetic.util.BuildException
     */
    public void setMethodName(String methodName) throws BuildException {
        if(this.methodName != null)
            throw new BuildException("Attempting to assign a method name when it is not null!");
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }
    
    @Override
    public void setup() throws BuildException {
        super.setup();
    }
    
    @Override
    public int getNumberInputs() {
        ContextModel cm = getContextModel();
        return cm.getTopLevel().getMethods().get(methodName).getNumberArguments();
    }
    
    @Override
    public String getInputName(int i) {
        ContextModel cm = getContextModel();
        return cm.getTopLevel().getMethods().get(methodName).getArgumentName(i);
    }
    
    @Override
    public InputSignature getInputSignature(int i) {
        ContextModel cm = getContextModel();
        Class type = cm.getTopLevel().getMethods().get(methodName).getArgumentType(i);
        return new ExpressionInputSignature(type);
    }

    @Override
    public void execute(Context context, List<GeneticComponent> inputs) {
        
        Method method = getContextModel().getTopLevel().getMethods().get(methodName);
        
        List<Object> parameters = new ArrayList<Object>();
        for(GeneticComponent input : inputs) {
            Expression expression = (Expression) input;
            parameters.add(expression.evaluate(context));
        }
        method.execute(context, parameters);
    }
    
}
