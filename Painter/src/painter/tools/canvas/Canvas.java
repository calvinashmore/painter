/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.canvas;

import java.awt.image.BufferedImage;
import java.nio.DoubleBuffer;
import utils.linear.Color;

/**
 *
 * @author Calvin Ashmore
 */
public class Canvas {

    private DoubleBuffer dataBuffer;
    private int width;
    private int height;
    private int channels;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.channels = 3;

        dataBuffer = DoubleBuffer.allocate(channels * width * height);
    }

    private Color getColor(int x, int y) {
        double data[] = new double[3];
        int offset = 3 * (x + width * y);
        dataBuffer.get(data, offset, 3);
        return new Color(data[0], data[1], data[2]);
    }

    public BufferedImage makeImage() {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                img.setRGB(x, y, getColor(x, y).toARGB());
            }
        }
        return img;
    }

    public void setColor(double x, double y, Color color) {
        //x = Math.max(0, Math.min(x/2+.5, 1));
        //y = Math.max(0, Math.min(y/2+.5, 1));

        int ix = (int) ((x) * width);
        int iy = (int) ((y) * height);
        if (ix < 0 || iy < 0 || ix >= width || iy >= height) {
            return;
        }
        
        double data[] = new double[3];
        int offset = 3 * (ix + width * iy);
        data[0] = color.r;
        data[1] = color.g;
        data[2] = color.b;
        
        dataBuffer.put(data, offset, 3);
    }
}
