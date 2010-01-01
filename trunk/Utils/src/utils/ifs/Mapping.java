/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.ifs;

import utils.linear.Linear;

/**
 *
 * @author Calvin Ashmore
 */
public interface Mapping<T extends Linear<T>> {

    /**
     * This applies the mapping on the argument point. The result is stored in dest and returned.
     * @param point
     * @param dest
     * @return
     */
    public T map(T point, T dest);
}
