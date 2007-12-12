/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetictest;

import genetic.Foundation;
import genetic.TypeSystem;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class IntTypeSystem implements TypeSystem{

    public List<Class> allTypes() {
        return Collections.<Class>singletonList(Integer.TYPE);
    }

    public Object perturbValue(Object obj) {
        assert(obj.getClass() == Integer.TYPE);
        return obj;
    }

    public Object checkInvalid(Object obj) {
        return obj;
    }

    public Object createDefault(Class c) {
        assert(c == Integer.TYPE);
        return 0;
    }

    public Object createRandom(Class c) {
        assert(c == Integer.TYPE);
        return Foundation.getInstance().getBuilderRandom().nextInt();
    }

}
