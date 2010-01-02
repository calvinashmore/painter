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
public class Julia implements IFSUtil.Mapping_v2 {

    private Random random;

    public Julia(Random random) {
        this.random = random;
    }


    // variation 13
    public LVect2d map(LVect2d v, LVect2d dest) {
        // this doesn't really have anything to do with a Julia set
        double rRoot = Math.sqrt(v.magnitude());
        double theta = Math.atan2(v.y, v.x);
        double omega = random.nextBoolean() ? 0 : Math.PI;
        dest.setTo(rRoot*Math.cos(theta/2+omega), rRoot*Math.sin(theta/2+omega));
        return dest;
    }
}
