/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.stroke;

import painter.tools.brush.Brush;
import painter.tools.canvas.Canvas;
import utils.linear.Color;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class BasicSegmentRenderer implements SegmentRenderer {

    public void renderSegment(Brush brush, double t, double sizeValue, Color colorValue, LVect2d positionValue, LVect2d difference, Canvas canvas) {
        brush.paint(positionValue.x, positionValue.y, difference.x, difference.y, sizeValue, colorValue, canvas);
    }
}
