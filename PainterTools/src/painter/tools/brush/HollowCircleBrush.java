/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import java.awt.Graphics2D;
import painter.tools.canvas.Canvas;
import utils.linear.Color;

/**
 * A very simple brush tool
 * @author Calvin Ashmore
 */
public class HollowCircleBrush implements Brush {

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        Graphics2D graphics = canvas.getGraphics();

        radius = Math.abs(radius);

        graphics.setColor(new java.awt.Color(color.toARGB()));
        graphics.drawOval(
                (int) (x * canvas.getWidth()),
                (int) (y * canvas.getHeight()),
                (int) (radius * canvas.getWidth()),
                (int) (radius * canvas.getHeight()));
    }
}
