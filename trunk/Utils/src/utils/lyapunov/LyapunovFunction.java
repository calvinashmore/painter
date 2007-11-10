/*
 * LyapunovFunction.java
 *
 * Created on May 10, 2006, 10:16 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.lyapunov;

/**
 *
 * @author gtg126z
 */
public interface LyapunovFunction {
    
    //public void reset();
    public double apply(double x, double k);
    public double deriv(double x, double k);
}
