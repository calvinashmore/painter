/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.expression.function;

import genetic.component.context.ContextModel;
import genetic.BuildException;
import genetic.Factory;
import genetic.component.accessor.Accessor;

/**
 *
 * @author Calvin Ashmore
 */
public interface ExpressionFunctionFactory extends Factory<ExpressionFunction> {
    public ExpressionFunction selectByOutput(Class outputClass, ContextModel cm, boolean seekTerminal) throws BuildException;
    public ConstantExpressionFunction  buildConstant(Class type, ContextModel cm) throws BuildException;
    public VariableExpressionFunction  buildVariable(Class type, ContextModel cm) throws BuildException;
    public AccessorFunction  buildAccessor(Accessor accessor, ContextModel cm) throws BuildException;
}
