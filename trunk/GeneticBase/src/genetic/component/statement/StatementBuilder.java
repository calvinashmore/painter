/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.statement;

import genetic.GeneticComponent;
import genetic.BuildException;
import genetic.Builder;
import genetic.component.statement.function.StatementFunction;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public interface StatementBuilder extends Builder<Statement> {
    //public Statement buildStatement(ContextModel cm, GeneticComponent parent) throws BuildException;
    //public Statement buildStatement(ContextModel cm, GeneticComponent parent, boolean seekTerminal) throws BuildException;
    public Statement buildStatement(GeneticComponent parent) throws BuildException;
    public Statement buildStatement(StatementFunction sf, GeneticComponent parent) throws BuildException;
    public Statement buildStatement(GeneticComponent parent, boolean seekTerminal) throws BuildException;
    public List<String> getAllowableMethodCalls(GeneticComponent parent);
}
