/*
 * MutateThread.java
 *
 * Created on June 3, 2006, 6:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.expression.mutator;

import genetic.component.expression.*;
import genetic.*;
import genetic.util.Mutator;

/**
 *
 * @author Calvin Ashmore
 */
public class ExpressionMutator extends Mutator<Expression> {

    public ExpressionMutator() {
        getMutators().add(new CollapseBranch());
        getMutators().add(new ExpandConstant());
        getMutators().add(new MutateBranch());
        getMutators().add(new RandomReplace());
        getMutators().add(new RandomReplaceWithConstant());
        getMutators().add(new RandomReplaceWithVariable());
    }
    
}
