/*
 * MutatorAction.java
 * 
 * Created on Nov 4, 2007, 6:07:26 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class MutatorAction<T extends GeneticComponent> implements Metadata {

    private Map<String, Object> metadata = new HashMap<String, Object>();

    public Object getMeta(String key) {
        return metadata.get(key);
    }

    public void addMeta(String key, Object value) {
        metadata.put(key, value);
    }

    /**
     * The contract of this method is to attempt to mutate the component.
     * If the mutation fails, the method should return false, and the state of 
     * target should remain unchanged! It *is* permissible to replace target in the
     * node structure. So, an expression mutator may replace its target with a constant,
     * and perform that replacement in target.getParent(), so that target is excluded
     * from the node heirarchy. 
     * @param target
     * @return
     * @throws genetic.BuildException
     */
    abstract public boolean mutate(T target) throws BuildException;
}
