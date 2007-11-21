/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.expression.mutator;

import genetic.ContextModel;
import genetic.Foundation;
import genetic.component.expression.Expression;
import genetic.component.expression.ExpressionUtils;
import genetic.component.expression.function.ExpressionFunction;
import genetic.util.BuildException;
import genetic.util.MutatorAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
public class ExpandConstant extends MutatorAction<Expression> {

    @Override
    public boolean mutate(ContextModel model, Expression target) throws BuildException {
        List<Expression> allNodes = ExpressionUtils.gatherNodes(target);
        List<Expression> constNodes = new ArrayList();
        
        for(Expression n : allNodes)
            if(n.getFunction().getClass().getName().contains("Constant"))
                constNodes.add(n);
        
        if(constNodes.isEmpty())
            return false;
        
        Random rand = Foundation.getInstance().getBuilderRandom();
        
        Expression constNode = constNodes.get(rand.nextInt(constNodes.size()));
        Class returnClass = constNode.getOutputType();
        
        Expression replacement = Foundation.getInstance().getExpressionBuilder().
                makeTree(returnClass, model, target.getParent());
        //Expression replacement = new Expression(new ExpressionFactory(contextModel).build(returnClass));
        //builder.buildNode(returnClass, target.getContextClass(), false, true, 3, 10, 1);
        
        ExpressionUtils.replaceExpression(target, constNode, replacement, model);
        
        return true;
    }

}
