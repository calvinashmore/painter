/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import genetic.TerminationException;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import painter.tools.canvas.Canvas;
import utils.linear.Color;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class SmudgeBrush implements Brush {

    private BrushPositionPolicy positionPolicy;
    private BrushSizePolicy sizePolicy;
    private LVect2d smudgeDirection;
    private double smudgeAmount;
    private boolean orient;

    public SmudgeBrush(LVect2d smudgeDirection, double smudgeAmount, BrushPositionPolicy positionPolicy, BrushSizePolicy sizePolicy) {
        this.positionPolicy = positionPolicy;
        this.sizePolicy = sizePolicy;
        this.smudgeDirection = smudgeDirection;
        this.smudgeAmount = smudgeAmount;
    }

    public void setOrient(boolean orient) {
        this.orient = orient;
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        if (Thread.interrupted()) {
            throw new TerminationException();
        }

        double smudgeX, smudgeY;

        if (orient) {
            double dmag = Math.sqrt(dx * dx + dy * dy);
            if (dmag < .001) {
                dx = 1;
                dy = 0;
            } else {
                dx /= dmag;
                dy /= dmag;
            }
            smudgeX = smudgeAmount * (smudgeDirection.x * dx - smudgeDirection.y * dy);
            smudgeY = smudgeAmount * (smudgeDirection.y * dx + smudgeDirection.x * dy);
        } else {
            smudgeX = smudgeDirection.x * smudgeAmount;
            smudgeY = smudgeDirection.y * smudgeAmount;
        }

        radius = Math.abs(radius);

        double width = radius * canvas.getHeight();
        //double height = radius * canvas.getHeight();

        x = positionPolicy.getX(x, y, canvas) + sizePolicy.getXOffset(width);
        y = positionPolicy.getY(x, y, canvas) + sizePolicy.getYOffset(width);

        Graphics2D graphics = (Graphics2D) canvas.getGraphics().create();

        // create the shape
        Shape clip = new Ellipse2D.Double(x, y, width, width);

        synchronized (graphics) {
            // clip
            graphics.setClip(clip);

            int offsetX = (int) (smudgeX);
            int offsetY = (int) (smudgeY);
            graphics.drawImage(canvas.makeImage(), offsetX, offsetY, null);
        }
    }
}
