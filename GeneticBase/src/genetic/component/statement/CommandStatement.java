/*
 * CommandStatement.java
 *
 * Created on September 14, 2006, 5:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.statement;

import genetic.Context;
import genetic.component.expression.Expression;
import genetic.expressions.ExpressionException;
import genetic.component.expression.ExpressionFunctionFactory;
import genetic.component.expression.ExpressionMutator;
import genetic.GeneticComponent;
import genetic.component.program.Program;
import genetic.component.statementlist.StatementList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
public class CommandStatement extends Statement {
    
    private String commandName;
    private List<Expression> expressions;
    
    /** Creates a new instance of CommandStatement */
    public CommandStatement(StatementList parent) throws StatementConstructionException {
        setParent(parent);
        
        Program program = getContextModel().getTopLevel();
        List<String> commands = program.getCommands();
        commandName = commands.get(new Random().nextInt(commands.size()));
        
        int numberParameters = program.getCommand(commandName).getNumberInputs();
        
        try {
            expressions = new ArrayList<Expression>();
            for(int i=0;i<numberParameters;i++) {
                Class variableType = program.getCommand(commandName).getInputType(i);
                expressions.add( new ExpressionFunctionFactory(getContextModel()).makeTree(variableType)  );
            }
        } catch(ExpressionException e) {
            throw new StatementConstructionException();
        }
    }
    
    protected CommandStatement() {
    }

    public Statement clone(GeneticComponent newParent) {
        CommandStatement r = new CommandStatement();
        r.setParent((StatementList)newParent);
        r.commandName = commandName;
        r.expressions = new ArrayList<Expression>();
        for(Expression expression : expressions)
            r.expressions.add(expression.clone());
        return r;
    }

    public void execute(Context context) {
        
        if(expressions.size() > 0) {
            Object objects[] = new Object[expressions.size()];
            for(int i=0;i<expressions.size();i++)
                objects[i] = expressions.get(i).evaluate(context);
            getContextModel().getTopLevel().getCommand(commandName).execute(context, objects);
        }
        else
            getContextModel().getTopLevel().getCommand(commandName).execute(context);
    }

    public void mutate() {
        if(expressions.size() == 0)
            return;
        int index = new Random().nextInt(expressions.size());
        expressions.set(index, ExpressionMutator.mutate(getContextModel(), expressions.get(index)));
    }

    public GeneticComponent breed(GeneticComponent component) {
        return null;
    }

    public String printout(String indent) {
        String r = indent+"command."+commandName + " (";
        if(expressions.size() != 0) {
            r += expressions.get(0);
            for(int i=1;i<expressions.size();i++)
                r += ", "+expressions.get(i);
        }
        r += ")\n";
        return r;
    }

    public void removeVariable(String name) {
        for(int i=0;i<expressions.size();i++) {
            expressions.set(i, ExpressionFunctionFactory.removeVariable(expressions.get(i), name));
        }
    }
    
}
