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
public class IntegerHandler implements TypeHandler<Integer> {

    public Integer perturbValue(Integer obj) {
        return new Random().nextInt(10) - 5 + obj;
    }

    public Integer checkInvalid(Integer obj) {
        return obj;
    }

    public Integer createDefault() {
        return 0;
    }

    public Integer createRandom() {
        return new Random().nextInt(20);
    }
}
