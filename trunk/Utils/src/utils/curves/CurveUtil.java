/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.curves;

import utils.linear.Color;
import utils.linear.LDouble;
import utils.linear.LVect2d;
import utils.linear.Linear;

/**
 *
 * @author Calvin Ashmore
 */
public class CurveUtil {

    // forbid construction of utility class
    private CurveUtil() {
    }

    public interface Curve_d extends Curve<LDouble> {
    }

    public interface Curve_v2 extends Curve<LVect2d> {
    }

    public interface Curve_col extends Curve<Color> {
    }

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

    public static <T extends Linear<T>> Curve<T> subCurve(final Curve<T> a, final double start, final double length) {
        return new Curve<T>() {

            public T getValue(double t) {
                return a.getValue(start + t * length);
            }
        };
    }

    public static <T extends Linear<T>> Curve<T> add(final Curve<T> a, final T offset) {
        return new Curve<T>() {

            public T getValue(double t) {
                return a.getValue(t).add(offset);
            }
        };
    }

    public static <T extends Linear<T>> Curve<T> add(final Curve<T> a, final Curve<T> b) {
        return new Curve<T>() {

            public T getValue(double t) {
                return a.getValue(t).add(b.getValue(t));
            }
        };
    }

    public static <T extends Linear<T>> Curve<T> sub(final Curve<T> a, final T offset) {
        return new Curve<T>() {

            public T getValue(double t) {
                return a.getValue(t).sub(offset);
            }
        };
    }

    public static <T extends Linear<T>> Curve<T> sub(final Curve<T> a, final Curve<T> b) {
        return new Curve<T>() {

            public T getValue(double t) {
                return a.getValue(t).sub(b.getValue(t));
            }
        };
    }

    public static <T extends Linear<T>> Curve<T> mult(final Curve<T> a, final double c) {
        return new Curve<T>() {

            public T getValue(double t) {
                return a.getValue(t).mult(c);
            }
        };
    }

    public static <T extends Linear<T>> Curve<T> reverse(final Curve<T> a) {
        return new Curve<T>() {

            public T getValue(double t) {
                return a.getValue(1 - t);
            }
        };
    }

    public static Curve_v2 rotate(final Curve<LVect2d> a, final double theta) {
        final double c = Math.cos(theta);
        final double s = Math.sin(theta);
        return new Curve_v2() {

            public LVect2d getValue(double t) {
                LVect2d v = a.getValue(t);
                return new LVect2d(v.x * c + v.y * s, v.y * c - v.x * s);
            }
        };
    }
}
