/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.stroke;

import painter.tools.brush.Brush;
import painter.tools.brush.SimpleBrush;
import painter.tools.canvas.Canvas;
import painter.util.curves.ConstantCurve;
import painter.util.curves.Curve;
import utils.linear.Color;
import utils.linear.LDouble;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class Stroke {

    private int steps = 1000;
    private Brush brush;
    private Curve<LDouble> size;
    private Curve<LVect2d> position;
    private Curve<Color> color;

    public Stroke(Curve<LDouble> size, Curve<LVect2d> position, Curve<Color> color) {
        this.brush = new SimpleBrush();
        this.size = size;
        this.position = position;
        this.color = color;
    }

    public Stroke(Brush brush, Curve<LDouble> size, Curve<LVect2d> position, Curve<Color> color) {
        this.brush = brush;
        this.size = size;
        this.position = position;
        this.color = color;
    }

    public Stroke(Curve<LVect2d> position, Color color) {
        this.brush = new SimpleBrush();
        this.size = new ConstantCurve<LDouble>(new LDouble(.1));
        this.position = position;
        this.color = new ConstantCurve<Color>(color);
    }

    public void render(Canvas canvas) {

        LVect2d lastPosition = null;
        for (int i = -1; i < steps; i++) {
            double t = (double) i / steps;

            LVect2d positionValue = position.getValue(t);

            if (i >= 1) {
                LDouble sizeValue = size.getValue(t);
                Color colorValue = color.getValue(t);

                // determine difference after the first cycle.
                LVect2d difference = positionValue.sub(lastPosition).mult(steps);

                // only paint after difference is determined
                brush.paint(positionValue.x, positionValue.y,
                        difference.x, difference.y,
                        sizeValue.val, colorValue, canvas);
            }
            lastPosition = positionValue;
        }
    }

    public void setBrush(Brush brush) {
        this.brush = brush;
    }

    public void setColor(Curve<Color> color) {
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = new ConstantCurve<Color>(color);
    }

    public void setPosition(Curve<LVect2d> position) {
        this.position = position;
    }

    public void setSize(Curve<LDouble> size) {
        this.size = size;
    }

    public void setSize(double size) {
        this.size = new ConstantCurve<LDouble>(new LDouble(size));
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
