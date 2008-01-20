/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetictest;

import genetic.component.context.Context;
import genetic.component.accessor.Accessor;

/**
 *
 * @author Calvin Ashmore
 */
public class Accessor2 extends Accessor {

    @Override
    public Class getReturnType() {
        return Integer.TYPE;
    }

    public Object evaluate(Context context, Object[] inputs) {
        int input = (Integer)inputs[0];
        return input+1;
    }

    @Override
    public int getNumberInputs() {
        return 1;
    }

    @Override
    public String getInputName(int i) {
        return "accessorInput";
    }

    @Override
    public Class getInputType(int i) {
        return Integer.TYPE;
    }

}
