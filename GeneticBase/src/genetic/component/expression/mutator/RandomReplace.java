/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.expression.mutator;

import genetic.ContextModel;
import genetic.Foundation;
import genetic.GeneticComponent;
import genetic.component.expression.Expression;
import genetic.component.expression.ExpressionUtils;
import genetic.BuildException;
import genetic.MutatorAction;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
public class RandomReplace extends MutatorAction<Expression> {

    protected Expression getReplacement(Class returnClass, ContextModel model, GeneticComponent parent) throws BuildException {
        return Foundation.getInstance().getExpressionBuilder().
                makeTree(returnClass, parent);
    }
    
    @Override
    public boolean mutate(ContextModel model, Expression target) throws BuildException {
        List<Expression> allNodes = ExpressionUtils.gatherNodes(target);
        
        Random rand = Foundation.getInstance().getBuilderRandom();
        
        Expression replaced = allNodes.get(rand.nextInt(allNodes.size()));
        Class returnClass = replaced.getOutputType();
        
        Expression replacement = getReplacement(returnClass, model, replaced.getParent());
        
        ExpressionUtils.replaceExpression(target, replaced, replacement);
        
        return true;
    }

}
