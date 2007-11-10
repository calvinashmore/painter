/*
 * Buffer_d.java
 *
 * Created on February 22, 2006, 9:51 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.linear.grid;

import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class Buffer_v2 extends Buffer<LVect2d> {
    
    /** Creates a new instance of Buffer_d */
    public Buffer_v2(int xres, int yres) {
        super(xres,yres,2);
    }

    public LVect2d getValue(int x, int y) {
        return new LVect2d(data[2*(x + xres*y)], data[2*(x + xres*y) + 1]);
    }

    public void setValue(int x, int y, LVect2d value) {
        data[2*(x + xres*y) + 0] = value.x;
        data[2*(x + xres*y) + 1] = value.y;
    }
}
