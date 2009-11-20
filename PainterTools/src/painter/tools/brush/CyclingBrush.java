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
public class CyclingBrush implements Brush {

    private Brush brush;

    public CyclingBrush(Brush brush) {
        this.brush = brush;
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        x = x % 1.0;
        if (x < 0) {
            x += 1.0;
        }

        y = y % 1.0;
        if (y < 0) {
            y += 1.0;
        }

        brush.paint(x, y, dx, dy, radius, color, canvas);
    }
}
