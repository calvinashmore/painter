/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.tools.imageop;

import java.awt.image.BufferedImage;
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

        img = new MosaicFilter(11).filter(img, null);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(img)));
        frame.pack();
        frame.setVisible(true);
    }
}
