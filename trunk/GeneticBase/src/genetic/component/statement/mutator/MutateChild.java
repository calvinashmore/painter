/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.statement.mutator;

import genetic.BuildException;
import genetic.Foundation;
import genetic.GeneticComponent;
import genetic.GeneticFoundation;
import genetic.MutatorAction;
import genetic.component.expression.Expression;
import genetic.component.statement.Statement;
import genetic.component.statementlist.StatementList;

/**
 *
 * @author Calvin Ashmore
 */
public class MutateChild extends MutatorAction<Statement> {

    @Override
    public boolean mutate(Statement target) throws BuildException {
        int numberInputs = target.getFunction().getNumberInputs();

        if (numberInputs == 0) {
            return false;
        }
        GeneticFoundation foundation = Foundation.getInstance();
        int index = foundation.getBuilderRandom().nextInt(numberInputs);
        GeneticComponent input = target.getInput(index);
        if (input instanceof StatementList) {
            return foundation.getStatementListMutator().mutate((StatementList) input);
        } else if (input instanceof Expression) {
            return foundation.getExpressionMutator().mutate((Expression) input);
        } else {
            // should never reach here
            return false;
        }
    }
}
