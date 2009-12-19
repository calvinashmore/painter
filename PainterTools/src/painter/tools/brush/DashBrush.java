/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import genetic.TerminationException;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import painter.tools.canvas.Canvas;
import utils.linear.Color;

/**
 *
 * @author Calvin Ashmore
 */
public class DashBrush implements Brush {

    private BrushPositionPolicy positionPolicy;
    private BrushSizePolicy sizePolicy;
    private double angle;
    private boolean orient;

    public DashBrush(double angle, BrushPositionPolicy positionPolicy, BrushSizePolicy sizePolicy) {
        this.positionPolicy = positionPolicy;
        this.sizePolicy = sizePolicy;
        this.angle = angle;
    }

    public void setOrient(boolean orient) {
        this.orient = orient;
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        if(Thread.interrupted()) {
            throw new TerminationException();
        }
        
        Graphics2D graphics = canvas.getGraphics();
        graphics = (Graphics2D) graphics.create();

        radius = Math.abs(radius);

        graphics.setColor(new java.awt.Color(color.toARGB()));
        graphics.setStroke(new BasicStroke(1));

        double width = radius * canvas.getHeight();
        //double height = radius * canvas.getHeight();

        x = positionPolicy.getX(x, y, canvas) + sizePolicy.getXOffset(width);
        y = positionPolicy.getY(x, y, canvas) + sizePolicy.getYOffset(width);

        double vx = width * Math.cos(Math.PI * angle);
        double vy = width * Math.sin(Math.PI * angle);

        double dmag = Math.sqrt(dx * dx + dy * dy);
        if (dmag < .001) {
            dx = 1;
            dy = 0;
        } else {
            dx /= dmag;
            dy /= dmag;
        }

        double x1, x2, y1, y2;
        if (orient) {
            vx = vx * dx - vy * dy;
            vy = vx * dy + vy * dx;
        }

        x1 = x + vx;
        x2 = x - vx;
        y1 = y + vy;
        y2 = y - vy;

        graphics.drawLine(
                (int) (x1),
                (int) (y1),
                (int) (x2),
                (int) (y2));
    }
}
