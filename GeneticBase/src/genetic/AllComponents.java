/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

import genetic.component.context.ContextModel;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public interface AllComponents<T> {
    public List<T> allInstances(ContextModel cm);
}
