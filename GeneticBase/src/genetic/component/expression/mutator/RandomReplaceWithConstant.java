/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.expression.mutator;

import genetic.component.context.ContextModel;
import genetic.Foundation;
import genetic.GeneticComponent;
import genetic.component.expression.Expression;
import genetic.BuildException;

/**
 *
 * @author Calvin Ashmore
 */
public class RandomReplaceWithConstant extends RandomReplace {

    @Override
    protected Expression getReplacement(Class returnClass, ContextModel model, GeneticComponent parent) throws BuildException {
        return Foundation.getInstance().getExpressionBuilder().newNode(
                Foundation.getInstance().getAllExpressionFunctions().getConstantFunction(returnClass),
                parent);
    }
}
