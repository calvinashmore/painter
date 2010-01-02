/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils.ifs;

import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class LinearWrap_v2 implements IFSUtil.Mapping_v2{

    private Mapping<LVect2d> base;
    private LinearMapping_v2 linear;
    private transient LVect2d temp = new LVect2d();

    public LinearWrap_v2(Mapping<LVect2d> base, double a, double b, double c, double d, double e, double f) {
        this.base = base;
        linear = new LinearMapping_v2(a, b, c, d, e, f);
    }

    public LVect2d map(LVect2d point, LVect2d dest) {
        linear.map(point, temp);
        base.map(temp, dest);
        return dest;
    }

}
