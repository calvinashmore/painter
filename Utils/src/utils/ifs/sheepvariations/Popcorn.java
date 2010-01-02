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
public class Popcorn implements IFSUtil.Mapping_v2 {

    private double c, f;

    public Popcorn(double c, double f) {
        this.c = c;
        this.f = f;
    }

    // variation 17
    public LVect2d map(LVect2d v, LVect2d dest) {
        dest.setTo(
                v.x + c * Math.sin(Math.tan(3 * v.y)),
                v.y + f * Math.sin(Math.tan(3 * v.x)));
        return dest;
    }
}
