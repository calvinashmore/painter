/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.applied;

import fluids.Fluid;
import fluids.output.ColorIsosurface;
import fluids.output.IsoRenderer;
import java.awt.image.BufferedImage;
import utils.linear.LVect3d;

/**
 *
 * @author lccstudent
 */
public class ColorFluid extends Fluid<ColorParticle> {

    public ColorFluid(double interactionRadius) {
        super(interactionRadius);
    }

    public BufferedImage createBasicImage(int imageSize) {

        ColorIsosurface iso = new ColorIsosurface();
        iso.setCutoff(.7);
        IsoRenderer renderer = new IsoRenderer(iso, this);
        renderer.setTransformation(
                new LVect3d(0, 0, 0),
                new LVect3d(1.0, 0, 0),
                new LVect3d(0, 0, 1.0));
        renderer.updateBounds();

        int width, height;
        if(renderer.getAspectRatio() < 1) {
            width = (int)(imageSize*renderer.getAspectRatio());
            height = imageSize;
        } else {
            width = imageSize;
            height = (int)(imageSize/renderer.getAspectRatio());
        }

        BufferedImage image = renderer.createImage(width, height);
        return image;
    }
}
