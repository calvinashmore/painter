/*
 * Mutator.java
 * 
 * Created on Nov 4, 2007, 5:52:15 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic;

import genetic.component.context.ContextModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
public class Mutator<T extends GeneticComponent> {

    protected Random getRandom() {
        return Foundation.getInstance().getBuilderRandom();
    }
    private List<MutatorAction<T>> mutators = new ArrayList<MutatorAction<T>>();

    protected List<MutatorAction<T>> getMutators() {
        return mutators;
    }

    protected int getNumberAttempts() {
        return 5;
    }

    public T mutate(GeneticComponent newParent, ContextModel model, T target) throws BuildException {

        for (int i = 0; i < getNumberAttempts(); i++) {
            MutatorAction<T> action = selectAction();
            if (action == null) {
                continue;
            }
            T test = (T) target.clone(target.getParent());
            if (action.mutate(model, test)) {
                test.setParent(newParent);
                return test;
            }
        }
        return null;
    }

    protected double getWeight(MutatorAction action) {
        if (action instanceof Metadata) {
            Object weight = ((Metadata) action).getMeta("selectionWeight");
            if (weight != null) {
                if (weight instanceof Double) {
                    return (Double) weight;
                } else if (weight instanceof Float) {
                    return (Float) weight;
                } else if (weight instanceof Integer) {
                    return (Integer) weight;
                }
            }
        }

        return 1.0;
    }

    protected MutatorAction<T> selectAction() {
        float totalWeights = 0;
        for (MutatorAction<T> action : getMutators()) {
            totalWeights += getWeight(action);
        }

        float selection = totalWeights * getRandom().nextFloat();
        for (MutatorAction<T> action : getMutators()) {
            selection -= getWeight(action);
            if (selection <= 0) {
                return action;
            }
        }
        return null;
    }
}
