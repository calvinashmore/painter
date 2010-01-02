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
public class Square implements IFSUtil.Mapping_v2 {

    private Random random;

    public Square(Random random) {
        this.random = random;
    }

    // variation 43
    public LVect2d map(LVect2d v, LVect2d dest) {
        double psi1 = random.nextDouble();
        double psi2 = random.nextDouble();

        dest.setTo(
            psi1 - .5,
            psi2 - .5
            );
        return dest;
    }
}
