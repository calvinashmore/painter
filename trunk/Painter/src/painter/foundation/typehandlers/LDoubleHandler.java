/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package painter.foundation.typehandlers;

import painter.foundation.TypeHandler;
import utils.linear.LDouble;

/**
 *
 * @author Calvin Ashmore
 */
public class LDoubleHandler implements TypeHandler<LDouble> {

    public LDouble perturbValue(LDouble obj) {
        if (Math.random() < .5) {
            // perturb multiplicatively
            double perturbation = 1 + Math.random() * .2 - .1;
            return new LDouble(obj.val * perturbation);
        } else {
            // perturb additively
            double perturbation = Math.random() * .2 - .1;
            return new LDouble(obj.val + perturbation);

        }
    }

    public LDouble checkInvalid(LDouble obj) {
        if(Double.isInfinite(obj.val) || Double.isNaN(obj.val))
            return new LDouble(0);
        return obj;
    }

    public LDouble createDefault() {
        return new LDouble(0);
    }

    public LDouble createRandom() {
        return new LDouble(Math.random()*2-1);
    }

}
