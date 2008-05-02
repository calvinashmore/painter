/*
 * Factory.java
 * 
 * Created on Nov 4, 2007, 5:43:31 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic;

import genetic.component.context.ContextModel;

/**
 * <p>A Factory builds an object of a type that belongs to a certain class.
 * Factories are responsible for creating ExpressionFunction objects and the like.
 * We use Factories for types which we wish to select amongst subclasses. For
 * other types, such as Expressions or Methods, we would wish to use a Builder.</p>
 * <p>Factories are also responsible for selecting a candidate amongst a population.
 * This will be determined by the given AllComponents&lt;T&gt;, and constructed
 * according to relevant contextual information.</p>
 * @see Builder
 * @author Calvin Ashmore
 */
public interface Factory<T> {

    /**
     * This constructs a new instance of the object in question. It does not
     * run the object's setup function (if it has one), and does not initialize it,
     * so this is essentially a shallow build.
     * 
     * The actual object in question should be responsible for initializing itself
     * and making sure that it sets up correctly at runtime.
     * 
     * @param t
     * @return a deep build of t
     * @throws genetic.util.BuildException
     */
    public T build(Class<? extends T> t, ContextModel cm) throws BuildException;

    public double getWeight(ContextModel context, T instance);
}
