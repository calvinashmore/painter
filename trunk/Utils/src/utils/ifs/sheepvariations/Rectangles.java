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
public class Rectangles implements IFSUtil.Mapping_v2 {

    private double p1, p2;

    public Rectangles(double p1, double p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // variation 40
    public LVect2d map(LVect2d v, LVect2d dest) {
        dest.setTo(
            (2*Math.floor(v.x/p1)+1)*p1 - v.x,
            (2*Math.floor(v.y/p2)+1)*p2 - v.y
            );
        return dest;
    }
}
