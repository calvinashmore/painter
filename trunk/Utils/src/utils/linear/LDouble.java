/*
 * LDouble.java
 *
 * Created on February 20, 2005, 1:57 PM
 */
package utils.linear;

/**
 *
 * @author Calvin Ashmore
 */
public class LDouble implements Linear<LDouble> {

    public double val;

    public LDouble(double val) {
        this.val = val;
    }

    public LDouble(LDouble a) {
        this.val = a.val;
    }

    public LDouble() {
        this.val = 0;
    }

    public LDouble zero() {
        return new LDouble();
    }

    public LDouble add(LDouble a) {
        return new LDouble(val + a.val);
    }

    public void addv(LDouble a) {
        val += a.val;
    }

    public LDouble sub(LDouble a) {
        return new LDouble(val - a.val);
    }

    public void subv(LDouble a) {
        val -= a.val;
    }

    public LDouble mult(double c) {
        return new LDouble(val * c);
    }

    public void multv(double c) {
        val *= c;
    }

    public LDouble normal() {
        return new LDouble(Math.signum(val));
    }

    public void normalv() {
        val = Math.signum(val);
    }

    public double magnitude() {
        return val;
    }

    @Override
    public String toString() {
        return "" + val;
    }

    @Override
    public LDouble clone() {
        return new LDouble(this);
    }

    public void setTo(LDouble a) {
        this.val = a.val;
    }
}

