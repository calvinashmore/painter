/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.util.curves;

import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class FermatSpiral implements Curve<LVect2d> {

    private double a;
    private double b;

    public FermatSpiral(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public FermatSpiral() {
        this(1, 3);
    }

    public LVect2d getValue(double t) {

        t = (2 * t - 1) * 2 * Math.PI;

        double r = a * Math.sqrt(t / (2 * Math.PI));
        return new LVect2d(r * Math.cos(b * t), r * Math.sin(b * t));
    }
}
