/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.stroke;

import java.awt.AlphaComposite;
import painter.tools.brush.Brush;
import painter.tools.canvas.Canvas;
import painter.tools.canvas.CanvasImpl;
import painter.tools.canvas.SubCanvas;
import utils.curves.ConstantCurve;
import utils.curves.Curve;
import utils.linear.Color;
import utils.linear.LDouble;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class AlphaStroke implements Stroke {

    private Stroke baseStroke;
    private Curve<LDouble> alphaCurve;

    public void setSteps(int steps) {
        baseStroke.setSteps(steps);
    }

    public AlphaStroke(Stroke baseStroke, Curve<LDouble> alphaCurve) {
        this.baseStroke = baseStroke;
        this.alphaCurve = alphaCurve;
    }

    public AlphaStroke(Stroke baseStroke) {
        this.baseStroke = baseStroke;
        this.alphaCurve = new ConstantCurve<LDouble>(new LDouble(.5));
    }

    public Curve<LDouble> getAlphaCurve() {
        return alphaCurve;
    }

    public void setAlphaCurve(Curve<LDouble> alphaCurve) {
        this.alphaCurve = alphaCurve;
    }

    public void render(Brush brush, Curve<LDouble> size, Curve<LVect2d> position, Curve<Color> color, Canvas canvas, SegmentRenderer renderer) {

        SubCanvas subCanvas = new SubCanvas(canvas);
        //subCanvas.getGraphics().setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
        baseStroke.render(brush, size, position, color, subCanvas, new AlphaRenderer(renderer));
    }

    private class AlphaRenderer implements SegmentRenderer {

        private SegmentRenderer baseRenderer;

        public AlphaRenderer(SegmentRenderer baseRenderer) {
            this.baseRenderer = baseRenderer;
        }

        public void renderSegment(Brush brush, double t, double sizeValue, Color colorValue, LVect2d positionValue, LVect2d difference, Canvas canvas) {

            float alpha = (float) alphaCurve.getValue(t).val;
            alpha = Math.abs(alpha);
            if (alpha > 1) {
                alpha = 1;
            }

            canvas.getGraphics().setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            baseRenderer.renderSegment(brush, t, sizeValue, colorValue, positionValue, difference, canvas);
        }
    }
}
