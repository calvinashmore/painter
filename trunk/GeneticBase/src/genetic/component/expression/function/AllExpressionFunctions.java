/*
 * FunctionGroup.java
 *
 * Created on January 2, 2006, 11:37 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package genetic.component.expression.function;

import genetic.component.context.ContextModel;
import genetic.AllComponents;
import genetic.BuildException;
import java.util.*;

/**
 *
 * @author Ron Ashmore
 */
public interface AllExpressionFunctions extends AllComponents<ExpressionFunction> {
    public VariableExpressionFunction getVariableFunction(Class type, ContextModel cm) throws BuildException;
    public ConstantExpressionFunction getConstantFunction(Class type) throws BuildException;
    public List<ExpressionFunction> allFunctionsByType(Class type, ContextModel cm) throws BuildException;
}
