/*
 * StatementFactory.java
 *
 * Created on August 29, 2006, 5:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.statement;

import genetic.component.statementlist.StatementList;
import genetic.*;
import genetic.util.BuildException;
import genetic.util.Factory;
import java.util.Random;

/**
 *
 * @author gtg126z
 */
public class StatementFactory implements Factory<Statement> {
    
    
    //private ContextModel contextModel;

    public StatementFactory() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    /** Creates a new instance of StatementFactory */
    //public StatementFactory(ContextModel contextModel) {
    //    this.contextModel = contextModel;
    //}

    public Statement createStatement(StatementList parent) {
        
        depth++;
        Statement r = null;
        
        while(true) {
            
            if(depth >= maxDepth) {
                // have exceeded maxDepth, so exclude branching statements
                int type = new Random().nextInt(6);
                try{
                    switch(type) {
                        case 0: r = new AssignmentStatement(parent); break;
                        case 1: r = new CommandStatement(parent); break;
                    }
                } catch(StatementConstructionException e) {}
            } else {
                // have not exceeded maxDepth, so use branching statements
                int type = new Random().nextInt(7);
                try{
                    switch(type) {
                        case 0: r = new AssignmentStatement(parent); break;
                        case 1: r = new CommandStatement(parent); break;
                        case 6: r = new ConditionalStatement(parent); break;
                    }
                } catch(StatementConstructionException e) {}
            }
            
            if(r != null) {
                depth--;
                return r;
            }
        }
        
    }
    
    public Statement select(ContextModel cm) throws BuildException {
        
    }

    public Statement shallowBuild(Class<? extends Statement> t, ContextModel cm) throws BuildException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Statement deepBuild(Class<? extends Statement> t, ContextModel cm) throws BuildException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
