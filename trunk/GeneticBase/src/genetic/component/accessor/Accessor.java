/*
 * Accessor.java
 *
 * Created on October 1, 2006, 4:24 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.accessor;

import genetic.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Accessor: Accesses some bit of world information
 * so program can act based on some existing bit of world knowledge
 * 
 * @author Calvin Ashmore
 */
abstract public class Accessor implements Evaluatable, Parameterized, Metadata, Serializable {
    
    private List<Class> inputs;
    protected void setInputs(Class ... inputs) {
        this.inputs = new ArrayList<Class>();
        for(Class input : inputs)
            this.inputs.add(input);
    }
    
    public int getNumberInputs() {return inputs.size();}
    public Class getInputType(int i) {return inputs.get(i);}
    public String getInputName(int i) {return "input "+i;}
    
    // these should be overridden
    public int getNumberParameters() {return 0;}
    public Object getParameter(int i) {return null;}
    public String getParameterName(int i) {return null;}
    public Class getParameterType(int i) {return null;}
    public void setParameter(int i, Object value) {}
    
    abstract public Class getReturnType();
    abstract public Object evaluate(Object ... params);
    
}
