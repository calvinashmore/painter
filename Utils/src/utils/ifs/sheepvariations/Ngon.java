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
public class Ngon implements IFSUtil.Mapping_v2 {

    private double p1, p2, p3, p4;

    public Ngon(double p1, double p2, double p3, double p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    // variation 38
    public LVect2d map(LVect2d v, LVect2d dest) {
        double phi = Math.atan2(v.x, v.y);
        double r = v.magnitude();
        double t3 = phi - p2 * Math.floor(phi / p2);
        double t4 = t3 > p2 / 2 ? t3 : t3 - p2;
        double k = (p3 * (1.0 / Math.cos(t4) - 1) + p4) / Math.pow(r, p1);
        dest.setTo(k * v.x, k * v.y);
        return dest;
    }
}
