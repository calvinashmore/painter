/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.statementlist.mutator;

import genetic.BuildException;
import genetic.MutatorAction;
import genetic.component.statementlist.StatementList;

/**
 *
 * @author lccstudent
 */
public class ExtractMethod extends MutatorAction<StatementList> {

    @Override
    public boolean mutate(StatementList target) throws BuildException {
        // 1) select statements to isolate
        // 2) create a new method with them in a statement list
        // 3) replace the statements with a call to invoke the method
    }
    
}
