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
public class Estimate_v3 extends Estimate {
    
    private double xMinimum;
    private double xMaximum;
    
    private double yMinimum;
    private double yMaximum;
    
    private double zMinimum;
    private double zMaximum;
    
    public double getXMinimum() {return xMinimum;}
    public double getXMaximum() {return xMaximum;}
    public double getYMinimum() {return yMinimum;}
    public double getYMaximum() {return yMaximum;}
    public double getZMinimum() {return zMinimum;}
    public double getZMaximum() {return zMaximum;}
    public boolean isConstant() {return xMinimum == xMaximum && yMinimum == yMaximum && zMinimum == zMaximum;}
    
    public utils.linear.LVect3d getCValue() {return new utils.linear.LVect3d(xMaximum, yMaximum, zMaximum);}
    
    public double getMaxMagnitude() {
        double xrange = Math.max( Math.abs(xMinimum), Math.abs(xMaximum));
        double yrange = Math.max( Math.abs(yMinimum), Math.abs(yMaximum));
        double zrange = Math.max( Math.abs(zMinimum), Math.abs(zMaximum));
        return Math.sqrt(xrange*xrange + yrange*yrange + zrange*zrange);
    }
    
    public double getMinMagnitude() {
        double xrange = Math.min( Math.abs(xMinimum), Math.abs(xMaximum));
        double yrange = Math.min( Math.abs(yMinimum), Math.abs(yMaximum));
        double zrange = Math.min( Math.abs(zMinimum), Math.abs(zMaximum));
        return Math.sqrt(xrange*xrange + yrange*yrange + zrange*zrange);
    }
    
    /** Creates a new instance of Estimate_d */
    public Estimate_v3() {
        this.xMinimum = Double.MIN_VALUE;
        this.xMaximum = Double.MAX_VALUE;
        this.yMinimum = Double.MIN_VALUE;
        this.yMaximum = Double.MAX_VALUE;
        this.zMinimum = Double.MIN_VALUE;
        this.zMaximum = Double.MAX_VALUE;
    }
    
    public Estimate_v3(double xMinimum, double xMaximum, double yMinimum, double yMaximum, double zMinimum, double zMaximum) {
        this.xMinimum = xMinimum;
        this.xMaximum = xMaximum;
        this.yMinimum = yMinimum;
        this.yMaximum = yMaximum;
        this.zMinimum = zMinimum;
        this.zMaximum = zMaximum;
    }
    
    public Estimate_v3(utils.linear.LVect3d min, utils.linear.LVect3d max) {
        this.xMinimum = min.x;
        this.xMaximum = max.x;
        this.yMinimum = min.y;
        this.yMaximum = max.y;
        this.zMinimum = min.z;
        this.zMaximum = max.z;
    }
    
}
