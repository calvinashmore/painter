/*
 * FractalZoomSelector.java
 *
 * Created on December 1, 2006, 9:27 PM
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
public interface FractalZoomSelector {
    
    public void doSetup(int maxIterations, FractalFunction function, FractalBailout bailout);
    
    // where z is untransformed starting location
    public Complex getC(Complex z);
    
    // where z is untransformed starting location
    // should retrun z having been suitably transformed.
    public Complex getZoom(Complex z);
}
