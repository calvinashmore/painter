/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.statement.function;

import genetic.component.statement.*;
import genetic.ContextModel;
import genetic.util.BuildException;
import genetic.util.Factory;

/**
 *
 * @author Calvin Ashmore
 */
public interface StatementFunctionFactory extends Factory<StatementFunction> {
    public StatementFunction select(ContextModel cm, boolean seekTerminal) throws BuildException;
}
