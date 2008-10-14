/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.linear.matrix;

import utils.linear.Complex;
import utils.linear.FiniteLinear;

/**
 *
 * @author Calvin Ashmore
 */
public interface FiniteMatrix<T, U extends FiniteLinear<U>> extends Matrix<T, U>, FiniteLinear<T>{
    public double get(int i, int j);
    //public Pair<double[], U[]> eigenDecomposition();
    public Complex[] eigenvalues(Complex[] target);
    
    /**
     * This SHOULD be a U where the members are Complexes instead of doubles,
     * but that is not possible given the current implementation.
     * @return
     */
    public Complex[] eigenvector(Complex eigenvalue);
}
