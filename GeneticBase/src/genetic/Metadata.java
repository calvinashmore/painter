/*
 * Metadata.java
 * 
 * Created on Nov 1, 2007, 10:10:57 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

/**
 *
 * @author Calvin Ashmore
 */
public interface Metadata {
    public Object getMeta(String key);
    public void addMeta(String key, Object value);
}
