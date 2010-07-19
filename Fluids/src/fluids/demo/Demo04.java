/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.demo;

import fluids.Fluid;
import fluids.FluidCollisions;
import fluids.FluidDensityRelaxation;
import fluids.Particle;
import fluids.applied.BoxEmitter;
import fluids.applied.CollidableBox;
import fluids.applied.CollidableSphere;
import fluids.applied.FieldForces;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class Demo04 {

    public static void main(String args[]) {
        new Demo04().doStuff();
    }
    private JPanel panel;
    private Fluid<Particle> fluid;
    private CollidableSphere sphere;

    private void doStuff() {

        fluid = new Fluid(.1);
        fluid.setDt(.2);
        fluid.setDensityRelaxation(new FluidDensityRelaxation());
        fluid.setForces(new FieldForces(new LVect3d(0, .07, 0)));

        FluidCollisions collisions = new FluidCollisions();
        CollidableBox box = new CollidableBox(new LVect3d(0, 1.5, 0), 2, .52, 2);
        sphere = new CollidableSphere(new LVect3d(.5, -.5, 0), .25);
        collisions.addCollidable(box);
        collisions.addCollidable(sphere);
//        collisions.setStickCoefficient(.1);
//        collisions.setStickDistance(.03);
        fluid.setCollisions(collisions);

        fluid.addEmitter(new BoxEmitter<Particle>(5, false, new LVect3d(.18, -.35, 0), new LVect3d(-.9, .0, 0), new LVect3d(.05, .05, .01)) {

            @Override
            public Particle constructParticle() {
                return new Particle();
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
                onAdvance(fluid);
            }
        });
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void onAdvance(Fluid fluid) {
        for (int i = 0; i < 2; i++) {
            fluid.simulateTimestep();
        }
        panel.repaint();
    }

    private class DisplayPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());

            for (Particle particle : fluid.getAllParticles()) {
                double x = getWidth() * (.5 + .5 * particle.getPosition().x);
                double y = getHeight() * (.5 + .5 * particle.getPosition().y);

                g.setColor(new Color(1, 1, 1, .5f));
                g.fillOval((int) x, (int) y, 8, 8);
            }


            int ir = (int) (getWidth() * sphere.getRadius());
            int x = (int) (getWidth() * (.5 + .5 * sphere.getCenter().x) - ir/2);
            int y = (int) (getHeight() * (.5 + .5 * sphere.getCenter().y) - ir/2);

            g.fillOval(x, y, ir, ir);

//            BasicIsosurface iso = new BasicIsosurface(10, .6, 2);
//            for (int i = 0; i < getWidth(); i++) {
//                for (int j = 0; j < getHeight(); j++) {
//
//                    double x = 2 * ((double) i / getWidth()) - 1;
//                    double y = 2 * ((double) j / getHeight()) - 1;
//                    double v = iso.isofunction(fluid, new LVect3d(x, y, 0)).val;
//
//                    float cv = (float) Math.min(v, 1.0);
//
//                    g.setColor(new java.awt.Color(cv, cv, cv));
//                    g.fillRect(i, j, 1, 1);
//                }
//            }
        }
    }
}
