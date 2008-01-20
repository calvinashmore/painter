/*
 * BreederAction.java
 * 
 * Created on Nov 4, 2007, 9:47:00 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

import genetic.component.context.ContextModel;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class BreederAction<T extends GeneticComponent> {
    abstract public T breed(ContextModel model, T target1, T target2);
}
