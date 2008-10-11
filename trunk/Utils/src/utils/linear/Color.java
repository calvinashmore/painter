/*
 * Color.java
 *
 * Created on September 23, 2005, 10:54 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package utils.linear;

// use simple public access for now
/**
 *
 * @author gtg126z
 */
public class Color implements Linear<Color> {

    public static Color makeHSB(double hue, double saturation, double brightness) {

        Color c = new Color();
        if (saturation == 0) {
            c.r = c.g = c.b = (brightness * 1.0f + 0.5f);
        } else {
            double h = (hue - Math.floor(hue)) * 6.0f;
            double f = h - java.lang.Math.floor(h);
            double p = brightness * (1.0f - saturation);
            double q = brightness * (1.0f - saturation * f);
            double t = brightness * (1.0f - (saturation * (1.0f - f)));
            switch ((int) h) {
                case 0:
                    c.r = (brightness * 1.0f + 0.5f);
                    c.g = (t * 1.0f + 0.5f);
                    c.b = (p * 1.0f + 0.5f);
                    break;
                case 1:
                    c.r = (q * 1.0f + 0.5f);
                    c.g = (brightness * 1.0f + 0.5f);
                    c.b = (p * 1.0f + 0.5f);
                    break;
                case 2:
                    c.r = (p * 1.0f + 0.5f);
                    c.g = (brightness * 1.0f + 0.5f);
                    c.b = (t * 1.0f + 0.5f);
                    break;
                case 3:
                    c.r = (p * 1.0f + 0.5f);
                    c.g = (q * 1.0f + 0.5f);
                    c.b = (brightness * 1.0f + 0.5f);
                    break;
                case 4:
                    c.r = (t * 1.0f + 0.5f);
                    c.g = (p * 1.0f + 0.5f);
                    c.b = (brightness * 1.0f + 0.5f);
                    break;
                case 5:
                    c.r = (brightness * 1.0f + 0.5f);
                    c.g = (p * 1.0f + 0.5f);
                    c.b = (q * 1.0f + 0.5f);
                    break;
            }
        }
        return c;

    /*
    double h = hue % 1.0;
    double s = Math.min(Math.max(saturation, 0), 1);
    double v = brightness;
    
    double f = h*6 - (int)(h*6);
    
    double p = v*(1.0-s);
    double q = v*(1.0-s*f);
    double t = v*(1.0-s*(1.0-f));
    
    if(h < 1.0/6)
    return new Color(q,v,p);
    else if(h < 2.0/6)
    return new Color(p,v,t);
    else if(h < 3.0/6)
    return new Color(p,q,v);
    else if(h < 4.0/6)
    return new Color(t,p,v);
    else if(h < 5.0/6)
    return new Color(v,p,q);
    else
    return new Color(v,t,p);
     */
    }

    public double[] hsbvals() {

        double hue, saturation, brightness;

        double[] hsbvals = new double[3];

        double cmax = (r > g) ? r : g;
        if (b > cmax) {
            cmax = b;
        }
        double cmin = (r < g) ? r : g;
        if (b < cmin) {
            cmin = b;
        }
        brightness = cmax;
        if (cmax != 0) {
            saturation = ((cmax - cmin)) / (cmax);
        } else {
            saturation = 0;
        }
        if (saturation == 0) {
            hue = 0;
        } else {
            double redc = ((cmax - r)) / ((cmax - cmin));
            double greenc = ((cmax - g)) / ((cmax - cmin));
            double bluec = ((cmax - b)) / ((cmax - cmin));
            if (r == cmax) {
                hue = bluec - greenc;
            } else if (g == cmax) {
                hue = 2.0f + redc - bluec;
            } else {
                hue = 4.0f + greenc - redc;
            }
            hue = hue / 6.0f;
            if (hue < 0) {
                hue = hue + 1.0f;
            }
        }
        hsbvals[0] = hue;
        hsbvals[1] = saturation;
        hsbvals[2] = brightness;
        return hsbvals;
    }

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

    /** Creates a new instance of Color */
    public Color() {
        r = 0;
        g = 0;
        b = 0;
    }

    public Color(Color col) {
        this.r = col.r;
        this.g = col.g;
        this.b = col.b;
    }

    public Color(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color(LDouble r, LDouble g, LDouble b) {
        this.r = r.val;
        this.g = g.val;
        this.b = b.val;
    }

    public int toARGB() {

        int A = 255;
        int R = Math.max(Math.min((int) (r * 255), 255), 0);
        int G = Math.max(Math.min((int) (g * 255), 255), 0);
        int B = Math.max(Math.min((int) (b * 255), 255), 0);

        return (A << 24) + (R << 16) + (G << 8) + (B);
    }

    public static Color fromRGB(int rgb) {
        int R = (rgb >> 16) & 0xff;
        int G = (rgb >> 8) & 0xff;
        int B = (rgb >> 0) & 0xff;

        return new Color((double) R / 255, (double) G / 255, (double) B / 255);
    }

    public Color zero() {
        return new Color();
    }

    public Color add(Color a) {
        return new Color(r + a.r, g + a.g, b + a.b);
    }

    public void addv(Color a) {
        r += a.r;
        g += a.g;
        b += a.b;
    }

    public Color sub(Color a) {
        return new Color(r - a.r, g - a.g, b - a.b);
    }

    public void subv(Color a) {
        r -= a.r;
        g -= a.g;
        b -= a.b;
    }

    public Color mult(double c) {
        return new Color(c * r, c * g, c * b);
    }

    public void multv(double c) {
        r *= c;
        g *= c;
        b *= c;
    }

    public Color normal() {
        double m = 1.0 / magnitude();
        return new Color(m * r, m * g, m * b);
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
    public Color clone() {
        return new Color(this);
    }
}
