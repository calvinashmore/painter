/*
 * Buffer_d.java
 *
 * Created on February 22, 2006, 9:51 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.linear.grid;

import utils.linear.Color;

/**
 *
 * @author Calvin Ashmore
 */
public class Buffer_col extends Buffer<Color> {
    
    /** Creates a new instance of Buffer_d */
    public Buffer_col(int xres, int yres) {
        super(xres,yres,3);
    }

    public Color getValue(int x, int y) {
        return new Color(data[3*(x + xres*y)], data[3*(x + xres*y) + 1], data[3*(x + xres*y) + 2]);
    }

    public void setValue(int x, int y, Color value) {
        data[3*(x + xres*y) + 0] = value.r;
        data[3*(x + xres*y) + 1] = value.g;
        data[3*(x + xres*y) + 2] = value.b;
    }

}
