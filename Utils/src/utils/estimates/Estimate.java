/*
 * Estimate.java
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
public class Estimate implements java.io.Serializable {
    
    // default Estimate class
    // this, instanced, implies that no real value estimation can be made
    
    public boolean isConstant() {return false;}
    
    /** Creates a new instance of Estimate */
    public Estimate() {
    }
    
}
