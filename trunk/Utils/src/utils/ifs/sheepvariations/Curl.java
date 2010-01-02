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
public class Curl implements IFSUtil.Mapping_v2 {

    private double p1, p2;

    public Curl(double p1, double p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // variation 39
    public LVect2d map(LVect2d v, LVect2d dest) {
        double t1 = 1 + p1*v.x + p2*(v.x*v.x + v.y*v.y);
        double t2 = p1*v.y + 2*p2*v.x*v.y;
        double scale = 1.0 / (t1*t1 + t2*t2);
        dest.setTo(scale*(v.x*t1 + v.y*t2), scale*(v.y*t1 - v.x*t2));
        return dest;
    }
}
