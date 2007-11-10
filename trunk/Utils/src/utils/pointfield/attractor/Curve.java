/*
 * Curve.java
 *
 * Created on May 22, 2006, 4:05 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.pointfield.attractor;

import java.util.ArrayList;
import java.util.List;
import utils.pointfield.Quadtree;

/**
 *
 * @author Calvin Ashmore
 */
public class Curve<PointType extends APoint> {
        
    public void process(CurveFunction<PointType> function, Quadtree<PointType> base, int numberPoints) {
        
        double xmin = Float.MAX_VALUE;
        double xmax = -Float.MAX_VALUE;
        double ymin = Float.MAX_VALUE;
        double ymax = -Float.MAX_VALUE;
        
        List<PointType> pointList = new ArrayList(numberPoints);
        for(int i=0;i<numberPoints;i++) {
            double t = (double)i/(numberPoints-1);
            
            PointType point = function.evalCurve(t);
            pointList.add(point);
            
            xmin = Math.min(xmin, point.x);
            xmax = Math.max(xmax, point.x);
            ymin = Math.min(ymin, point.y);
            ymax = Math.max(ymax, point.y);
        }
        
        base.setup(xmin,xmax,ymin,ymax);
        base.setData(pointList);
    }
}
