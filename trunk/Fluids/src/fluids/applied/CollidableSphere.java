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
public class CollidableSphere implements Collidable {

    private LVect3d center;
    private double radius;
    private List<LVect3d> hull;

    public CollidableSphere(LVect3d center, double radius) {
        this.center = center;
        this.radius = radius;

        // simple box hull.
        hull = new ArrayList<LVect3d>();
        hull.add(new LVect3d(center.x + radius, center.y + radius, center.z + radius));
        hull.add(new LVect3d(center.x + radius, center.y + radius, center.z - radius));
        hull.add(new LVect3d(center.x + radius, center.y - radius, center.z + radius));
        hull.add(new LVect3d(center.x + radius, center.y - radius, center.z - radius));
        hull.add(new LVect3d(center.x - radius, center.y + radius, center.z + radius));
        hull.add(new LVect3d(center.x - radius, center.y + radius, center.z - radius));
        hull.add(new LVect3d(center.x - radius, center.y - radius, center.z + radius));
        hull.add(new LVect3d(center.x - radius, center.y - radius, center.z - radius));
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

        double r = point.sub(center).magnitude() - radius;
        return r;
    }

    public boolean isInside(LVect3d point) {
        double dx = point.x - center.x;
        double dy = point.y - center.y;
        double dz = point.z - center.z;
        return dx * dx + dy * dy + dz * dz < radius * radius;
    }

    public LVect3d getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public List<LVect3d> getHull() {
        return hull;
    }

    public TraceResult trace(LVect3d start, LVect3d end) {
        // algebraic ray-sphere intersection:
        // ray is x(t) = start + d;
        // sphere is (x-center) dot (x-center) = radius^2
        // substitution results in quadratic form:
        // A*t*t + B*t + C = 0
        // where A = d dot d = 1 (for unit vector), B = 2*(start - center) dot d, C = (start - center) dot (start - center) - radius^2

        LVect3d d = end.sub(start);
        double segmentLength = d.magnitude();
        d.multv(1.0 / segmentLength);

        LVect3d q = start.sub(center);

        double B = q.dot(d);
        double C = q.dot(q) - radius * radius;
        double D = B * B - C;
        if (D < 0) {
            return null;
        }

        double l = -B - Math.sqrt(D);
        if (l > segmentLength) {
            return null;
        }

        LVect3d intersection = d.mult(l);
        intersection.addv(start);

        TraceResult result = new TraceResult();
        result.intersectionPoint = intersection;
        result.surfaceNormal = normalTo(intersection);
        return result;
    }

    public LVect3d normalTo(LVect3d point) {
        LVect3d v = point.sub(center);
        v.normalv();
        return v;
    }
}
