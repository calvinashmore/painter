/*
 * Command.java
 *
 * Created on September 13, 2006, 11:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.statement.command;

import genetic.Context;
import genetic.Metadata;
import genetic.Parameterized;
import genetic.Evaluatable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class Command implements Evaluatable, Parameterized, Metadata, Serializable {
    
    private List<Class> inputs;
    protected void setInputs(Class ... inputs) {
        this.inputs = new ArrayList<Class>();
        for(Class input : inputs)
            this.inputs.add(input);
    }
    
    private Map<String,Object> meta = new Hashtable<String, Object>();
    public Object getMeta(String key) {return meta.get(key);}
    public void addMeta(String key, Object value) {meta.put(key,value);}
    
    public Class getReturnType() {return null;}
    public int getNumberInputs() {return inputs.size();}
    public Class getInputType(int i) {return inputs.get(i);}
    public String getInputName(int i) {return "input "+i;}
    
    // these should be overridden
    public int getNumberParameters() {return 0;}
    public Object getParameter(int i) {return null;}
    public String getParameterName(int i) {return null;}
    public Class getParameterType(int i) {return null;}
    public void setParameter(int i, Object value) {}
    
    /** Creates a new instance of Command */
    public Command() {}

    public Object evaluate(Context context, Object[] inputs) {
        execute(context, inputs);
        return null;
    }
    public abstract void execute(Context context, Object ... parameters);
}
