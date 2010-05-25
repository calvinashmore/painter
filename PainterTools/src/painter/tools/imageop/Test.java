/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.imageop;

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
//        img = new SmoothConvolution(4) {
//
//            @Override
//            public double getCoefficient(double x, double y) {
//                return Math.cos(x*y*Math.PI*.98);
//            }
//        }.filter(img, null);

//        Kernel kernel = new Kernel(5, 5, new float[]{
//                    0.0f, 0.3f, 0.5f, 0.3f, 0.0f,
//                    0.3f, 0.5f, 0.1f, 0.5f, 0.3f,
//                    0.5f, 0.1f, -1.0f, 0.1f, 0.5f,
//                    0.3f, 0.5f, 0.1f, 0.5f, 0.3f,
//                    0.0f, 0.3f, 0.5f, 0.3f, 0.0f,});
        Kernel kernel = new KernelGenerator() {

            @Override
            public double getValue(double x, double y) {
                //return Math.cos(x*3*Math.PI)*Math.cos(y*2*Math.PI+x*y*2)*(Math.sqrt(x*x+y*y));
                //return Math.cos(x*3*Math.PI);
//                return x*y*y - x*x*y;
                //return 2*x + (y)*(y-1);
                return 1.0/x;
            }
        }.createKernel(5, 20);

//        float[] data = kernel.getKernelData(null);
//        for (float f : data) {
//            System.out.println("  "+f);
//        }

        //System.out.println(kernel);
        ConvolveOp op = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        img = op.filter(img, null);
        img = op.filter(img, null);
        img = op.filter(img, null);
        img = op.filter(img, null);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(img)));
        frame.pack();
        frame.setVisible(true);
    }
}
