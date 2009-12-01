/*
 * ContextModel.java
 *
 * Created on August 23, 2006, 1:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package genetic.component.context;

import genetic.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gtg126z
 */
public class ContextModel {

    private static class VariableDefinition {

        public VariableDefinition(Class type, boolean readOnly) {
            this.type = type;
            this.readOnly = readOnly;
        }
        final public Class type;
        final public boolean readOnly;

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 61 * hash + (this.type != null ? this.type.hashCode() : 0);
            hash = 61 * hash + (this.readOnly ? 1 : 0);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof VariableDefinition &&
                    ((VariableDefinition) obj).type == type &&
                    ((VariableDefinition) obj).readOnly == readOnly;
        }
    }
    //private static final int numberBaseVars = 0;
    //private static final int numberFlexVars = 4;
    private ContextModel parent;
    private GeneticTopLevel topLevel;
    private Map<String, VariableDefinition> variableTypes;

    /** Creates a new instance of ContextModel */
    protected ContextModel() {
    }

    public ContextModel(ContextModel parent) {
        this.parent = parent;
        this.topLevel = parent.topLevel;
        variableTypes = new HashMap<String, ContextModel.VariableDefinition>();
    }

    public ContextModel(GeneticTopLevel topLevel) {
        this.parent = null;
        this.topLevel = topLevel;
        variableTypes = new HashMap<String, ContextModel.VariableDefinition>();
    }

    public void setParent(ContextModel parent) {
        this.parent = parent;
        if (parent != null) {
            this.topLevel = parent.topLevel;
        }
    }

    public void setTopLevel(GeneticTopLevel topLevel) {
        this.topLevel = topLevel;
    }

    public boolean contains(ContextModel model) {
        for (String variable : model.variableTypes.keySet()) {
            VariableDefinition definition = model.variableTypes.get(variable);
            if (!variableTypes.get(variable).equals(definition)) {
                return false;
            }
        }
        return true;
    }

    public String declareVariable(String name, Class type, boolean readOnly) {

        //if (variableTypes.get(name) != null) {
        if (getType(name) != null) {
            // get numeric suffix, add to it until the variable has a unique name
            if (!name.matches(".*_\\d+$")) {
                name = name + "_1";
            }

            int underscorePos = name.lastIndexOf("_");

            do {
                int varNumber = Integer.parseInt(name.substring(underscorePos + 1));
                name = name.substring(0, underscorePos + 1) + (varNumber + 1);
            } while (getType(name) != null);
        }

        VariableDefinition def = new VariableDefinition(type, readOnly);
        variableTypes.put(name, def);
        return name;
    }

    public String declareVariable(Class type, boolean readOnly) {
        return declareVariable("var_" + type.getName() + "_0", type, readOnly);
    }

    public Class getType(String name) {
        VariableDefinition var = variableTypes.get(name);
        if (var == null && parent != null) {
            return parent.getType(name);
        }
        if (var != null) {
            return var.type;
        }
        return null;
    }

    public boolean getReadOnly(String name) {
        if (variableTypes.get(name) == null && parent != null) {
            return parent.getReadOnly(name);
        }
        if (variableTypes.get(name) != null) {
            return variableTypes.get(name).readOnly;
        }
        return false;
    }

    public List<String> getVariables() {
        List<String> vars = new ArrayList<String>();
        for (ContextModel model = this; model != null; model = model.parent) {
            vars.addAll(model.variableTypes.keySet());
        }
        return vars;
    }

    public List<String> getAssignableVariables() {
        List<String> vars = getVariables();
        List<String> assignableVars = new ArrayList<String>();
        for (String var : vars) {
            if (!getReadOnly(var)) {
                assignableVars.add(var);
            }
        }
        return assignableVars;
    }

    public List<String> getMyVariables() {
        return new ArrayList<String>(variableTypes.keySet());
    }

    void removeVariable(String name) {
        variableTypes.remove(name);
    }

    public List<String> getVariablesByType(Class type) {
        List<String> vars = getVariables();
        List<String> typedVars = new ArrayList<String>();
        for (String var : vars) {
            if (getType(var) == type) {
                typedVars.add(var);
            }
        }
        return typedVars;
    }

    public List<String> getAssignableVariablesByType(Class type) {
        List<String> vars = getVariables();
        List<String> typedVars = new ArrayList<String>();
        for (String var : vars) {
            if (getType(var) == type && !getReadOnly(var)) {
                typedVars.add(var);
            }
        }
        return typedVars;
    }

    public GeneticTopLevel getTopLevel() {
        return topLevel;
    }

    public ContextModel copy() {
        ContextModel r = new ContextModel();
        r.setParent(parent);
        r.topLevel = topLevel;
        r.variableTypes = new Hashtable<String, ContextModel.VariableDefinition>(variableTypes);
        return r;
    }

    public Context createContext() {
        return createContext(null);
    }

    public Context createContext(Context parent) {
        Context context;
        if (parent != null) {
            context = new Context(parent, this);
        } else {
            context = new Context(this);
        }
        for (String name : variableTypes.keySet()) {
            Object value = Foundation.getInstance().getTypeSystem().createDefault(variableTypes.get(name).type);
            context.setVariable(name, value);
        }

        return context;
    }

    public void absorb(ContextModel contextModel) {
        variableTypes.putAll(contextModel.variableTypes);
    }
}
