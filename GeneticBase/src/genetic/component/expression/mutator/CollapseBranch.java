/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.expression.mutator;

import genetic.ContextModel;
import genetic.Foundation;
import genetic.component.expression.Expression;
import genetic.component.expression.ExpressionBuilder;
import genetic.component.expression.ExpressionUtils;
import genetic.component.expression.function.ExpressionFunction;
import genetic.component.expression.function.ExpressionFunctionUtils;
import genetic.BuildException;
import genetic.Factory;
import genetic.MutatorAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
public class CollapseBranch extends MutatorAction<Expression> {

    @Override
    public boolean mutate(ContextModel model, Expression target) throws BuildException {
        
        List<Expression> allNodes = ExpressionUtils.gatherNodes(target);
        Random rand = Foundation.getInstance().getBuilderRandom();
        
        Factory<ExpressionFunction> nff = Foundation.getInstance().getExpressionFunctionFactory();
        ExpressionBuilder nb = Foundation.getInstance().getExpressionBuilder();
        
        for(int i=0; i<100; i++) {
            
            // grab our branch function to be collapsed
            Expression replaced = allNodes.get(rand.nextInt(allNodes.size()));
            if(!ExpressionFunctionUtils.isBranchFunction(replaced.getFunction(), replaced.getReturnType()))
                continue;
            
            // find a suitable child of the branch
            List<Expression> branchChildren = new ArrayList<Expression>();
            for(int j=0; j<replaced.getNumberInputs(); j++)
                if(replaced.getInput(i).getReturnType() == replaced.getReturnType())
                    branchChildren.add(replaced);
            if(branchChildren.isEmpty()) // something is wrong
                throw new BuildException("Found a branch node that is not really a branch? "+replaced.getFunction());
            
            Expression branchChild = branchChildren.get(rand.nextInt(branchChildren.size()));
            
            ExpressionUtils.replaceExpression(target, replaced, branchChild);
            return true;
        }
        return false;
    }

}
