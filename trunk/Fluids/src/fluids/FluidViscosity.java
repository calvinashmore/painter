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
public class FluidViscosity<T extends Particle> {

    private double sigma, beta;

    public FluidViscosity(double sigma, double beta) {
        this.sigma = sigma;
        this.beta = beta;
    }

    public void applyViscosity(Fluid<T> fluid) {

        for (T particle : fluid.getAllParticles()) {

            List<T> neighbors = fluid.getNeighbors(particle);
            for (T neighbor : neighbors) {
                // do a triangular loop, only handle each pair once.
                if (neighbor.getIndex() >= particle.getIndex()) {
                    continue;
                }

                double q = fluid.getDistanceSquared(particle, neighbor);
                if (q >= fluid.getInteractionRadiusSquared()) {
                    continue;
                }
                q = Math.sqrt(q) / fluid.getInteractionRadius();

                LVect3d D = neighbor.getPosition().sub(particle.getPosition());
                D.normalv();
                double u = particle.getVelocity().sub(neighbor.getVelocity()).dot(D);

                if (u > 0) {
                    double impulseMagnitude = fluid.getDt() * (1 - q) * (sigma * u + beta * u * u);
                    LVect3d impulse = D.mult(.5 * impulseMagnitude);

                    particle.getVelocity().subv(impulse);
                    neighbor.getVelocity().addv(impulse);
                }
            }
        }
    }
}
