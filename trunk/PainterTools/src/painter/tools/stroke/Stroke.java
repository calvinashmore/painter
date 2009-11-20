/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.stroke;

import painter.tools.brush.Brush;
import painter.tools.canvas.Canvas;
import painter.util.curves.Curve;
import utils.linear.Color;
import utils.linear.LDouble;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public interface Stroke {

    public void render(Brush brush, Curve<LDouble> size, Curve<LVect2d> position, Curve<Color> color, Canvas canvas, SegmentRenderer renderer);
}
