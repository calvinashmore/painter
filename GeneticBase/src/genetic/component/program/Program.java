/*
 * Program.java
 *
 * Created on August 22, 2006, 5:52 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.program;

import genetic.component.context.Context;
import genetic.component.context.ContextModel;
import genetic.GeneticTopLevel;
import genetic.GeneticComponent;
import genetic.*;
import genetic.component.method.Method;
import genetic.BuildException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gtg126z
 */
public class Program implements GeneticTopLevel {
    
    // must find ways in here to articulate catalog of action functions
    // maybe these are just NFs?
    // have return type void?
    // also articulate the core functions that make up the triggered events
    
    private Map<String, Method> methods;
    //private Map<Integer, Function> internalFunctions;
    
    private ContextModel contextModel;
    private Context context;
    
    private boolean isSetup;

    public int getDepth() {
        return 0;
    }
    
    /** Creates a new instance of Program */
    public Program() {
        methods = new Hashtable<String, Method>();
        contextModel = new ContextModel(this);
    }

    public boolean isSetup() {
        return isSetup;
    }
    
    public void setup() throws BuildException {
        context = contextModel.createContext();
    
        isSetup = true;
        
        for(Method method : methods.values())
            method.setup();
    }
    
    public Method createMethod(String name, Class... parameters) {
        
        Method method = buildMethod(Arrays.asList(parameters), name);
        methods.put(name, method);
        return method;
    }
    
    protected Method buildMethod(List<Class> lparams, String name) {
        Method method = Foundation.getInstance().getMethodBuilder().build(name, this, lparams);
        return method;
    }
    
    public void callMethod(String name, Object... parameters) {
        
        Method eventFunction = methods.get(name);
        List<Object> lparameters = new ArrayList<Object>();
        for(Object parameter : parameters)
            lparameters.add(parameter);
        eventFunction.execute(context, lparameters);
    }

    public Map<String, Method> getMethods() {
        return Collections.unmodifiableMap(methods);
    }
    
    public GeneticComponent getParent() {
        return null;
    }

    public ContextModel getContextModel() {
        return contextModel;
    }
    
    public Context getContext() {
        return context;
    }

    /*public Program mutateProgram() {
        
        Program r = this.clone();
        r.mutate();
        return r;
    }
    
    public void mutate() {
        
        if(Math.random() < .2f && contextModel.getVariables().size() > 0) {
            int toRemove = new Random().nextInt( Math.min(contextModel.getMyVariables().size(), 3) );
            for(int i=0;i<toRemove;i++) {
                String varName = contextModel.getMyVariables().get( new Random().nextInt(contextModel.getMyVariables().size()) );
                removeVariable(varName);
                contextModel.removeVariable(varName);
            }
        }
        if(Math.random() < .1f) {
            contextModel.createNewVariables();
        }
        
        int index = new Random().nextInt(events.size());
        String key = new ArrayList<String>(events.keySet()).get(index);
        //events.put(key, events.get(key).mutate());
        events.get(key).mutate();
        
        initialize();
    }*/

    /*public Program breed(GeneticComponent component) {
        Program mate = (Program) component;
        // FIXME
        
        return null;
    }*/
    
    public Program clone(GeneticComponent newParent) throws BuildException {
        try {
            Program program = (Program) getClass().newInstance();
            program.contextModel = contextModel.copy();
            program.contextModel.setTopLevel(program);
            
            for (String i : methods.keySet()) {
                Method newFunction = methods.get(i).clone(program);
                program.methods.put(i, newFunction);
            }
            
            program.context = program.getContextModel().createContext();
            
            program.isSetup = true;
            
            return program;
            
        } catch (InstantiationException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void removeVariable(String name) {
        for(String fname : methods.keySet()) {
            Method function = methods.get(fname);
            function.removeVariable(name);
        }
    }
    
    public boolean hasVariable(String name) {
        for(String fname : methods.keySet()) {
            Method function = methods.get(fname);
            if(function.hasVariable(name))
                return true;
        }
        return false;
    }

    public void setParent(GeneticComponent newParent) {
        throw new UnsupportedOperationException("Cannot assign a parent to a Program");
    }

    public boolean hasMethod(String name) {
        return methods.containsKey(name);
    }

}
