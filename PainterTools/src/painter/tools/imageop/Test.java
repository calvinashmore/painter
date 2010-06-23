/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.imageop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Calvin Ashmore
 */
public class Test {

    public static void main(String args[]) throws IOException {

        BufferedImage img = ImageIO.read(new File("painterfun.png"));

        //img = new MosaicFilter(5).filter(img, null);

        Kernel kernel = new KernelGenerator() {

            @Override
            public double getValue(double x, double y) {
                //return Math.cos(x*3*Math.PI)*Math.cos(y*2*Math.PI+x*y*2)*(Math.sqrt(x*x+y*y));
                //return Math.cos(x*3*Math.PI);
//                return x*y*y - x*x*y;
                //return 2*x + (y)*(y-1);
                //return 1.0/x;
                return 1.0/(x*Math.cos(1.3) + y*Math.sin(1.3));
            }
        }.createKernel(15, 15);

//        float[] data = kernel.getKernelData(null);
//        for (float f : data) {
//            System.out.println("  "+f);
//        }

        ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        BufferedImage newImg = op.filter(img, null);


        BufferedImage myImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        Graphics g = myImage.getGraphics();

        g.drawImage(img, 0, 0, null);
        g.setClip(new java.awt.geom.Ellipse2D.Double(0, 0, 400, 400));
        g.drawImage(newImg, 0, 0, null);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(myImage)));
        frame.pack();
        frame.setVisible(true);
    }
}
