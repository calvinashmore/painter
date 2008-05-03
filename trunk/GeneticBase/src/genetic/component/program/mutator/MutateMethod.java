/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.program.mutator;

import genetic.BuildException;
import genetic.Foundation;
import genetic.GeneticTopLevel;
import genetic.MutatorAction;
import genetic.component.method.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class MutateMethod extends MutatorAction<GeneticTopLevel> {

    @Override
    public boolean mutate(GeneticTopLevel target) throws BuildException {
        List<Method> methods = new ArrayList(target.getMethods().values());
        int index = Foundation.getInstance().getBuilderRandom().nextInt(methods.size());
        
        // Mutation seems to work by replacing the whole thing, but this only needs to be done once, at the top
        // selective mutation may be done, but that should probably be a more special thing
        
        return Foundation.getInstance().getMethodMutator().mutate(methods.get(index));
    }
}
