/*
 * NoiseFractal.java
 *
 * Created on May 3, 2006, 2:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.noise;

/**
 *
 * @author gtg126z
 */
public interface NoiseFractal {
    
    public double evalFractal(NoiseFunction f, double x, double y, double z);
}
