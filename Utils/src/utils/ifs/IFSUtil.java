/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils.ifs;

import java.util.Random;
import utils.linear.LDouble;
import utils.linear.LVect2d;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class IFSUtil {

    public static class IFS_d extends IFS<LDouble> {}
    public static class IFS_v2 extends IFS<LVect2d> {}
    public static class IFS_v3 extends IFS<LVect3d> {}

    public static class IFS_d_wrap extends IFS_d {
        private final IFS<LDouble> ifs;

        public IFS_d_wrap(IFS<LDouble> ifs) {
            this.ifs = ifs;
        }

        @Override
        public LDouble apply(LDouble src, LDouble dest, Random rand) {
            return ifs.apply(src, dest, rand);
        }

        @Override
        public void addMapping(Mapping<LDouble> mapping, double probability) {
            ifs.addMapping(mapping, probability);
        }
    }

    public static class IFS_v2_wrap extends IFS_v2 {
        private final IFS<LVect2d> ifs;

        public IFS_v2_wrap(IFS<LVect2d> ifs) {
            this.ifs = ifs;
        }

        @Override
        public LVect2d apply(LVect2d src, LVect2d dest, Random rand) {
            return ifs.apply(src, dest, rand);
        }

        @Override
        public void addMapping(Mapping<LVect2d> mapping, double probability) {
            ifs.addMapping(mapping, probability);
        }
    }

    public static class IFS_v3_wrap extends IFS_v3 {
        private final IFS<LVect3d> ifs;

        public IFS_v3_wrap(IFS<LVect3d> ifs) {
            this.ifs = ifs;
        }

        @Override
        public LVect3d apply(LVect3d src, LVect3d dest, Random rand) {
            return ifs.apply(src, dest, rand);
        }

        @Override
        public void addMapping(Mapping<LVect3d> mapping, double probability) {
            ifs.addMapping(mapping, probability);
        }
    }

    public static interface Mapping_d extends Mapping<LDouble> {}
    public static interface Mapping_v2 extends Mapping<LVect2d> {}
    public static interface Mapping_v3 extends Mapping<LVect3d> {}

    public static class Mapping_d_wrap implements Mapping_d {

        private final Mapping<LDouble> mapping;

        public Mapping_d_wrap(Mapping<LDouble> mapping) {
            this.mapping = mapping;
        }

        public LDouble map(LDouble point, LDouble dest) {
            return mapping.map(point, dest);
        }
    }

    public static class Mapping_v2_wrap implements Mapping_v2 {

        private final Mapping<LVect2d> mapping;

        public Mapping_v2_wrap(Mapping<LVect2d> mapping) {
            this.mapping = mapping;
        }

        public LVect2d map(LVect2d point, LVect2d dest) {
            return mapping.map(point, dest);
        }
    }

    public static class Mapping_v3_wrap implements Mapping_v3 {

        private final Mapping<LVect3d> mapping;

        public Mapping_v3_wrap(Mapping<LVect3d> mapping) {
            this.mapping = mapping;
        }

        public LVect3d map(LVect3d point, LVect3d dest) {
            return mapping.map(point, dest);
        }
    }
}
