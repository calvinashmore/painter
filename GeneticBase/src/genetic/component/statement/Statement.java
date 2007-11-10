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

/**
 *
 * @author gtg126z
 */
abstract public class Statement implements GeneticComponent {
    
    private StatementList parent;
    private boolean destroyFlag;
    public boolean isDestroyFlagged() {return destroyFlag;}
    protected void setDestroyFlag(boolean value) {destroyFlag = value;}
    
    /** Creates a new instance of Statement */
    public Statement() {
    }
    
    protected void setParent(StatementList parent) {this.parent = parent;}
    public StatementList getParent() {return parent;}
    abstract public Statement clone(GeneticComponent newParent);
    abstract public void execute(Context context);
    
    public ContextModel getContextModel() {
        return parent.getContextModel();
    }

    abstract public String printout(String indent);
}
