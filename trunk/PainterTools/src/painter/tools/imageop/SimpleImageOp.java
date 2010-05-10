/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.imageop;

import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;

/**
 *
 * @author Calvin Ashmore
 */
public abstract class SimpleImageOp implements BufferedImageOp {

    private RenderingHints hints;

    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if(dest == null)
            dest = createCompatibleDestImage(src, null);

        filterImpl(src, dest);

        return dest;
    }

    abstract public void filterImpl(BufferedImage src, BufferedImage dest);

    public Rectangle2D getBounds2D(BufferedImage src) {
        return src.getRaster().getBounds();
    }

    public BufferedImage createCompatibleDestImage(BufferedImage src, ColorModel destCM) {
        BufferedImage image;
        if (destCM == null) {
            destCM = src.getColorModel();
        }

        int w = src.getWidth();
        int h = src.getHeight();
        image = new BufferedImage(destCM,
                destCM.createCompatibleWritableRaster(w, h),
                destCM.isAlphaPremultiplied(), null);

        return image;
    }

    public Point2D getPoint2D(Point2D srcPt, Point2D dstPt) {
        if (dstPt == null) {
            dstPt = new Point2D.Float();
        }
	dstPt.setLocation(srcPt.getX(), srcPt.getY());

        return dstPt;
    }

    public RenderingHints getRenderingHints() {
        return hints;
    }
}
