/*
 * Assignment.java
 *
 * Created on August 22, 2006, 6:01 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.statement;

import genetic.Context;
import genetic.expressions.ExpressionException;
import genetic.component.expression.ExpressionFunctionFactory;
import genetic.GeneticComponent;
import genetic.component.statement.Statement;
import genetic.component.statement.StatementConstructionException;
import genetic.component.statementlist.StatementList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author gtg126z
 */
public class AssignmentStatement extends XAssignmentStatement {
    
    /** Creates a new instance of Assignment */
    public AssignmentStatement(StatementList parent) throws StatementConstructionException {
        try {
            setParent(parent);
            List<String> vars = getContextModel().getAssignableVariables();
            variableName = vars.get( new Random().nextInt(vars.size()) );
            Class variableType = getContextModel().getType(variableName);
            content = new ExpressionFunctionFactory(getContextModel()).makeTree(variableType);
        }
        catch(NullPointerException e) {throw new StatementConstructionException();}
        catch(ArrayIndexOutOfBoundsException e) {throw new StatementConstructionException();}
        catch(IllegalArgumentException e) {throw new StatementConstructionException();}
        catch(ExpressionException e) {throw new StatementConstructionException();}
    }
    
    protected AssignmentStatement() {
    }

    public Statement clone(GeneticComponent newParent) {
        AssignmentStatement r = new AssignmentStatement();
        r.setParent( (StatementList)newParent );
        r.variableName = variableName;
        r.content = content.clone();
        return r;
    }

    public void execute(Context context) {
        context.setVariable(variableName, content.evaluate(context));
        if(getContextModel().getType(variableName) != context.getVariable(variableName).getClass()) {
            System.err.println(content.toString());
            throw new RuntimeException();
        }
    }

    public GeneticComponent breed(GeneticComponent component) {
        return null;
    }

    public String printout(String indent) {
        return indent+"var."+variableName+" = "+content+"\n";
    }
}
