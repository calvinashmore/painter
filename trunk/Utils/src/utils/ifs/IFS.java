/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.ifs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utils.linear.Linear;

/**
 *
 * @author Calvin Ashmore
 */
public class IFS<T extends Linear<T>> {

    private List<Mapping<T>> mappings;
    private List<Double> probabilities;
    private double probabilitySum = 0;

    public IFS() {
        mappings = new ArrayList<Mapping<T>>();
        probabilities = new ArrayList<Double>();
    }

    public void addMapping(Mapping<T> mapping, double probability) {
        if (mapping == null || probability <= 0) {
            throw new IllegalArgumentException();
        }

        mappings.add(mapping);
        probabilities.add(probability);
        probabilitySum += probability;
    }

    /**
     * apply the mapping n times and return the result
     * @param src
     * @param rand
     * @return
     */
    public T applyRepeatedly(T src, int n, Random rand) {

        T dest = src.zero();
        T temp = null;

        for (int i = 0; i < n; i++) {
            // apply
            apply(src, dest, rand);

            // swap
            temp = src;
            src = dest;
            dest = temp;
        }

        return dest;
    }

    public T apply(T src, T dest, Random rand) {
        if (dest == null) {
            dest = src.zero();
        }

        double value = rand.nextDouble() * probabilitySum;

        int index;
        for (index = 0; index < probabilities.size(); index++) {
            value -= probabilities.get(index);
            if (value < 0) {
                break;
            }
        }

        Mapping<T> mapping = mappings.get(index);
        mapping.map(src, dest);
        return dest;
    }
}
