/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic;

import genetic.component.context.ContextModel;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Calvin Ashmore
 */
public class AbstractFactory<T> implements Factory<T> {

    public T build(Class<? extends T> t, ContextModel cm) throws BuildException {
        try {
            try {
                Constructor<? extends T> c = t.getConstructor(ContextModel.class);
                return c.newInstance(cm);
            } catch (NoSuchMethodException e) {
            }

            return t.newInstance();
        } catch (IllegalAccessException e) {
            throw new BuildException("Failed to instantiate class: " + t.getName(), e);
        } catch (InstantiationException e) {
            throw new BuildException("Failed to instantiate class: " + t.getName(), e);
        } catch (InvocationTargetException e) {
            throw new BuildException("Failed to instantiate class: " + t.getName(), e);
        }
    }

    public double getWeight(ContextModel context, T instance) {

        if (instance instanceof Metadata) {
            Object weight = ((Metadata) instance).getMeta("probability");
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
}
