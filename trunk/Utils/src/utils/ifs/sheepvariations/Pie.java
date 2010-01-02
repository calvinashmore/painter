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
public class Pie implements IFSUtil.Mapping_v2 {

    private Random random;
    private double p1;
    private double p2;
    private double p3;

    public Pie(Random random, double p1, double p2, double p3) {
        this.random = random;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    // variation 37
    public LVect2d map(LVect2d v, LVect2d dest) {
        double t1 = Math.floor(random.nextDouble()*p1 + .5);
        double t2 = p2 + (2*Math.PI/p1)*(t1 + random.nextDouble()*p3);
        double r = random.nextDouble();

        dest.setTo(
            r*Math.cos(t2), r*Math.sin(t2)
            );
        return dest;
    }
}
