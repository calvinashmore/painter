/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.demo;

import fluids.Fluid;
import fluids.FluidDensityRelaxation;
import fluids.Particle;
import fluids.applied.ColorIsosurface;
import fluids.applied.ColorParticle;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import utils.linear.Color;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class Demo01 {

    public static void main(String args[]) {
        new Demo01().doStuff();
    }
    private JPanel panel;
    private Fluid<ColorParticle> fluid;

    private void doStuff() {

        fluid = new Fluid(.1);
        fluid.setDt(1);
        //fluid.setDensityRelaxation(new FluidDensityRelaxation());
        fluid.setDensityRelaxation(new FluidDensityRelaxation(10, .004, .05));

        for (int i = 0; i < 2000; i++) {

            ColorParticle particle = new ColorParticle();
            particle.getPosition().x = 1 * (2 * Math.random() - 1);
            particle.getPosition().y = 1 * (2 * Math.random() - 1);
            particle.getPosition().z = .01 * (2 * Math.random() - 1);

            float v = (float) ((particle.getPosition().x + 1) / 2);
            //Color c = new Color(v, (float) Math.random(), 1 - v);
            Color c = new Color(v, .5f, 1 - v);
            particle.setColor(c);

            fluid.addParticle(particle);
        }

        panel = new DisplayPanel();
        panel.setPreferredSize(new Dimension(600, 600));

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.CENTER);

        JButton button = new JButton("step");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                onAdvance(fluid);
            }
        });
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void onAdvance(Fluid fluid) {
        fluid.simulateTimestep();
        panel.repaint();
    }

    private class DisplayPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
//            g.setColor(Color.BLACK);
//            g.fillRect(0, 0, getWidth(), getHeight());
//
//            for (Particle particle : fluid.getAllParticles()) {
//                double x = getWidth() * (.5 + .5 * particle.getPosition().x);
//                double y = getHeight() * (.5 + .5 * particle.getPosition().y);
//
//                PaintParticle p = (PaintParticle) particle;
////                g.setColor(new Color(1, 1, 1, .2f));
//                g.setColor(p.getColor());
//
//                g.fillOval((int) x, (int) y, 8, 8);
//            }

//            BasicIsosurface iso = new BasicIsosurface();// = new BasicIsosurface(fluid);
//            for (int i = 0; i < getWidth(); i++) {
//                for (int j = 0; j < getHeight(); j++) {
//
//                    double x = 2 * ((double) i / getWidth()) - 1;
//                    double y = 2 * ((double) j / getHeight()) - 1;
//                    double v = iso.isofunction(fluid, new LVect3d(x, y, 0)).val;
//
//                    float cv = (float) Math.min(v, 1.0);
//
//                    g.setColor(new Color(cv, cv, cv));
//                    g.fillRect(i, j, 1, 1);
//                }
//            }

            ColorIsosurface iso = new ColorIsosurface(15, 3);
            for (int i = 0; i < getWidth(); i++) {
                for (int j = 0; j < getHeight(); j++) {

                    double x = 2 * ((double) i / getWidth()) - 1;
                    double y = 2 * ((double) j / getHeight()) - 1;

                    Color v = iso.isofunction(fluid, new LVect3d(x, y, 0));

                    g.setColor(new java.awt.Color((float) v.r, (float) v.g, (float) v.b));
                    g.fillRect(i, j, 1, 1);
                }
            }
        }
    }
}
