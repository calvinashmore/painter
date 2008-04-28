/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.statement.function;

import genetic.component.context.Context;
import genetic.component.context.ContextModel;
import genetic.GeneticComponent;
import genetic.Metadata;
import genetic.Parameterized;
import genetic.SetupComponent;
import genetic.component.expression.Expression;
import genetic.component.statementlist.StatementList;
import genetic.BuildException;
import genetic.Described;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class StatementFunction implements
        Parameterized, Metadata, SetupComponent, Cloneable, Described {

    abstract public static class InputSignature {
        // package protected so cannot be overridden
        InputSignature() {}
        
        abstract public Class getInputClass();
    }

    final public static class ExpressionInputSignature extends InputSignature {
        private Class expressionType;
        public ExpressionInputSignature(Class expressionType) {this.expressionType = expressionType;}
        
        @Override
        public Class getInputClass() {return Expression.class;}
        public Class getExpressionReturnType() {return expressionType;}
    }
    
    final public static class StatementListInputSignature extends InputSignature {
        public StatementListInputSignature() {}
        @Override public Class getInputClass() {return StatementList.class;}
    }
    
    public String getName() {return getClass().getName();}
    
    private boolean parametersChanged = true;
    public void setParametersChanged(boolean changed) {parametersChanged=changed;}
    public boolean parametersChanged() {return parametersChanged;}
    
    private ContextModel contextModel;
    protected ContextModel getContextModel() {return contextModel;}
    public void setContextModel(ContextModel contextModel) {this.contextModel = contextModel;}
    
    private Map<String,Object> meta = new Hashtable<String, Object>();
    public Object getMeta(String key) {return meta.get(key);}
    public void addMeta(String key, Object value) {meta.put(key,value);}
    
    public StatementFunction cloneFunction(ContextModel newModel) throws BuildException {
        try {
            StatementFunction clone = (StatementFunction) clone();
            clone.setContextModel(newModel);
            
            clone.setup();
            
            for(int i=0; i<getNumberParameters(); i++)
                clone.setParameter(i, getParameter(i));
            
            return clone;
        } catch (CloneNotSupportedException ex) {
            throw new AssertionError(ex);
        }
    }
    
    public int getNumberParameters() {return 0;}
    public Object getParameter(int i) {return null;}
    public String getParameterName(int i) {return null;}
    public Class getParameterType(int i) {return null;}
    public void setParameter(int i, Object value) {}

    public int getNumberInputs() {return 0;}
    public String getInputName(int i) {return null;}
    public InputSignature getInputSignature(int i) {return null;}
    abstract public void execute(Context context, List<GeneticComponent> inputs);
    
    public int getNumberContextVariables() {return 0;}
    public String getContextVariableIntendedName(int i) {return null;}
    public Class getContextVariableType(int i) {return null;}
    
    private Map<String, String> variableMap = new HashMap();
    public void setContextVariableActualName(String intendedName, String actualName) {
        variableMap.put(intendedName, actualName);
    }
    public String getContextVariableActualName(String intendedName) {
        return variableMap.get(intendedName);
    }
    
    private boolean isSetup = false;
    public boolean isSetup() {return isSetup;}
    public void setup() throws BuildException {isSetup = true;}

    public String getDescription() {
        return "No description.";
    }
}
