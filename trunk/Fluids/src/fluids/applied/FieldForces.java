/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.applied;

import fluids.Fluid;
import fluids.FluidForces;
import fluids.Particle;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class FieldForces<T extends Particle> extends FluidForces<T> {

    private LVect3d forceDirection;

    public FieldForces(LVect3d forceDirection) {
        this.forceDirection = forceDirection;
    }

    @Override
    public void applyForces(Fluid<T> fluid) {
        LVect3d forceStep = forceDirection.mult(fluid.getDt());
        for (Particle particle : fluid.getAllParticles()) {
            particle.getVelocity().addv(forceStep);
        }
    }
}
