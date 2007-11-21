/*
 * XAssignmentStatement.java
 *
 * Created on September 28, 2006, 1:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.statement;

import genetic.component.expression.Expression;
import genetic.component.expression.function.ExpressionFunctionFactoryImpl;
import genetic.component.expression.mutator.ExpressionMutator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class AbstractAssignmentStatement extends Statement {
    
    protected Expression content;
    protected String variableName;

    public void mutate() {
        // try: with small probability, change the variable name
        // with larger probability, mutate the expression
        
        List<String> vars = getContextModel().getAssignableVariablesByType( getContextModel().getType(variableName) );//(Float.class);
        
        
        if(vars.size() > 1 && Math.random() < .075f) {
            
            //vars.remove(variableName);
            int index = new Random().nextInt(vars.size());
            variableName = vars.get(index);
            return;
        }
        
        do {
            content = ExpressionMutator.mutate(getContextModel(), content);
        } while(content.getOutputType() != getContextModel().getType(variableName));
    }
    
    public void removeVariable(String name) {
        // try: check current variable name, if current is removed, switch to another, or post for destroy??
        // otherwise, pass to expression
        
        if(name.equals(variableName)) {
            setDestroyFlag(true);
            return;
        }
        
        content = ExpressionFunctionFactoryImpl.removeVariable(content, name);
    }
    
}
