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
public class Waves implements IFSUtil.Mapping_v2 {

    private double b, c, e, f;

    public Waves(double b, double c, double e, double f) {
        this.b = b;
        this.c = c;
        this.e = e;
        this.f = f;
    }

    // variation 15
    public LVect2d map(LVect2d v, LVect2d dest) {
        dest.setTo(
                v.x + b * Math.sin(v.y * c),
                v.y + e * Math.sin(v.x * f));
        return dest;
    }
}
