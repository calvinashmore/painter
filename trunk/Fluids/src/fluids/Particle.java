/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids;

import java.util.ArrayList;
import java.util.List;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class Particle {

    LVect3d previousPosition = new LVect3d();
    private LVect3d position = new LVect3d();
    private LVect3d velocity = new LVect3d();
    int index;
    private List<ParticleSpring> springs = new ArrayList<ParticleSpring>();

    public int getIndex() {
        return index;
    }

    public double distanceTo(LVect3d pos) {
        return position.sub(pos).magnitude();
    }

    public double distance(Particle p) {
        return distanceTo(p.position);
    }

    public LVect3d getPosition() {
        return position;
    }

    public LVect3d getVelocity() {
        return velocity;
    }
}
