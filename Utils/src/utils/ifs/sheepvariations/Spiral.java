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
public class Spiral implements IFSUtil.Mapping_v2 {

    // variation 9
    public LVect2d map(LVect2d v, LVect2d dest) {
        double r = v.magnitude();
        double invR = 1.0/r;
        double theta = Math.atan2(v.y, v.x);
        dest.setTo(invR*(Math.cos(theta)+Math.sin(r)), invR*(Math.sin(theta)-Math.cos(r)));
        return dest;
    }
}
