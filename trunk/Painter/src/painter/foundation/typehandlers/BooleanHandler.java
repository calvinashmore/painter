/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package painter.foundation.typehandlers;

import java.util.Random;
import painter.foundation.TypeHandler;

/**
 *
 * @author Calvin Ashmore
 */
public class BooleanHandler implements TypeHandler<Boolean> {

    public Boolean perturbValue(Boolean obj) {
        return new Random().nextBoolean();
    }

    public Boolean checkInvalid(Boolean obj) {
        return obj;
    }

    public Boolean createDefault() {
        return false;
    }

    public Boolean createRandom() {
        return new Random().nextBoolean();
    }
}