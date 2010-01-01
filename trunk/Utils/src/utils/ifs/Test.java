/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.ifs;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class Test {

    private static Mapping<LVect2d> createRandomMapping() {

        double contractScale = .9;
        double contractOffset = .3;
        return new LinearMapping_v2(
                contractScale*(2*Math.random()-1), contractScale*(2*Math.random()-1), contractOffset*(2*Math.random()-1),
                contractScale*(2*Math.random()-1), contractScale*(2*Math.random()-1), contractOffset*(2*Math.random()-1)
                );
    }

    private static IFSUtil.IFS_v2 makeIFS() {

        IFSUtil.IFS_v2 ifs = new IFSUtil.IFS_v2();

        ifs.addMapping(createRandomMapping(), .333);
        ifs.addMapping(createRandomMapping(), .167);
        ifs.addMapping(createRandomMapping(), .5);

        return ifs;
    }
    private static final int resolution = 500;

    public static void main(String args[]) {

        JFrame frame = new JFrame("IFS Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BufferedImage image = new BufferedImage(resolution, resolution, BufferedImage.TYPE_INT_ARGB);

        render(makeIFS(), image);

        frame.add(new JLabel(new ImageIcon(image)));

        frame.pack();
        frame.setVisible(true);
    }

    public static void render(IFSUtil.IFS_v2 ifs, BufferedImage image) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        Random rand = new Random();

        g.setColor(Color.white);
        g.fillRect(0, 0, resolution, resolution);

        for(int i=0;i<100000;i++) {

            LVect2d v = new LVect2d(2*Math.random()-1, 2*Math.random()-1);
            LVect2d result = ifs.applyRepeatedly(v, 20, rand);

            int xpos = (int) (resolution * (result.x / 2 + .5));
            int ypos = (int) (resolution * (result.y / 2 + .5));

            g.setColor(Color.black);
            g.fillOval(xpos, ypos, 2, 2);
        }
    }
}
