/*
 * XAssignmentStatement.java
 *
 * Created on September 28, 2006, 1:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.statement.function;

import genetic.component.statement.*;
import genetic.Context;
import genetic.ContextModel;
import genetic.Foundation;
import genetic.component.expression.Expression;
import genetic.util.BuildException;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class AssignmentStatementFunction extends StatementFunction {
    
    protected Expression content;
    protected String variableName;
    
    // note: we do not override hasVariable to include "variableName"
    // since that is not actually *used*, though it is assigned to.
    
    public String getVariableName() {return variableName;}

    @Override
    public void setup() throws BuildException {
        ContextModel contextModel = getContextModel();
        List<String> variables = contextModel.getAssignableVariables();
        
        if(variables.size() == 0)
            throw new BuildException("Cannot create an AssignmentStatement without variables");
        
        variableName = variables.get(Foundation.getInstance().getBuilderRandom().nextInt(variables.size()));
        Class variableType = contextModel.getType(variableName);
        
        content = Foundation.getInstance().getExpressionBuilder().makeTree(variableType, getContextModel(), this);
        addChild(content);
        
        super.setup();
    }
    
    @Override
    public boolean isNestingStatement() {
        return false;
    }
    
    @Override
    public void removeVariable(String name) {
        // try: check current variable name, if current is removed, switch to another, or post for destroy??
        // otherwise, pass to expression
        
        if(name.equals(getVariableName())) {
            setDestroyFlag(true);
            return;
        }
        
        super.removeVariable(name);
    }

    @Override
    public void execute(Context context) {
        Object expressionResult = content.evaluate(context);
        performAssignment(context, expressionResult);
    }
    
    protected void performAssignment(Context context, Object expressionResult) {
        context.setVariable(getVariableName(), expressionResult);
    }
}
