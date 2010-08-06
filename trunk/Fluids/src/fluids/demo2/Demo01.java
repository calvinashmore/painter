/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.demo2;

import fluids.Fluid;
import fluids.FluidCollisions;
import fluids.FluidDensityRelaxation;
import fluids.FluidViscosity;
import fluids.applied.AbsorptionCollisions;
import fluids.applied.BoxEmitter;
import fluids.applied.CollidableBox;
import fluids.applied.ColorParticle;
import fluids.applied.FieldForces;
import fluids.output.ColorIsosurface;
import fluids.output.IsoRenderer;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

    private void doStuff() {

        Fluid<ColorParticle> fluid = new Fluid(.1);
        fluid.setDt(.1);
        fluid.setDensityRelaxation(new FluidDensityRelaxation(10, .01, .002));
        fluid.setForces(new FieldForces(new LVect3d(0, .03, 0)));
        fluid.setViscosity(new FluidViscosity<ColorParticle>(20, 1.5));

        AbsorptionCollisions collisions = new AbsorptionCollisions();
        CollidableBox box = new CollidableBox(new LVect3d(0, 0.5, 0), 2, .50, 2);
        collisions.addCollidable(box);
        collisions.setSlidingFriction(.1);
        collisions.setAbsorptionRate(.007);
        fluid.setCollisions(collisions);

        fluid.addEmitter(new BoxEmitter<ColorParticle>(300, true, new LVect3d(0, .9, 0), new LVect3d(new LVect3d(0, -.5, 0)), new LVect3d(.10, .30, .10)) {

            @Override
            public ColorParticle constructParticle() {
                ColorParticle particle = new ColorParticle();
                particle.setColor(new Color(Math.random(), Math.random(), Math.random()));
                return particle;
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
                new LVect3d(1.0, 0, 0),
                new LVect3d(0, 0, 1.0));
        renderer.updateBounds();


        System.out.println("rendering...");
        BufferedImage image = renderer.createImage((int) (500 * renderer.getAspectRatio()), 500);
        System.out.println("rendering: done");


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);
    }
}
