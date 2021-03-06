/*
 * Breeder.java
 * 
 * Created on Nov 4, 2007, 9:45:57 PM
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
public class Breeder<T extends GeneticComponent> {

    protected Random getRandom() {
        return Foundation.getInstance().getBuilderRandom();
    }
    private List<BreederAction<T>> breeders = new ArrayList<BreederAction<T>>();

    protected List<BreederAction<T>> getBreeders() {
        return breeders;
    }

    protected int getNumberAttempts() {
        return 5;
    }

    public T breed(GeneticComponent newParent, ContextModel model, T target1, T target2) {

        for (int i = 0; i < getNumberAttempts(); i++) {
            BreederAction<T> action = selectAction();
            if (action == null) {
                continue;
            }
            try {
                T test1 = (T) target1.clone(target1.getParent());
                T test2 = (T) target2.clone(target2.getParent());

                T result = action.breed(model, test1, test2);
                if (result != null && reconcileContextModels(newParent, result, model, test1, test2)) {
                    result.setParent(newParent);
                    return result;
                }
            } catch (BuildException e) {
                continue;
            }
        }
        return null;
    }

    protected boolean reconcileContextModels(GeneticComponent newParent, T result, ContextModel model, T test1, T test2) {
        return false;
    }

    protected double getWeight(BreederAction action) {
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

        return 1.0f;
    }

    protected BreederAction<T> selectAction() {
        float totalWeights = 0;
        for (BreederAction<T> action : getBreeders()) {
            totalWeights += getWeight(action);
        }

        float selection = totalWeights * getRandom().nextFloat();
        for (BreederAction<T> action : getBreeders()) {
            selection -= getWeight(action);
            if (selection <= 0) {
                return action;
            }
        }
        return null;
    }
}
