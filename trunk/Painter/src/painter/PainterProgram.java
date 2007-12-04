/*
 * PainterProgram.java
 * 
 * Created on Nov 1, 2007, 1:25:47 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package painter;

import genetic.component.program.Program;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Calvin Ashmore
 */
public class PainterProgram extends Program {
    
    private Graphics2D graphics;
    private BufferedImage image;

    protected void setImage(BufferedImage image) {
        this.image = image;
        this.graphics = image.createGraphics();
    }
    
    public PainterProgram() {
    }

    public void initialize(BufferedImage image) {
        setImage(image);
        
        super.initialize();
        createMethod("main");
    }
    
    
}
