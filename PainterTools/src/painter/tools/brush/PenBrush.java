/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import painter.tools.canvas.Canvas;
import utils.linear.Color;

/**
 *
 * @author Calvin Ashmore
 */
public class PenBrush implements Brush {

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        Graphics2D graphics = canvas.getGraphics();
        graphics = (Graphics2D) graphics.create();

        radius = Math.abs(radius);

        graphics.setColor(new java.awt.Color(color.toARGB()));
        graphics.setStroke(new BasicStroke((float) (radius * canvas.getWidth())));

        graphics.drawLine(
                (int) (x * canvas.getWidth()),
                (int) (y * canvas.getHeight()),
                (int) ((x + dx) * canvas.getWidth()),
                (int) ((y + dy) * canvas.getHeight()));
    }
}
