/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fluids;

import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public interface Isofunction<V, T extends Particle> {
    public V isofunction(Fluid<T> fluid, LVect3d position);
}
