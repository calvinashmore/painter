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
public class Hyperbolic implements IFSUtil.Mapping_v2 {

    // variation 10
    public LVect2d map(LVect2d v, LVect2d dest) {
        double r = v.magnitude();
        double theta = Math.atan2(v.y, v.x);
        dest.setTo(Math.sin(theta)/r, r*Math.cos(theta));
        return dest;
    }
}
