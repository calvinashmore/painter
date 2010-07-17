/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.applied;

import fluids.Emitter;
import fluids.Particle;
import java.util.ArrayList;
import java.util.List;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class SimpleEmitter<T extends Particle> extends Emitter<T> {

    private LVect3d translation;
    private int numberParticles;

    public SimpleEmitter(int numberParticles) {
        this.numberParticles = numberParticles;
        this.translation = new LVect3d();
    }

    public SimpleEmitter(int numberParticles, LVect3d translation) {
        this.translation = translation;
        this.numberParticles = numberParticles;
    }

    public LVect3d getTranslation() {
        return translation;
    }

    public void setTranslation(LVect3d translation) {
        this.translation = translation;
    }

    abstract public T createParticle();

    @Override
    public List<T> emitParticles() {

        List<T> particles = new ArrayList<T>();

        for (int i = 0; i < numberParticles; i++) {
            T particle = createParticle();
            particle.getPosition().addv(translation);
            particles.add(particle);
        }
        return particles;
    }
}
