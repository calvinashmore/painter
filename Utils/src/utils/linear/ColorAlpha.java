/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils.linear;

/**
 * Similar to the color class but includes alpha values.
 * @author Calvin Ashmore
 */
public class ColorAlpha {


    @Override
    public String toString() {
        return "< " + r + " , " + g + " , " + b + " >";
    }

    public static Color parse(String s) {
        s = s.replaceAll("[<> ]", "");
        String sa[] = s.split(",");
        return new Color(
                Double.parseDouble(sa[0]),
                Double.parseDouble(sa[1]),
                Double.parseDouble(sa[2]));
    }
    public double r;
    public double g;
    public double b;
    public double a;

    /** Creates a new instance of Color */
    public ColorAlpha() {
        r = 0;
        g = 0;
        b = 0;
        a = 1;
    }

    public ColorAlpha(Color col) {
        this.r = col.r;
        this.g = col.g;
        this.b = col.b;
        this.a = 1;
    }

    public ColorAlpha(ColorAlpha col) {
        this.r = col.r;
        this.g = col.g;
        this.b = col.b;
        this.a = col.a;
    }

    public ColorAlpha(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 1;
    }

    public ColorAlpha(double r, double g, double b, double a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public int toARGB() {

        int A = Math.max(Math.min((int) (a * 255), 255), 0);
        int R = Math.max(Math.min((int) (r * 255), 255), 0);
        int G = Math.max(Math.min((int) (g * 255), 255), 0);
        int B = Math.max(Math.min((int) (b * 255), 255), 0);

        return (A << 24) + (R << 16) + (G << 8) + (B);
    }

    public static ColorAlpha fromRGB(int rgba) {
        int A = (rgba >> 24) & 0xff;
        int R = (rgba >> 16) & 0xff;
        int G = (rgba >> 8) & 0xff;
        int B = (rgba >> 0) & 0xff;

        return new ColorAlpha((double) R / 255, (double) G / 255, (double) B / 255, (double) A / 255);
    }

    public ColorAlpha zero() {
        return new ColorAlpha();
    }

    public ColorAlpha add(ColorAlpha color) {
        return new ColorAlpha(r + color.r, g + color.g, b + color.b, a + color.a);
    }

    public void addv(ColorAlpha color) {
        r += color.r;
        g += color.g;
        b += color.b;
        //a += color.a;
        a += color.a;
    }

    public ColorAlpha sub(ColorAlpha color) {
        return new ColorAlpha(r - color.r, g - color.g, b - color.b, a - color.a);
    }

    public void subv(ColorAlpha color) {
        r -= color.r;
        g -= color.g;
        b -= color.b;
        a -= color.a;
    }

    public ColorAlpha mult(double c) {
        return new ColorAlpha(c * r, c * g, c * b, a);
    }

    public void multv(double c) {
        r *= c;
        g *= c;
        b *= c;
        // a is unchanged.
    }

    public ColorAlpha normal() {
        double m = 1.0 / magnitude();
        return new ColorAlpha(m * r, m * g, m * b, a);
    }

    public void normalv() {
        double m = 1.0 / magnitude();
        r *= m;
        g *= m;
        b *= m;
    }

    public double magnitude() {
        return Math.max(Math.abs(r), Math.max(Math.abs(g), Math.abs(b)));
    }

    @Override
    public ColorAlpha clone() {
        return new ColorAlpha(this);
    }

    public void setTo(ColorAlpha color) {
        this.r = color.r;
        this.g = color.g;
        this.b = color.b;
        this.a = color.a;
    }
}
