/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

import java.util.ArrayList;
import java.util.List;
import painter.tools.canvas.Canvas;
import utils.linear.Color;

/**
 *
 * @author Calvin Ashmore
 */
public class MultiBrush implements Brush {

    private static class SubBrushInfo {

        Brush subBrush;
        double xOffset;
        double yOffset;
        double radiusMultiplier;
        Color colorOffset;
    }
    private List<SubBrushInfo> subBrushes = new ArrayList<SubBrushInfo>();
    private double colorMultiplier = .3;

    public MultiBrush() {
    }

    public void setColorMultiplier(double colorMultiplier) {
        this.colorMultiplier = colorMultiplier;
    }

    public void addBrush(Brush subBrush, double xOffset, double yOffset, double radiusMultiplier, Color colorOffset) {
        SubBrushInfo info = new SubBrushInfo();
        info.subBrush = subBrush;
        info.xOffset = xOffset;
        info.yOffset = yOffset;
        info.radiusMultiplier = radiusMultiplier;
        info.colorOffset = colorOffset;

        subBrushes.add(info);
    }

    public void paint(double x, double y, double dx, double dy, double radius, Color color, Canvas canvas) {

        for (SubBrushInfo info : subBrushes) {

            Color subColor = color.mult(1 - colorMultiplier).add(info.colorOffset.mult(colorMultiplier));

            info.subBrush.paint(
                    x + info.xOffset,
                    y + info.yOffset,
                    dx, dy,
                    radius * info.radiusMultiplier,
                    subColor, canvas);
        }
    }
}
