/*
 * ContextModel.java
 *
 * Created on August 23, 2006, 1:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic;

import genetic.component.program.Program;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gtg126z
 */
public class ContextModel {

    private class VariableDefinition {
        public Class type;
        public boolean readOnly;

        public int hashCode() {
            int hash = 3;
            hash = 61 * hash + (this.type != null ? this.type.hashCode() : 0);
            hash = 61 * hash + (this.readOnly ? 1 : 0);
            return hash;
        }
        
        public boolean equals(Object obj) {
            return obj instanceof VariableDefinition &&
                   ((VariableDefinition)obj).type == type &&
                   ((VariableDefinition)obj).readOnly == readOnly;
        }
    }
    
    //private static final int numberBaseVars = 0;
    //private static final int numberFlexVars = 4;
    private ContextModel parent;
    private Program topLevel;
    private Map<String, VariableDefinition> variableTypes;

    /** Creates a new instance of ContextModel */
    protected ContextModel() {
    }

    public ContextModel(ContextModel parent) {
        this.parent = parent;
        this.topLevel = parent.topLevel;
        variableTypes = new Hashtable<String, ContextModel.VariableDefinition>();
    }

    public ContextModel(Program topLevel) {
        this.parent = null;
        this.topLevel = topLevel;
        variableTypes = new Hashtable<String, ContextModel.VariableDefinition>();
    }

    public void setParent(ContextModel parent) {
        this.parent = parent;
        if (parent != null) this.topLevel = parent.topLevel;
    }

    public void setProgram(Program topLevel) {
        this.topLevel = topLevel;
    }

    public boolean contains(ContextModel model) {
        for(String variable : model.variableTypes.keySet()) {
            VariableDefinition definition = model.variableTypes.get(variable);
            if(!variableTypes.get(variable).equals(definition))
                return false;
        }
        return true;
    }
    
    public String declareVariable(String name, Class type, boolean readOnly) {
        
        if(variableTypes.get(name) != null) {
            // get numeric suffix, add to it until the variable has a unique name
            if(!name.matches(".*_\\d+$"))
                name = name + "_1";
                
            int underscorePos = name.lastIndexOf("_");
            
            do {
                int varNumber = Integer.parseInt(name.substring(underscorePos+1));
                name = name.substring(0, underscorePos+1) + (varNumber+1);
            } while(variableTypes.get(name) != null);
        }
        
        VariableDefinition def = new VariableDefinition();
        def.readOnly = readOnly;
        def.type = type;
        variableTypes.put(name, def);
        return name;
    }
    
    public String declareVariable(Class type, boolean readOnly) {
        return declareVariable("var_"+type.getName()+"_0", type, readOnly);
    }

    public Class getType(String name) {
        if (variableTypes.get(name) == null && parent != null)
            return parent.getType(name);
        if (variableTypes.get(name) != null)
            return variableTypes.get(name).type;
        return null;
    }

    public boolean getReadOnly(String name) {
        if (variableTypes.get(name) == null && parent != null)
            return parent.getReadOnly(name);
        if (variableTypes.get(name) != null)
            return variableTypes.get(name).readOnly;
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
            if (!getReadOnly(var)) assignableVars.add(var);
        }
        return assignableVars;
    }

    List<String> getMyVariables() {
        return new ArrayList<String>(variableTypes.keySet());
    }

    void removeVariable(String name) {
        variableTypes.remove(name);
    }

    public List<String> getVariablesByType(Class type) {
        List<String> vars = getVariables();
        List<String> typedVars = new ArrayList<String>();
        for (String var : vars) {
            if (getType(var) == type) typedVars.add(var);
        }
        return typedVars;
    }

    public List<String> getAssignableVariablesByType(Class type) {
        List<String> vars = getVariables();
        List<String> typedVars = new ArrayList<String>();
        for (String var : vars) {
            if (getType(var) == type && !getReadOnly(var)) typedVars.add(var);
        }
        return typedVars;
    }

    public Program getTopLevel() {
        return topLevel;
    }

    public ContextModel clone() {
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
        if (parent != null) context = new Context(parent, this);
        else context = new Context(this);
        for (String name : variableTypes.keySet()) {
            Object value = GeneticFoundation.getInstance().getTypeSystem().createDefault(variableTypes.get(name).type);
            context.setVariable(name, value);
        }

        return context;
    }

    public String printout(String indent) {
        String r = indent + "contextModel\n";
        for (String name : variableTypes.keySet()) {
            r += indent + "  " + name + ": " + variableTypes.get(name).type;
            if (variableTypes.get(name).readOnly) r += " (r/o)";
            r += "\n";
        }
        return r;
    }

    /*protected void createNewVariables() {
        int vars = numberBaseVars + new Random().nextInt(numberFlexVars);
        for (int i = 0; i < vars; i++) {
            Class type = randomType();
            declareVariable(type, false);
        }
        //System.out.println(vars+" variables created.");
    }*/

    public void absorb(ContextModel contextModel) {
        variableTypes.putAll(contextModel.variableTypes);
    }

    /*protected Class randomType() {
        int i = new Random().nextInt(7);
        switch (i) {
            case 0: return Color.class;
            case 1: return Complex.class;
            case 2: return LDouble.class;
            case 3: return LVect2d.class;
            case 4: return LVect2i.class;
            case 5: return LVect3d.class;
            case 6: return Quaternion.class;
        }
        return null;
    }*/
}