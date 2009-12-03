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
public interface BrushPositionPolicy {
    double getX(double x, double y, Canvas canvas);
    double getY(double x, double y, Canvas canvas);
}
