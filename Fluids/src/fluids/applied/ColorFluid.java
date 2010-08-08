/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.applied;

import fluids.Fluid;
import fluids.output.ColorIsosurface2;
import fluids.output.IsoRenderer2;
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

        ColorIsosurface2 iso = new ColorIsosurface2();
        iso.setCutoff(.5,.7);
        IsoRenderer2 renderer = new IsoRenderer2(iso, this);
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

        width = Math.max(20,width);
        height = Math.max(20,height);

        BufferedImage image = renderer.createImage(width, height);
        return image;
    }
}
