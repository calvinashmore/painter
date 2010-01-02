/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils.ifs.sheepvariations;

import utils.ifs.IFSUtil;
import utils.linear.LVect2d;

/**
 * This code is developed from the whitepaper "The Fractal Flame Algorithm" by Draves and Reckase.
 * @author Calvin Ashmore
 */
public class Bubble implements IFSUtil.Mapping_v2 {

    // variation 28
    public LVect2d map(LVect2d v, LVect2d dest) {
        double r = v.magnitude();
        double scale = 4.0/(r*r+4);
        dest.setTo(scale*v.x, scale*v.y);
        return dest;
    }
}
