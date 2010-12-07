/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.curves.derahm;

import utils.linear.Complex;

/**
 *
 * @author Calvin
 */
public class CesaroFunction implements DeRahmFunction<Complex> {

    final private Complex a;
    final private Complex oneMinusA;

    public CesaroFunction(Complex a) {
        this.a = a;
        oneMinusA = new Complex(1 - a.x, -a.y);
    }

    public Complex f0(Complex z) {
        return a.mult(z);
    }

    public Complex f1(Complex z) {
        return a.add(oneMinusA.mult(z));
    }

    public Complex zero() {
        return new Complex();
    }
}
