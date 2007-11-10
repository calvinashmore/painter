/*
 * Parameterized.java
 * 
 * Created on Nov 1, 2007, 8:46:24 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

/**
 *
 * @author Calvin Ashmore
 */
public interface Parameterized {
    public int getNumberParameters();
    public Object getParameter(int i);
    public String getParameterName(int i);
    public Class getParameterType(int i);
    public void setParameter(int i, Object value);
}
