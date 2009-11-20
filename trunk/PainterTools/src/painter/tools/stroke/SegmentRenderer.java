package painter.tools.stroke;

import painter.tools.brush.Brush;
import painter.tools.canvas.Canvas;
import utils.linear.Color;
import utils.linear.LVect2d;

public interface SegmentRenderer {

    public void renderSegment(Brush brush, double t, double sizeValue, Color colorValue, LVect2d positionValue, LVect2d difference, Canvas canvas);
}
