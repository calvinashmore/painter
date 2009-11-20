/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.util.curves;

import utils.linear.LVect2d;
import utils.linear.Linear;

/**
 *
 * @author Calvin Ashmore
 */
public class LogarithmicSpiral implements Curve<LVect2d> {

    private double a;
    private double b;
    private double c;

    public LogarithmicSpiral(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public LogarithmicSpiral() {
        this(1, 1, 3);
    }

    public LVect2d getValue(double t) {

        t = t * 2 * Math.PI;

        double r = a * Math.exp(b * t / (2 * Math.PI));
        return new LVect2d(r * Math.cos(c * t), r * Math.sin(c * t));
    }
}
