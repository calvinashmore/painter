/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetictest;

import genetic.Context;
import genetic.component.accessor.Accessor;

/**
 *
 * @author Calvin Ashmore
 */
public class Accessor1 extends Accessor {

    @Override
    public Class getReturnType() {
        return Integer.class;
    }

    public Object evaluate(Context context, Object[] inputs) {
        return (int)(Runtime.getRuntime().freeMemory());
    }

}
