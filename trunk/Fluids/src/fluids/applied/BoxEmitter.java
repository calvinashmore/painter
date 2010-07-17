/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.applied;

import fluids.Particle;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class BoxEmitter<T extends Particle> extends SimpleEmitter<T> {

    private LVect3d boxSize;
    private LVect3d velocity;
    private boolean oneShot;

    public BoxEmitter(int numberParticles, boolean oneShot, LVect3d velocity, LVect3d translation, LVect3d boxSize) {
        super(numberParticles, translation);
        this.oneShot = oneShot;
        this.velocity = velocity;
        this.boxSize = boxSize;
    }

    /**
     * creates a fresh, new particle of type T. Please don't modify it in any wierd way.
     * @return
     */
    abstract public T constructParticle();

    @Override
    public T createParticle() {
        T particle = constructParticle();
        particle.getPosition().x = 2 * (Math.random() - 1) * boxSize.x;
        particle.getPosition().y = 2 * (Math.random() - 1) * boxSize.y;
        particle.getPosition().z = 2 * (Math.random() - 1) * boxSize.z;
        particle.getVelocity().setTo(velocity);
        return particle;
    }

    @Override
    public boolean isOneShot() {
        return oneShot;
    }
}
