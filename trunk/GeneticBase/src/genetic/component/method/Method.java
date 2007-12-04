/*
 * Function.java
 *
 * Created on August 22, 2006, 4:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.method;

import genetic.component.statementlist.StatementList;
import genetic.component.program.Program;
import genetic.*;
import genetic.util.BuildException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gtg126z
 */
public class Method implements GeneticComponent {
    
    private String name;
    
    private Class returnType;
    private List<Class> argumentTypes;
    private List<String> argumentNames;
    
    private StatementList body;
    private ContextModel contextModel;
    private Program parent;
    
    /** Creates a new instance of Function */
    protected Method() {}
    
    // creates a function and some starting statement list
    public Method(String name, Program parent, Class returnType, List<Class> argumentTypes) {
        this.name = name;
        this.parent = parent;
        this.returnType = returnType;
        this.argumentTypes = argumentTypes;
        
        this.contextModel = new ContextModel(parent.getContextModel());
        this.argumentNames = new ArrayList<String>();
        
        for(Class type : argumentTypes)
            argumentNames.add(contextModel.declareVariable(type, true));
        
        body = new StatementList( this );
    }
    
    public Program getParent() {
        return parent;
    }

    public ContextModel getContextModel() {
        return contextModel;
    }
    
    public Method clone(GeneticComponent newParent) throws BuildException {
        Method r = new Method();
        r.contextModel = contextModel.clone();
        r.contextModel.setParent(newParent.getContextModel());
        r.returnType = returnType;
        r.parent = (Program)newParent;
        r.argumentTypes = new ArrayList<Class>(argumentTypes);
        r.body = body.clone(r);
        return r;
    }
    
    public void execute(Context parentContext, List<Object> arguments) {
        Context context = contextModel.createContext(parentContext);
        body.execute(context);
    }

    public void removeVariable(String name) {
        body.removeVariable(name);
    }

    public void setParent(GeneticComponent newParent) {
    }

    public boolean hasVariable(String name) {
        return body.hasVariable(name);
    }

    public boolean isSetup() {
        return body.isSetup();
    }

    public void setup() throws BuildException {
        body.setup();
    }

    public boolean hasMethod(String name) {
        return body.hasMethod(name);
    }

}
