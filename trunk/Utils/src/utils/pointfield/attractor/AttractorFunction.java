/*
 * AttractorFunction.java
 *
 * Created on May 10, 2006, 1:46 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.pointfield.attractor;

import utils.pointfield.Quadtree;

/**
 *
 * @author gtg126z
 */
abstract public class AttractorFunction<PointType extends APoint> {
    abstract public PointType getNewPoint();
    abstract public Quadtree makeQuadtree();
    abstract public void apply(PointType in_val, PointType out_val);
    abstract public double derivMagnitude(PointType in_val);
    
    public void adjustParameters() {}
    
    public int getIdealIterations() {return 40000;}
    public int getMinimumCells() {return 50;}
    public double getMaxLyapunov() {return Float.MAX_VALUE;}
    public double getMinLyapunov() {return 0;}
}
