/*
 * LVect2d.java
 *
 * Created on February 20, 2005, 1:59 PM
 */
package utils.linear;

/**
 *
 * @author Calvin Ashmore
 */
public class LVect2d implements FiniteLinear<LVect2d> {

    public double x,  y;

    public LVect2d() {
        x = 0;
        y = 0;
    }

    public LVect2d(LVect2d a) {
        this.x = a.x;
        this.y = a.y;
    }

    public LVect2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public LVect2d zero() {
        return new LVect2d();
    }

    public LVect2d add(LVect2d a) {
        return new LVect2d(x + a.x, y + a.y);
    }

    public void addv(LVect2d a) {
        x += a.x;
        y += a.y;
    }

    public LVect2d sub(LVect2d a) {
        return new LVect2d(x - a.x, y - a.y);
    }

    public void subv(LVect2d a) {
        x -= a.x;
        y -= a.y;
    }

    public LVect2d mult(double c) {
        return new LVect2d(c * x, c * y);
    }

    public void multv(double c) {
        x *= c;
        y *= c;
    }

    public LVect2d normal() {
        double m = 1.0 / magnitude();
        return new LVect2d(m * x, m * y);
    }

    public void normalv() {
        double m = 1.0 / magnitude();
        x *= m;
        y *= m;
    }

    public double dot(LVect2d v) {
        return v.x * x + v.y * y;
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "< " + x + " , " + y + " >";
    }

    public static LVect2d parse(String s) {
        s = s.replaceAll("[<> ]", "");
        String sa[] = s.split(",");
        return new LVect2d(
                Double.parseDouble(sa[0]),
                Double.parseDouble(sa[1]));
    }

    @Override
    public LVect2d clone() {
        return new LVect2d(this);
    }

    public int dimensions() {
        return 2;
    }

    public double get(int i) {
        if (i == 0) {
            return x;
        }
        if (i == 1) {
            return y;
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }
}
