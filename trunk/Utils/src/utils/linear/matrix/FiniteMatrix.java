/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.linear.matrix;

import utils.Pair;
import utils.linear.FiniteLinear;

/**
 *
 * @author Calvin Ashmore
 */
public interface FiniteMatrix<T, U extends FiniteLinear<U>> extends Matrix<T, U>, FiniteLinear<T>{
    public double get(int i, int j);
    public Pair<double[], U[]> eigenDecomposition();
}
