/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package painter.foundation.typehandlers;

import painter.foundation.TypeHandler;
import utils.linear.Color;

/**
 *
 * @author Calvin Ashmore
 */
public class ColorHandler implements TypeHandler<Color> {

    public Color perturbValue(Color obj) {
        if (Math.random() < .5) {
            // perturb multiplicatively
            double perturbation = 1 + Math.random() * .2 - .1;
            return new Color(obj.mult(perturbation));
        } else {
            // perturb additively
            double perturbationX = Math.random() * .2 - .1;
            double perturbationY = Math.random() * .2 - .1;
            double perturbationZ = Math.random() * .2 - .1;
            return new Color(
                    obj.r + perturbationX,
                    obj.g + perturbationY,
                    obj.b + perturbationZ);

        }
    }

    public Color checkInvalid(Color obj) {

        if (    Double.isInfinite(obj.r) || Double.isNaN(obj.r) ||
                Double.isInfinite(obj.g) || Double.isNaN(obj.g) ||
                Double.isInfinite(obj.b) || Double.isNaN(obj.b)) {
            return new Color();
        }
        return obj;
    }

    public Color createDefault() {
        return new Color();
    }

    public Color createRandom() {
        // uses a square distribution
        return new Color(Math.random(), Math.random(), Math.random());
    }
}