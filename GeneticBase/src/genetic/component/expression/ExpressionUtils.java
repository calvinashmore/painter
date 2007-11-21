/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.expression;

import genetic.component.expression.function.VariableExpressionFunction;
import genetic.component.expression.function.ExpressionFunction;
import genetic.ContextModel;
import genetic.Foundation;
import genetic.util.BuildException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class ExpressionUtils {

    public static List<Expression> gatherNodes(Expression target) {
        List<Expression> gathered = new ArrayList<Expression>();

        gatherNodesHelper(target, gathered);
        return gathered;
    }

    private static void gatherNodesHelper(Expression target, List<Expression> current) {

        if (target == null) {
            return;
        }

        if (current.contains(target)) {
            return;
        }

        current.add(target);

        //for(Expression n : target.getInputs())
        //    gatherNodes(n, current);
        for (int i = 0; i < target.getNumberInputs(); i++) {
            gatherNodesHelper(target.getInput(i), current);
        }
    }
    
    public static Expression replaceExpressionAndClone(Expression expression, Expression replaced, Expression replacer, ContextModel cm) throws BuildException {

        // sanity case
        if(expression == replaced)
            return replacer;
        
        Expression r = expression.clone();
        for(Expression child : gatherNodes(r)) {
            
            List<Expression> subChildren = child.getChildren();
            for(int i=0; i<subChildren.size(); i++) {
                
                if(subChildren.get(i) == replaced) {
                    child.setInput(i, replacer);
                }
            }
        }
        
        return r;
    }

    /**
     * root must NOT be same as replaced.
     * 
     * @param root
     * @param replaced
     * @param replacer
     * @param cm
     * @throws genetic.util.BuildException
     */
    public static void replaceExpression(Expression expression, Expression replaced, Expression replacer, ContextModel cm) throws BuildException {

        for(Expression child : gatherNodes(expression)) {
            
            List<Expression> subChildren = child.getChildren();
            for(int i=0; i<subChildren.size(); i++) {
                
                if(subChildren.get(i) == replaced) {
                    child.setInput(i, replacer);
                }
            }
        }
    }

    public static Expression removeVariableAndClone(Expression expression, String name, ContextModel cm) throws BuildException {

        Expression r = expression.clone();

        List<Expression> expressions = gatherNodes(r);
        for (Expression expression1 : expressions) {
            
            if(!(expression1.getFunction() instanceof VariableExpressionFunction))
                continue;
            
            VariableExpressionFunction function1 = (VariableExpressionFunction) expression1.getFunction();
            
            if(!function1.getVariableName().equals(name))
                continue;

            // the expression is a variable, and the variable name matches the variable being removed
            // need to replace the NF with a constant

            Class returnType = function1.getReturnType();
            ExpressionFunction constantFunction = Foundation.getInstance().getAllExpressionFunctions().getConstantFunction(returnType);
            Expression constantExpression = Foundation.getInstance().getExpressionBuilder().newNode(constantFunction, cm, expression1.getParent());

            if(r == expression1)
                return constantExpression;
            
            replaceExpression(r, expression1, constantExpression, cm);
            
        }

        return r;
    }
}
