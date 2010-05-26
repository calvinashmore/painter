/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import genetic.TerminationException;
import java.awt.Graphics2D;
import painter.tools.canvas.Canvas;
import utils.linear.Color;

/**
 * A very simple brush tool
 * @author Calvin Ashmore
 */
public class HollowArcBrush implements Brush {

    private BrushPositionPolicy positionPolicy;
    private BrushSizePolicy sizePolicy;
    private double startAngle;
    private double endAngle;

    public HollowArcBrush(BrushPositionPolicy positionPolicy, BrushSizePolicy sizePolicy) {
        this.positionPolicy = positionPolicy;
        this.sizePolicy = sizePolicy;
    }

    public void setAngles(double startAngle, double endAngle) {
        this.startAngle = startAngle;
        this.endAngle = endAngle;
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        if (Thread.interrupted()) {
            throw new TerminationException();
        }

        Graphics2D graphics = canvas.getGraphics();

        radius = Math.abs(radius);

        double width = radius * canvas.getHeight();
        //double height = radius * canvas.getHeight();

        x = positionPolicy.getX(x, y, canvas) + sizePolicy.getXOffset(width);
        y = positionPolicy.getY(x, y, canvas) + sizePolicy.getYOffset(width);

        int iStartAngle = (int) (360 * startAngle);
        int iEndAngle = (int) (360 * endAngle);

        synchronized (graphics) {
            graphics.setColor(new java.awt.Color(color.toARGB()));
            graphics.drawArc(
                    (int) (x),
                    (int) (y),
                    (int) (width),
                    (int) (width),
                    iStartAngle,
                    iEndAngle);
        }
    }
}
