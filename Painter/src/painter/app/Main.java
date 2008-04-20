/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package painter.app;

import genetic.BuildException;
import genetic.GeneticTopLevel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    
    public static void main(String args[]) {
        
        JFrame frame = new JFrame("Painter test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DemoApplet applet = new DemoApplet();
        
        frame.getContentPane().add(applet);
        applet.init();
        applet.start();
        
        frame.pack();
        frame.setVisible(true);
    }
    
    
    /*public static void main(String args[]) throws BuildException {
        Foundation foundation = new Foundation();
        genetic.Foundation.setInstance(foundation);

        Canvas canvas = makeCanvas();
        
        JFrame frame = new JFrame("Painter test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JLabel frameLabel = new JLabel(new ImageIcon(canvas.makeImage()));
        frame.add(frameLabel);
        frame.pack();
        frame.setVisible(true);
        
        frameLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    Canvas canvas = makeCanvas();
                    frameLabel.setIcon(new ImageIcon(canvas.makeImage()));
                } catch (BuildException ex) {
                    ex.printStackTrace();
                    //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
    
    private static Canvas makeCanvas() throws BuildException {
        Foundation foundation = (Foundation) genetic.Foundation.getInstance();
        GeneticTopLevel program = foundation.getProgramBuilder().build();
        
        program.getContextModel().declareVariable("canvas", Canvas.class, true);
        program.createMethod("doStuff");
        
        System.out.println("Setting up...");
        program.setup();
        
        Canvas canvas = new Canvas(500, 500);
        program.getContext().setVariable("canvas", canvas);
        
        System.out.println("Calling method...");
        program.callMethod("doStuff");
        System.out.println("Done!");
        
        return canvas;
    }*/
}
