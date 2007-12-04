/*
 * AccessorFunction.java
 *
 * Created on October 5, 2006, 2:31 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package genetic.component.expression.function;

import genetic.component.accessor.Accessor;
import genetic.*;

/**
 *
 * @author Calvin Ashmore
 */
public class AccessorFunction extends ExpressionFunction {
    //String name;
    Accessor accessor;
    //Class[] inputClasses;
    /** Creates a new instance of Variable */
    public AccessorFunction() {
    }

    public AccessorFunction(Accessor accessor) {
        this.accessor = accessor;
    }

    @Override
    public Object evaluate(Context context, Object[] inputs) {
        return accessor.evaluate(context, inputs);
    }

    @Override
    public int getNumberInputs() {
        return accessor.getNumberInputs();
    }

    @Override
    public Class getInputType(int i) {
        return accessor.getInputType(i);
    }

    public Class getReturnType() {
        return accessor.getReturnType();
    }

    @Override
    public int getNumberParameters() {
        return accessor.getNumberParameters();
    }

    @Override
    public Object getParameter(int i) {
        return accessor.getParameter(i);
    }

    @Override
    public String getParameterName(int i) {
        return accessor.getParameterName(i);
    }

    @Override
    public Class getParameterType(int i) {
        return accessor.getParameterType(i);
    }

    @Override
    public void setParameter(int i, Object value) {
        accessor.setParameter(i, value);
    
    }
    /*public Class[] getInputClasses() {
    return inputClasses;
    }*/
    /*public String toString(String... args) {
    String r = "accessor."+name+"(";
    if(args != null && args.length > 0) {
    r += " "+args[0];
    for(int i=1;i<args.length;i++)
    r += ", "+args[i];
    r += " ";
    }
    r += ")";
    return r;
    }*/
}
