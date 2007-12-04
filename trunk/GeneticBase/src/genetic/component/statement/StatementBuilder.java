/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.statement;

import genetic.util.Builder;

/**
 *
 * @author Calvin Ashmore
 */
public interface StatementBuilder extends Builder<Statement> {
    public Statement buildStatement();
}
