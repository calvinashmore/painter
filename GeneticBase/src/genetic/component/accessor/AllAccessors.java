/*
 * AllAccessors.java
 * 
 * Created on Nov 3, 2007, 1:16:38 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.accessor;

import genetic.component.context.ContextModel;
import genetic.AllComponents;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class AllAccessors implements AllComponents<Accessor> {

    public List<Accessor> allInstances(ContextModel cm) {
        return new ArrayList<Accessor>();
    }

}
