/*
 * Mutator.java
 * 
 * Created on Nov 4, 2007, 5:52:15 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.util;

import genetic.ContextModel;
import genetic.GeneticComponent;
import genetic.GeneticFoundation;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
public class Mutator<T extends GeneticComponent> {
    
    protected Random getRandom() {
        return GeneticFoundation.getFoundation().getBuilderRandom();
    }
    
    private List<MutatorAction<T>> mutators = new ArrayList<MutatorAction<T>>();
    protected List<MutatorAction<T>> getMutators() {return mutators;}
    
    protected int getNumberAttempts() {return 5;}
    
    public T mutate(GeneticComponent newParent, ContextModel model, T target) {
        
        for(int i=0; i<getNumberAttempts(); i++) {
            MutatorAction<T> action = selectAction();
            if(action == null)
                continue;
            
            T test = (T) target.clone(target.getParent());
            if(action.mutate(model, test)) {
                test.resetParent(newParent);
                return test;
            }
        }
        return null;
    }
    
    protected float getWeight(MutatorAction action) {
        return 1.0f;
    }
    
    protected MutatorAction<T> selectAction() {
        float totalWeights = 0;
        for (MutatorAction<T> action : getMutators()) {
            totalWeights += getWeight(action);
        }
        
        float selection = totalWeights*getRandom().nextFloat();
        for (MutatorAction<T> action : getMutators()) {
            selection -= getWeight(action);
            if(selection <= 0)
                return action;
        }
        return null;
    }
}
