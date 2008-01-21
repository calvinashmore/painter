/*
 * Main.java
 * 
 * Created on Nov 1, 2007, 1:22:40 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app01;

import genetic.component.context.Context;
import genetic.component.command.Command;
import painter.PainterProgram;

/**
 *
 * @author Calvin Ashmore
 */
public class Main {
    
    static private class CircleCommand extends Command {

        public void execute(Context context, Object... parameters) {
            System.out.println("circle");
        }
    }
    
    static private class SquareCommand extends Command {

        public void execute(Context context, Object... parameters) {
            System.out.println("square");
        }
    }
    
    public static void main(String args[]) {
        
        PainterProgram program = new PainterProgram();
        
        program.createCommand("A", new CircleCommand());
        program.createCommand("B", new SquareCommand());
        program.initialize();
        
        System.out.println("Executing main... ");
        program.callMethod("main");
        
        System.out.println("Mutating...");
        
        program = (PainterProgram)program.mutateProgram();
        System.out.flush();
        System.out.println("Executing main... ");
        program.callMethod("main");
    }
}
