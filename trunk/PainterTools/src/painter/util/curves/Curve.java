/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package painter.util.curves;

import utils.linear.Color;
import utils.linear.LDouble;
import utils.linear.LVect2d;
import utils.linear.Linear;

/**
 * Defines a curve of an arbitrary type over a time period ranging from 0 to 1.
 * @author Calvin Ashmore
 */
public interface Curve<T extends Linear<T>>{

    T getValue(double t);
}
