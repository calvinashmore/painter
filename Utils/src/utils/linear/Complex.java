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
        String sa[] = s.split("\\+");
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

    public static Complex sin(Complex x) {
        return new Complex( Math.sin(x.x)*Math.cosh(x.y), Math.cos(x.x)*Math.sinh(x.y) );
    }
    public static Complex cos(Complex x) {
        return new Complex( Math.cos(x.x)*Math.cosh(x.y), -Math.sin(x.x)*Math.sinh(x.y) );
    }
    public static Complex tan(Complex x) {
        return new Complex( Math.sinh(x.y)*Math.cosh(x.y), Math.sin(x.x)*Math.cos(x.x) ).mult(
                1.0 /( Math.cos(x.x)*Math.cos(x.x) + Math.sinh(x.y)*Math.sinh(x.y) ) );
    }

    public static Complex sinh(Complex x) {
        return new Complex( Math.sinh(x.x)*Math.cos(x.y), Math.cosh(x.x)*Math.sin(x.y) );
    }
    public static Complex cosh(Complex x) {
        return new Complex( Math.cosh(x.x)*Math.cos(x.y), Math.sinh(x.x)*Math.sin(x.y) );
    }
    public static Complex tanh(Complex x) {
        return new Complex( Math.sinh(x.x)*Math.cosh(x.x), Math.sin(x.y)*Math.cos(x.y) ).mult(
                1.0 /( Math.cos(x.y)*Math.cos(x.y) + Math.sinh(x.x)*Math.sinh(x.x) ) );
    }

    public static Complex asin(Complex x) {
        Complex r = new Complex(-x.y,x.x).add( new Complex(1-x.x*x.x+x.y*x.y,-2*x.x*x.y).pow(.5) ).log();
        Complex p = new Complex(r.y,-r.x);

        return p;
    }
    public static Complex acos(Complex x) {
        Complex r = new Complex(-x.y,x.x).add( new Complex(1-x.x*x.x+x.y*x.y,-2*x.x*x.y).pow(.5) ).log();
        Complex p = new Complex(Math.PI/2 - r.y, r.x);

        return p;
    }
    public static Complex atan(Complex x) {
        Complex r = new Complex(1+x.y,-x.x).log();
        Complex s = new Complex(1-x.y, x.x).log();
        Complex t = r.add(s);
        Complex p = new Complex( -t.y/2, t.x/2 );

        return p;
    }

    public static Complex pow(Complex x, Complex y) {
        Complex xlog = new Complex( Math.log(x.magnitude()), x.theta() );
        Complex ymul = new Complex( xlog.x * y.x - xlog.y * y.y, xlog.x * y.y + xlog.y * y.x );
        Complex z = new Complex( Math.exp(ymul.x)*Math.cos(ymul.y), Math.exp(ymul.x)*Math.sin(ymul.y) );

        return z;
    }
    public static Complex div(Complex x, Complex y) {
        Complex z = new Complex();
        z.x = x.x * y.x + x.y * y.y;
        z.y = x.y * y.x - x.x * y.y;
        double mag = x.magnitude() * y.magnitude();
        return z.mult( 1.0/mag );
    }
}
