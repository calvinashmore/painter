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
public class Ex implements IFSUtil.Mapping_v2 {

    // variation 12
    public LVect2d map(LVect2d v, LVect2d dest) {
        double r = v.magnitude();
        double theta = Math.atan2(v.y, v.x);
        double p0 = Math.pow(Math.sin(theta+r),3);
        double p1 = Math.pow(Math.cos(theta-r),3);
        dest.setTo(r*(p0+p1), r*(p0-p1));
        return dest;
    }
}
