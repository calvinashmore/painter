/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.curves;

import utils.linear.Linear;

/**
 *
 * @author Calvin Ashmore
 */
public class Spline<T extends Linear<T>> implements Curve<T> {

    private T a[];

    public Spline(T... a) {
        this.a = a;
    }

    public T getValue(double t) {

        double alpha = t*a.length - Math.floor(t*a.length);
        int i = (int)(t*a.length);

        T r = a[0].zero();
        r.addv(a[getWrap(i-1)].mult(splineEval(alpha, -1)));
        r.addv(a[getWrap(i+0)].mult(splineEval(alpha, 0)));
        r.addv(a[getWrap(i+1)].mult(splineEval(alpha, 1)));
        r.addv(a[getWrap(i+2)].mult(splineEval(alpha, 2)));
        return r;
    }

    private double splineEval(double t, int lev) {
        switch(lev) {
            case -1: return (1/6.0)*(1 - 3*t + 3*t*t - t*t*t);
            case  0: return (1/6.0)*(4 - 6*t*t + 3*t*t*t);
            case  1: return (1/6.0)*(1 + 3*t + 3*t*t - 3*t*t*t);
            case  2: return (1/6.0)*(t*t*t);
        }
        return 0;
    }
    private int getWrap(int x) {
        return (x+a.length)%a.length;
    }
}
