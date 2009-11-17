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

    public static class Curve_d implements Curve<LDouble> {

        private Curve<LDouble> base;

        public Curve_d(Curve<LDouble> base) {
            this.base = base;
        }

        public LDouble getValue(double t) {
            return base.getValue(t);
        }
    }

    public static class Curve_v2 implements Curve<LVect2d> {

        private Curve<LVect2d> base;

        public Curve_v2(Curve<LVect2d> base) {
            this.base = base;
        }

        public LVect2d getValue(double t) {
            return base.getValue(t);
        }
    }

    public static class Curve_col implements Curve<Color> {

        private Curve<Color> base;

        public Curve_col(Curve<Color> base) {
            this.base = base;
        }

        public Color getValue(double t) {
            return base.getValue(t);
        }
    }
}
