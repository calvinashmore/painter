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
public class Gaussian implements IFSUtil.Mapping_v2 {

    private Random random;

    public Gaussian(Random random) {
        this.random = random;
    }

    // variation 35
    public LVect2d map(LVect2d v, LVect2d dest) {
        double scale = -2;
        for(int i=0;i<4;i++) {
            scale += random.nextDouble();
        }

        double psi = random.nextDouble();
        // this function actually discards the input
        dest.setTo(
            scale*Math.cos(2*Math.PI*psi), scale*Math.sin(2*Math.PI*psi)
            );
        return dest;
    }
}
