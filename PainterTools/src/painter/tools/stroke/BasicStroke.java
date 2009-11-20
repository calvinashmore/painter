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
public class BasicStroke implements Stroke {

    private static int baseSteps = 1000;
    private double stepsMultiplier = 1;

    public static void setBaseSteps(int baseSteps) {
        BasicStroke.baseSteps = baseSteps;
    }

    public void render(Brush brush, Curve<LDouble> size, Curve<LVect2d> position, Curve<Color> color, Canvas canvas, SegmentRenderer renderer) {

        LVect2d lastPosition = null;
        int totalSteps = (int) (baseSteps * stepsMultiplier);
        double invSteps = 1.0 / totalSteps;

        for (int i = -1; i < totalSteps; i++) {
            double t = (double) i * invSteps;

            LVect2d positionValue = position.getValue(t);

            if (i >= 1) {
                // only paint after difference is determined
                LVect2d difference = positionValue.sub(lastPosition).mult(totalSteps);
                renderer.renderSegment(brush, t, size.getValue(t).val, color.getValue(t), positionValue, difference, canvas);
            }
            lastPosition = positionValue;
        }
    }
}
