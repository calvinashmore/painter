/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.curves.derahm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import utils.linear.Complex;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


        CesaroFunction c = new CesaroFunction(new Complex(.6, -.37));
        KochPeanoFunction c2 = new KochPeanoFunction(new Complex(.4, .2));
        GeneralAffineFunction c3 = new GeneralAffineFunction(.5,.3,-.4,.05,.4,.4);
        DeRahmCurve<Complex> curve = new DeRahmCurve<Complex>(c2);
        DeRahmCurve<LVect2d> curve2 = new DeRahmCurve<LVect2d>(c3);

        BufferedImage img = new BufferedImage(1000, 750, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.black);

        int N = 10000;
        for(int i=0;i<N;i++) {
            double d = ((double)i)/N;
//            Complex value = curve.getValue(d);
            LVect2d value = curve2.getValue(d);

            int x,y;
            x = (int) (250 + 500 * value.x);
            y = (int) (250 + 500 * value.y);

//            g.drawLine(x, y, x, y);
            g.fillOval(x, y, 2, 2);

//            System.out.println(value);
//            System.out.println(x+", "+y);
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(img)));
        frame.pack();
        frame.setVisible(true);

//        getBit(1, 0);
//
//        for(int i=0;i<10;i++)
//            toast(Math.random());
    }
//
//    private static void toast(double d) {
//        for (int i = 0; i < 53; i++) {
//            if (d < .5) {
//                System.out.print(0);
//                d *= 2;
//            } else {
//                System.out.print(1);
//                d -= .5;
//                d *= 2;
//            }
//        }
//        System.out.println();
//    }
//
//
//
//    private static int getBit(double v, int place) {
//        long l = Double.doubleToLongBits(v);
//        // 0xfff0000000000000
//        long exponent = (l & 0x7ff0000000000000L) >> 52;
//        long mantissa = l &  0x000fffffffffffffL;
//
//        System.out.println(exponent);
//        System.out.println(Long.toBinaryString(0x7ff));
//        System.out.println(Long.toBinaryString(exponent));
//        System.out.println(Long.toBinaryString(0x000fffffffffffffL));
//        System.out.println(Long.toBinaryString(mantissa));
//
//        return -1;
//    }
}
