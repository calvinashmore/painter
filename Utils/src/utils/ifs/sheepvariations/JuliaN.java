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
public class JuliaN implements IFSUtil.Mapping_v2 {

    private Random random;
    private double p1, p2;

    public JuliaN(Random random, double p1, double p2) {
        this.random = random;
        this.p1 = p1;
        this.p2 = p2;
    }

    // variation 32
    public LVect2d map(LVect2d v, LVect2d dest) {
        double psi = random.nextDouble();
        double phi = Math.atan2(v.x, v.y);
        double r = v.magnitude();
        double p3 = Math.floor(Math.abs(p1) * psi);
        double t = (phi + 2 * Math.PI * p3) / p1;
        double scale = Math.pow(r, p2 / p1);

        dest.setTo(
                scale * Math.cos(t), scale * Math.sin(t));
        return dest;
    }
}
