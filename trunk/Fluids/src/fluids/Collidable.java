/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fluids;

import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public interface Collidable {

    public class TraceResult {
        public LVect3d intersectionPoint;
        public LVect3d surfaceNormal;
        public LVect3d surfaceTangent;
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

    public TraceResult trace(LVect3d start, LVect3d end);
}
