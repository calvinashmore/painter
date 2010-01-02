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
public class Twintrain implements IFSUtil.Mapping_v2 {

    private Random random;

    public Twintrain(Random random) {
        this.random = random;
    }

    // variation 41
    public LVect2d map(LVect2d v, LVect2d dest) {
        double psi = random.nextDouble();
        double rpsi = psi * v.magnitude();
        double t = 2 * Math.log(Math.abs(Math.sin(rpsi))) + Math.cos(rpsi);

        dest.setTo(
                v.x * t,
                v.x * (t - Math.PI * Math.sin(rpsi)));

        return dest;
    }
}
