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
public class Estimate_q extends Estimate {
    
    private double uMinimum;
    private double uMaximum;
    private double iMinimum;
    private double iMaximum;
    private double jMinimum;
    private double jMaximum;
    private double kMinimum;
    private double kMaximum;
    
    public double getUMinimum() {return uMinimum;}
    public double getUMaximum() {return uMaximum;}
    public double getIMinimum() {return iMinimum;}
    public double getIMaximum() {return iMaximum;}
    public double getJMinimum() {return jMinimum;}
    public double getJMaximum() {return jMaximum;}
    public double getKMinimum() {return kMinimum;}
    public double getKMaximum() {return kMaximum;}
    public boolean isConstant() {
        return
                uMinimum == uMaximum &&
                iMinimum == iMaximum &&
                jMinimum == jMaximum &&
                kMinimum == kMaximum;
    }
    
    public utils.linear.Quaternion getCValue() {
        return new utils.linear.Quaternion(uMaximum, iMaximum, jMaximum, kMaximum);
    }
    
    public Estimate_v3 getVectorEstimate() {
        return new Estimate_v3(
                iMinimum, iMaximum,
                jMinimum, jMaximum,
                kMinimum, kMaximum
                );
    }
    
    public double getMaxMagnitude() {
        double urange = Math.max( Math.abs(uMinimum), Math.abs(uMaximum));
        double xrange = Math.max( Math.abs(iMinimum), Math.abs(iMaximum));
        double yrange = Math.max( Math.abs(jMinimum), Math.abs(jMaximum));
        double zrange = Math.max( Math.abs(kMinimum), Math.abs(kMaximum));
        return Math.sqrt( urange*urange + xrange*xrange + yrange*yrange + zrange*zrange);
    }
    
    public double getMinMagnitude() {
        double urange = Math.min( Math.abs(uMinimum), Math.abs(uMaximum));
        double xrange = Math.min( Math.abs(iMinimum), Math.abs(iMaximum));
        double yrange = Math.min( Math.abs(jMinimum), Math.abs(jMaximum));
        double zrange = Math.min( Math.abs(kMinimum), Math.abs(kMaximum));
        return Math.sqrt( urange*urange + xrange*xrange + yrange*yrange + zrange*zrange);
    }
    
    /** Creates a new instance of Estimate_d */
    public Estimate_q() {
        this.uMinimum = Double.MIN_VALUE;
        this.uMaximum = Double.MAX_VALUE;
        this.iMinimum = Double.MIN_VALUE;
        this.iMaximum = Double.MAX_VALUE;
        this.jMinimum = Double.MIN_VALUE;
        this.jMaximum = Double.MAX_VALUE;
        this.kMinimum = Double.MIN_VALUE;
        this.kMaximum = Double.MAX_VALUE;
    }
    
    public Estimate_q(
            double uMinimum, double uMaximum,
            double iMinimum, double iMaximum,
            double jMinimum, double jMaximum,
            double kMinimum, double kMaximum
            ) {
        this.uMinimum = uMinimum;
        this.uMaximum = uMaximum;
        this.iMinimum = iMinimum;
        this.iMaximum = iMaximum;
        this.jMinimum = jMinimum;
        this.jMaximum = jMaximum;
        this.kMinimum = kMinimum;
        this.kMaximum = kMaximum;
    }
    
    public Estimate_q(utils.linear.Quaternion min, utils.linear.Quaternion max) {
        this.uMinimum = min.u;
        this.uMaximum = max.u;
        this.iMinimum = min.i;
        this.iMaximum = max.i;
        this.jMinimum = min.j;
        this.jMaximum = max.j;
        this.kMinimum = min.k;
        this.kMaximum = max.k;
    }
    
}
