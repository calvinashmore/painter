/*
 * NodeFunction.java
 *
 * Created on September 20, 2005, 1:00 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package genetic.component.expression.function;

import genetic.Context;
import genetic.Evaluatable;
import genetic.Metadata;
import genetic.Parameterized;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author gtg126z
 */
abstract public class ExpressionFunction implements Evaluatable, Parameterized, Metadata, Serializable {
    
    private boolean parametersChanged = true;
    public void setParametersChanged(boolean changed) {parametersChanged=changed;}
    public boolean parametersChanged() {return parametersChanged;}
    
    private Map<String,Object> meta = new Hashtable<String, Object>();
    public Object getMeta(String key) {return meta.get(key);}
    public void addMeta(String key, Object value) {meta.put(key,value);}
    
    /** Creates a new instance of NodeFunction */
    public ExpressionFunction() {
        //meta = new Hashtable();
    }
    
    private transient boolean isSetup;
    public boolean isSetup() {return isSetup;}
    public void setIsSetup(boolean v) {isSetup = v;}
    public void setup() {}
    
    abstract public Object evaluate( Context context, Object inputs[]);
    abstract public int getNumberInputs();
    abstract public Class getInputType(int i);
    public String getInputName(int i) {return "input "+i;}
    
    // these should be overridden
    public int getNumberParameters() {return 0;}
    public Object getParameter(int i) {return null;}
    public String getParameterName(int i) {return null;}
    public Class getParameterType(int i) {return null;}
    public void setParameter(int i, Object value) {}

    public String getDescription() {
        return "No description.";
    }
    
    //abstract public String toString(String... args);
    public String toString(String... args) {
        String r = getClass().getName()+"(";
        
        for(int i=0; i<args.length; i++) {
            if(i>0)
                r += ", ";
            r += args[i];
        }
        
        r += ")";
        return r;
    }
}