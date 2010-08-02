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
public class ColorIsosurface implements Isofunction<Color, ColorParticle> {

    private double distanceScale = 10;
    private double radiusMultiplier = 2;

    public ColorIsosurface(double distanceScale, double radiusMultiplier) {
        this.distanceScale = distanceScale;
        this.radiusMultiplier = radiusMultiplier;
    }

    public ColorIsosurface() {
    }

    public Color isofunction(Fluid<ColorParticle> fluid, LVect3d position) {

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
        if (r > 0) {
            color.multv(1.0/r);
        }

        return color;
//        return new LDouble(r * scale);
    }
}
