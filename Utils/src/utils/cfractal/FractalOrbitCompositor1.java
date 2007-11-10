/*
 * FractalOrbitCompositor.java
 *
 * Created on December 2, 2006, 2:45 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.cfractal;

/**
 *
 * @author Calvin Ashmore
 */
public interface FractalOrbitCompositor1 {
    
    public void clear();
    public void addSample(double iterationRatio, double value);
    public double getComposite();
}
