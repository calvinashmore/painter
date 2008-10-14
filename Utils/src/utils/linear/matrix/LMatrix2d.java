/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.linear.matrix;

import utils.linear.Complex;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class LMatrix2d implements FiniteMatrix<LMatrix2d, LVect2d> {

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

    public double get(int i, int j) {
        if (i == 0) {
            if (j == 0) {
                return m00;
            } else if (j == 1) {
                return m01;
            } else {
                throw new ArrayIndexOutOfBoundsException(j);
            }
        } else if (i == 1) {
            if (j == 0) {
                return m10;
            } else if (j == 1) {
                return m11;
            } else {
                throw new ArrayIndexOutOfBoundsException(j);
            }
        } else {
            throw new ArrayIndexOutOfBoundsException(i);
        }
    }

    public Complex[] eigenvalues(Complex[] target) {
        // first calculate characteristic polynomial
        // the eigenvalues are the values of lambda that satisfy the formula:
        // det(M - lambda*Identity) = 0
        // for a 2x2 matrix, this will form a quadratic equation of the form
        // lambda^2 - lambda*(m01+m10) + m00*m11 - m01*m10 = 0
        // this has solutions:
        // lambda1 = (m00+m11)/2 + sqrt((m00+m11)^2 -4(m00*m11-m10*m01))/2  <--- will always be larger
        // lambda2 = (m00+m11)/2 - sqrt((m00+m11)^2 -4(m00*m11-m10*m01))/2  <--- will always be smaller
        // if (m00+m11)^2 -4(m00*m11-m10*m01) < 0, then the eigenvalues are complex. We ignore these for now
        double eigenRoot = (m00 + m11) * (m00 + m11) - 4 * (m00 * m11 - m10 * m01);
        
        // use the target if it is not null, otherwise create new
        Complex[] eigenvalues = target == null ? new Complex[2] : target;

        double part1 = .5 * (m00 + m11);
        double part2 = .5 * Math.sqrt(Math.abs(eigenRoot));

        Complex eigenvalue1 = eigenvalues[0] == null ? new Complex() : eigenvalues[0];
        Complex eigenvalue2 = eigenvalues[1] == null ? new Complex() : eigenvalues[1];

        if (eigenRoot < 0) {
            eigenvalue1.x = part1;
            eigenvalue1.y = part2;
            eigenvalue2.x = part1;
            eigenvalue2.y = -part2;
        } else {
            eigenvalue1.x = part1 + part2;
            eigenvalue1.x = part1 - part2;
        }
        double mag1 = eigenvalue1.magnitude();
        double mag2 = eigenvalue2.magnitude();

        if (mag1 > mag2) {
            eigenvalues[0] = eigenvalue1;
            eigenvalues[1] = eigenvalue2;
        } else {
            eigenvalues[0] = eigenvalue2;
            eigenvalues[1] = eigenvalue1;
        }
        return eigenvalues;
    }

    public Complex[] eigenvector(Complex eigenvalue) {
        Complex[] eigenvector = new Complex[2];
        if (m10 != 0) {
            // this should be the case with most matrices.
            eigenvector[0] = new Complex(1, 0);
            eigenvector[1] = new Complex(m00 - eigenvalue.x, eigenvalue.y).mult(1 / m10);
        } else if (m01 != 0) {
            // in this case, one non-diagonal corner of the matrix is zero, but the other is nonzero
            eigenvector[0] = new Complex(m11 - eigenvalue.x, eigenvalue.y).mult(1 / m01);
            eigenvector[1] = new Complex(1, 0);
        } else {
            // in this unusual case, the matrix is diagonal.
            // the eigenvalue is necessarily real in this case
            if (eigenvalue.x == m00) {
                eigenvector[0] = new Complex(1, 0);
                eigenvector[1] = new Complex(0, 0);
            } else {
                eigenvector[0] = new Complex(0, 0);
                eigenvector[1] = new Complex(1, 0);
            }
        }
        double inverseMagnitude = Math.sqrt(1 + eigenvector[1].magnitude());
        eigenvector[0].mult(inverseMagnitude);
        eigenvector[1].mult(inverseMagnitude);
        return eigenvector;
    }

    public int dimensions() {
        return 4;
    }

    public double get(int i) {
        if (i == 0) {
            return m00;
        } else if (i == 1) {
            return m10;
        } else if (i == 2) {
            return m01;
        } else if (i == 3) {
            return m11;
        }

        throw new ArrayIndexOutOfBoundsException(i);
    }

    public void setTo(LMatrix2d a) {
        this.m00 = a.m00;
        this.m01 = a.m01;
        this.m10 = a.m10;
        this.m11 = a.m11;
    }
}
