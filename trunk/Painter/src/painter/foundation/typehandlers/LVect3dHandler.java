/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.foundation.typehandlers;

import painter.foundation.TypeHandler;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class LVect3dHandler implements TypeHandler<LVect3d> {

    public LVect3d perturbValue(LVect3d obj) {
        if (Math.random() < .5) {
            // perturb multiplicatively
            double perturbation = 1 + Math.random() * .2 - .1;
            return new LVect3d(obj.mult(perturbation));
        } else {
            // perturb additively
            double perturbationX = Math.random() * .2 - .1;
            double perturbationY = Math.random() * .2 - .1;
            double perturbationZ = Math.random() * .2 - .1;
            return new LVect3d(obj.x + perturbationX, obj.y + perturbationY, obj.z + perturbationZ);

        }
    }

    public LVect3d checkInvalid(LVect3d obj) {

        if (Double.isInfinite(obj.x) || Double.isNaN(obj.x) ||
                Double.isInfinite(obj.y) || Double.isNaN(obj.y) ||
                Double.isInfinite(obj.z) || Double.isNaN(obj.z)) {
            return new LVect3d();
        }
        return obj;
    }

    public LVect3d createDefault() {
        return new LVect3d();
    }

    public LVect3d createRandom() {
        // uses a square distribution
        return new LVect3d(Math.random() * 2 - 1, Math.random() * 2 - 1, Math.random() * 2 - 1);
    }
}
