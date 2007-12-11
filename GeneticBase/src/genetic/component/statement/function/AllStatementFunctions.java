/*
 * AllStatements.java
 * 
 * Created on Nov 3, 2007, 1:14:41 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.statement.function;

import genetic.component.statement.*;
import genetic.ContextModel;
import genetic.AllComponents;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class AllStatementFunctions implements AllComponents<StatementFunction> {

    public List<StatementFunction> allInstances(ContextModel cm) {
        List<StatementFunction> statements = new ArrayList<StatementFunction>();
        
        statements.add(new AssignmentStatementFunction());
        statements.add(new CommandStatementFunction());
        statements.add(new MethodStatementFunction());
        return statements;
    }
    

}
