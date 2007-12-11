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
import java.util.List;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
public class MutateBranch extends MutatorAction<Expression> {

    @Override
    public boolean mutate(ContextModel model, Expression target) throws BuildException {
        
        List<Expression> allNodes = ExpressionUtils.gatherNodes(target);
        Random rand = Foundation.getInstance().getBuilderRandom();
        
        Factory<ExpressionFunction> nff = Foundation.getInstance().getExpressionFunctionFactory();
        ExpressionBuilder nb = Foundation.getInstance().getExpressionBuilder();
        
        Expression replaced;
        
        for(int i=0;i<100; i++) {
            replaced = allNodes.get(rand.nextInt(allNodes.size()));
            List<ExpressionFunction> insertables = ExpressionFunctionUtils.
                    getOneToBranchFunctions(replaced.getOutputType(), model);
            
            if(insertables.size() == 0)
                continue;
            
            Class<? extends ExpressionFunction> nfClass = insertables.get(rand.nextInt(insertables.size())).getClass();
            ExpressionFunction insertNF = nff.build(nfClass, model);
            
            Expression inserted = nb.newNode(insertNF, replaced.getParent());
            
            boolean hasInserted = false;
            for(int j = 0; j<inserted.getNumberInputs(); j++) {
                
                if(!hasInserted && inserted.getInputType(j) == replaced.getOutputType()) {
                    inserted.setInput(j, replaced);
                    hasInserted = true;
                } else {
                    inserted.setInput(j, nb.makeTree(inserted.getInputType(j), replaced.getParent()));
                }
            }
            
            if(!hasInserted)
                continue;
            
            ExpressionUtils.replaceExpression(target, replaced, inserted);
            return true;
        }
        
        return false;
    }

}
