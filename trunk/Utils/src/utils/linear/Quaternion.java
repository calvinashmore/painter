/*
 * Quaternion.java
 *
 * Created on April 27, 2006, 3:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package utils.linear;

/**
 *
 * @author gtg126z
 */
public class Quaternion implements Linear<Quaternion> {

    public double u,  i,  j,  k;

    /** Creates a new instance of Quaternion */
    public Quaternion() {
    }

    public Quaternion(double u, double i, double j, double k) {
        this.u = u;
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public Quaternion(double u, LVect3d v) {
        this.u = u;
        this.i = v.x;
        this.j = v.y;
        this.k = v.z;
    }

    public Quaternion(Quaternion q) {
        this.u = q.u;
        this.i = q.i;
        this.j = q.j;
        this.k = q.k;
    }

    public Quaternion zero() {
        return new Quaternion();
    }

    public Quaternion add(Quaternion a) {
        return new Quaternion(u + a.u, i + a.i, j + a.j, k + a.k);
    }

    public void addv(Quaternion a) {
        u += a.u;
        i += a.i;
        j += a.j;
        k += a.k;
    }

    public Quaternion sub(Quaternion a) {
        return new Quaternion(u - a.u, i - a.i, j - a.j, k - a.k);
    }

    public void subv(Quaternion a) {
        u -= a.u;
        i -= a.i;
        j -= a.j;
        k -= a.k;
    }

    public Quaternion mult(double c) {
        return new Quaternion(u * c, i * c, j * c, k * c);
    }

    public void multv(double c) {
        u *= c;
        i *= c;
        j *= c;
        k *= c;
    }

    public Quaternion normal() {
        return mult(1.0 / magnitude());
    }

    public void normalv() {
        multv(1.0 / magnitude());
    }

    public double magnitude() {
        return Math.sqrt(u * u + i * i + j * j + k * k);
    }

    public Quaternion mult(Quaternion a) {
        return new Quaternion(
                u * a.u - i * a.i - j * a.j - k * a.k,
                u * a.i + i * a.j + j * a.k - k * a.u,
                u * a.j - i * a.k + j * a.u + k * a.i,
                u * a.k + i * a.j - j * a.k + k * a.u);
    }

    public Quaternion conj() {
        return new Quaternion(u, -i, -j, -k);
    }

    public Quaternion invert() {
        double imag2 = 1.0 / (u * u + i * i + j * j + k * k);
        return conj().mult(imag2);
    }

    public Quaternion div(Quaternion a) {
        return mult(a.invert());
    }

    public double dot(Quaternion a) {
        return u * a.u + i * a.i + j * a.j + k * a.k;
    }

    public LVect3d vectorPart() {
        return new LVect3d(i, j, k);
    }

    public double anglePart() {
        return Math.acos(u / magnitude());
    }

    public Quaternion exp() {
        double mag = Math.exp(u);
        double arg = vectorPart().magnitude();

        return new Quaternion(
                mag * Math.cos(arg),
                vectorPart().mult(mag * Math.sin(arg) / arg));
    }

    public Quaternion log() {
        double mag = magnitude();
        return new Quaternion(
                Math.log(mag),
                vectorPart().mult(anglePart() / mag));
    }

    public Quaternion pow(Quaternion q) {
        return log().mult(q).exp();
    }

    public Quaternion pow(double v) {
        return log().mult(v).exp();
    }

    public Quaternion sin() {
        double arg = vectorPart().magnitude();
        return new Quaternion(
                Math.sin(u) * Math.cosh(arg),
                vectorPart().mult(Math.cos(u) * Math.sinh(arg) / arg));
    }

    public Quaternion cos() {
        double arg = vectorPart().magnitude();
        return new Quaternion(
                Math.cos(u) * Math.cosh(arg),
                vectorPart().mult(-Math.sin(u) * Math.sinh(arg) / arg));
    }

    public Quaternion tan() {
        return sin().div(cos());
    }

    public Quaternion sinh() {
        double arg = vectorPart().magnitude();
        return new Quaternion(
                Math.sinh(u) * Math.cos(arg),
                vectorPart().mult(Math.cosh(u) * Math.sin(arg) / arg));
    }

    public Quaternion cosh() {
        double arg = vectorPart().magnitude();
        return new Quaternion(
                Math.cosh(u) * Math.cos(arg),
                vectorPart().mult(Math.sinh(u) * Math.sin(arg) / arg));
    }

    public Quaternion tanh() {
        return sinh().div(cosh());
    }

    public Quaternion arcsinh() {
        Quaternion r = mult(this);
        r.u += 1;

        r = r.pow(.5); // sqrt(1 + this^2)
        r = r.add(this);
        return r.log();
    }

    public Quaternion arccosh() {
        Quaternion r = mult(this);
        r.u -= 1;

        r = r.pow(.5); // sqrt(this^2 - 1)
        r = r.add(this);
        return r.log();
    }

    public Quaternion arctanh() {
        Quaternion a = new Quaternion(1 + u, i, j, k);
        Quaternion b = new Quaternion(1 - u, -i, -j, -k);
        return a.log().sub(b.log()).mult(.5);
    }

    public Quaternion arcsin() {
        Quaternion a = new Quaternion(0, vectorPart());
        return a.mult(-1).mult(mult(a).arcsinh());
    }

    public Quaternion arccos() {
        Quaternion a = new Quaternion(0, vectorPart());
        return a.mult(-1).mult(arccosh());
    }

    public Quaternion arctan() {
        Quaternion a = new Quaternion(0, vectorPart());
        return a.mult(-1).mult(mult(a).arctanh());
    }

    @Override
    public String toString() {
        return u + " + " + i + " i + " + j + " j + " + k + " k";
    }

    public static Quaternion parse(String s) {
        s = s.replaceAll("[ijk ]", "");
        String sa[] = s.split("+");
        //String sa[] = s.split("ijk+ ");
        return new Quaternion(
                Double.parseDouble(sa[0]),
                Double.parseDouble(sa[1]),
                Double.parseDouble(sa[2]),
                Double.parseDouble(sa[3]));
    }

    @Override
    public Quaternion clone() {
        return new Quaternion(this);
    }

    public void setTo(Quaternion a) {
        this.i = a.i;
        this.j = a.j;
        this.k = a.k;
        this.u = a.u;
    }
}
