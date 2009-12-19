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
public class PenBrush implements Brush {

    private BrushPositionPolicy positionPolicy;
    private BrushSizePolicy sizePolicy;

    public PenBrush(BrushPositionPolicy positionPolicy, BrushSizePolicy sizePolicy) {
        this.positionPolicy = positionPolicy;
        this.sizePolicy = sizePolicy;
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        if(Thread.interrupted()) {
            throw new TerminationException();
        }
        
        Graphics2D graphics = canvas.getGraphics();
        graphics = (Graphics2D) graphics.create();

        radius = Math.abs(radius);

        graphics.setColor(new java.awt.Color(color.toARGB()));
        graphics.setStroke(new BasicStroke((float) (radius * canvas.getWidth())));

        double width = radius * canvas.getHeight();
        //double height = radius * canvas.getHeight();

        double x1 = positionPolicy.getX(x, y, canvas) + sizePolicy.getXOffset(width);
        double y1 = positionPolicy.getY(x, y, canvas) + sizePolicy.getYOffset(width);
        double x2 = positionPolicy.getX(x + dx, y + dy, canvas) + sizePolicy.getYOffset(width);
        double y2 = positionPolicy.getY(x + dx, y + dy, canvas) + sizePolicy.getYOffset(width);

        graphics.drawLine(
                (int) (x1),
                (int) (y1),
                (int) (x2),
                (int) (y2));
    }
}
