/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetictest;

import genetic.Context;
import genetic.component.expression.function.ExpressionFunction;

/**
 *
 * @author Calvin Ashmore
 */
public class IntAdditionFunction extends ExpressionFunction {

    @Override
    public Object evaluate(Context context, Object[] inputs) {
        int in1 = (Integer)inputs[0];
        int in2 = (Integer)inputs[1];
        return in1+in2;
    }

    @Override
    public int getNumberInputs() {
        return 2;
    }

    @Override
    public Class getInputType(int i) {
        return Integer.TYPE;
    }

    public Class getReturnType() {
        return Integer.TYPE;
    }

}
