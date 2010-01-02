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
public class Rays implements IFSUtil.Mapping_v2 {

    private Random random;

    public Rays(Random random) {
        this.random = random;
    }

    // variation 44
    public LVect2d map(LVect2d v, LVect2d dest) {
        double psi = Math.PI*random.nextDouble();
        double scale = Math.tan(psi)/(v.x*v.x + v.y*v.y);

        dest.setTo(
            scale*Math.cos(v.x), scale*Math.sin(v.y));
        return dest;
    }
}
