/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import painter.tools.canvas.Canvas;
import utils.linear.Color;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class SpatterBrush implements Brush {

    private Brush subBrush;
    private LVect2d[] spatterPoints;
    private double[] spatterRadii;
    private Color[] colorOffsets;
    private double colorMultiplier;
    boolean sizePoints = true;
    boolean orient = false;

    /**
     * dotSize is a fraction of the actual brush size.
     * @param numberDots
     * @param dotSize
     */
    public SpatterBrush(Brush subBrush, LVect2d[] spatterPoints, double pointRadius) {
        this.spatterPoints = spatterPoints;
        this.subBrush = subBrush;
        spatterRadii = new double[spatterPoints.length];
        for (int i = 0; i < spatterPoints.length; i++) {
            spatterRadii[i] = pointRadius;
        }
    }

    public SpatterBrush(Brush subBrush, LVect2d[] spatterPoints, double[] spatterRadii) {
        this.subBrush = subBrush;
        this.spatterPoints = spatterPoints;
        this.spatterRadii = spatterRadii;
    }

    public void setSizePoints(boolean sizePoints) {
        this.sizePoints = sizePoints;
    }

    public void setOrient(boolean orient) {
        this.orient = orient;
    }

    public void setColorOffsets(Color[] colorOffsets, double colorMultiplier) {
        this.colorOffsets = colorOffsets;
        this.colorMultiplier = colorMultiplier;
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        double dSize = Math.sqrt(dx * dx + dy * dy);

        if (dSize < .001) {
            // if there is no specified direction, use a default.
            dx = 1;
            dy = 0;
            dSize = 1;
        }

        // these define the tangent for the sweep
        double tx = dy / dSize;
        double ty = -dx / dSize;

        for (int i = 0; i < spatterPoints.length; i++) {
            LVect2d point = spatterPoints[i];
            double dotr = spatterRadii[i];

            if (sizePoints) {
                dotr = radius * dotr;
            }

            double dotx, doty;
            if (orient) {
                dotx = x + point.x * ty - point.y * tx;
                doty = y + point.x * tx + point.x * ty;
            } else {
                dotx = x + point.x * radius;
                doty = y + point.y * radius;
            }

            Color dotc = color;
            if (colorOffsets != null) {
                Color offset = colorOffsets[i];
                dotc = dotc.mult(1 - colorMultiplier).add(offset.mult(colorMultiplier));
            }

            subBrush.paint(dotx, doty, dx, dy, dotr, dotc, canvas);
        }
    }
}
