/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils.curves.derahm;

import utils.linear.Linear;

/**
 *
 * @author Calvin
 */
public interface DeRahmFunction<T extends Linear<T>> {
    public T f0(T x);
    public T f1(T x);

    public T zero();
}
