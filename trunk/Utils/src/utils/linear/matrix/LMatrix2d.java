/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.linear.matrix;

import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class LMatrix2d implements Matrix<LMatrix2d, LVect2d> {

    public double m00,  m10;
    public double m01,  m11;

    public LMatrix2d() {
    }

    public LMatrix2d(LMatrix2d matrix) {
        this.m00 = matrix.m00;
        this.m10 = matrix.m10;
        this.m01 = matrix.m01;
        this.m11 = matrix.m11;
    }

    public LMatrix2d(double m00, double m10, double m01, double m11) {
        this.m00 = m00;
        this.m10 = m10;
        this.m01 = m01;
        this.m11 = m11;
    }

    public LMatrix2d getIdentity() {
        return new LMatrix2d(1, 0, 0, 1);
    }

    public LVect2d apply(LVect2d x) {
        return new LVect2d(m00 * x.x + m01 * x.y, m10 * x.x + m11 * x.y);
    }

    public LMatrix2d apply(LMatrix2d matrix) {
        return new LMatrix2d(
                m00 * matrix.m00 + m01 * matrix.m10,
                m10 * matrix.m00 + m11 * matrix.m10,
                m00 * matrix.m01 + m01 * matrix.m11,
                m10 * matrix.m01 + m11 * matrix.m11);
    }

    public LMatrix2d zero() {
        return new LMatrix2d();
    }

    public LMatrix2d add(LMatrix2d a) {
        LMatrix2d m = new LMatrix2d(this);
        m.addv(a);
        return m;
    }

    public void addv(LMatrix2d a) {
        this.m00 += a.m00;
        this.m10 += a.m10;
        this.m01 += a.m01;
        this.m11 += a.m11;
    }

    public LMatrix2d sub(LMatrix2d a) {
        LMatrix2d m = new LMatrix2d(this);
        m.subv(a);
        return m;
    }

    public void subv(LMatrix2d a) {
        this.m00 -= a.m00;
        this.m10 -= a.m10;
        this.m01 -= a.m01;
        this.m11 -= a.m11;
    }

    public LMatrix2d mult(double c) {
        LMatrix2d m = new LMatrix2d(this);
        m.multv(c);
        return m;
    }

    public void multv(double c) {
        this.m00 *= c;
        this.m10 *= c;
        this.m01 *= c;
        this.m11 *= c;
    }

    public LMatrix2d normal() {
        LMatrix2d m = new LMatrix2d(this);
        m.normalv();
        return m;
    }

    public void normalv() {
        double inverseMagnitude = 1.0 / magnitude();
        m00 *= inverseMagnitude;
        m10 *= inverseMagnitude;
        m01 *= inverseMagnitude;
        m11 *= inverseMagnitude;
    }

    public double magnitude() {
        return Math.sqrt(m00 * m00 + m01 * m01 + m10 * m10 + m11 * m11);
    }

    @Override
    public LMatrix2d clone() {
        return new LMatrix2d(this);
    }

    public double determinant() {
        return m00 * m11 - m10 * m01;
    }

    public LMatrix2d invert() {
        LMatrix2d m = new LMatrix2d(m11, -m10, -m01, m00);
        m.mult(1.0 / determinant());
        return m;
    }
}
