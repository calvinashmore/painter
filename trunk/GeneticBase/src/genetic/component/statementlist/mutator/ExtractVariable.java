/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.statementlist.mutator;

import genetic.BuildException;
import genetic.Foundation;
import genetic.GeneticComponent;
import genetic.MutatorAction;
import genetic.component.expression.Expression;
import genetic.component.expression.function.VariableExpressionFunction;
import genetic.component.statement.Statement;
import genetic.component.statement.function.AssignmentStatementFunction;
import genetic.component.statementlist.StatementList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author lccstudent
 */
public class ExtractVariable extends MutatorAction<StatementList> {

    private class Result {

        Expression expression;
        Statement statement;
        int index;

        public Result(Expression expression, Statement statement, int index) {
            this.expression = expression;
            this.statement = statement;
            this.index = index;
        }
    }

    @Override
    public boolean mutate(StatementList target) throws BuildException {
        // 1) find an expression to replace
        Result expressionResult = findExpression(target);
        if (expressionResult == null) {
            return false;
        }

        // 2) create a new variable in the context model
        Class variableType = expressionResult.expression.getOutputType();
        String variableName = target.getContextModel().declareVariable(variableType, false);

        // 3) introduce a variable declaration statement
        AssignmentStatementFunction assignment = new AssignmentStatementFunction();
        assignment.setVariable(variableName, variableType);
        Statement declaration = new Statement(assignment, target);
        List<Statement> newStatements = new ArrayList(target.getStatements());
        newStatements.add(0, declaration);
        target.setStatements(newStatements.toArray(new Statement[newStatements.size()]));

        // 4) replace the existing statement with the variable reference
        VariableExpressionFunction variable = new VariableExpressionFunction(variableName, variableType);
        Expression variableExpression = new Expression(variable, expressionResult.statement);
        expressionResult.statement.setInput(expressionResult.index, variableExpression);
        
        // hopefully this approach clears up all of those references and does not leave any
        // strange memory leaks.

        return true;
    }
    private int NUMBER_ATTEMPTS = 5;

    private Result findExpression(StatementList target) {
        for (int i = 0; i < NUMBER_ATTEMPTS; i++) {

            // select a statement
            int numberStatements = target.getStatements().size();
            Random rand = Foundation.getInstance().getBuilderRandom();
            Statement statement = target.getStatements().get(rand.nextInt(numberStatements));

            // Does this statement have an expression in it?
            for (int j = 0; j < NUMBER_ATTEMPTS; j++) {
                int numberInputs = statement.getFunction().getNumberInputs();
                int index = rand.nextInt(numberInputs);
                GeneticComponent input = statement.getInput(index);
                if (input instanceof Expression) {
                    return new Result((Expression) input, statement, index);
                }
            }
        }
        return null;
    }
}
