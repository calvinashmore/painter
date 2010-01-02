/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.ifs.sheepvariations;

import java.util.Random;
import utils.ifs.IFSUtil;
import utils.linear.LVect2d;

/**
 * This code is developed from the whitepaper "The Fractal Flame Algorithm" by Draves and Reckase.
 * @author Calvin Ashmore
 */
public class RadialBlur implements IFSUtil.Mapping_v2 {

    private Random random;
    private double p1;

    public RadialBlur(Random random, double p1) {
        this.random = random;
        this.p1 = p1;
    }

    // variation 36
    public LVect2d map(LVect2d v, LVect2d dest) {
        double t1 = -2;
        for(int i=0;i<4;i++)
            t1 += random.nextDouble();

        double phi = Math.atan2(v.x, v.y);
        double t2 = phi + t1*Math.sin(p1);
        double t3 = t1*Math.cos(p1)-1;
        double r = v.magnitude();

        dest.setTo(
            r*Math.cos(t2) + t3*v.x, r*Math.sin(t2) + t3*v.y
            );
        return dest;
    }
}
