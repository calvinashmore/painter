/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids;

import fluids.Particle.ParticleSpring;
import java.util.ArrayList;
import java.util.List;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class FluidElastics<T extends Particle> {

    private double springTension;
    private double plasticity;
    private double yieldRatio;

    public FluidElastics() {
        this(.3, .3, .1);
    }

    public FluidElastics(double springTension, double plasticity, double yieldRatio) {
        this.springTension = springTension;
        this.plasticity = plasticity;
        this.yieldRatio = yieldRatio;
    }

    public void applyElastity(Fluid<T> fluid) {
        List<Particle.ParticleSpring> toRemove = new ArrayList<ParticleSpring>();
        for (T particle : fluid.getAllParticles()) {
            // apply spring forces

            toRemove.clear();
            for (Particle.ParticleSpring spring : particle.getSprings()) {

                LVect3d D = particle.getPosition().sub(spring.getOther().getPosition());
                double r = D.magnitude();

                if (r < .0001) {
                    continue;
                } else if(r > fluid.getInteractionRadius()) {
                    // break the spring if this is too long
                    toRemove.add(spring);
                    continue;
                }

                D.multv(1.0 / r);

                double L = spring.getRestLength();
                double h = fluid.getInteractionRadius();
                double dtSquared = fluid.getDt() * fluid.getDt();
                double dConstant = -.5 * dtSquared * springTension * (1 - L / h) * (L - r);
                D.multv(dConstant);

                particle.getPosition().subv(D);
                spring.getOther().getPosition().addv(D);
            }
            particle.getSprings().removeAll(toRemove);
        }
    }

    public void applyPlasticity(Fluid<T> fluid) {
        for (T particle : fluid.getAllParticles()) {

            for (T neighbor : fluid.getNeighbors(particle)) {
                // only make triangular pairs
                if (neighbor.getIndex() <= particle.getIndex()) {
                    continue;
                }

                double r = Math.sqrt(fluid.getDistanceSquared(particle, neighbor));
                if (r > fluid.getInteractionRadius()) {
                    continue;
                }

                ParticleSpring spring = particle.getSpring(neighbor);
                if (spring == null) {
                    spring = particle.addSpring(neighbor, fluid.getInteractionRadius());
//                    spring.setRestLength(r);
                }
                double L = spring.getRestLength();

                double d = yieldRatio * L;
                if (r > L + d) {
                    // stretch
                    double change = fluid.getDt() * plasticity * (r - L - d);
                    spring.setRestLength(L + change);
                } else if (r < L - d) {
                    // compress
                    double change = fluid.getDt() * plasticity * (L - d - r);
                    spring.setRestLength(Math.max(L - change, 0));
                }
            }

            List<ParticleSpring> toRemove = new ArrayList<ParticleSpring>();
            for (ParticleSpring spring : particle.getSprings()) {
                if (spring.getRestLength() > fluid.getInteractionRadius()) {
                    toRemove.add(spring);
                }
            }
            for (ParticleSpring spring : toRemove) {
                particle.removeSpring(spring);
            }
        }
    }
}
