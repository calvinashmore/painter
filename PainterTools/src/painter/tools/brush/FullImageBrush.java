/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import genetic.TerminationException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import painter.tools.canvas.Canvas;
import painter.tools.misc.ColorTransformer;
import utils.linear.Color;

/**
 *
 * @author Calvin Ashmore
 */
public class FullImageBrush implements Brush {

    private BufferedImage image;
    private BrushPositionPolicy positionPolicy;
    private BufferedImageOp op = null;
    private double sizeOffset = 0;

    public FullImageBrush(BufferedImage image, BrushPositionPolicy positionPolicy) {
        this.image = image;
        this.positionPolicy = positionPolicy;
    }

    public void setOp(BufferedImageOp op) {
        this.op = op;
    }

    public void setSizeOffset(double sizeOffset) {
        this.sizeOffset = sizeOffset;
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        if (Thread.interrupted()) {
            throw new TerminationException();
        }

        Graphics2D graphics = (Graphics2D) canvas.getGraphics().create();

        radius = Math.abs(radius) + sizeOffset;
        if (radius == 0) {
            radius = 1;
        }

//        double width = 5 * radius * canvas.getHeight();
        //double height = radius * canvas.getHeight();

        x = positionPolicy.getX(x, y, canvas);
        y = positionPolicy.getY(x, y, canvas);

        final double[] colorHSB = color.hsbvals();
        LookupTable lookupTable = new ColorTransformer() {

            public void transformPixel(int[] src, int[] dst) {
                double[] hsbvals = toHSB(src);

                hsbvals[0] += colorHSB[0];
                hsbvals[1] = (hsbvals[1] + colorHSB[1]) / 2;
                hsbvals[2] = (hsbvals[2] + colorHSB[2]) / 2;
                toRGB(hsbvals, dst);
            }
        }.createLookup();
        image = new LookupOp(lookupTable, null).filter(image, null);

        double rotation = Math.atan2(dy, dx);
        if (Double.isNaN(rotation)) {
            rotation = 0;
        }

        synchronized (graphics) {
            graphics.translate(-image.getWidth() / 2, -image.getHeight() / 2);
            graphics.scale(radius, radius);
            graphics.rotate(rotation);
            graphics.translate(x, y);

            if (op != null) {
                graphics.drawImage(image, op, 0, 0);
            } else {
                graphics.drawImage(image, 0, 0, null);
            }
        }
    }
}
