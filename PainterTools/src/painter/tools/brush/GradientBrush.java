/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import genetic.TerminationException;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import painter.tools.canvas.Canvas;
import utils.linear.Color;

/**
 * A very simple brush tool
 * @author Calvin Ashmore
 */
abstract public class GradientBrush implements Brush {

    private double radiusMultiplier = 1;
    private BrushPositionPolicy positionPolicy;
    private BrushSizePolicy sizePolicy;
    private double angle;

    public GradientBrush(BrushPositionPolicy positionPolicy, BrushSizePolicy sizePolicy) {
        this.positionPolicy = positionPolicy;
        this.sizePolicy = sizePolicy;
    }

    public GradientBrush(BrushPositionPolicy positionPolicy, BrushSizePolicy sizePolicy, double radiusMultiplier) {
        this.positionPolicy = positionPolicy;
        this.sizePolicy = sizePolicy;
        this.radiusMultiplier = radiusMultiplier;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    abstract public Color getColor2(Color baseColor);

    public void paint(double x, double y, double dx, double dy, double radius, Color color1, Canvas canvas) {

        if (Thread.interrupted()) {
            throw new TerminationException();
        }

        Graphics2D graphics = canvas.getGraphics();

        radius = Math.abs(radius * radiusMultiplier);

        double width = radius * canvas.getHeight();
        //double height = radius * canvas.getHeight();

        x = positionPolicy.getX(x, y, canvas) + sizePolicy.getXOffset(width);
        y = positionPolicy.getY(x, y, canvas) + sizePolicy.getYOffset(width);

        float x1, x2, y1, y2;

        x1 = (float) (x + .5 * width * (1 + Math.cos(angle * Math.PI)));
        y1 = (float) (y + .5 * width * (1 + Math.sin(angle * Math.PI)));
        x2 = (float) (x + .5 * width * (1 - Math.cos(angle * Math.PI)));
        y2 = (float) (y + .5 * width * (1 - Math.sin(angle * Math.PI)));

        Color color2 = getColor2(color1);
        GradientPaint paint = new GradientPaint(x1, y1, new java.awt.Color(color1.toARGB()), x2, y2, new java.awt.Color(color2.toARGB()), true);

        synchronized (graphics) {
            graphics.setPaint(paint);
            graphics.fillOval(
                    (int) (x),
                    (int) (y),
                    (int) (width),
                    (int) (width));
        }
    }
}
