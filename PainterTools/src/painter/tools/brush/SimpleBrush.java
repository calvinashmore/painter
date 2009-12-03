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
public class SimpleBrush implements Brush {

    private double radiusMultiplier = 1;
    private BrushPositionPolicy positionPolicy;
    private BrushSizePolicy sizePolicy;

    public SimpleBrush(BrushPositionPolicy positionPolicy, BrushSizePolicy sizePolicy) {
        this.positionPolicy = positionPolicy;
        this.sizePolicy = sizePolicy;
    }

    public SimpleBrush(BrushPositionPolicy positionPolicy, BrushSizePolicy sizePolicy, double radiusMultiplier) {
        this.positionPolicy = positionPolicy;
        this.sizePolicy = sizePolicy;
        this.radiusMultiplier = radiusMultiplier;
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        Graphics2D graphics = canvas.getGraphics();

        radius = Math.abs(radius * radiusMultiplier);
        
        double width = radius * canvas.getHeight();
        //double height = radius * canvas.getHeight();

        x = positionPolicy.getX(x, y, canvas) + sizePolicy.getXOffset(width);
        y = positionPolicy.getY(x, y, canvas) + sizePolicy.getYOffset(width);

        graphics.setColor(new java.awt.Color(color.toARGB()));
        graphics.fillOval(
                (int) (x),
                (int) (y),
                (int) (width),
                (int) (width));
    }
}
