/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.method;

import genetic.GeneticTopLevel;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class MethodBuilderImpl implements MethodBuilder {

    public Method build(String name, GeneticTopLevel parent, List<Class> argumentTypes) {
        return new Method(name, parent, argumentTypes);
    }

}
