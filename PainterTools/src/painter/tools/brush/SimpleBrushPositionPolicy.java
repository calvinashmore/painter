/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import painter.tools.canvas.Canvas;

/**
 *
 * @author Calvin Ashmore
 */
public class SimpleBrushPositionPolicy implements BrushPositionPolicy {

    private double xAnchor;
    private double yAnchor;
    private double xDirection;
    private double yDirection;

    /**
     * Both xAnchor and yAnchor will typically be 0, -1, or 1. 
     * The direction arguments will be 1 to have a window of 1 unit, or .5 to have a window of 2 units.
     * The sign on direction will be whichever way the view is pointing.
     * @param xAnchor
     * @param yAnchor
     * @param xDirection
     * @param yDirection
     */
    public SimpleBrushPositionPolicy(double xAnchor, double yAnchor, double xDirection, double yDirection) {
        this.xAnchor = xAnchor;
        this.yAnchor = yAnchor;
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    public double getX(double x, double y, Canvas canvas) {
        return (xAnchor + x * xDirection) * canvas.getWidth();
    }

    public double getY(double x, double y, Canvas canvas) {
        return (yAnchor + x * yDirection) * canvas.getHeight();
    }
}
