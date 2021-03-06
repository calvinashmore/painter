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
public class Horseshoe implements IFSUtil.Mapping_v2 {

    // variation 4
    public LVect2d map(LVect2d v, LVect2d dest) {
        double invR = 1.0/v.magnitude();
        dest.setTo(invR*(v.x-v.y)*(v.x+v.y),invR*2*v.x*v.y);
        return dest;
    }
}
