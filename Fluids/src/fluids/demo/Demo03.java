/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.demo;

import fluids.Fluid;
import fluids.FluidDensityRelaxation;
import fluids.FluidViscosity;
import fluids.applied.BoxEmitter;
import fluids.applied.ColorIsosurface;
import fluids.applied.ColorParticle;
import fluids.applied.FieldForces;
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
public class Demo03 {

    public static void main(String args[]) {
        new Demo03().doStuff();
    }
    private JPanel panel;
    private Fluid<ColorParticle> fluid;

    private void doStuff() {

        fluid = new Fluid(.1);
        fluid.setDt(.1);
        fluid.setDensityRelaxation(new FluidDensityRelaxation(10, .008, .01));
        fluid.setForces(new FieldForces(new LVect3d(0, .07, 0)));
        fluid.setViscosity(new FluidViscosity(1.5, 0.5));

        fluid.addEmitter(new BoxEmitter<ColorParticle>(8, false, new LVect3d(.0, -.5, 0), new LVect3d(-.0, .9, 0), new LVect3d(.04, .1, .01)) {

            @Override
            public ColorParticle constructParticle() {
                return new ColorParticle();
            }
        });

        panel = new DisplayPanel();
        panel.setPreferredSize(new Dimension(600, 600));

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.CENTER);

        JButton button = new JButton("step");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                onAdvance();
            }
        });
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void onAdvance() {
        for (int i = 0; i < 10; i++) {
            fluid.simulateTimestep();
        }

        for (ColorParticle particle : fluid.getAllParticles()) {

            double modifiedIndex = 1.0*particle.getIndex() / 500;
            Color color = Color.makeHSB(modifiedIndex, 1, 1);
            particle.setColor(color);
        }

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
//                g.setColor(new Color(1, 1, 1, .5f));
//                g.fillOval((int) x, (int) y, 8, 8);
//            }

            ColorIsosurface iso = new ColorIsosurface(10, 2);
            for (int i = 0; i < getWidth(); i++) {
                for (int j = 0; j < getHeight(); j++) {

                    double x = 2 * ((double) i / getWidth()) - 1;
                    double y = 2 * ((double) j / getHeight()) - 1;


                    Color color = iso.isofunction(fluid, new LVect3d(x, y, 0));
                    //float cv = (float) Math.min(v, 1.0);
                    int argb = color.toARGB();

                    g.setColor(new java.awt.Color(argb));
                    g.fillRect(i, j, 1, 1);
                }
            }
        }
    }
}
