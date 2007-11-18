/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.expression;

import genetic.ContextModel;
import genetic.GeneticComponent;
import genetic.GeneticFoundation;
import genetic.util.BuildException;

/**
 *
 * @author Calvin Ashmore
 */
public class ExpressionBuilderImpl implements ExpressionBuilder {

    private ExpressionFunctionFactory nff;
    private int targetDepth = 5;

    public ExpressionBuilderImpl() {
        this.nff = GeneticFoundation.getInstance().getExpressionFunctionFactory();
    }

    public Expression makeTree(Class outputClass, ContextModel cm, GeneticComponent parent) throws BuildException {
        return makeTree(outputClass, cm, parent, 0);
    }

    public Expression makeTree(Class outputClass, ContextModel cm, GeneticComponent parent, int depth) throws BuildException {
        // would also want some space limiting parameters in here...

        // *** seek an appropriate function        
        ExpressionFunction nf = nff.selectByOutput(outputClass, cm, depth >= targetDepth);

        // *** if we are in too deep, seek a terminal function
        if ((depth >= targetDepth && nf != null && nf.getNumberInputs() != 0)) {
            int check = 10;// + (int) Math.sqrt(numberNodes);

            for (int i = 0; i < check && nf != null && nf.getNumberInputs() != 0; i++) {
                nf = nff.selectByOutput(outputClass, cm, true);
            }
        }

        if (nf == null) {
            throw new BuildException("Cannot find builder with output: " + outputClass + " (" + depth + "/" + targetDepth + " deep)");
        }


        // *** okay, we've found the nf we are looking for,
        // build a real one
        // the current nf is just a shallow copy
        nf = nff.deepBuild(nf.getClass(), cm);

        Expression node = newNode(nf, cm, parent);

        // *** fill subchildren
        //Class inputClasses[] = node.getInputClasses();
        //if(inputClasses != null)
        for (int i = 0; i < node.getNumberInputs(); i++) {
            node.assignChild(i, makeTree(node.getInputType(i), cm, node, depth + 1));
        }

        return node;
    }

    public Expression newNode(ExpressionFunction nf, ContextModel cm, GeneticComponent parent) {
        return new Expression(nf, cm, parent);
    }
}
