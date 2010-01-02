/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.ifs;

import java.util.ArrayList;
import java.util.List;
import utils.Pair;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class ComposeMapping_v2 implements IFSUtil.Mapping_v2 {

    private List<Mapping<LVect2d>> mappings = new ArrayList<Mapping<LVect2d>>();
    private List<Double> weights = new ArrayList<Double>();
    private double weightSum;

    public ComposeMapping_v2(Pair<Mapping<LVect2d>, Double>... contents) {
        weightSum = 0;
        for (Pair<Mapping<LVect2d>, Double> pair : contents) {

            mappings.add(pair.getLeft());
            weights.add(pair.getRight());
            weightSum += pair.getRight();
        }
    }

    public LVect2d map(LVect2d point, LVect2d dest) {
        LVect2d temp = new LVect2d();
        dest.setTo(0, 0);

        for (int i = 0; i < mappings.size(); i++) {
            Mapping<LVect2d> mapping = mappings.get(i);
            double weight = weights.get(i);

            mapping.map(point, temp);
            temp.multv(weight);
            dest.add(temp);
        }
        dest.multv(1.0 / weightSum); // ?
        return dest;
    }
}
