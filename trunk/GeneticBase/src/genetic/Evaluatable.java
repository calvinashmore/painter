/*
 * TakesInputs.java
 * 
 * Created on Nov 1, 2007, 10:17:42 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

/**
 *
 * @author Calvin Ashmore
 */
public interface Evaluatable {
    public Object evaluate(Context context, Object inputs[]);
    public Class getReturnType();
    
    public int getNumberInputs();
    public Class getInputType(int i);
    public String getInputName(int i);
}
