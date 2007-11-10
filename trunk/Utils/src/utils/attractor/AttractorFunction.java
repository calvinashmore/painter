/*
 * AttractorFunction.java
 *
 * Created on May 10, 2006, 1:46 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.attractor;

/**
 *
 * @author gtg126z
 */
public interface AttractorFunction {
    public final static int dimension = -1;
    public void apply(double[] in_val, double[] out_val);
    public double derivMagnitude(double[] in_val);
}
