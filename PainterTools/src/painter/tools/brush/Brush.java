/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import painter.tools.canvas.Canvas;
import utils.linear.Color;

/**
 *
 * @author Calvin Ashmore
 */
public interface Brush {

    void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas);
}
