/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetictest;

import genetic.component.context.Context;
import genetic.component.command.Command;

/**
 *
 * @author Calvin Ashmore
 */
public class Command1 extends Command {

    @Override
    public void execute(Context context, Object... parameters) {
        System.out.println("Command1 called");
    }

}
