/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.expression;

import genetic.util.Factory;

/**
 *
 * @author Calvin Ashmore
 */
public interface ExpressionFunctionFactory extends Factory<ExpressionFunction> {
    public ExpressionFunction selectByOutput(Class outputClass, boolean seekTerminal);
}
