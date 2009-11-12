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
public class Complex implements Linear<Complex> {

    public double x,  y;

    public Complex() {
        x = 0;
        y = 0;
    }

    public Complex(Complex a) {
        this.x = a.x;
        this.y = a.y;
    }

    public Complex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Complex zero() {
        return new Complex();
    }

    public Complex add(Complex a) {
        return new Complex(x + a.x, y + a.y);
    }

    public void addv(Complex a) {
        x += a.x;
        y += a.y;
    }

    public Complex sub(Complex a) {
        return new Complex(x - a.x, y - a.y);
    }

    public void subv(Complex a) {
        x -= a.x;
        y -= a.y;
    }

    public Complex mult(double c) {
        return new Complex(c * x, c * y);
    }

    public void multv(double c) {
        x *= c;
        y *= c;
    }

    public Complex mult(Complex c) {
        return new Complex(c.x * x - c.y * y, c.x * y + c.y * x);
    }

    public void multv(Complex c) {
        double newx = c.x * x - c.y * y;
        double newy = c.x * y + c.y * x;

        x = newx;
        y = newy;
    }

    public Complex normal() {
        double m = 1.0 / magnitude();
        return new Complex(m * x, m * y);
    }

    public void normalv() {
        double m = 1.0 / magnitude();
        x *= m;
        y *= m;
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public double theta() {
        return Math.atan2(y, x);
    }

    public double xPart() {
        return x / magnitude();
    }

    public double yPart() {
        return y / magnitude();
    }

    public Complex exp() {
        return new Complex(Math.exp(x) * Math.cos(y), Math.exp(x) * Math.sin(y));
    }

    public Complex log() {
        return new Complex(Math.log(magnitude()), theta());
    }

    public Complex pow(Complex c) {
        return log().mult(c).exp();
    }

    public Complex pow(double c) {
        return log().mult(c).exp();
    }

    public Complex invert() {
        double invMag2 = 1 / (x * x + y * y);
        return new Complex(x * invMag2, -y * invMag2);
    }

    public Complex div(Complex c) {
        return mult(c.invert());
    }

    @Override
    public String toString() {
        return x + " + " + y + " i";
    }

    public static Complex parse(String s) {
        s = s.replaceAll("[i ]", "");
        String sa[] = s.split("+");
        //String sa[] = s.split("i+ ");
        return new Complex(
                Double.parseDouble(sa[0]),
                Double.parseDouble(sa[1]));
    }

    @Override
    public Complex clone() {
        return new Complex(this);
    }

    public void setTo(Complex a) {
        this.x = a.x;
        this.y = a.y;
    }
}
