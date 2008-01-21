/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.statementlist;

import genetic.BuildException;
import genetic.Builder;
import genetic.GeneticComponent;
import genetic.component.statement.Statement;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public interface StatementListBuilder extends Builder<StatementList>{
    public StatementList build(GeneticComponent parent);
    public List<Statement> buildChildren(StatementList list) throws BuildException ;
}
