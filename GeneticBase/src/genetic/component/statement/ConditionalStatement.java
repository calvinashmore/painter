/*
 * ConditionalStatement.java
 *
 * Created on August 22, 2006, 5:58 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.statement;

import genetic.Context;
import genetic.component.expression.Expression;
import genetic.component.expression.function.ExpressionFunctionFactoryImpl;
import genetic.GeneticComponent;
import genetic.component.statementlist.StatementList;

/**
 *
 * @author gtg126z
 */
public class ConditionalStatement extends Statement {
    
    private Expression condition;
    private StatementList ifBody;
    private StatementList elseBody;
    
    public StatementList getIfBody() {return ifBody;}
    public StatementList getElseBody() {return elseBody;}
    
    /** Creates a new instance of ConditionalStatement */
    public ConditionalStatement(StatementList parent) throws StatementConstructionException {
        setParent(parent);
        
        try {
            condition = new ExpressionFunctionFactoryImpl(getContextModel()).makeTree(Boolean.class);
        } catch(ExpressionException e) {
            throw new StatementConstructionException();
        }
        ifBody = new StatementList(this);
        elseBody = new StatementList(this);
    }
    
    protected ConditionalStatement() {
    }

    public Statement clone(GeneticComponent newParent) {
        ConditionalStatement r = new ConditionalStatement();
        r.setParent((StatementList)newParent);
        r.condition = condition.clone();
        r.ifBody = ifBody.clone(r);
        r.elseBody = elseBody.clone(r);
        return r;
    }

    public void execute(Context context) {
        boolean conditionResult = (Boolean) condition.evaluate(context);
        if(conditionResult)
            ifBody.execute(context);
        else
            elseBody.execute(context);
    }

    public String printout(String indent) {
        String r = indent+"if("+condition+")\n";
        r += ifBody.printout(indent+"  ");
        r += indent+"else\n";
        r += elseBody.printout(indent+"  ");
        return r;
    }
    
}
