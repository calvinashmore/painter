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
public class Rings implements IFSUtil.Mapping_v2 {

    private double c;

    public Rings(double c) {
        this.c = c;
    }

    // variation 21
    public LVect2d map(LVect2d v, LVect2d dest) {
        double r = v.magnitude();
        double scale = ((r + c) % (2 * c)) - c + r * (1 - c);
        double theta = Math.atan2(v.y, v.x);
        dest.setTo(
                scale * Math.cos(theta), scale * Math.sin(theta));
        return dest;
    }
}
