/*
 * CommandStatement.java
 *
 * Created on September 14, 2006, 5:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.statement.function;

import genetic.GeneticComponent;
import genetic.component.statement.*;
import genetic.Context;
import genetic.Foundation;
import genetic.component.command.Command;
import genetic.component.expression.Expression;
import genetic.util.BuildException;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class CommandStatementFunction extends StatementFunction {
    
    private Command command;
    //private List<Expression> expressions;

    @Override
    public void setup() throws BuildException {
        
        List<Command> commands = Foundation.getInstance().getAllCommands().allInstances(getContextModel());
        command = commands.get(Foundation.getInstance().getBuilderRandom().nextInt(commands.size()));
        
        super.setup();
    }
    
    @Override public int getNumberInputs() {return command.getNumberInputs();}
    @Override public String getInputName(int i) {return "expression "+i;}
    @Override
    public InputSignature getInputSignature(int i) {
        return new ExpressionInputSignature(command.getInputType(i));
    }
    
    
    @Override
    public void execute(Context context, List<GeneticComponent> inputs) {
        if(inputs.size() > 0) {
            Object objects[] = new Object[inputs.size()];
            for(int i=0;i<inputs.size();i++)
                objects[i] = ((Expression)inputs.get(i)).evaluate(context);
            command.execute(context, objects);
        }
        else
            command.execute(context);
    }
}
