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
public class Rings2 implements IFSUtil.Mapping_v2 {

    private double p;

    public Rings2(double p) {
        this.p = p;
    }

    // variation 26
    public LVect2d map(LVect2d v, LVect2d dest) {
        double r = v.magnitude();
        double theta = Math.atan2(v.y, v.x);
        double trunc = Math.floor((r+p)/(2*p));
        double t = r - 2*p*trunc + r*(1-p);

        dest.setTo(
            t*Math.sin(theta), t*Math.cos(theta)
            );
        return dest;
    }
}
