/*
 * Buffer_d.java
 *
 * Created on February 22, 2006, 9:51 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.linear.grid;

import utils.linear.LDouble;

/**
 *
 * @author Calvin Ashmore
 */
public class Buffer_d extends Buffer<LDouble> {
    
    /** Creates a new instance of Buffer_d */
    public Buffer_d(int xres, int yres) {
        super(xres,yres,1);
    }

    public LDouble getValue(int x, int y) {
        return new LDouble(data[x + xres*y]);
    }

    public void setValue(int x, int y, LDouble value) {
        data[x + xres*y] = value.val;
    }
}
