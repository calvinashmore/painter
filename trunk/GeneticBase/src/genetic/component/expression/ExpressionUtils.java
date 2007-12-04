/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.expression;

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

    /**
     * root must NOT be same as replaced.
     * 
     * @param root
     * @param replaced
     * @param replacer
     * @param cm
     * @throws genetic.util.BuildException
     */
    public static void replaceExpression(Expression expression, Expression replaced, Expression replacer) throws BuildException {

        for(Expression child : gatherNodes(expression)) {
            
            List<Expression> subChildren = child.getChildren();
            for(int i=0; i<subChildren.size(); i++) {
                
                if(subChildren.get(i) == replaced) {
                    child.setInput(i, replacer);
                }
            }
        }
    }

}
