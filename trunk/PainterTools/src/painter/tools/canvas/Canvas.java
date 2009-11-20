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
public interface Canvas {

    Graphics2D getGraphics();

    int getHeight();

    int getWidth();

    BufferedImage makeImage();

}
