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
 * A very simple brush tool
 * @author Calvin Ashmore
 */
public class RubberStampBrush implements Brush {

    private BrushPositionPolicy positionPolicy;
    private BrushSizePolicy sizePolicy;
    private double offsetX, offsetY;
    private BufferedImageOp op = null;

    public RubberStampBrush(BrushPositionPolicy positionPolicy, BrushSizePolicy sizePolicy, double offsetX, double offsetY) {
        this.positionPolicy = positionPolicy;
        this.sizePolicy = sizePolicy;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public void setOp(BufferedImageOp op) {
        this.op = op;
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        if (Thread.interrupted()) {
            throw new TerminationException();
        }

        Graphics2D graphics = (Graphics2D) canvas.getGraphics().create();

        radius = Math.abs(radius);

        double width = radius * canvas.getHeight();
        //double height = radius * canvas.getHeight();

        x = positionPolicy.getX(x, y, canvas) + sizePolicy.getXOffset(width);
        y = positionPolicy.getY(x, y, canvas) + sizePolicy.getYOffset(width);

        int stampX = (int) (positionPolicy.getX(x + offsetX, y + offsetY, canvas) + sizePolicy.getXOffset(width));
        int stampY = (int) (positionPolicy.getY(x + offsetX, y + offsetY, canvas) + sizePolicy.getYOffset(width));
        int stampWidth = (int) width;
        int stampHeight = (int) width;

        stampX %= canvas.getWidth();
        stampY %= canvas.getHeight();
        if (stampX < 0) {
            stampX += canvas.getWidth();
        }
        if (stampY < 0) {
            stampY += canvas.getHeight();
        }

        stampWidth = Math.min(stampWidth + stampX, canvas.getWidth() - 1) - stampX;
        stampHeight = Math.min(stampHeight + stampY, canvas.getHeight() - 1) - stampY;

        if (stampWidth <= 0 || stampHeight <= 0) {
            return;
        }

        BufferedImage subimage = canvas.makeImage().getSubimage(stampX, stampY, stampWidth, stampHeight);

        // create the shape
        Shape clip = new Ellipse2D.Double(x, y, width, width);

        // clip
        graphics.setClip(clip);

        if (op != null) {
            graphics.drawImage(subimage, op, (int) x, (int) y);
        } else {
            graphics.drawImage(subimage, (int) x, (int) y, null);
        }

//        graphics.setColor(new java.awt.Color(color.toARGB()));
//        graphics.fillOval(
//                (int) (x),
//                (int) (y),
//                (int) (width),
//                (int) (width));
    }
}
