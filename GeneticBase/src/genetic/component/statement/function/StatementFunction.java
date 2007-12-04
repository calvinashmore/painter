/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.statement.function;

import genetic.Context;
import genetic.GeneticComponent;
import genetic.Metadata;
import genetic.Parameterized;
import genetic.SetupComponent;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class StatementFunction implements Parameterized, Metadata, SetupComponent, Cloneable {

    private boolean parametersChanged = true;
    public void setParametersChanged(boolean changed) {parametersChanged=changed;}
    public boolean parametersChanged() {return parametersChanged;}
    
    private Map<String,Object> meta = new Hashtable<String, Object>();
    public Object getMeta(String key) {return meta.get(key);}
    public void addMeta(String key, Object value) {meta.put(key,value);}
    
    @Override
    public StatementFunction clone() {
        try {
            StatementFunction clone = (StatementFunction) super.clone();
            clone.isSetup = false;
            clone.parametersChanged = false;
            clone.meta = meta; // referential copy
            
            for(int i=0; i<getNumberParameters(); i++)
                clone.setParameter(i, getParameter(i));
            
            clone.setup();
            
            return clone;
        } catch (CloneNotSupportedException ex) {
            throw new AssertionError(ex);
        }
    }
    
    public int getNumberParameters() {return 0;}
    public Object getParameter(int i) {return null;}
    public String getParameterName(int i) {return null;}
    public Class getParameterType(int i) {return null;}
    public void setParameter(int i, Object value) {}

    public int getNumberInputs() {return 0;}
    public Class getInputType(int i) {return null;}
    abstract public void execute(Context context, List<GeneticComponent> children);
    
    private boolean isSetup = false;
    public boolean isSetup() {return isSetup;}
    public void setup() {isSetup = true;}

}
