/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils.curves;

import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class Circle implements Curve<LVect2d>{

    LVect2d center;
    double radius;

    public Circle(LVect2d center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public LVect2d getValue(double t) {
        LVect2d r = new LVect2d(center);
        r.x += radius*Math.cos(t*2*Math.PI);
        r.y += radius*Math.sin(t*2*Math.PI);
        return r;
    }

}
