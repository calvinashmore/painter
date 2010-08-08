/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.output;

import fluids.Fluid;
import fluids.applied.ColorParticle;
import utils.linear.Color;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class ColorIsosurface2 implements Isofunction<Integer, ColorParticle> {

    private double distanceScale = 10;
    private double radiusMultiplier = 2;
    private double minCutoff = 0;
    private double maxCutoff = 0;

    public void setCutoff(double minCutoff, double maxCutoff) {
        this.minCutoff = minCutoff;
        this.maxCutoff = maxCutoff;
    }

    public ColorIsosurface2(double distanceScale, double radiusMultiplier) {
        this.distanceScale = distanceScale;
        this.radiusMultiplier = radiusMultiplier;
    }

    public ColorIsosurface2() {
    }

    public Integer isofunction(Fluid<ColorParticle> fluid, LVect3d position) {

        double r = 0;
        int samples = 0;
        Color color = new Color();

        for (ColorParticle particle : fluid.getNeighbors(position)) {

            double R = fluid.getInteractionRadius();

            double d = radiusMultiplier * particle.distanceTo(position) / R;
            if (d > 1) {
                continue;
            }
            samples++;

            d = d * d;
            d *= distanceScale;
            //r += 1-d*d;
//            r += Math.exp(1-d*d)*.1;

            double v = (1 / (1 + d) - 1.0 / (1 + distanceScale));
            if (v > 0) {
                r += v;
                color.addv(particle.getColor().mult(v));
            }
        }
        if (r < minCutoff) {
            return 0;
        }

        if (r > 0) {
            color.multv(1.0 / r);
        }
        double alpha = Math.min((r - minCutoff) / (maxCutoff- minCutoff),1);
        int A = (int) (255 * alpha) & 0xff;

        int argb = color.toARGB();
        argb &= A << 24 | 0x00ffffff;

        return argb;
//        return new LDouble(r * scale);
    }
}
