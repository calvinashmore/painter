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
public class Estimate_col extends Estimate {
    
    private double rMinimum;
    private double rMaximum;
    
    private double gMinimum;
    private double gMaximum;
    
    private double bMinimum;
    private double bMaximum;
    
    public double getRMinimum() {return rMinimum;}
    public double getRMaximum() {return rMaximum;}
    public double getGMinimum() {return gMinimum;}
    public double getGMaximum() {return gMaximum;}
    public double getBMinimum() {return bMinimum;}
    public double getBMaximum() {return bMaximum;}
    public boolean isConstant() {return rMinimum == rMaximum && gMinimum == gMaximum && bMinimum == bMaximum;}
    
    public utils.linear.Color getCValue() {return new utils.linear.Color(rMaximum, gMaximum, bMaximum);}
    
    public double getMaxMagnitude() {
        return Math.max(rMaximum , Math.max(gMaximum , bMaximum));
    }
    
    public double getMinMagnitude() {
        return Math.min(rMinimum , Math.min(gMinimum , bMinimum));
    }
    
    /** Creates a new instance of Estimate_d */
    public Estimate_col() {
        this.rMinimum = Double.MIN_VALUE;
        this.rMaximum = Double.MAX_VALUE;
        this.gMinimum = Double.MIN_VALUE;
        this.gMaximum = Double.MAX_VALUE;
        this.bMinimum = Double.MIN_VALUE;
        this.bMaximum = Double.MAX_VALUE;
    }
    
    public Estimate_col(double rMinimum, double rMaximum, double gMinimum, double gMaximum, double bMinimum, double bMaximum) {
        this.rMinimum = rMinimum;
        this.rMaximum = rMaximum;
        this.gMinimum = gMinimum;
        this.gMaximum = gMaximum;
        this.bMinimum = bMinimum;
        this.bMaximum = bMaximum;
    }
    
    public Estimate_col(utils.linear.Color min, utils.linear.Color max) {
        this.rMinimum = min.r;
        this.rMaximum = max.r;
        this.gMinimum = min.g;
        this.gMaximum = max.g;
        this.bMinimum = min.b;
        this.bMaximum = max.b;
    }
    
}
