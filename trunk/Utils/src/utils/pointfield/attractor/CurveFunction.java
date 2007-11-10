/*
 * CurveFunction.java
 *
 * Created on May 22, 2006, 4:06 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.pointfield.attractor;

/**
 *
 * @author Calvin Ashmore
 */
public interface CurveFunction<PointType extends APoint> {
    public PointType evalCurve(double t); // t ranges from 0 to 1
}
