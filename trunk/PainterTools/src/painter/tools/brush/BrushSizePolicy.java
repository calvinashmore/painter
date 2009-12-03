/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package painter.tools.brush;

/**
 *
 * @author Calvin Ashmore
 */
abstract public interface BrushSizePolicy {
    public double getXOffset(double width);
    public double getYOffset(double width);
}
