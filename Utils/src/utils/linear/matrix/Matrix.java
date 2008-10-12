/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils.linear.matrix;

import utils.linear.Linear;

/**
 * 
 * @author Calvin Ashmore
 * @param <T> The Matrix type itself.
 * @param <U> The Vector type that the matrix operates on.
 */
public interface Matrix<T, U extends Linear<U>> extends Linear<T>{
    public T getIdentity();
    public U apply(U x);
    public T apply(T matrix);
    
    public double determinant();
    public T invert();
}
