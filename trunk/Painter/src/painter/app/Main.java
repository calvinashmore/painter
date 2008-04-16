/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package painter.app;

import genetic.BuildException;
import genetic.GeneticTopLevel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import painter.foundation.Foundation;
import painter.tools.canvas.Canvas;


/**
 *
 * @author Calvin Ashmore
 */
public class Main {
    public static void main(String args[]) throws BuildException {
        Foundation foundation = new Foundation();
        genetic.Foundation.setInstance(foundation);

        GeneticTopLevel program = foundation.getProgramBuilder().build();
        
        
        program.getContextModel().declareVariable("canvas", Canvas.class, true);
        program.createMethod("doStuff");
        
        System.out.println("Setting up...");
        program.setup();
        
        Canvas canvas = new Canvas(100, 100);
        program.getContext().setVariable("canvas", canvas);
        
        System.out.println("Calling method...");
        program.callMethod("doStuff");
        System.out.println("Done!");
        
        JFrame frame = new JFrame("Painter test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(canvas.makeImage())));
        frame.setVisible(true);
    }
}
