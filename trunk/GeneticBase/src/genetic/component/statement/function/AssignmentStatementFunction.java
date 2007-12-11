/*
 * XAssignmentStatement.java
 *
 * Created on September 28, 2006, 1:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.statement.function;

import genetic.GeneticComponent;
import genetic.component.statement.*;
import genetic.Context;
import genetic.ContextModel;
import genetic.Foundation;
import genetic.component.expression.Expression;
import genetic.BuildException;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class AssignmentStatementFunction extends StatementFunction {
    
    //protected Expression content;
    protected String variableName;
    protected Class variableType;
    
    // note: we do not override hasVariable to include "variableName"
    // since that is not actually *used*, though it is assigned to.
    
    public String getVariableName() {return variableName;}
    public Class getVariableType() {return variableType;}
    
    @Override
    public void setup() throws BuildException {
        ContextModel contextModel = getContextModel();
        List<String> variables = contextModel.getAssignableVariables();
        
        if(variables.size() == 0)
            throw new BuildException("Cannot create an AssignmentStatement without variables");
        
        variableName = variables.get(Foundation.getInstance().getBuilderRandom().nextInt(variables.size()));
        variableType = contextModel.getType(variableName);
        
        //content = Foundation.getInstance().getExpressionBuilder().makeTree(variableType, getContextModel(), this);
        //addChild(content);
        
        super.setup();
    }
    
    protected void performAssignment(Context context, Object expressionResult) {
        context.setVariable(getVariableName(), expressionResult);
    }
    
    @Override public int getNumberInputs() {return 1;}
    @Override public String getInputName(int i) {return "expression";}
    @Override public InputSignature getInputSignature(int i) {
        return new ExpressionInputSignature(variableType);
    }
    
    @Override
    public void execute(Context context, List<GeneticComponent> inputs) {
        Expression content = (Expression) inputs.get(0);
        
        Object expressionResult = content.evaluate(context);
        performAssignment(context, expressionResult);
    }
}
