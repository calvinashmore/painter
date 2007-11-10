/*
 * Factory.java
 * 
 * Created on Nov 4, 2007, 5:43:31 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.util;

/**
 *
 * @author Calvin Ashmore
 */
public interface Factory<T> {    
    public T build(Class t) throws BuildException;
}
