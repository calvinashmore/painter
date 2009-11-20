/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.canvas;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Calvin Ashmore
 */
public class SubCanvas implements Canvas {

    private Canvas canvas;
    private Graphics2D graphics;

    public SubCanvas(Canvas canvas) {
        this.canvas = canvas;
        this.graphics = (Graphics2D) canvas.getGraphics().create();
    }

    public Graphics2D getGraphics() {
        return graphics;
    }

    public int getHeight() {
        return canvas.getHeight();
    }

    public int getWidth() {
        return canvas.getWidth();
    }

    public BufferedImage makeImage() {
        return canvas.makeImage();
    }
}
