/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.canvas;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import utils.linear.Color;

/**
 *
 * @author Calvin Ashmore
 */
public class Canvas {

    //private DoubleBuffer dataBuffer;
    private BufferedImage image;
    private int width;
    private int height;
    private Graphics2D graphics;
    //private int channels;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        //this.channels = 3;

        //dataBuffer = DoubleBuffer.allocate(channels * width * height);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Graphics2D getGraphics() {

        if (graphics == null) {
            graphics = image.createGraphics();
        }
        return graphics;
    }

    public BufferedImage makeImage() {
        return image;
    }
}
