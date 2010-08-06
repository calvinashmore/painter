/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.output;

import fluids.Fluid;
import fluids.applied.ColorParticle;
import java.awt.image.BufferedImage;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class IsoRenderer2 {

    private ColorIsosurface2 iso;
    private Fluid<ColorParticle> fluid;
    // image is a 2d plane which is the set
    // {x*viewX+y*viewY+viewCenter | x in [-1,1], y in [-1,1]}
    // transforms the 2d image plane into 3d fluid space coordinates.
    private LVect3d viewCenter = new LVect3d();
    private LVect3d viewX = new LVect3d(1, 0, 0);
    private LVect3d viewY = new LVect3d(0, 1, 0);

    public IsoRenderer2(ColorIsosurface2 iso, Fluid<ColorParticle> fluid) {
        this.iso = iso;
        this.fluid = fluid;
    }

    public void setTransformation(LVect3d viewCenter, LVect3d viewX, LVect3d viewY) {
        this.viewCenter = viewCenter;
        this.viewX = viewX;
        this.viewY = viewY;
    }

    public double getAspectRatio() {
        return viewX.magnitude() / viewY.magnitude();
    }

    public void updateBounds() {

        double minX = Double.MAX_VALUE;
        double maxX = -Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxY = -Double.MAX_VALUE;

        LVect3d viewZ = LVect3d.cross(viewX, viewY).normal();
        viewX.normalv();
        viewY.normalv();

        for (ColorParticle particle : fluid.getAllParticles()) {
            LVect3d relativePos = particle.getPosition().sub(viewCenter);
            double zOffset = relativePos.dot(viewZ);
            if (Math.abs(zOffset) > fluid.getInteractionRadius()) {
                continue;
            }

            double x = relativePos.dot(viewX);
            double y = relativePos.dot(viewY);
            if (x < minX) {
                minX = x;
            }
            if (x > maxX) {
                maxX = x;
            }
            if (y < minY) {
                minY = y;
            }
            if (y > maxY) {
                maxY = y;
            }
        }

        LVect3d newViewCenter = viewCenter.add(viewX.mult((maxX + minX) / 2)).add(viewY.mult((maxY + minY) / 2));
        LVect3d newViewX = viewX.mult(0.55 * (maxX - minX));
        LVect3d newViewY = viewY.mult(0.55 * (maxY - minY));

        viewCenter = newViewCenter;
        viewX = newViewX;
        viewY = newViewY;
    }

    public BufferedImage createImage(
            int xRes, int yRes) {
        BufferedImage img = new BufferedImage(xRes, yRes, BufferedImage.TYPE_INT_ARGB);

        for (int ix = 0; ix < xRes; ix++) {
            for (int iy = 0; iy < yRes; iy++) {
                double x = 2.0 * ix / xRes - 1;
                double y = 2.0 * iy / yRes - 1;
                int argb = iso.isofunction(fluid, new LVect3d(
                        viewCenter.x + viewX.x * x + viewY.x * y,
                        viewCenter.y + viewX.y * x + viewY.y * y,
                        viewCenter.z + viewX.z * x + viewY.z * y));
                img.setRGB(ix, iy, argb);
            }
        }
        return img;
    }
}
