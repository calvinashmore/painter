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
    
    @Override
    public LDouble pointAverage(int x, int y, int rx, int ry)
    {
        int count = 0;
        //LDouble avg = getValue(0,0).zero();
        double avg = 0;
        for(int xt = x - rx; xt <= x + rx; xt++)
        for(int yt = y - ry; yt <= y + ry; yt++)
        {
            if(xt < 0 || xt >= xres || yt < 0 || yt >= yres)
                continue;
            
            avg += data[xt + xres*yt];
            //avg.addv(getValue(xt,yt));
            count++;
        }
        
        //avg.multv(1.0/count);
        avg *= 1.0/count;
        return new LDouble(avg);
    }
}
