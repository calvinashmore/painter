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
public class Bent implements IFSUtil.Mapping_v2 {

    // variation 14
    public LVect2d map(LVect2d v, LVect2d dest) {
        if(v.x >= 0) {
            if(v.y >= 0) {
                dest.setTo(v);
            } else {
                dest.setTo(v.x, v.y*.5);
            }
        } else {
            if(v.y >= 0) {
                dest.setTo(v.x*2, v.y);
            } else {
                dest.setTo(v.x*2, v.y*.5);
            }
        }
        return dest;
    }
}
