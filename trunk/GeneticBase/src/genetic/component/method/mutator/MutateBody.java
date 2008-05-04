/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.method.mutator;

import genetic.BuildException;
import genetic.Foundation;
import genetic.MutatorAction;
import genetic.component.method.Method;

/**
 *
 * @author Calvin Ashmore
 */
public class MutateBody extends MutatorAction<Method> {

    @Override
    public boolean mutate(Method target) throws BuildException {
        return Foundation.getInstance().getStatementListMutator().mutate(target.getBody());
    }
}
