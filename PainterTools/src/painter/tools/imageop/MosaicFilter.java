/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.imageop;

import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 *
 * @author Calvin Ashmore
 */
public class MosaicFilter extends SimpleImageOp {

    private int tileSize;

    public MosaicFilter(int tileSize) {
        this.tileSize = tileSize;
    }

    @Override
    public void filterImpl(BufferedImage src, BufferedImage dest) {
        int[] srcRGB = new int[tileSize * tileSize];
        int[] dstRGB = new int[tileSize * tileSize];

        for (int x = 0; x < src.getWidth(); x += tileSize) {
            for (int y = 0; y < src.getHeight(); y += tileSize) {


                int totalR = 0;
                int totalG = 0;
                int totalB = 0;

                // what are OFFSET and SCANSIZE???
                // ALSO: need to make some sort of testing method?!?!?!

                int w = Math.min(tileSize, src.getWidth() - x);
                int h = Math.min(tileSize, src.getHeight() - y);

                src.getRGB(x, y, w, h, srcRGB, 0, w);

                int k = 0;
                for (int i = 0; i < w; i++) {
                    for (int j = 0; j < h; j++) {
                        int rgb = srcRGB[k++];
                        totalR += (rgb & 0x00000000ff) >> 0;
                        totalG += (rgb & 0x000000ff00) >> 8;
                        totalB += (rgb & 0x0000ff0000) >> 16;
                    }
                }

                totalR = (totalR / k) & 0xff;
                totalG = (totalG / k) & 0xff;
                totalB = (totalB / k) & 0xff;

                int averageRGB = (totalR) | (totalG << 8) | (totalB << 16);
                Arrays.fill(dstRGB, averageRGB);

                dest.setRGB(x, y, w, h, dstRGB, 0, w);
            }
        }
    }
}
