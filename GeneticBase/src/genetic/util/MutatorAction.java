/*
 * MutatorAction.java
 * 
 * Created on Nov 4, 2007, 6:07:26 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.util;

import genetic.ContextModel;
import genetic.GeneticComponent;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class MutatorAction<T extends GeneticComponent> {
    abstract public boolean mutate(ContextModel model, T target) throws BuildException;
}