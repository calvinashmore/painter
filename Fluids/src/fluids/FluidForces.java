/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class FluidForces<T extends Particle> {

    abstract public void applyForces(Fluid<T> fluid);
}
