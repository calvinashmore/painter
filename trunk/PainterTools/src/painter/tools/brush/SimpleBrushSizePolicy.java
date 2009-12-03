/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.brush;

/**
 *
 * @author Calvin Ashmore
 */
public class SimpleBrushSizePolicy implements BrushSizePolicy {

    private double anchorX, anchorY;

    /**
     * Values are typically: 0 for left anchor, .5 for center, and 1 for right anchor.
     * @param anchorX
     * @param anchorY
     */
    public SimpleBrushSizePolicy(double anchorX, double anchorY) {
        this.anchorX = anchorX;
        this.anchorY = anchorY;
    }

    public double getXOffset(double width) {
        return -width * anchorX;
    }

    public double getYOffset(double width) {
        return -width * anchorY;
    }
}
