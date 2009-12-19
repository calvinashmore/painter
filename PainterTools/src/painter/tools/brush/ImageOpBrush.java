/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import genetic.TerminationException;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import painter.tools.canvas.Canvas;
import utils.linear.Color;

/**
 *
 * @author Calvin Ashmore
 */
public class ImageOpBrush implements Brush {

    private BrushPositionPolicy positionPolicy;
    private BrushSizePolicy sizePolicy;
    private BufferedImageOp op;

    public ImageOpBrush(BufferedImageOp op, BrushPositionPolicy positionPolicy, BrushSizePolicy sizePolicy) {
        this.positionPolicy = positionPolicy;
        this.sizePolicy = sizePolicy;
        this.op = op;
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        if(Thread.interrupted()) {
            throw new TerminationException();
        }

        Graphics2D graphics = (Graphics2D) canvas.getGraphics().create();

        radius = Math.abs(radius);

        double width = radius * canvas.getHeight();
        //double height = radius * canvas.getHeight();

        x = positionPolicy.getX(x, y, canvas) + sizePolicy.getXOffset(width);
        y = positionPolicy.getY(x, y, canvas) + sizePolicy.getYOffset(width);

        // create the shape
        Shape clip = new Ellipse2D.Double(x, y, width, width);

        // clip
        graphics.setClip(clip);

        // apply the operation
        BufferedImage result = op.filter(canvas.makeImage(), null);

        // draw it using the clipped graphics
        graphics.drawImage(result, 0, 0, null);
    }
}
