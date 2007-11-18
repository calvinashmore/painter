/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.expression;

import genetic.GeneticFoundation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class ExpressionUtils {

    public static List<Expression> gatherNodes(Expression target) {
        List<Expression> gathered = new ArrayList<Expression>();

        gatherNodes(target, gathered);
        return gathered;
    }

    private static void gatherNodes(Expression target, List<Expression> current) {

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
            gatherNodes(target.getInput(i), current);
        }
    }

    public static Expression removeVariable(Expression expression, String name) {

        Expression r = expression.clone();

        List<Expression> expressions = gatherNodes(r);
        for (Expression expression1 : expressions) {
            if (expression1.getFunction() instanceof VariableExpressionFunction && ((VariableExpressionFunction) expression1.getFunction()).getVariableName().equals(name)) {
                // the expression is a variable, and the variable name matches the variable being removed
                // need to replace the NF with a constant

                *********** REVISE
                
                String nfClassName = expression1.getFunction().getClass().getName().replace("Variable", "Constant");

                ExpressionFunction constant;
                try {
                    constant = (ExpressionFunction) Class.forName(nfClassName).newInstance();
                } catch (InstantiationException ex) {
                    throw new RuntimeException(ex);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                Expression replacement = GeneticFoundation.getInstance().getExpressionBuilder().newNode(constant, cm, expression1.getParent());

                for (Expression expression2 : expressions) {
                    List<Expression> subExpressions = expression2.getChildren();
                    for (int i = 0; i < subExpressions.size(); i++) {
                        if (subExpressions.get(i) == expression1) {
                            expression2.setInput(i, replacement);
                        }
                    }
                }
                if (r == expression1) {
                    r = replacement;
                }
            }
        }

        return r;
    }
}
