/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fluids;

import java.util.List;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public interface Collidable {

    public class TraceResult {
        public LVect3d intersectionPoint;
        public LVect3d surfaceNormal;
    }

    /**
     * Returns the distance of the point to the object.
     * @param point
     * @return
     */
    public double getDistance(LVect3d point);

    /**
     * Returns true if the given point is inside the surface. This should be a very fast test.
     * @param point
     * @return
     */
    public boolean isInside(LVect3d point);

    /**
     * Returns a trace result indicating the data from the trace if the segment given by start and end intersects the collidable.
     * If it does NOT intersect, then NULL is returned.
     * @param start
     * @param end
     * @return
     */
    public TraceResult trace(LVect3d start, LVect3d end);

    /**
     * Returns a list of points whose convex hull bounds the collidable object
     * @return
     */
    public List<LVect3d> getHull();

    public LVect3d normalTo(LVect3d point);
}
