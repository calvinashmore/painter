/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.util;

import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public interface TypeSystem {
    public List<Class> allTypes();
    public Object perturbValue(Object obj);
    public Object checkInvalid(Object obj);
    public Object createDefault(Class c);
}
