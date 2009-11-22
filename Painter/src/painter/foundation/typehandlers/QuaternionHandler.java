/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.foundation.typehandlers;

import painter.foundation.TypeHandler;
import utils.linear.Quaternion;

/**
 *
 * @author Calvin Ashmore
 */
public class QuaternionHandler implements TypeHandler<Quaternion> {

    public Quaternion perturbValue(Quaternion obj) {
        if (Math.random() < .5) {
            // perturb multiplicatively
            double perturbation = 1 + Math.random() * .2 - .1;
            return new Quaternion(obj.mult(perturbation));
        } else {
            // perturb additively
            double perturbationU = Math.random() * .2 - .1;
            double perturbationI = Math.random() * .2 - .1;
            double perturbationJ = Math.random() * .2 - .1;
            double perturbationK = Math.random() * .2 - .1;
            return new Quaternion(
                    obj.u + perturbationU, obj.i + perturbationI,
                    obj.j + perturbationJ, obj.k + perturbationK);

        }
    }

    public Quaternion checkInvalid(Quaternion obj) {

        if (Double.isInfinite(obj.u) || Double.isNaN(obj.u) ||
                Double.isInfinite(obj.i) || Double.isNaN(obj.i) ||
                Double.isInfinite(obj.j) || Double.isNaN(obj.j) ||
                Double.isInfinite(obj.k) || Double.isNaN(obj.k)) {
            return new Quaternion();
        }
        return obj;
    }

    public Quaternion createDefault() {
        return new Quaternion();
    }

    public Quaternion createRandom() {
        // uses a square distribution
        return new Quaternion(
                Math.random() * 2 - 1, Math.random() * 2 - 1,
                Math.random() * 2 - 1, Math.random() * 2 - 1);
    }
}
