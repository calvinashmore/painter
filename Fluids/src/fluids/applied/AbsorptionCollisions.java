/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.applied;

import fluids.Collidable;
import fluids.Fluid;
import fluids.FluidCollisions;
import fluids.Particle;
import java.util.HashMap;
import java.util.Map;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class AbsorptionCollisions<T extends Particle> extends FluidCollisions<T> {

    private Map<T, Double> absorption = new HashMap<T, Double>();
    private double absorptionRate = .1;

    public double getAbsorptionRate() {
        return absorptionRate;
    }

    public void setAbsorptionRate(double absorptionRate) {
        this.absorptionRate = absorptionRate;
    }

    public double getAbsorption(T particle) {
        Double value = absorption.get(particle);
        if (value == null) {
            return 0;
        }
        return value;
    }

    @Override
    public void resolveCollisions(Fluid<T> fluid) {

        for (T particle : absorption.keySet()) {
            boolean isAbsorbed = false;
            for (Collidable collidable : getCollidables()) {
                if (collidable.getDistance(particle.getPosition())< .01) {
                    isAbsorbed = true;
                }
            }
            if (!isAbsorbed) {
                absorption.put(particle, 0.0);
            }
        }

        super.resolveCollisions(fluid);

        // afterward, make move all particles that have absorption closer to their starting point.
        for (Map.Entry<T, Double> entry : absorption.entrySet()) {
            T particle = entry.getKey();
            double particleAbsorption = entry.getValue();

            LVect3d position = particle.getPosition();
            LVect3d previousPosition = particle.getPreviousPosition();

            double newX = position.x * (1 - particleAbsorption) + previousPosition.x * (particleAbsorption);
            double newY = position.y * (1 - particleAbsorption) + previousPosition.y * (particleAbsorption);
            double newZ = position.z * (1 - particleAbsorption) + previousPosition.z * (particleAbsorption);

            particle.getPosition().setTo(new LVect3d(newX, newY, newZ));
        }
    }

    @Override
    protected void handleCollision(Collidable collidable, T particle) {

        double penetration = Math.abs(collidable.getDistance(particle.getPosition()));
        double particleAbsorption = getAbsorption(particle);
        particleAbsorption +=  absorptionRate;
        particleAbsorption = Math.min(particleAbsorption, 1);
        absorption.put(particle, particleAbsorption);

        super.handleCollision(collidable, particle);
    }
}
