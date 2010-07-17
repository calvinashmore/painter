/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class FluidElastics<T extends Particle> {

    abstract public void applyElastity(Fluid<T> fluid);

    abstract public void applyPlasticity(Fluid<T> fluid);
}
