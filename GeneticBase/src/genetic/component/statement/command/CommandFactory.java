/*
 * CommandFactory.java
 * 
 * Created on Nov 3, 2007, 1:12:08 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.statement.command;

import genetic.util.BuildException;
import genetic.util.Factory;

/**
 *
 * @author Calvin Ashmore
 */
public class CommandFactory implements Factory<Command> {

    public CommandFactory() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Command shallowBuild(Class t) throws BuildException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
