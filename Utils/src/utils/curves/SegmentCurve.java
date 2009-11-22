/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.curves;

import utils.linear.Linear;

/**
 * @author Calvin Ashmore
 */
public class SegmentCurve<T extends Linear<T>> implements Curve<T> {

    private T a;
    private T b;

    /**
     * Defines a linear curve between a and b
     * @param a
     * @param b
     */
    public SegmentCurve(T a, T b) {
        this.a = a;
        this.b = b;
    }

    public T getValue(double t) {
        return a.mult(1 - t).add(b.mult(t));
    }
}
