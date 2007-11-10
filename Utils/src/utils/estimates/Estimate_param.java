/*
 * Estimate_d.java
 *
 * Created on October 1, 2005, 9:53 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package utils.estimates;

/**
 *
 * @author Calvin Ashmore
 */
public class Estimate_param extends Estimate {
    
    private Object value;
    
    public Object getValue() {return value;}
    public boolean isConstant() {return true;}
    
    /** Creates a new instance of Estimate_d */
    public Estimate_param() {this(null);}
    
    public Estimate_param(Object value) {
        this.value = value;
    }
    
}
