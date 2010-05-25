/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.imageop;

import java.awt.image.Kernel;

/**
 *
 * @author Calvin Ashmore
 */
public abstract class KernelGenerator {

    /**
     * x and y fall within [-1,1]x[-1,1]
     * @param x
     * @param y
     * @return
     */
    abstract public double getValue(double x, double y);

    public Kernel createKernel(int xRes, int yRes) {

        float[] data = new float[xRes * yRes];
        double total = 0;

        for (int ix = 0; ix < xRes; ix++) {
            double x = 2.0 * ix / (xRes - 1) - 1;
            for (int iy = 0; iy < yRes; iy++) {
                double y = 2.0 * iy / (yRes - 1) - 1;

                float value = (float) getValue(x, y);
                if(Float.isNaN(value) || Float.isInfinite(value))
                    //throw new ArithmeticException();
                    value = 0;
                total += value;
                data[ix + iy * xRes] = value;
            }
        }

        // normalize
        if (Math.abs(total) > 1) {
            for (int i = 0; i < data.length; i++) {
                data[i] /= total;
            }
        }

        return new Kernel(xRes, yRes, data);
    }
}
