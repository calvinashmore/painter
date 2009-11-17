/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.util.curves;

import utils.linear.Color;
import utils.linear.LDouble;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class CurveUtil {

    // forbid construction of utility class
    private CurveUtil() {
    }

    public interface Curve_d extends Curve<LDouble> {}
    public interface Curve_v2 extends Curve<LVect2d> {}
    public interface Curve_col extends Curve<Color> {}

    public static class Curve_d_wrap implements Curve_d {

        private Curve<LDouble> base;

        public Curve_d_wrap(Curve<LDouble> base) {
            this.base = base;
        }

        public LDouble getValue(double t) {
            return base.getValue(t);
        }
    }

    public static class Curve_v2_wrap implements Curve_v2 {

        private Curve<LVect2d> base;

        public Curve_v2_wrap(Curve<LVect2d> base) {
            this.base = base;
        }

        public LVect2d getValue(double t) {
            return base.getValue(t);
        }
    }

    public static class Curve_col_wrap implements Curve_col {

        private Curve<Color> base;

        public Curve_col_wrap(Curve<Color> base) {
            this.base = base;
        }

        public Color getValue(double t) {
            return base.getValue(t);
        }
    }
}
