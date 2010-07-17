/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids;

import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class Emitter<T extends Particle> {

    private boolean fired = false;

    abstract public List<T> emitParticles();

    void addParticles(Fluid<T> fluid) {
        if (isOneShot() && hasFired()) {
            return;
        }

        fired = true;
        List<T> particles = emitParticles();
        for (T particle : particles) {
            fluid.addParticle(particle);
        }
    }

    public final boolean hasFired() {
        return fired;
    }

    /**
     * A one shot emitter emits all particles on its first turn and then stops.
     * @return
     */
    public boolean isOneShot() {
        return true;
    }
}
