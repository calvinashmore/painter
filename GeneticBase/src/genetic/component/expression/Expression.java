/*
 * Node.java
 *
 * Created on September 20, 2005, 11:57 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package genetic.component.expression;

import genetic.GeneticComponent;
import genetic.Parameterized;
import genetic.component.expression.function.ExpressionFunction;
import genetic.*;
import genetic.Foundation;
import genetic.component.expression.function.VariableExpressionFunction;
import genetic.BuildException;
import java.util.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author gtg126z
 */
public class Expression implements Parameterized, GeneticComponent {

    private List<Expression> children;
    private Object[] cacheInputs;
    private ExpressionFunction function;
    private transient Object cacheOutput = null;
    //private ContextModel cm;
    private GeneticComponent parent;

    private void setParent(Expression parent) {
        this.parent = parent;
    }
    
    public Expression(ExpressionFunction function, /*ContextModel cm,*/ GeneticComponent parent) {

        this.parent = parent;
        //this.cm = cm;
        
        children = new ArrayList<Expression>(function.getNumberInputs());
        cacheInputs = new Object[function.getNumberInputs()];

        for (int i = 0; i < function.getNumberInputs(); i++) {
            children.add(null);
        }

        this.function = function;
    }

    public Class getOutputType() {
        return function.getReturnType();
    }

    public boolean assignChild(int index, Expression child) {

        if (index >= function.getNumberInputs() || index < 0) {
            throw new IllegalArgumentException("Assigning child index of "+index+" where number is: "+function.getNumberInputs());
        }
        
        if(child == null)
            throw new IllegalArgumentException("Attempting to assign null child!");

        // allowing child to be null here
        // for sake of use in editor
        if (child.getOutputType() != function.getInputType(index)) {
            throw new IllegalArgumentException("Child output type "+child.getOutputType()+" does not match function type "+function.getInputType(index));
        }

        child.setParent(this);
        children.set(index, child);
        return true;
    }

    public List<Expression> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public boolean allChildrenAssigned() {
        for (Expression child : children) {
            if (child == null) {
                return false;
            }
        }
        return true;
    }

    public ExpressionFunction getFunction() {
        return function;
    }

    public Object evaluate(Context context) {

        if (cacheOutput != null) {
            return cacheOutput;
        }

        for (int i = 0; i < children.size(); i++) {
            Expression child = children.get(i);
            cacheInputs[i] = child.evaluate(context);
        }

        try {
            cacheOutput = function.evaluate(context, cacheInputs);
            cacheOutput = Foundation.getInstance().getTypeSystem().checkInvalid(cacheOutput);
        } catch (ClassCastException e) {
            //debugPrint(e, context);
            cacheOutput = Foundation.getInstance().getTypeSystem().createDefault(function.getReturnType());
        } catch (NullPointerException e) {
            //debugPrint(e, context);
            cacheOutput = Foundation.getInstance().getTypeSystem().createDefault(function.getReturnType());
        }

        return cacheOutput;
    }

    /*private void debugPrint(Exception e, Context context) {
        synchronized (System.err) {
            System.err.println(function);
            System.err.println("inputs: ");
            for (int i = 0; i < children.size(); i++) {
                System.err.println("    " + children.get(i).getFunction() + " (" + children.get(i).getOutputType() + ") -> " + cacheInputs[i]);
            }

            System.err.println("context: ");
            for (String var : context.allVariables()) {
                System.out.println("    var." + var + ": " + context.getVariable(var));
            }

            e.printStackTrace(System.err);
        }
        //throw e;
        throw new RuntimeException();
    }*/
    // this sets up the node and makes it ready for evaluation
    //private transient boolean isSetup;

    public void setup() throws BuildException {

        function.setup();

        for (Expression child : children) {
            if (child != null) {
                child.setup();
            }
        }
    }
    
    public boolean isSetup() {
        //return isSetup;
        if(!function.isSetup())
            return false;
        
        for(Expression child : children)
            if(!child.isSetup())
                return false;
        return true;
    }

    public String getName() {
        return function.getClass().getName();
    }

    public String getDescription() {
        return function.getDescription();
    }

    public String getInputName(int i) {
        return function.getInputName(i);
    }

    public Class getInputType(int i) {
        return function.getInputType(i);
    }

    public int getNumberInputs() {
        return function.getNumberInputs();
    }

    public Class getReturnType() {
        return function.getReturnType();
    }
    

    /*@Deprecated
    public List<Expression> getInputs() {
        List<Expression> r = new ArrayList<Expression>(getNumberInputs());
        for (int i = 0; i < getNumberInputs(); i++) {
            r.add(getInput(i));
        }
        return r;
    }*/

    public Expression getInput(int i) {
        return children.get(i);
    }

    public void setInput(int i, Expression node) {
        assignChild(i, node);
    }

    public int getNumberParameters() {
        return function.getNumberParameters();
    }

    public String getParameterName(int i) {
        return function.getParameterName(i);
    }

    public Class getParameterType(int i) {
        return function.getParameterType(i);
    }

    public Object getParameter(int i) {
        return function.getParameter(i);
    }

    public void setParameter(int i, Object value) {
        function.setParameter(i, value);
    }

    /*@Override
    public String toString() {

        String args[] = new String[getNumberInputs()];
        for (int i = 0; i < getNumberInputs(); i++) {
            args[i] = children.get(i).toString();
        }
        return function.toString(args);
    }*/

    public GeneticComponent getParent() {
        return parent;
    }

    public ContextModel getContextModel() {
        return getParent().getContextModel();
    }

    public void setParent(GeneticComponent newParent) {
        this.parent = newParent;
    }

    public Expression clone(GeneticComponent newParent) throws BuildException {
        
        Expression clone = new Expression(function.cloneFunction(), newParent);
        
        // clone children
        for(int i=0; i<getNumberInputs(); i++) {
            clone.setInput(i, getInput(i).clone(clone));
        }
        
        return clone;
    }

    public void removeVariable(String name) {
        if(function instanceof VariableExpressionFunction) {
            VariableExpressionFunction variableFunction = (VariableExpressionFunction) function;
            if(variableFunction.getVariableName().equals(name)) {
                try {
                    // now we need to replace the function.
                    // this 
                    Class returnType = variableFunction.getReturnType();
                    ExpressionFunction constantFunction = Foundation.getInstance().getAllExpressionFunctions().getConstantFunction(returnType);
                    function = constantFunction;
                    
                } catch (BuildException ex) {
                    // Supress an exception here, it should never occur.
                }
            }
        }
        // otherwise do nothing, we're okay.
    }

    public boolean hasVariable(String name) {
        if(function instanceof VariableExpressionFunction) {
            VariableExpressionFunction variableFunction = (VariableExpressionFunction) function;
            if(variableFunction.getVariableName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMethod(String name) {
        return false;
    }
}
