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
public class Blob implements IFSUtil.Mapping_v2 {

    private double p1, p2;
    private int p3;

    public Blob(double p1, double p2, int p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    // variation 23
    public LVect2d map(LVect2d v, LVect2d dest) {
        double r = v.magnitude();
        double theta = Math.atan2(v.y, v.x);
        double scale = r * (p2 + .5 * (p1 + p2) * (Math.sin(p3 * theta) + 1));
        dest.setTo(
                scale * Math.cos(theta), scale * Math.sin(theta));
        return dest;
    }
}
