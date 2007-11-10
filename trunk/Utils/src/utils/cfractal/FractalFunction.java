/*
 * FractalFunction.java
 *
 * Created on February 18, 2006, 5:58 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.cfractal;

import utils.linear.Complex;

/**
 *
 * @author Calvin Ashmore
 */
public interface FractalFunction {
    void apply(Complex z, Complex c, Complex out);
    boolean isZeroStable();
    double getBailAmmount();
}
