/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.canvas;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 *
 * @author Calvin Ashmore
 */
public class CanvasImpl implements Canvas {

    private BufferedImage image;
    private int width;
    private int height;
    private Graphics2D graphics;

    public CanvasImpl() {
//        this.width = width;
//        this.height = height;
//
//        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Graphics2D getGraphics() {

//        if (graphics == null) {
//            graphics = image.createGraphics();
//        }
        return graphics;
    }

    public BufferedImage makeImage() {
        return image;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D newGraphics = newImage.createGraphics();
        if(image != null) {
            newGraphics.drawImage(image, 0, 0, null);
        }

        image = newImage;
        graphics = newGraphics;

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
}
