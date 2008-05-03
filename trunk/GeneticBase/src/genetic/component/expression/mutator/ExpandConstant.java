/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.expression.mutator;

import genetic.Foundation;
import genetic.component.expression.Expression;
import genetic.component.expression.ExpressionUtils;
import genetic.component.expression.function.ConstantExpressionFunction;
import genetic.BuildException;
import genetic.MutatorAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
public class ExpandConstant extends MutatorAction<Expression> {

    @Override
    public boolean mutate(Expression target) throws BuildException {
        List<Expression> allNodes = ExpressionUtils.gatherNodes(target);
        List<Expression> constNodes = new ArrayList();
        
        for(Expression n : allNodes)
            if(n.getFunction() instanceof ConstantExpressionFunction)
                constNodes.add(n);
        
        if(constNodes.isEmpty())
            return false;
        
        Random rand = Foundation.getInstance().getBuilderRandom();
        
        Expression constNode = constNodes.get(rand.nextInt(constNodes.size()));
        Class returnClass = constNode.getOutputType();
        
        Expression replacement = Foundation.getInstance().getExpressionBuilder().
                makeTree(returnClass, target.getParent());
        
        ExpressionUtils.replaceExpression(target, constNode, replacement);
        
        return true;
    }

}
