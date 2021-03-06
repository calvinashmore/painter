/*
 * StatementFactory.java
 *
 * Created on August 29, 2006, 5:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package genetic.component.statement.function;

import genetic.component.context.ContextModel;
import genetic.component.statement.*;
import genetic.*;
import genetic.AbstractFactory;
import genetic.BuildException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gtg126z
 */
public class StatementFunctionFactoryImpl extends AbstractFactory<StatementFunction> implements StatementFunctionFactory {

    private static final int SELECT_ATTEMPTS = 10;

    public StatementFunction select(ContextModel cm, boolean seekTerminal) throws BuildException {
        List<StatementFunction> allStatements = new ArrayList(Foundation.getInstance().getAllStatementFunctions().allInstances(cm));
        List<StatementFunction> matches;

        if (seekTerminal) {
            matches = new ArrayList<StatementFunction>();
            for (StatementFunction statement : allStatements) {
                if (statement instanceof CommandStatementFunction) {
                    matches.add(statement);
                }
            }
        } else {
            matches = allStatements;
        }

        if (matches.size() == 0) {
            throw new BuildException("Cannot construct a suitable statement!");
        }

        BuildException lastException = null;
        for (int attempt = 0; attempt < SELECT_ATTEMPTS; attempt++) {
            // select from this list, using weights
            double weightTotal = 0;
            for (StatementFunction match : matches) {
                weightTotal += getWeight(cm, match);
            }

            double target = Foundation.getInstance().getBuilderRandom().nextFloat() * weightTotal;
            int index = 0;
            for (StatementFunction match : matches) {
                target -= getWeight(cm, match);
                if (target < 0) {
                    break;
                }
                index++;
            }

            try {
                StatementFunction result = build(matches.get(index).getClass(), cm);
                return result;
            } catch (BuildException ex) {
                lastException = ex;
            }
        }
        throw new BuildException("Could not construct suitable statement!", lastException);
    }

    @Override
    public StatementFunction build(Class<? extends StatementFunction> t, ContextModel cm) throws BuildException {
        StatementFunction sf = super.build(t, cm);
        sf.setContextModel(cm); // this is the parent context model, it may be reassigned to another context model on statement setup
        sf.setup();
        return sf;
    }
}
