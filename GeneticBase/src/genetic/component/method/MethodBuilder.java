/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.method;

import genetic.Builder;
import genetic.GeneticTopLevel;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public interface MethodBuilder extends Builder<Method> {
    public Method build(String name, GeneticTopLevel parent, List<Class> argumentTypes);
}
