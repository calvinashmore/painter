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
public class Estimate_d extends Estimate {
    
    private double minimum;
    private double maximum;
    
    public double getMinimum() {return minimum;}
    public double getMaximum() {return maximum;}
    public boolean isConstant() {return minimum == maximum;}
    
    public utils.linear.LDouble getCValue() {return new utils.linear.LDouble(maximum);}
    
    /** Creates a new instance of Estimate_d */
    public Estimate_d() {
        this.minimum = Double.MIN_VALUE;
        this.maximum = Double.MAX_VALUE;
    }
    
    public Estimate_d(double minimum, double maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }
    
}
