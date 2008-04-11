/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import painter.tools.canvas.Canvas;
import utils.linear.Color;

/**
 * A very simple brush tool
 * @author Calvin Ashmore
 */
public class Brush {

    public void paint(double x, double y, Color color, Canvas canvas) {

        x = x % 1.0;
        if (x < 0) {
            x += 1.0;
        }
        
        y = y % 1.0;
        if (y < 0) {
            y += 1.0;
        }

        canvas.setColor(x, y, color);
    }
}
