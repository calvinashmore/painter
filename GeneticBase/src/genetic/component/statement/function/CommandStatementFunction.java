/*
 * CommandStatement.java
 *
 * Created on September 14, 2006, 5:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.statement.function;

import genetic.component.statement.*;
import genetic.Context;
import genetic.Foundation;
import genetic.component.expression.Expression;
import genetic.component.command.Command;
import genetic.util.BuildException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class CommandStatementFunction extends StatementFunction {
    
    private Command command;
    private List<Expression> expressions;

    @Override
    public void setup() throws BuildException {
        
        List<Command> commands = Foundation.getInstance().getAllCommands().allInstances(getContextModel());
        command = commands.get(Foundation.getInstance().getBuilderRandom().nextInt(commands.size()));
        
        int numberInputs = command.getNumberInputs();
        expressions = new ArrayList<Expression>();
        for(int i=0; i<numberInputs; i++) {
            Class inputClass = command.getInputType(i);
            Expression expression = Foundation.getInstance().getExpressionBuilder().makeTree(
                    inputClass, getContextModel(), this);
            expressions.add(expression);
            
            addChild(expression);
        }
        
        super.setup();
    }

    @Override
    public boolean isNestingStatement() {
        return false;
    }
    
    protected CommandStatementFunction() {
    }

    public void execute(Context context) {
        
        if(expressions.size() > 0) {
            Object objects[] = new Object[expressions.size()];
            for(int i=0;i<expressions.size();i++)
                objects[i] = expressions.get(i).evaluate(context);
            command.execute(context, objects);
        }
        else
            command.execute(context);
    }
}
