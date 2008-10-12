/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.linear;

/**
 *
 * @author Calvin Ashmore
 */
public interface FiniteLinear<T> extends Linear<T> {
    public int dimensions();
    public double get(int i);
}
