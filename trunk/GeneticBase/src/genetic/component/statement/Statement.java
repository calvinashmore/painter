/*
 * Statement.java
 *
 * Created on August 22, 2006, 11:51 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.statement;

import genetic.component.statementlist.StatementList;
import genetic.*;
import genetic.component.statement.function.StatementFunction;
import genetic.util.BuildException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gtg126z
 */
public class Statement implements GeneticComponent {
    
    private StatementList parent;
    private boolean destroyFlag;
    public boolean isDestroyFlagged() {return destroyFlag;}
    protected void setDestroyFlag(boolean value) {destroyFlag = value;}
    
    private StatementFunction function;
    
    //private boolean isSetup;
    //public boolean isSetup() {return isSetup;}
    
    private List<GeneticComponent> children = new ArrayList<GeneticComponent>();
    
    public Statement() {
        // ??
    }
    
    /** Creates a new instance of Statement */
    public Statement(StatementFunction function) {
        this.function = function;
    }
    
    //protected void setParent(StatementList parent) {this.parent = parent;}
    public StatementList getParent() {return parent;}
    public Statement clone(GeneticComponent newParent) throws BuildException {
        assert(newParent instanceof StatementList) : "Attempt to assign "+newParent+" as parent of a clone of "+this;
        
        Statement clone = new Statement();
        
        for(GeneticComponent child : children)
            clone.children.add(child.clone(clone));
        
        
        return clone;
        
        /*Statement clone = Foundation.getInstance().getStatementFactory().build(getClass(), parent.getContextModel());
        clone.parent = (StatementList) parent;
        
        for(GeneticComponent child : children)
            clone.children.add(child.clone(clone));
        
        clone.isSetup = true;
        
        return clone;*/
    }
    
    public void setup() throws BuildException {
    }
    
    public boolean isSetup() {
        
        function.setup();
        
        
    }
    
    public void execute(Context context) {
        function.execute(context, children);
    }
    
    /**
     * true if this statement contains one or more StatementLists. 
     */
    public boolean isNestingStatement() {return true;}
    
    protected void addChild(GeneticComponent child) {children.add(child);}
    public List<GeneticComponent> getChildren() {return children;}
    
    public ContextModel getContextModel() {
        return parent.getContextModel();
    }

    //public String printout(String indent);

    public void setParent(GeneticComponent newParent) {
        assert(newParent instanceof StatementList) : "Attempt to assign "+newParent+" as parent of "+this;
        parent = (StatementList) newParent;
    }

    public void removeVariable(String name) {
        for(GeneticComponent child : children) {
            child.removeVariable(name);
        }
    }

    public boolean hasVariable(String name) {
        for(GeneticComponent child : children) {
            if(child.hasVariable(name))
                return true;
        }
        return false;
    }

    public boolean hasMethod(String name) {
        for(GeneticComponent child : children) {
            if(child.hasMethod(name))
                return true;
        }
        return false;
    }
    
}
