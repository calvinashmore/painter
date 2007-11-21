/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.expression;

import genetic.component.expression.function.ExpressionFunction;
import genetic.ContextModel;
import genetic.GeneticComponent;
import genetic.util.BuildException;
import genetic.util.Builder;

/**
 *
 * @author Calvin Ashmore
 */
public interface ExpressionBuilder extends Builder<Expression> {
    
    public Expression makeTree(Class outputClass, ContextModel cm, GeneticComponent parent) throws BuildException;
    public Expression makeTree(Class outputClass, ContextModel cm, GeneticComponent parent, int depth) throws BuildException;
    public Expression newNode(ExpressionFunction nf, ContextModel cm, GeneticComponent parent) throws BuildException;
}
