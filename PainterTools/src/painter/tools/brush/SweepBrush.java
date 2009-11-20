/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import painter.tools.canvas.Canvas;
import utils.linear.Color;

/**
 *
 * @author Calvin Ashmore
 */
public class SweepBrush implements Brush {

    private int numberDots;
    private double dotSize;
    private Brush subBrush;

    /**
     * dotSize is a fraction of the actual brush size.
     * @param numberDots
     * @param dotSize
     */
    public SweepBrush(int numberDots, double dotSize, Brush subBrush) {
        this.numberDots = numberDots;
        this.dotSize = dotSize;
        this.subBrush = subBrush;
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        double dSize = Math.sqrt(dx * dx + dy * dy);

        if (dSize < .001) {
            // if there is no specified direction, use a default.
            dx = 1;
            dy = 0;
        }

        // these define the tangent for the sweep
        double tx = dy / dSize;
        double ty = -dx / dSize;

        for (int i = 0; i < numberDots; i++) {
            double t = 2 * (double) i / (numberDots - 1) - 1;
            double dotx = t * tx * radius;
            double doty = t * ty * radius;

            double dotr = radius * dotSize / numberDots;

            subBrush.paint(dotx, doty, dx, dy, dotr, color, canvas);
        }
    }
}
