/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.statementlist;

import genetic.BuildException;
import genetic.Foundation;
import genetic.GeneticComponent;
import genetic.component.statement.Statement;
import genetic.component.statement.StatementBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class StatementListBuilderImpl implements StatementListBuilder {

    private static final int numberBaseStatements = 1;
    private static final int numberFlexStatements = 3;
    
    public StatementList build(GeneticComponent parent) {
        return new StatementList(parent);
    }

    public List<Statement> buildChildren(StatementList list) throws BuildException {
        List<Statement> statements = new ArrayList<Statement>();

        StatementBuilder builder = Foundation.getInstance().getStatementBuilder();

        int numberStatements = Foundation.getInstance().getBuilderRandom().
                nextInt(numberFlexStatements) + numberBaseStatements;

        for (int i = 0; i < numberStatements; i++) {
            Statement statement = builder.buildStatement(list.getContextModel(), list);
            statements.add(statement);
        //Statement statementTemplate = factory.select(contextModel, false);
        //Statement statement = factory.build(statementTemplate.getClass(), contextModel);
        //statements.add(statement);
        }
        return statements;
    }
}
