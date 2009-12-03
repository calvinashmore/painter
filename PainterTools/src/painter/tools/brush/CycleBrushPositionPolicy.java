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
public class CycleBrushPositionPolicy implements BrushPositionPolicy {

    private BrushPositionPolicy other;

    public CycleBrushPositionPolicy(BrushPositionPolicy other) {
        this.other = other;
    }

    public double getX(double x, double y, Canvas canvas) {
        double newX = other.getX(x, y, canvas);
        double width = canvas.getWidth();

        newX = newX % width;
        if (newX < 0) {
            newX += width;
        }

        return newX;
    }

    public double getY(double x, double y, Canvas canvas) {
        double newY = other.getY(x, y, canvas);
        double height = canvas.getHeight();

        newY = newY % height;
        if (newY < 0) {
            newY += height;
        }

        return newY;
    }
}
