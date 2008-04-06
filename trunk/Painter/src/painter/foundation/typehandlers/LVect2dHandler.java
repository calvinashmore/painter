/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.foundation.typehandlers;

import painter.foundation.TypeHandler;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class LVect2dHandler implements TypeHandler<LVect2d> {

    public LVect2d perturbValue(LVect2d obj) {
        if (Math.random() < .5) {
            // perturb multiplicatively
            double perturbation = 1 + Math.random() * .2 - .1;
            return new LVect2d(obj.mult(perturbation));
        } else {
            // perturb additively
            double perturbationX = Math.random() * .2 - .1;
            double perturbationY = Math.random() * .2 - .1;
            return new LVect2d(obj.x + perturbationX, obj.y + perturbationY);

        }
    }

    public LVect2d checkInvalid(LVect2d obj) {

        if (Double.isInfinite(obj.x) || Double.isNaN(obj.x) ||
                Double.isInfinite(obj.y) || Double.isNaN(obj.y)) {
            return new LVect2d();
        }
        return obj;
    }

    public LVect2d createDefault() {
        return new LVect2d();
    }

    public LVect2d createRandom() {
        // uses a square distribution
        return new LVect2d(Math.random() * 2 - 1, Math.random() * 2 - 1);
    }
}
