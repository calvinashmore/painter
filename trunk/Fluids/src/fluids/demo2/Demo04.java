/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.demo2;

import fluids.Emitter;
import fluids.Fluid;
import fluids.FluidDensityRelaxation;
import fluids.FluidElastics;
import fluids.FluidViscosity;
import fluids.applied.AbsorptionCollisions;
import fluids.applied.CollidableBox;
import fluids.applied.ColorParticle;
import fluids.applied.FieldForces;
import fluids.output.ColorIsosurface;
import fluids.output.IsoRenderer;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import utils.linear.Color;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class Demo04 {

    public static void main(String args[]) {
        new Demo04().doStuff();
    }

    private void doStuff() {

        Fluid<ColorParticle> fluid = new Fluid(.1);
        fluid.setDt(.1);
        fluid.setDensityRelaxation(new FluidDensityRelaxation(10, .004, .01));
        fluid.setForces(new FieldForces(new LVect3d(0, .03, 0)));
        fluid.setViscosity(new FluidViscosity<ColorParticle>(20, 1.5));
        fluid.setElastics(new FluidElastics<ColorParticle>(.1, .1, 0));

        AbsorptionCollisions collisions = new AbsorptionCollisions();
        CollidableBox box = new CollidableBox(new LVect3d(0, 0.5, 0), 20, .50, 20);
        collisions.addCollidable(box);
        collisions.setSlidingFriction(.03);
        collisions.setAbsorptionRate(.1);
        fluid.setCollisions(collisions);

        fluid.addEmitter(new Emitter<ColorParticle>() {

            boolean fired = false;

            @Override
            public List<ColorParticle> emitParticles() {

                if (fired) {
                    return Collections.emptyList();
                }

                fired = true;
                List<ColorParticle> particles = new ArrayList<ColorParticle>();
                Color color1 = new Color(1, .5, 0);
                Color color2 = new Color(0, .5, 1);

                int N = 200;
                for (int i = 0; i < N; i++) {
                    double t = 1.0 * i / N;
                    int M = 1 + (int) (4 *(1-t)* Math.random());
                    for (int j = 0; j < M; j++) {
                        double u = 1.0 * j / M;

                        ColorParticle particle = new ColorParticle();
                        particle.getPosition().x = 2 * (2 * t - 1);
                        particle.getPosition().y = -.5;
                        particle.getPosition().z = 0 + .1 * u;

                        particle.getVelocity().x = .05 * Math.cos(Math.PI * t) + .5 * t;
                        particle.getVelocity().y = .5 + .1 * Math.cos(2 * Math.PI * t + .1 * Math.random() + .3);
                        particle.getVelocity().z = .0 + .05 * Math.sin(2 * Math.PI * 2 * t + .0);

                        particle.setColor(color1.mult(t).add(color2.mult(1 - t)));

                        particles.add(particle);
                    }
                }

                return particles;
            }
        });

        System.out.println("simulating...");
        for (int i = 0; i < 100; i++) {
            fluid.simulateTimestep();
        }

        System.out.println("simulating: done");

        ColorIsosurface iso = new ColorIsosurface();
        iso.setCutoff(.7);
        IsoRenderer renderer = new IsoRenderer(iso, fluid);
        renderer.setTransformation(
                new LVect3d(0, 0, 0),
                new LVect3d(2, 0, 0),
                new LVect3d(0, 0, 0.5));
        renderer.updateBounds();

        System.out.println("rendering...");
        BufferedImage image = renderer.createImage((int) (150 * renderer.getAspectRatio()), (int) (150));
        System.out.println("rendering: done");


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);
    }
}
