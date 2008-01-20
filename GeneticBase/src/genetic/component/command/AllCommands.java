/*
 * AllCommands.java
 * 
 * Created on Nov 3, 2007, 1:11:58 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.command;

import genetic.component.context.ContextModel;
import genetic.AllComponents;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class AllCommands implements AllComponents<Command> {

    public List<Command> allInstances(ContextModel cm) {
        return new ArrayList<Command>();
    }


}
