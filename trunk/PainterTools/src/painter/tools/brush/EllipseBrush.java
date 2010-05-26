/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import genetic.TerminationException;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import painter.tools.canvas.Canvas;
import utils.linear.Color;

/**
 * A very simple brush tool
 * @author Calvin Ashmore
 */
public class EllipseBrush implements Brush {

    private double xRadius, yRadius, theta;
    private BrushPositionPolicy positionPolicy;
    private BrushSizePolicy sizePolicy;
    private boolean hollow;

    public EllipseBrush(BrushPositionPolicy positionPolicy, BrushSizePolicy sizePolicy, double xRadius, double yRadius, double theta, boolean hollow) {
        this.positionPolicy = positionPolicy;
        this.sizePolicy = sizePolicy;
        this.xRadius = xRadius;
        this.yRadius = yRadius;
        this.theta = theta;
        this.hollow = hollow;
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        if (Thread.interrupted()) {
            throw new TerminationException();
        }

        Graphics2D graphics = canvas.getGraphics();

        double width = Math.abs(radius * xRadius) * canvas.getHeight();
        double height = Math.abs(radius * yRadius) * canvas.getHeight();

        x = positionPolicy.getX(x, y, canvas) + sizePolicy.getXOffset(width);
        y = positionPolicy.getY(x, y, canvas) + sizePolicy.getYOffset(width);

        AffineTransform transform = graphics.getTransform();

        synchronized (graphics) {
            graphics.translate(x, y);
            graphics.rotate(theta);

            graphics.setColor(new java.awt.Color(color.toARGB()));
            if (hollow) {
                graphics.drawOval(
                        (int) (0),
                        (int) (0),
                        (int) (width),
                        (int) (height));
            } else {
                graphics.fillOval(
                        (int) (0),
                        (int) (0),
                        (int) (width),
                        (int) (height));
            }

            graphics.setTransform(transform);
        }
    }
}
