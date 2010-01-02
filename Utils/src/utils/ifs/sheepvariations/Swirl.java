/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils.ifs.sheepvariations;

import utils.ifs.IFSUtil;
import utils.linear.LVect2d;

/**
 * This code is developed from the whitepaper "The Fractal Flame Algorithm" by Draves and Reckase.
 * @author Calvin Ashmore
 */
public class Swirl implements IFSUtil.Mapping_v2 {

    // variation 3
    public LVect2d map(LVect2d v, LVect2d dest) {
        double r2 = v.x*v.x + v.y*v.y;
        double sr2 = Math.sin(r2);
        double cr2 = Math.cos(r2);
        dest.setTo(v.x*sr2 - v.y*cr2, v.x*cr2 + v.y*sr2);
        return dest;
    }
}
