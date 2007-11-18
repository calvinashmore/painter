/*
 * FunctionGroup.java
 *
 * Created on January 2, 2006, 11:37 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package genetic.component.expression;

import genetic.util.AllComponents;
import java.util.*;

/**
 *
 * @author Ron Ashmore
 */
public interface AllExpressionFunctions extends AllComponents<ExpressionFunction> {
    public Class<ExpressionFunction> getVariableFunction(Class type);
    public Class<ExpressionFunction> getConstantFunction(Class type);
}
