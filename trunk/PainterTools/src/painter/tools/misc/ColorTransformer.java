/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.misc;

import java.awt.image.LookupTable;

/**
 *
 * @author Calvin Ashmore
 */
public abstract class ColorTransformer {

    private double hsb[] = new double[3];
    private int tmp[] = new int[3];

    public abstract void transformPixel(int[] src, int[] dst);

    protected double[] toHSB(int[] rgbSrc) {

        double hue, saturation, brightness;
        double r = (double) rgbSrc[0] / 255;
        double g = (double) rgbSrc[1] / 255;
        double b = (double) rgbSrc[2] / 255;

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
        hsb[0] = hue;
        hsb[1] = saturation;
        hsb[2] = brightness;
        return hsb;
    }

    protected int[] toRGB(double[] hsbSrc, int[] rgbDst) {

        double hue = hsbSrc[0];
        double saturation = hsbSrc[0];
        double brightness = hsbSrc[0];

        double r = 0, g = 0, b = 0;

        if (saturation == 0) {
            r = g = b = (brightness * 1.0f + 0.5f);
        } else {
            double h = (hue - Math.floor(hue)) * 6.0f;
            double f = h - java.lang.Math.floor(h);
            double p = brightness * (1.0f - saturation);
            double q = brightness * (1.0f - saturation * f);
            double t = brightness * (1.0f - (saturation * (1.0f - f)));
            switch ((int) h) {
                case 0:
                    r = (brightness * 1.0f + 0.5f);
                    g = (t * 1.0f + 0.5f);
                    b = (p * 1.0f + 0.5f);
                    break;
                case 1:
                    r = (q * 1.0f + 0.5f);
                    g = (brightness * 1.0f + 0.5f);
                    b = (p * 1.0f + 0.5f);
                    break;
                case 2:
                    r = (p * 1.0f + 0.5f);
                    g = (brightness * 1.0f + 0.5f);
                    b = (t * 1.0f + 0.5f);
                    break;
                case 3:
                    r = (p * 1.0f + 0.5f);
                    g = (q * 1.0f + 0.5f);
                    b = (brightness * 1.0f + 0.5f);
                    break;
                case 4:
                    r = (t * 1.0f + 0.5f);
                    g = (p * 1.0f + 0.5f);
                    b = (brightness * 1.0f + 0.5f);
                    break;
                case 5:
                    r = (brightness * 1.0f + 0.5f);
                    g = (p * 1.0f + 0.5f);
                    b = (q * 1.0f + 0.5f);
                    break;
            }
        }

        rgbDst[0] = (int) (255 * r);
        rgbDst[1] = (int) (255 * g);
        rgbDst[2] = (int) (255 * b);
        return rgbDst;
    }

    public LookupTable createLookup() {
        return new LookupTable(0, 4) {
            public int[] lookupPixel(int[] src, int[] dst) {
                if (dst == null) {
                    // Need to alloc a new destination array
                    dst = new int[src.length];
                }

                transformPixel(src, tmp);

                float alpha = 1;
                if(src.length >= 4) {
                    dst[3] = src[3];
                    alpha = src[3]/255f;
                }
                dst[0] = (int)(tmp[0]*alpha + (1-alpha)*src[0]);
                dst[1] = (int)(tmp[1]*alpha + (1-alpha)*src[1]);
                dst[2] = (int)(tmp[2]*alpha + (1-alpha)*src[2]);
                return dst;
            }
        };
    }
}
