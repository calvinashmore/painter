/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.curves.derahm;

import utils.curves.Curve;
import utils.linear.Linear;

/**
 * The basic idea for this comes from here: http://en.wikipedia.org/wiki/De_Rham_curve
 * @author Calvin
 */
public class DeRahmCurve<T extends Linear<T>> implements Curve<T> {

    private static final int PRECISION = 53;
    private DeRahmFunction<T> function;

    public DeRahmCurve(DeRahmFunction<T> function) {
        this.function = function;
    }

    public T getValue(double t) {

        long L = 0;
        for (int i = 0; i < PRECISION; i++) {
            if (t < .5) {
//                System.out.print(0);
                t *= 2;
            } else {
//                System.out.print(1);
                L += 1 << i;
                t -= .5;
                t *= 2;
            }
        }

        T v = function.zero();
//        System.out.println();

        for (int i = 0; i < PRECISION; i++) {
            long bit = (L >> (PRECISION - i - 1)) & 1;
            if (bit == 0) {
                v = function.f0(v);
            } else {
                v = function.f1(v);
            }
        }

        return v;
    }
}
