/*
 * FractalOrbitTrap.java
 *
 * Created on December 2, 2006, 2:12 PM
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
public interface FractalOrbitTrap {
    
    // should return: 1 for when point falls inside trap
    // 0 at edge and for all points after
    public double getTrap(Complex z, Complex zPrevious, double iterationRatio);
}
