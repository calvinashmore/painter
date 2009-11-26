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

import genetic.component.context.Context;
import genetic.component.context.ContextModel;
import genetic.component.expression.function.ExpressionFunction;
import genetic.*;
import genetic.Foundation;
import genetic.component.expression.function.VariableExpressionFunction;
import genetic.BuildException;
import genetic.component.expression.function.cx.ContextDependentExpressionFunction;
import genetic.component.expression.function.cx.ContextDependentExpressionProxy;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author gtg126z
 */
public class Expression implements Parameterized, GeneticComponent {

    private List<Expression> children;
    private Object[] cacheInputs;
    private ExpressionFunction function;
    private GeneticComponent parent;
    private ContextDependentExpressionProxy cxProxy = null; // this stays null unless the function is context dependent.
    private int depth;

    private void setParent(Expression parent) {
        this.parent = parent;
    }

    public int getDepth() {
        return depth;
    }

    public Expression(ExpressionFunction function, GeneticComponent parent) {

        this.parent = parent;

        if (function instanceof ContextDependentExpressionFunction) {
            cxProxy = new ContextDependentExpressionProxy((ContextDependentExpressionFunction) function, this);
        }

        children = new ArrayList<Expression>(function.getNumberInputs());
        cacheInputs = new Object[function.getNumberInputs()];

        for (int i = 0; i < function.getNumberInputs(); i++) {
            children.add(null);
        }

        this.function = function;
        this.depth = parent.getDepth() + 1;
    }

    public Class getOutputType() {
        return function.getReturnType();
    }

    public boolean assignChild(int index, Expression child) {

        if (index >= function.getNumberInputs() || index < 0) {
            throw new IllegalArgumentException("Assigning child index of " + index + " where number is: " + function.getNumberInputs());
        }

        if (child == null) {
            throw new IllegalArgumentException("Attempting to assign null child!");
        }

        // allowing child to be null here
        // for sake of use in editor
        if (child.getOutputType() != function.getInputType(index)) {
            throw new IllegalArgumentException("Child output type " + child.getOutputType() + " does not match function type " + function.getInputType(index));
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

        Object output;

        for (int i = 0; i < children.size(); i++) {
            Expression child = children.get(i);
            cacheInputs[i] = child.evaluate(context);
        }

        try {

            if (cxProxy != null) {
                // handle context dependent case:
                output = cxProxy.evaluate(context, cacheInputs);
            } else {
                output = function.evaluate(context, cacheInputs);
            }

            if (output == null) {
                throw new IllegalStateException("function " + function.getClass().getName() + " created a null output! " +
                        "Return type: " + function.getReturnType());
            }

            output = Foundation.getInstance().getTypeSystem().checkInvalid(output);
        } catch (ClassCastException e) {
            output = Foundation.getInstance().getTypeSystem().createDefault(function.getReturnType());
        } catch (NullPointerException e) {
            output = Foundation.getInstance().getTypeSystem().createDefault(function.getReturnType());
        }

        return output;
    }

    public void setup() throws BuildException {

        function.setup();

        for (Expression child : children) {
            if (child != null) {
                child.setup();
            }
        }

        if (cxProxy != null) {
            cxProxy.setup();
        }
    }

    public boolean isSetup() {
        //return isSetup;
        if (!function.isSetup()) {
            return false;
        }

        for (Expression child : children) {
            if (!child.isSetup()) {
                return false;
            }
        }

        if (cxProxy != null && !cxProxy.isSetup()) {
            return false;
        }

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

    public GeneticComponent getParent() {
        return parent;
    }

    public ContextModel getContextModel() {
        return getParent().getContextModel();
    }

    public void setParent(GeneticComponent newParent) {
        this.parent = newParent;
    }

    public ContextDependentExpressionProxy getContextProxy() {
        return cxProxy;
    }

    public Expression clone(GeneticComponent newParent) throws BuildException {

        Expression clone = new Expression(function.cloneFunction(), newParent);

        // clone children
        for (int i = 0; i < getNumberInputs(); i++) {
            clone.setInput(i, getInput(i).clone(clone));
        }

        if (cxProxy != null) {
            clone.cxProxy = cxProxy.clone(clone);
        }

        return clone;
    }

    public void removeVariable(String name) {
        if (function instanceof VariableExpressionFunction) {
            VariableExpressionFunction variableFunction = (VariableExpressionFunction) function;
            if (variableFunction.getVariableName().equals(name)) {
                try {
                    // now we need to replace the function.
                    Class returnType = variableFunction.getReturnType();
                    ExpressionFunction constantFunction = Foundation.getInstance().getAllExpressionFunctions().getConstantFunction(returnType);
                    function = constantFunction;

                } catch (BuildException ex) {
                    // Supress an exception here, it should never occur.
                }
            }
        }

        if (cxProxy != null) {
            cxProxy.removeVariable(name);
        }
        // otherwise do nothing, we're okay.
    }

    public boolean hasVariable(String name) {
        if (function instanceof VariableExpressionFunction) {
            VariableExpressionFunction variableFunction = (VariableExpressionFunction) function;
            if (variableFunction.getVariableName().equals(name)) {
                return true;
            }
        }

        if (cxProxy != null && cxProxy.hasVariable(name)) {
            return true;
        }
        return false;
    }

    public boolean hasMethod(String name) {
        return false;
    }
}
