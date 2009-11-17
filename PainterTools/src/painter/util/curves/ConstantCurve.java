/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.util.curves;

import utils.linear.Linear;

/**
 *
 * @author Calvin Ashmore
 */
public class ConstantCurve<T extends Linear<T>> implements Curve<T> {

    private T constantValue;

    public ConstantCurve(T constantValue) {
        this.constantValue = constantValue;
    }

    public T getValue(double t) {
        return constantValue;
    }
}
