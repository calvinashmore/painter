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

    /**
     * Builds a new statement under the specified parent, using a randomly selected StatementFunction, and fills in its children.
     * @param parent
     * @return
     * @throws genetic.BuildException
     */
    public Statement buildStatement(GeneticComponent parent) throws BuildException;

    /**
     * Builds a new terminal statement under the specified parent, using a randomly selected StatementFunction, and fills in its children.
     * Terminal means that the statement does not have StatementLists as children.
     * @param parent
     * @param seekTerminal
     * @return
     * @throws genetic.BuildException
     */
    public Statement buildStatement(GeneticComponent parent, boolean seekTerminal) throws BuildException;

    /**
     * Builds a new statement using the given statement function, and also fills in its children.
     * @param sf
     * @param parent
     * @return
     * @throws genetic.BuildException
     */
    public Statement buildStatement(StatementFunction statementFunction, GeneticComponent parent) throws BuildException;

    /**
     * Builds a new statement using the given statement function, but does not fill in the children.
     * These are left as null by default.
     * @param statementFunction
     * @param parent
     * @return
     * @throws genetic.BuildException
     */
    public Statement buildEmptyStatement(StatementFunction statementFunction, GeneticComponent parent) throws BuildException;

    /**
     * Returns a list of names corresponding to Methods in the program which it is safe for a statement generated under parent to call.
     * The goal of this method is to identify methods that will not generate cyclic behavior.
     * @param parent
     * @return
     */
    public List<String> getAllowableMethodCalls(GeneticComponent parent);
}
