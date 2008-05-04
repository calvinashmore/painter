/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.statementlist.mutator;

import genetic.BuildException;
import genetic.Foundation;
import genetic.GeneticFoundation;
import genetic.MutatorAction;
import genetic.component.statement.Statement;
import genetic.component.statementlist.StatementList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class InjectStatement extends MutatorAction<StatementList> {

    @Override
    public boolean mutate(StatementList target) throws BuildException {
        List<Statement> statements = new ArrayList<Statement>(target.getStatements());

        GeneticFoundation foundation = Foundation.getInstance();

        int index = foundation.getBuilderRandom().nextInt(statements.size());

        Statement newStatement = foundation.getStatementBuilder().buildStatement(target);
        statements.add(index, newStatement);

        target.setStatements(statements.toArray(new Statement[statements.size()]));
        return true;
    }
}
