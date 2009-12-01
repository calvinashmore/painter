/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.expression.function.cx;

import genetic.BuildException;
import genetic.GeneticComponent;
import genetic.component.context.Context;
import genetic.component.context.ContextModel;
import genetic.component.expression.Expression;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class ContextDependentExpressionProxy implements GeneticComponent {

    private Expression parent;
    private ContextDependentExpressionFunction function;
    private ContextModel contextModel;
    private List<Expression> children;
    private int depth;

    public ContextDependentExpressionProxy(ContextDependentExpressionFunction function, Expression parent) {
        //assert (parent instanceof Expression);
        this.depth = parent.getDepth()+1;
        this.parent = parent;
        this.function = function;

        children = new ArrayList<Expression>();

        contextModel = new ContextModel(parent.getContextModel());
        for (int i = 0; i < function.getNumberContextVariables(); i++) {

            String intendedName = function.getContextVariableIntendedName(i);
            Class type = function.getContextVariableType(i);

            String actualName = contextModel.declareVariable(intendedName, type, true);
            function.setContextVariableActualName(intendedName, actualName);
        }

        for(int i=0; i<function.getNumberContextInputs(); i++)
            children.add(null);
    }

    public Expression getParent() {
        return parent;
    }

    public ContextModel getContextModel() {
        return contextModel;
    }

    public void setParent(GeneticComponent newParent) {
        assert (newParent instanceof Expression) : "Attempt to assign " + newParent + " as parent of " + this;
        this.parent = (Expression) newParent;
    }

    public ContextDependentExpressionProxy clone(GeneticComponent newParent) throws BuildException {
        assert (newParent instanceof Expression) : "Attempt to assign " + newParent + " as parent of a clone of " + this;

        ContextDependentExpressionProxy clone = new ContextDependentExpressionProxy(
                (ContextDependentExpressionFunction) function.cloneFunction(), (Expression) newParent);

        for (Expression child : children) {
            clone.children.add(child.clone(clone));
        }

        return clone;
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
        return false;
    }

    public Expression getInput(int i) {return children.get(i);}
    public void setInput(int i, Expression child) {children.set(i, child);}

    public int getDepth() {
        return depth;
    }

    public void setup() throws BuildException {

        function.setContextModel(getContextModel());
        function.setup();
        for(Expression child : children)
            child.setup();
    }

    public boolean isSetup() {

        if(!function.isSetup())
            return false;

        for(Expression child : children)
            if(!child.isSetup())
                return false;
        return true;
    }

    public Object evaluate(Context context, Object[] inputs) {
        return function.evaluate(context, inputs, children);
    }
}
