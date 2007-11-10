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
abstract public class APoint extends utils.pointfield.Point {
    
    abstract public double diff(APoint last);
    abstract public double bound();
    
    abstract public void setMinValues();
    abstract public void setMaxValues();
    
    abstract public void minimize(APoint point);
    abstract public void maximize(APoint point);
    
    public double index;
    
    abstract public APoint clone();
}
