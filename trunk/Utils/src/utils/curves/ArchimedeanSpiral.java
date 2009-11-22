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
public class ArchimedeanSpiral implements Curve<LVect2d> {

    private double a;
    private double b;

    public ArchimedeanSpiral(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public ArchimedeanSpiral() {
        this(1,3);
    }

    public LVect2d getValue(double t) {

        t = t * 2 * Math.PI;

        double r = a * t / (2 * Math.PI);
        return new LVect2d(r * Math.cos(b * t), r * Math.sin(b * t));
    }
}
