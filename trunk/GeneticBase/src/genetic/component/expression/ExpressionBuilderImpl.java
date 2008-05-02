/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.expression;

import genetic.component.expression.function.ExpressionFunctionFactory;
import genetic.component.expression.function.ExpressionFunction;
import genetic.GeneticComponent;
import genetic.Foundation;
import genetic.BuildException;

/**
 *
 * @author Calvin Ashmore
 */
public class ExpressionBuilderImpl implements ExpressionBuilder {

    private ExpressionFunctionFactory nff;
    //private int targetDepth = 5;
    
    protected int getTargetDepth() {return 5;}

    public ExpressionBuilderImpl() {
        this.nff = Foundation.getInstance().getExpressionFunctionFactory();
    }

    public Expression makeTree(Class outputClass, GeneticComponent parent) throws BuildException {
        return makeTree(outputClass, parent, 0);
    }

    public Expression makeTree(Class outputClass, GeneticComponent parent, int depth) throws BuildException {
        // would also want some space limiting parameters in here...

        // *** seek an appropriate function        
        ExpressionFunction nf = nff.selectByOutput(outputClass, parent.getContextModel(), depth >= getTargetDepth());

        // *** if we are in too deep, seek a terminal function
        if ((depth >= getTargetDepth() && nf != null && nf.getNumberInputs() != 0)) {
            int check = 10;// + (int) Math.sqrt(numberNodes);

            for (int i = 0; i < check && nf != null && nf.getNumberInputs() != 0; i++) {
                nf = nff.selectByOutput(outputClass, parent.getContextModel(), true);
            }
        }

        if (nf == null) {
            throw new BuildException("Cannot find builder with output: " + outputClass + " (" + depth + "/" + getTargetDepth() + " deep)");
        }

        // *** okay, we've found the nf we are looking for,
        // build a real one
        // the current nf is just a shallow copy
        //nf = nff.build(nf.getClass(), parent.getContextModel());

        Expression node = newNode(nf, parent);

        // *** fill subchildren
        //Class inputClasses[] = node.getInputClasses();
        //if(inputClasses != null)
        for (int i = 0; i < node.getNumberInputs(); i++) {
            node.assignChild(i, makeTree(node.getInputType(i), node, depth + 1));
        }

        return node;
    }

    public Expression newNode(ExpressionFunction nf, GeneticComponent parent) {
        return new Expression(nf, parent);
    }
}
