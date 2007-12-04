/*
 * StatementFactory.java
 *
 * Created on August 29, 2006, 5:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.statement.function;

import genetic.component.statement.*;
import genetic.*;
import genetic.util.AbstractFactory;
import genetic.util.BuildException;
import java.util.List;

/**
 *
 * @author gtg126z
 */
public class StatementFunctionFactoryImpl extends AbstractFactory<StatementFunction> implements StatementFunctionFactory {

    public StatementFunction select(ContextModel cm, boolean seekTerminal) throws BuildException {
        List<StatementFunction> allStatements = Foundation.getInstance().getAllStatementFunctions().allInstances(cm);
        
        for (StatementFunction statement : allStatements) {
            statement.is
        }

    }
}
