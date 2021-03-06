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
public class Arch implements IFSUtil.Mapping_v2 {

    private Random random;

    public Arch(Random random) {
        this.random = random;
    }

    // variation 41
    public LVect2d map(LVect2d v, LVect2d dest) {
        double psi = Math.PI * random.nextDouble();

        dest.setTo(
                Math.sin(psi),
                Math.pow(Math.sin(psi), 2) / Math.cos(psi));
        return dest;
    }
}
