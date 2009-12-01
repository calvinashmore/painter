/*
 * APoint2d.java
 *
 * Created on May 18, 2006, 5:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.pointfield.attractor;

import utils.pointfield.Point;

/**
 *
 * @author Calvin Ashmore
 */
public class APoint2d extends APoint {

    public APoint2d() {}
    public APoint2d(APoint source) {
        x = source.x;
        y = source.y;
        index = source.index;
    }
    
    public double diff(APoint last) {
        return Math.abs(last.x - x) + Math.abs(last.y - y);
    }
    public double bound() {
        if(Double.isNaN(x) || Double.isNaN(y))
            return 100000;
        return Math.max( Math.abs(x), Math.abs(y) );
    }
    
    public void setMinValues() {
        x = -Float.MAX_VALUE;
        y = -Float.MAX_VALUE;
    }
    public void setMaxValues() {
        x = Float.MAX_VALUE;
        y = Float.MAX_VALUE;
    }
    
    public void minimize(APoint point) {
        APoint2d point1 = (APoint2d)point;
        x = Math.min(x, point1.x);
        y = Math.min(y, point1.y);
    }
    public void maximize(APoint point) {
        APoint2d point1 = (APoint2d)point;
        x = Math.max(x, point1.x);
        y = Math.max(y, point1.y);
    }
    
    final public APoint2d clone() {
        return new APoint2d(this);
    }
}
