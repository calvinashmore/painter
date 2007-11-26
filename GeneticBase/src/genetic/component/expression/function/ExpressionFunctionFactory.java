/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.expression.function;

import genetic.ContextModel;
import genetic.util.BuildException;
import genetic.util.Factory;

/**
 *
 * @author Calvin Ashmore
 */
public interface ExpressionFunctionFactory extends Factory<ExpressionFunction> {
    public ExpressionFunction selectByOutput(Class outputClass, ContextModel cm, boolean seekTerminal) throws BuildException;
}