/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.expression;

import genetic.component.expression.function.ExpressionFunction;
import genetic.GeneticComponent;
import genetic.BuildException;
import genetic.Builder;

/**
 *
 * @author Calvin Ashmore
 */
public interface ExpressionBuilder extends Builder<Expression> {
    
    public Expression makeTree(Class outputClass, GeneticComponent parent) throws BuildException;
    public Expression makeTree(Class outputClass, GeneticComponent parent, int depth) throws BuildException;
    public Expression newNode(ExpressionFunction nf, GeneticComponent parent) throws BuildException;
}
