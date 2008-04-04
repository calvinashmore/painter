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
        //private String[] contextVariableNames;
        //private Class[] contextVariableTypes;
        public StatementListInputSignature() {}
        //StatementListInputSignature(String[] contextVariableNames, Class[] contextVariableTypes) {
        //    this.contextVariableNames = contextVariableNames;
        //    this.contextVariableTypes = contextVariableTypes;
        //}
        
        @Override public Class getInputClass() {return StatementList.class;}
        //public int getNumberContextVariables() {return contextVariableNames.length;}
        //public String getContextVariableName(int i) {return contextVariableNames[i];}
        //public Class getContextVariableType(int i) {return contextVariableTypes[i];}
    }
    
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
            //clone.isSetup = false;
            //clone.parametersChanged = false;
            //clone.meta = meta; // referential copy
            
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
    
    // for each statement list input, maps an intended variable name to its actual value
    // this is something of a awkward construct, but hopefully it can be hidden effectively
    /*private Map<StatementListInputSignature, Map<String, String>> variableMaps = new HashMap();
    
    public void setStatementListInputVariableName(
            int input, String intendedVariableName, String actualVariableName) {
        StatementListInputSignature signature = (StatementListInputSignature) getInputSignature(input);
        Map<String, String> variableMap = variableMaps.get(signature);
        if(variableMap == null) {
            variableMap = new HashMap<String, String>();
            variableMaps.put(signature, variableMap);
        }
        
        variableMap.put(intendedVariableName, actualVariableName);
    }
    
    protected String getActualVariableName(int input, String name) {
        StatementListInputSignature signature = (StatementListInputSignature) getInputSignature(input);
        Map<String, String> variableMap = variableMaps.get(signature);
        return variableMap.get(name);
    }*/
    
    private boolean isSetup = false;
    public boolean isSetup() {return isSetup;}
    public void setup() throws BuildException {isSetup = true;}

    public String getDescription() {
        return "No description.";
    }
}
