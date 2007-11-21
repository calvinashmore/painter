/*
 * Program.java
 *
 * Created on August 22, 2006, 5:52 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.program;

import genetic.*;
import genetic.component.method.Method;
import genetic.component.expression.accessor.Accessor;
import genetic.component.statement.command.Command;
import java.util.ArrayList;
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
    
    private Map<String, Method> events;
    //private Map<Integer, Function> internalFunctions;
    
    private ContextModel contextModel;
    private Context context;
    
    private Map<String, Command> commands;
    private Map<String, Accessor> accessors;
    
    /** Creates a new instance of Program */
    public Program() {
        events = new Hashtable<String, Method>();
        commands = new Hashtable<String, Command>();
        accessors = new Hashtable<String, Accessor>();
        //internalFunctions = new Hashtable();
        
        contextModel = new ContextModel(this);
        // init vars again for goodly program variables
        //.createNewVariables();
    }
    
    public void initialize() {
        context = contextModel.createContext();
    }
    
    public void createEvent(String name, Class... parameters) {
        
        List<Class> lparams = new ArrayList<Class>();
        for(Class parameter : parameters)
            lparams.add(parameter);
        
        Method eventFunction = new Method(name, this, null, lparams);
        events.put(name, eventFunction);
    }
    
    public void callEvent(String name, Object... parameters) {
        
        Method eventFunction = events.get(name);
        List<Object> lparameters = new ArrayList<Object>();
        for(Object parameter : parameters)
            lparameters.add(parameter);
        eventFunction.execute(context, lparameters);
    }
    
    /*public List<Integer> getFunctionNames() {
        return new ArrayList(internalFunctions.keySet());
    }
    
    public Function getFunction(int name) {
        return internalFunctions.get(name);
    }*/
    
    public void createCommand(String name, Command command) {
        commands.put(name, command);
    }
    public void createAccessor(String name, Accessor accessor) {
        accessors.put(name, accessor);
    }
    
    public List<String> getCommands() {return new ArrayList<String>(commands.keySet());}
    public List<String> getAccessors() {return new ArrayList<String>(accessors.keySet());}
    
    public List<String> getAccessorsByType(Class type) {
        //return new ArrayList(accessors.keySet());
        List<String> r = new ArrayList<String>();
        for(String name : accessors.keySet())
            if(accessors.get(name).getReturnType() == type)
                r.add(name);
        return r;
    }
    
    public Command getCommand(String name) {return commands.get(name);}
    public Accessor getAccessor(String name) {return accessors.get(name);}
    
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
    
    public Program clone() {return clone(null);}
    public Program clone(GeneticComponent newParent) {
        try {
            Program program = (Program) getClass().newInstance();
            program.contextModel = contextModel.clone();
            program.contextModel.setProgram(program);
            program.commands = new Hashtable<String, Command>(commands);
            program.accessors = new Hashtable<String, Accessor>(accessors);

            for (String i : events.keySet()) {
                Method newFunction = events.get(i).clone(program);
                program.events.put(i, newFunction);
            }

            /*for(Integer i : internalFunctions.keySet()) {
            Function newFunction = internalFunctions.get(i).clone(program);
            program.internalFunctions.put( i, newFunction );
            }*/
            return program;
            
        } catch (InstantiationException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String printout(String indent) {
        String r = indent+"program\n";
        r += contextModel.printout(indent+"  ");
        for(String name : events.keySet()) {
            Method function = events.get(name);
            r += function.printout(indent+"  ", name);
        }
        return r;
    }

    public void removeVariable(String name) {
        for(String fname : events.keySet()) {
            Method function = events.get(fname);
            function.removeVariable(name);
        }
    }

    public void resetParent(GeneticComponent newParent) {
        
    }
}
