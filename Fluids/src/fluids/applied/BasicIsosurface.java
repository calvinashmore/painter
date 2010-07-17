/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.applied;

import fluids.Fluid;
import fluids.Isofunction;
import fluids.Particle;
import utils.linear.LDouble;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class BasicIsosurface implements Isofunction<LDouble, Particle> {

    private double distanceScale = 10;
    private double scale = .3;
    private double radiusMultiplier = 2;

    public BasicIsosurface(double distanceScale, double scale, double radiusMultiplier) {
        this.distanceScale = distanceScale;
        this.scale = scale;
        this.radiusMultiplier = radiusMultiplier;
    }

    public BasicIsosurface() {
    }

    public LDouble isofunction(Fluid<Particle> fluid, LVect3d position) {

        double r = 0;
        int samples = 0;

        for (Particle particle : fluid.getNeighbors(position)) {

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
            }
        }
        if (samples > 0) {
            r = Math.sqrt(r);
        }
        return new LDouble(r * scale);
    }
}
