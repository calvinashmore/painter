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
public class Spherical implements IFSUtil.Mapping_v2 {

    // variation 2
    public LVect2d map(LVect2d v, LVect2d dest) {
        double invR2 = 1.0/(v.x*v.x + v.y*v.y);
        dest.setTo(invR2*v.x, invR2*v.y);
        return dest;
    }
}
