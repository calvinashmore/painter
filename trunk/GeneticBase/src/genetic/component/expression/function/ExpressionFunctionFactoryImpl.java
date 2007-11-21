/*
 * NodeFunctionFactory.java
 *
 * Created on September 23, 2005, 11:21 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package genetic.component.expression.function;

import genetic.*;
import genetic.util.BuildException;
import java.util.*;
import java.lang.reflect.*;

/**
 *
 * @author gtg126z
 */
public class ExpressionFunctionFactoryImpl implements ExpressionFunctionFactory {

    public ExpressionFunctionFactoryImpl() {
    }

    public float getFunctionWeight(Class<? extends ExpressionFunction> nfClass) {
        return 1.0f;
    }

    public ExpressionFunction selectByOutput(Class outputClass, ContextModel cm, boolean seekTerminal) throws BuildException {

        List<Class<? extends ExpressionFunction>> matches = new ArrayList<Class<? extends ExpressionFunction>>();
        for (ExpressionFunction nf : GeneticFoundation.getInstance().getAllExpressionFunctions().allInstances(cm)) {
            if (nf.getReturnType() == outputClass &&
                    (!seekTerminal || nf.getNumberInputs() == 0)) {
                matches.add(nf.getClass());
            }
        }

        // if we are seeking a terminal, and there are no possible terminals, go ahead and
        // just select from all possible outputs
        if (matches.size() == 0 && seekTerminal) {
            for (ExpressionFunction nf : GeneticFoundation.getInstance().getAllExpressionFunctions().allInstances(cm)) {
                if (nf.getReturnType() == outputClass) {
                    matches.add(nf.getClass());
                }
            }
        }


        if (matches.size() == 0) {
            System.out.println("Cannot match output class " + outputClass.getName());
            return null;
        }

        // select from this list, using weights
        double weightTotal = 0;
        for (Class<? extends ExpressionFunction> nfc : matches) {
            weightTotal += getFunctionWeight(nfc);
        }

        double target = GeneticFoundation.getInstance().getBuilderRandom().nextFloat() * weightTotal;
        int index = 0;
        for (Class<? extends ExpressionFunction> nfc : matches) {
            target -= getFunctionWeight(nfc);
            if (target < 0) {
                break;
            }
            index++;
        }

        return shallowBuild(matches.get(index), cm);
    }

    public ExpressionFunction shallowBuild(Class<? extends ExpressionFunction> nfClass, ContextModel cm) throws BuildException {

        try {
            return nfClass.newInstance();
        } catch (IllegalAccessException e) {
        } catch (InstantiationException e) {
        }

        throw new BuildException("Failed to instantiate class: " + nfClass.getName());
    }

    public ExpressionFunction deepBuild(Class<? extends ExpressionFunction> nfClass, ContextModel cm) throws BuildException {

        try {
            try {
                Constructor<? extends ExpressionFunction> c = nfClass.getConstructor(ContextModel.class);
                return c.newInstance(cm);
            } catch (NoSuchMethodException e) {
            }

            return nfClass.newInstance();
        } catch (IllegalAccessException e) {
        } catch (InstantiationException e) {
        } catch (InvocationTargetException e) {
        }

        throw new BuildException("Failed to instantiate class: " + nfClass.getName());
    }
}
