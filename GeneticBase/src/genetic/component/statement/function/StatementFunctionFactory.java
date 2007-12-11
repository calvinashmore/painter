/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.statement.function;

import genetic.component.statement.*;
import genetic.ContextModel;
import genetic.BuildException;
import genetic.Factory;

/**
 *
 * @author Calvin Ashmore
 */
public interface StatementFunctionFactory extends Factory<StatementFunction> {
    
    /**
     * Selects and BUILDS a new StatementFunction
     * @param cm
     * @param seekTerminal
     * @return
     * @throws genetic.util.BuildException
     */
    public StatementFunction select(ContextModel cm, boolean seekTerminal) throws BuildException;
}
