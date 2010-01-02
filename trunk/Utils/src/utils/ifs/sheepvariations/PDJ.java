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
public class PDJ implements IFSUtil.Mapping_v2 {

    private double p1, p2, p3, p4;

    public PDJ(double p1, double p2, double p3, double p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    // variation 24
    // Peter de Jong attractor
    public LVect2d map(LVect2d v, LVect2d dest) {
        dest.setTo(
                Math.sin(p1 * v.y) - Math.cos(p2 * v.x),
                Math.sin(p3 * v.x) - Math.cos(p4 * v.y));
        return dest;
    }
}
