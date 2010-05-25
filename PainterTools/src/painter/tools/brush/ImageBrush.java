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
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import painter.tools.canvas.Canvas;
import painter.tools.misc.ColorTransformer;
import utils.linear.Color;

/**
 *
 * @author Calvin Ashmore
 */
public class ImageBrush implements Brush {

    private BufferedImage image;
    private BrushPositionPolicy positionPolicy;
    private BrushSizePolicy sizePolicy;
    private boolean round = true;
    private boolean scaleImage = false;
    private boolean stamp = false;
    private double offsetX = 0, offsetY = 0;
    private double scale = 1;
    private double rotation = 0;
    private BufferedImageOp op = null;

    public ImageBrush(BufferedImage image, BrushPositionPolicy positionPolicy, BrushSizePolicy sizePolicy) {
        this.image = image;
        this.positionPolicy = positionPolicy;
        this.sizePolicy = sizePolicy;
    }

    public void setRound(boolean round) {
        this.round = round;
    }

    public void setOp(BufferedImageOp op) {
        this.op = op;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public void setScaleImage(boolean scaleImage) {
        this.scaleImage = scaleImage;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setStamp(boolean stamp) {
        this.stamp = stamp;
    }

    public void setOffset(double offsetX, double offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        if (Thread.interrupted()) {
            throw new TerminationException();
        }

        Graphics2D graphics = (Graphics2D) canvas.getGraphics().create();

        radius = Math.abs(radius);

        double width = 5 * radius * canvas.getHeight();
        //double height = radius * canvas.getHeight();

        int stampX;
        int stampY;

        if (stamp) {
            stampX = (int) ((x + offsetX) * image.getWidth());
            stampY = (int) ((y + offsetY) * image.getWidth());
        } else {
            stampX = (int) (offsetX * image.getWidth());
            stampY = (int) (offsetY * image.getWidth());
        }

        x = positionPolicy.getX(x, y, canvas) + sizePolicy.getXOffset(width);
        y = positionPolicy.getY(x, y, canvas) + sizePolicy.getYOffset(width);

        int stampWidth = (int) width;
        int stampHeight = (int) width;

        stampX %= image.getWidth();
        stampY %= image.getHeight();
        if (stampX < 0) {
            stampX += image.getWidth();
        }
        if (stampY < 0) {
            stampY += image.getHeight();
        }

        stampWidth = Math.min(stampWidth + stampX, image.getWidth() - 1) - stampX;
        stampHeight = Math.min(stampHeight + stampY, image.getHeight() - 1) - stampY;

        if (stampWidth <= 0 || stampHeight <= 0) {
            return;
        }

        BufferedImage subimage = image.getSubimage(stampX, stampY, stampWidth, stampHeight);

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
        subimage = new LookupOp(lookupTable, null).filter(subimage, null);

        if (scaleImage) {
            graphics.scale(scale * stampWidth / image.getWidth(),
                    scale * stampHeight / image.getHeight());
        } else {
            graphics.scale(scale, scale);
        }
        graphics.rotate(rotation);
        graphics.translate(x, y);

        if (round) {
            // create the shape
            Shape clip = new Ellipse2D.Double(0, 0, width, width);
            // clip
            graphics.setClip(clip);
        }

        if (op != null) {
            graphics.drawImage(subimage, op, 0, 0);
        } else {
            graphics.drawImage(subimage, 0, 0, null);
        }
    }
}
