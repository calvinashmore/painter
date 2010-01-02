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
public class Fan implements IFSUtil.Mapping_v2 {

    private double t;
    private double f;

    public Fan(double t, double f) {
        this.t = t;
        this.f = f;
    }

    // variation 22
    public LVect2d map(LVect2d v, LVect2d dest) {
        double r = v.magnitude();
        double theta = Math.atan2(v.y, v.x);

        if( (theta+f) % t > t/2) {
            double thetaMinus = theta - t/2;
            dest.setTo(r*Math.cos(thetaMinus), r*Math.sin(thetaMinus));
        } else {
            double thetaPlus = theta + t/2;
            dest.setTo(r*Math.cos(thetaPlus), r*Math.sin(thetaPlus));
        }
        return dest;
    }
}
