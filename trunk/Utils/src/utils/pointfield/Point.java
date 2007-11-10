/*
 * Point.java
 *
 * Created on May 18, 2006, 3:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.pointfield;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class Point implements java.io.Serializable {
    
    public Point() {}
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double x, y;
    
    public double distanceSquared(double x, double y) {
        return (this.x-x)*(this.x-x) + (this.y-y)*(this.y-y);
    }
}
