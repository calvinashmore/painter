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
public class Fan2 implements IFSUtil.Mapping_v2 {

    private double p1, p2;

    public Fan2(double p1, double p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // variation 25
    public LVect2d map(LVect2d v, LVect2d dest) {
        double r = v.magnitude();
        double theta = Math.atan2(v.y, v.x);
        double trunc = Math.floor(2*theta*p2/p1);
        double t = theta + p2 - p1*trunc;

        if(t > p1/2) {
            dest.setTo(r*Math.sin(theta-p1/2), r*Math.cos(theta-p1/2));
        } else {
            dest.setTo(r*Math.sin(theta+p1/2), r*Math.cos(theta+p1/2));
        }
        return dest;
    }
}
