/*
 * Accessor.java
 *
 * Created on October 1, 2006, 4:24 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.accessor;

import genetic.Metadata;
import genetic.Parameterized;
import genetic.Evaluatable;
import genetic.*;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * Accessor: Accesses some bit of world information
 * so program can act based on some existing bit of world knowledge
 * 
 * @author Calvin Ashmore
 */
abstract public class Accessor implements Evaluatable, Parameterized, Metadata, Serializable {
    
    /*private List<Class> inputs;
    protected void setInputs(Class ... inputs) {
        this.inputs = new ArrayList<Class>();
        for(Class input : inputs)
            this.inputs.add(input);
    }*/
    
    private Map<String,Object> meta = new Hashtable<String, Object>();
    public Object getMeta(String key) {return meta.get(key);}
    public void addMeta(String key, Object value) {meta.put(key,value);}
    
    public int getNumberInputs() {return 0;}
    public Class getInputType(int i) {return null;}
    public String getInputName(int i) {return null;}
    
    // these should be overridden
    public int getNumberParameters() {return 0;}
    public Object getParameter(int i) {return null;}
    public String getParameterName(int i) {return null;}
    public Class getParameterType(int i) {return null;}
    public void setParameter(int i, Object value) {}
    
    abstract public Class getReturnType();
    
}
