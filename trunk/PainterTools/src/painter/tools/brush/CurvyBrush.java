/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package painter.tools.brush;

import genetic.TerminationException;
import java.awt.Graphics2D;
import java.awt.Shape;
import painter.tools.canvas.Canvas;
import utils.linear.Color;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class CurvyBrush implements  Brush {

    private BrushPositionPolicy positionPolicy;
    private BrushSizePolicy sizePolicy;
    private LVect2d v1, v2, v3, v4;


    public CurvyBrush(BrushPositionPolicy positionPolicy, BrushSizePolicy sizePolicy, LVect2d v1, LVect2d v2, LVect2d v3, LVect2d v4) {
        this.positionPolicy = positionPolicy;
        this.sizePolicy = sizePolicy;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        if(Thread.interrupted()) {
            throw new TerminationException();
        }

        Graphics2D graphics = canvas.getGraphics();

        radius = Math.abs(radius);

        double width = radius * canvas.getHeight();
        //double height = radius * canvas.getHeight();

        x = positionPolicy.getX(x, y, canvas) + sizePolicy.getXOffset(width);
        y = positionPolicy.getY(x, y, canvas) + sizePolicy.getYOffset(width);


        Shape shape = new java.awt.geom.CubicCurve2D.Double(
                x+v1.x*width, y+v1.y*width,
                x+v2.x*width, y+v2.y*width,
                x+v3.x*width, y+v3.y*width,
                x+v4.x*width, y+v4.y*width);

        synchronized(graphics) {
        graphics.setColor(new java.awt.Color(color.toARGB()));
        graphics.draw(shape);
        }
    }
}
