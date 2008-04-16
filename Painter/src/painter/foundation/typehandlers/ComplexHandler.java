/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.foundation.typehandlers;

import painter.foundation.TypeHandler;
import utils.linear.Complex;

/**
 *
 * @author Calvin Ashmore
 */
public class ComplexHandler implements TypeHandler<Complex> {

    public Complex perturbValue(Complex obj) {
        if (Math.random() < .5) {
            // perturb multiplicatively
            double perturbation = 1 + Math.random() * .2 - .1;
            return new Complex(obj.mult(perturbation));
        } else {
            // perturb additively
            double perturbationX = Math.random() * .2 - .1;
            double perturbationY = Math.random() * .2 - .1;
            return new Complex(obj.x + perturbationX, obj.y + perturbationY);

        }
    }

    public Complex checkInvalid(Complex obj) {

        if (Double.isInfinite(obj.x) || Double.isNaN(obj.x) ||
                Double.isInfinite(obj.y) || Double.isNaN(obj.y)) {
            return new Complex();
        }
        return obj;
    }

    public Complex createDefault() {
        return new Complex();
    }

    public Complex createRandom() {
        // uses a square distribution
        return new Complex(Math.random() * 2 - 1, Math.random() * 2 - 1);
    }
}
