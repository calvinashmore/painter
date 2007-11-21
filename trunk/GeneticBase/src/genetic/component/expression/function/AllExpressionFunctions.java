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

import genetic.ContextModel;
import genetic.util.AllComponents;
import genetic.util.BuildException;
import java.util.*;

/**
 *
 * @author Ron Ashmore
 */
public interface AllExpressionFunctions extends AllComponents<ExpressionFunction> {
    public ExpressionFunction getVariableFunction(Class type, ContextModel cm) throws BuildException;
    public ExpressionFunction getConstantFunction(Class type) throws BuildException;
}
