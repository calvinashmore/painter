/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils.curves.derahm;

import utils.linear.LVect2d;

/**
 *
 * @author Calvin
 */
public class GeneralAffineFunction implements DeRahmFunction<LVect2d>{

    private double a, b, c, d, e, f;

    public GeneralAffineFunction(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }



    public LVect2d f0(LVect2d x) {
        return new LVect2d(
                a*x.x + d*x.y,
                b*x.x + e*x.y);
    }

    public LVect2d f1(LVect2d x) {
        return new LVect2d(
                a+(1-a)*x.x + c*x.y,
                b-b*x.x + f*x.y);
    }

    public LVect2d zero() {
        return new LVect2d();
    }

}
