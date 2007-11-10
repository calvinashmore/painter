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
public class Estimate_c extends Estimate {
    
    private double xMinimum;
    private double xMaximum;
    
    private double yMinimum;
    private double yMaximum;
    
    public double getXMinimum() {return xMinimum;}
    public double getXMaximum() {return xMaximum;}
    public double getYMinimum() {return yMinimum;}
    public double getYMaximum() {return yMaximum;}
    public boolean isConstant() {return xMinimum == xMaximum && yMinimum == yMaximum;}
    
    public utils.linear.LVect2d getCValue() {return new utils.linear.LVect2d(xMaximum, yMaximum);}
    
    public double getMaxMagnitude() {
        double xrange = Math.max( Math.abs(xMinimum), Math.abs(xMaximum));
        double yrange = Math.max( Math.abs(yMinimum), Math.abs(yMaximum));
        return Math.sqrt(xrange*xrange + yrange*yrange);
    }
    
    public double getMinMagnitude() {
        double xrange = Math.min( Math.abs(xMinimum), Math.abs(xMaximum));
        double yrange = Math.min( Math.abs(yMinimum), Math.abs(yMaximum));
        return Math.sqrt(xrange*xrange + yrange*yrange);
    }
    
    /** Creates a new instance of Estimate_d */
    public Estimate_c() {
        this.xMinimum = Double.MIN_VALUE;
        this.xMaximum = Double.MAX_VALUE;
        this.yMinimum = Double.MIN_VALUE;
        this.yMaximum = Double.MAX_VALUE;
    }
    
    public Estimate_c(double xMinimum, double xMaximum, double yMinimum, double yMaximum) {
        this.xMinimum = xMinimum;
        this.xMaximum = xMaximum;
        this.yMinimum = yMinimum;
        this.yMaximum = yMaximum;
    }
    
    public Estimate_c(utils.linear.LVect2d min, utils.linear.LVect2d max) {
        this.xMinimum = min.x;
        this.xMaximum = max.x;
        this.yMinimum = min.y;
        this.yMaximum = max.y;
    }
    
}
