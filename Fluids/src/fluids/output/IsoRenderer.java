/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.output;

import fluids.Fluid;
import fluids.applied.ColorParticle;
import java.awt.image.BufferedImage;
import utils.linear.Color;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class IsoRenderer {

    private ColorIsosurface iso;
    private Fluid<ColorParticle> fluid;
    // image is a 2d plane which is the set
    // {x*viewX+y*viewY+viewCenter | x in [-1,1], y in [-1,1]}
    // transforms the 2d image plane into 3d fluid space coordinates.
    private LVect3d viewCenter = new LVect3d();
    private LVect3d viewX = new LVect3d(1, 0, 0);
    private LVect3d viewY = new LVect3d(0, 1, 0);

    public IsoRenderer(ColorIsosurface iso, Fluid<ColorParticle> fluid) {
        this.iso = iso;
        this.fluid = fluid;
    }

    public void setTransformation(LVect3d viewCenter, LVect3d viewX, LVect3d viewY) {
        this.viewCenter = viewCenter;
        this.viewX = viewX;
        this.viewY = viewY;
    }

    public BufferedImage createImage(
            int xRes, int yRes) {
        BufferedImage img = new BufferedImage(xRes, yRes, BufferedImage.TYPE_INT_ARGB);

        for (int ix = 0; ix < xRes; ix++) {
            for (int iy = 0; iy < yRes; iy++) {
                double x = 2.0 * ix / xRes - 1;
                double y = 2.0 * iy / yRes - 1;
                Color color = iso.isofunction(fluid, new LVect3d(
                        viewCenter.x + viewX.x * x + viewY.x * y,
                        viewCenter.y + viewX.y * x + viewY.y * y,
                        viewCenter.z + viewX.z * x + viewY.z * y));
                img.setRGB(ix, iy, color.toARGB());
            }
        }
        return img;
    }
}
