/*
 * Context.java
 *
 * Created on September 23, 2005, 11:01 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package genetic.component.context;

import genetic.*;
import java.util.*;


/**
 *
 * @author gtg126z
 */
public class Context {

    private ContextModel model;
    private Context parent;
    private Map<String, Object> variables;

    public Context(ContextModel model) {
        this.model = model;
        variables = new Hashtable<String, Object>();
    }

    public Context(Context parent, ContextModel model) {
        this.parent = parent;
        this.model = model;
        variables = new Hashtable<String, Object>();
    }
    
    public ContextModel getModel() {return model;}
    public GeneticTopLevel getTopLevel() {return getModel().getTopLevel();}

    public void setVariable(String name, Object value) {
        if(parent != null && parent.getVariable(name) != null) {
            // if variable exists in previous context, update previous context version
            parent.setVariable(name, value);
        } else
            // otherwise add to existing context
            variables.put(name, value);
    }

    public Object getVariable(String name) {
        
        if(variables.get(name) == null && parent != null)
            return parent.getVariable(name);
        return variables.get(name);
    }

    public List<String> allVariables() {
        List<String> vars = new ArrayList<String>(variables.keySet());
        if(parent != null)
            vars.addAll(parent.allVariables());
        return vars;
    }
}
