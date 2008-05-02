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
import genetic.component.context.Context;
import genetic.Foundation;
import genetic.component.command.Command;
import genetic.component.expression.Expression;
import genetic.BuildException;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class CommandStatementFunction extends StatementFunction {

    private Command command;

    @Override
    public void setup() throws BuildException {

        if (command == null) {
            List<Command> commands = Foundation.getInstance().getAllCommands().allInstances(getContextModel());
            command = commands.get(Foundation.getInstance().getBuilderRandom().nextInt(commands.size()));
        }

        super.setup();
    }

    @Override
    public String getName() {
        return command.getClass().getName();
    }

    @Override
    public int getNumberInputs() {
        return command.getNumberInputs();
    }

    @Override
    public String getInputName(int i) {
        return command.getInputName(i);
    }

    @Override
    public InputSignature getInputSignature(int i) {
        return new ExpressionInputSignature(command.getInputType(i));
    }

    @Override
    public Object getMeta(String key) {
        if (command == null) {
            return null;
        }
        return command.getMeta(key);

    }

    @Override
    public String getDescription() {
        if (command == null) {
            return null;
        }
        return command.getDescription();
    }

    @Override
    public void execute(Context context, List<GeneticComponent> inputs) {
        if (inputs.size() > 0) {
            Object objects[] = new Object[inputs.size()];
            for (int i = 0; i < inputs.size(); i++) {
                objects[i] = ((Expression) inputs.get(i)).evaluate(context);
            }
            command.execute(context, objects);
        } else {
            command.execute(context, null);
        }
    }
}
