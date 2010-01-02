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
public class Blur implements IFSUtil.Mapping_v2 {

    private Random random;

    public Blur(Random random) {
        this.random = random;
    }

    // variation 34
    public LVect2d map(LVect2d v, LVect2d dest) {
        double psi1 = random.nextDouble();
        double psi2 = random.nextDouble();
        // this function actually discards the input
        dest.setTo(
                psi1 * Math.cos(2 * Math.PI * psi2), psi1 * Math.sin(2 * Math.PI * psi2));
        return dest;
    }
}
