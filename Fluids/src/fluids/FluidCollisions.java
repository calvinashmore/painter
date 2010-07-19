/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids;

import fluids.Collidable.TraceResult;
import java.util.ArrayList;
import java.util.List;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class FluidCollisions<T extends Particle> {

    private List<Collidable> collidables = new ArrayList<Collidable>();
    private double slidingFriction = 0;
    private double stickDistance = 0;
    private double stickCoefficient = 0;

    public double getSlidingFriction() {
        return slidingFriction;
    }

    public void setSlidingFriction(double slidingFriction) {
        this.slidingFriction = slidingFriction;
    }

    public double getStickCoefficient() {
        return stickCoefficient;
    }

    public void setStickCoefficient(double stickCoefficient) {
        this.stickCoefficient = stickCoefficient;
    }

    public double getStickDistance() {
        return stickDistance;
    }

    public void setStickDistance(double stickDistance) {
        this.stickDistance = stickDistance;
    }

    public void addCollidable(Collidable collidable) {
        collidables.add(collidable);
    }

    public void resolveCollisions(Fluid<T> fluid) {
        // foreach collidable, get the nearby particles, and then trace them.
        for (Collidable collidable : collidables) {

            List<T> toTest = fluid.getNeighbors(collidable.getHull());
            for (Particle particle : toTest) {
                TraceResult trace = collidable.trace(particle.getPreviousPosition(), particle.getPosition());

                if (trace == null) {
                    // does not intersect, can ignore this.
                    continue;
                } else {
                    // okay, we hit the obstacle.
                    // now it bounces.

                    LVect3d v = particle.getPosition().sub(particle.getPreviousPosition());
                    //v.multv(1.0/fluid.getDt());


                    double normalMagnitude = v.dot(trace.surfaceNormal);
                    LVect3d vNormal = v.mult(normalMagnitude);
                    LVect3d vTangent = v.sub(vNormal);

                    vTangent.multv(slidingFriction);
                    LVect3d impulse = vNormal.sub(vTangent);
                    //impulse.multv(fluid.getDt());

                    particle.getPosition().addv(impulse);
                    if (collidable.getDistance(particle.getPosition()) < 0) {
                        particle.getPosition().setTo(trace.intersectionPoint);
                    }
                }

                // check stickiness.
                if (stickCoefficient > 0 && collidable.getDistance(particle.getPosition()) < stickDistance) {
                    double d = collidable.getDistance(particle.getPosition());
                    double impulseMagnitude = -fluid.getDt() * d * (1 - d / stickDistance);
                    LVect3d impulse = collidable.normalTo(particle.getPosition()).mult(impulseMagnitude);
                    particle.getPosition().addv(impulse);
                }
            }
        }
    }
}