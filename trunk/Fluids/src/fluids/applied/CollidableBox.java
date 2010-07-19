/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.applied;

import fluids.Collidable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class CollidableBox implements Collidable {

    private LVect3d center;
    private double dx, dy, dz;
    private List<LVect3d> hull;

    public CollidableBox(LVect3d center, double dx, double dy, double dz) {
        this.center = center;
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;

        hull = new ArrayList<LVect3d>();
        hull.add(new LVect3d(center.x + dx, center.y + dy, center.z + dz));
        hull.add(new LVect3d(center.x + dx, center.y + dy, center.z - dz));
        hull.add(new LVect3d(center.x + dx, center.y - dy, center.z + dz));
        hull.add(new LVect3d(center.x + dx, center.y - dy, center.z - dz));
        hull.add(new LVect3d(center.x - dx, center.y + dy, center.z + dz));
        hull.add(new LVect3d(center.x - dx, center.y + dy, center.z - dz));
        hull.add(new LVect3d(center.x - dx, center.y - dy, center.z + dz));
        hull.add(new LVect3d(center.x - dx, center.y - dy, center.z - dz));
        hull = Collections.unmodifiableList(hull);
    }

    /**
     * This returns the *maximum* of the distance of any point to the plane of the box.
     * Around corners, the distance will be more of a manhattan metric.
     * This will efficiently yield accurate measurements close to the surface of the volume.
     * @param point
     * @return
     */
    public double getDistance(LVect3d point) {

        double xOffset = Math.abs(point.x - center.x) - dx;
        double yOffset = Math.abs(point.y - center.y) - dy;
        double zOffset = Math.abs(point.z - center.z) - dz;

        return Math.max(xOffset, Math.max(yOffset, zOffset));
    }

    public boolean isInside(LVect3d point) {
        if (point.x - center.x < -dx || point.x - center.x > dx) {
            return false;
        }
        if (point.y - center.y < -dy || point.y - center.y > dy) {
            return false;
        }
        if (point.z - center.z < -dz || point.z - center.z > dz) {
            return false;
        }
        return true;
    }

    public List<LVect3d> getHull() {
        return hull;
    }

    public TraceResult trace(LVect3d start, LVect3d end) {

        double tNear = -Double.MAX_VALUE;
        double tFar = Double.MAX_VALUE;

        LVect3d d = end.sub(start); // unit vector denoting the ray from start to the end
        double r = d.magnitude(); // the length of the segment
        d.multv(1.0 / r);

        int trigger = 0;
        // this indicates which of the planes triggered the collision. 1->x, 2->y, 3->z

        // go plane by plane.
        // X plane
        if (d.x == 0) {
            // no movement in the x direction, so ray is parallel to the x planes.
            if (start.x < center.x - dx || start.x > center.x + dx) {
                // the segment is fully outside the planes.
                return null;
            }
        } else {
            double t1 = (center.x - dx - start.x) / d.x;
            double t2 = (center.x + dx - start.x) / d.x;
            if (t1 > t2) {
                double tmp = t1;
                t1 = t2;
                t2 = tmp;
            }
            if (t1 > tNear) {
                tNear = t1;
                trigger = 1;
            }
            if (t2 < tFar) {
                tFar = t2;
            }

            if (tNear > tFar) {
                // the box was missed
                return null;
            } else if (tFar < 0) {
                // the ray points away from the box
                return null;
            }
        }

        // Y plane
        if (d.y == 0) {
            // no movement in the x direction, so ray is parallel to the x planes.
            if (start.y < center.y - dx || start.y > center.y + dy) {
                // the segment is fully outside the planes.
                return null;
            }
        } else {
            double t1 = (center.y - dy - start.y) / d.y;
            double t2 = (center.y + dy - start.y) / d.y;
            if (t1 > t2) {
                double tmp = t1;
                t1 = t2;
                t2 = tmp;
            }
            if (t1 > tNear) {
                tNear = t1;
                trigger = 2;
            }
            if (t2 < tFar) {
                tFar = t2;
            }

            if (tNear > tFar) {
                // the box was missed
                return null;
            } else if (tFar < 0) {
                // the ray points away from the box
                return null;
            }
        }

        // Z plane
        if (d.z == 0) {
            // no movement in the x direction, so ray is parallel to the x planes.
            if (start.z < center.z - dz || start.z > center.z + dz) {
                // the segment is fully outside the planes.
                return null;
            }
        } else {
            double t1 = (center.z - dz - start.z) / d.z;
            double t2 = (center.z + dz - start.z) / d.z;
            if (t1 > t2) {
                double tmp = t1;
                t1 = t2;
                t2 = tmp;
            }
            if (t1 > tNear) {
                tNear = t1;
                trigger = 3;
            }
            if (t2 < tFar) {
                tFar = t2;
            }

            if (tNear > tFar) {
                // the box was missed
                return null;
            } else if (tFar < 0) {
                // the ray points away from the box
                return null;
            }
        }

        if (tNear > r) {
            // the segment isn't long enough.
            return null;
        }

        TraceResult result = new TraceResult();
        result.intersectionPoint = start.add(d.mult(tNear));
        if (trigger == 1) {
            result.surfaceNormal = new LVect3d(-Math.signum(d.x), 0, 0);
        } else if (trigger == 2) {
            result.surfaceNormal = new LVect3d(0, -Math.signum(d.y), 0);
        } else if (trigger == 3) {
            result.surfaceNormal = new LVect3d(0, 0, -Math.signum(d.z));
        }
        return result;
    }

    public LVect3d normalTo(LVect3d point) {
        double px = Math.abs(point.x - center.x) - dx;
        double py = Math.abs(point.y - center.y) - dy;
        double pz = Math.abs(point.z - center.z) - dz;

        if (px >= py && px >= pz) {
            // x is greatest
            return new LVect3d(Math.signum(point.x - center.x), 0, 0);
        } else if (py >= px && py >= pz) {
            // y is greatest
            return new LVect3d(0, Math.signum(point.y - center.y), 0);
        } else {
            // z is greatest
            return new LVect3d(0, 0, Math.signum(point.z - center.z));
        }
    }
}
