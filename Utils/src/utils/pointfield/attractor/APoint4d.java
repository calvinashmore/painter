/*
 * APoint2d.java
 *
 * Created on May 18, 2006, 5:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.pointfield.attractor;

/**
 *
 * @author Calvin Ashmore
 */
public class APoint4d extends APoint {
    
    public APoint4d() {}
    public APoint4d(APoint4d source) {
        x = source.x;
        y = source.y;
        z = source.z;
        w = source.w;
        index = source.index;
    }
    
    public double diff(APoint last) {
        APoint4d last1 = (APoint4d)last;
        return Math.abs(last1.x - x) + Math.abs(last1.y - y) +
               Math.abs(last1.z - z) + Math.abs(last1.w - w);
    }
    public double bound() {
        if(Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z) || Double.isNaN(w))
            return 100000;
        return Math.max( Math.max( Math.abs(x), Math.abs(w)), Math.max( Math.abs(y), Math.abs(z)) );
    }
    
    public void setMinValues() {
        x = -Float.MAX_VALUE;
        y = -Float.MAX_VALUE;
        z = -Float.MAX_VALUE;
        w = -Float.MAX_VALUE;
    }
    public void setMaxValues() {
        x = Float.MAX_VALUE;
        y = Float.MAX_VALUE;
        z = Float.MAX_VALUE;
        w = Float.MAX_VALUE;
    }
    
    public void minimize(APoint point) {
        APoint4d point1 = (APoint4d)point;
        x = Math.min(x, point1.x);
        y = Math.min(y, point1.y);
        z = Math.min(z, point1.z);
        w = Math.min(w, point1.w);
    }
    public void maximize(APoint point) {
        APoint4d point1 = (APoint4d)point;
        x = Math.max(x, point1.x);
        y = Math.max(y, point1.y);
        z = Math.max(z, point1.z);
        w = Math.max(w, point1.w);
    }
    
    public double z;
    public double w;
    
    final public APoint4d clone() {
        return new APoint4d(this);
    }
}
