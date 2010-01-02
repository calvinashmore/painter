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
public class Perspective implements IFSUtil.Mapping_v2 {

    private double p1, p2;

    public Perspective(double p1, double p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // variation 30
    public LVect2d map(LVect2d v, LVect2d dest) {
        double scale = p2 / (p2 - v.y * Math.sin(p1));
        dest.setTo(scale*v.x, scale*v.y * Math.cos(p1));
        return dest;
    }
}
