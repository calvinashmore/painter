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

import genetic.component.context.ContextModel;
import genetic.*;
import genetic.AbstractFactory;
import genetic.BuildException;
import genetic.component.accessor.Accessor;
import java.util.*;
import java.lang.reflect.*;

/**
 *
 * @author gtg126z
 */
public class ExpressionFunctionFactoryImpl extends AbstractFactory<ExpressionFunction>
        implements ExpressionFunctionFactory {

    public ExpressionFunctionFactoryImpl() {
    }
    private static final int SELECT_ATTEMPTS = 10;

    public ExpressionFunction selectByOutput(Class outputClass, ContextModel cm, boolean seekTerminal) throws BuildException {

        List<ExpressionFunction> matches = new ArrayList<ExpressionFunction>();
        for (ExpressionFunction nf : Foundation.getInstance().getAllExpressionFunctions().allInstances(cm)) {
            if (nf.getReturnType() == outputClass &&
                    (!seekTerminal || nf.getNumberInputs() == 0)) {
                matches.add(nf);
            }
        }

        // if we are seeking a terminal, and there are no possible terminals, go ahead and
        // just select from all possible outputs
        if (matches.size() == 0 && seekTerminal) {
            for (ExpressionFunction nf : Foundation.getInstance().getAllExpressionFunctions().allInstances(cm)) {
                if (nf.getReturnType() == outputClass) {
                    matches.add(nf);
                }
            }
        }

        if (matches.size() == 0) {
            //System.out.println("Cannot match output class " + outputClass.getName());
            throw new BuildException("Cannot match output class " + outputClass.getName());
        }

        BuildException lastException = null;
        for (int attempt = 0; attempt < SELECT_ATTEMPTS; attempt++) {

            // select from this list, using weights
            double weightTotal = 0;
            for (ExpressionFunction nfc : matches) {
                weightTotal += getWeight(cm, nfc);
            }

            double target = Foundation.getInstance().getBuilderRandom().nextFloat() * weightTotal;
            int index = 0;
            for (ExpressionFunction nfc : matches) {
                target -= getWeight(cm, nfc);
                if (target < 0) {
                    break;
                }
                index++;
            }

            try {
                ExpressionFunction template = matches.get(index);

                if (template instanceof ConstantExpressionFunction) {
                    return buildConstant(((ConstantExpressionFunction) template).getReturnType(), cm);
                }

                if (template instanceof VariableExpressionFunction) {
                    return buildVariable(((VariableExpressionFunction) template).getReturnType(), cm);
                }

                if (template instanceof AccessorFunction) {
                    return buildAccessor(((AccessorFunction) template).getAccessor(), cm);
                }

                ExpressionFunction nf = build(template.getClass(), cm);
                return nf;
            } catch (BuildException ex) {
                lastException = ex;
            }
        }
        throw new BuildException("Could not build a suitable match", lastException);
    }

    public ConstantExpressionFunction buildConstant(Class type, ContextModel cm) throws BuildException {
        ConstantExpressionFunction nf = Foundation.getInstance().getAllExpressionFunctions().getConstantFunction(type);
        return nf;
    }

    public VariableExpressionFunction buildVariable(Class type, ContextModel cm) throws BuildException {
        VariableExpressionFunction nf = Foundation.getInstance().getAllExpressionFunctions().getVariableFunction(type, cm);
        return nf;
    }

    public AccessorFunction buildAccessor(Accessor accessor, ContextModel cm) throws BuildException {
        return new AccessorFunction(accessor);
    }

    @Override
    public ExpressionFunction build(Class<? extends ExpressionFunction> t, ContextModel cm) throws BuildException {
        ExpressionFunction nf = super.build(t, cm);
        nf.setup();
        return nf;
    }
}
