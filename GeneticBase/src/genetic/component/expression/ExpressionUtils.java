/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.expression;

import genetic.BuildException;
import genetic.component.statement.Statement;
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
     * 
     * @param root
     * @param replaced
     * @param replacer
     * @param cm
     * @throws genetic.util.BuildException
     */
    public static void replaceExpression(Expression root, Expression replaced, Expression replacer) throws BuildException {

        if (root == replaced) {
            // we are replacing the root itself, so we need to change the parent of root.

            // root has an expression parent, just use that
            if (root.getParent() instanceof Expression) {
                replaceExpression((Expression) root.getParent(), replaced, replacer);
                return;
            }

            // otherwise, the parent should be a statement.
            Statement parent = (Statement) root.getParent();
            for (int i = 0; i < parent.getFunction().getNumberInputs(); i++) {
                if (parent.getInput(i) == root) {
                    parent.setInput(i, replacer);
                }
            }

            return;
        }

        for (Expression child : gatherNodes(root)) {
            List<Expression> subChildren = child.getChildren();
            for (int i = 0; i < subChildren.size(); i++) {
                if (subChildren.get(i) == replaced) {
                    child.setInput(i, replacer);
                }
            }
        }
    }
}
