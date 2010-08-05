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
public class Demo03 {

    public static void main(String args[]) {
        new Demo03().doStuff();
    }

    private void doStuff() {
        final Random random = new Random(123456);


        Fluid<ColorParticle> fluid = new Fluid(.1);
        fluid.setDt(.1);
        fluid.setDensityRelaxation(new FluidDensityRelaxation(10, .004, .01));
        fluid.setForces(new FieldForces(new LVect3d(0, .03, 0)));
//        fluid.setViscosity(new FluidViscosity<ColorParticle>(20, 1.5));

        AbsorptionCollisions collisions = new AbsorptionCollisions();
        CollidableBox box = new CollidableBox(new LVect3d(0, 0.5, 0), 2, .50, 2);
        collisions.addCollidable(box);
        collisions.setSlidingFriction(.03);
        collisions.setAbsorptionRate(.1);
        fluid.setCollisions(collisions);

        fluid.addEmitter(new BoxEmitter<ColorParticle>(200, true, new LVect3d(.4, .5, 0), new LVect3d(new LVect3d(-1.25, -.5, 0)), new LVect3d(.10, .10, .10)){

            @Override
            public ColorParticle constructParticle() {
                ColorParticle particle = new ColorParticle();
                //particle.setColor(new Color(random.nextDouble(), Math.random(), Math.random()));
                particle.setColor(new Color(0, 0, 1));
                return particle;
            }
        });

        System.out.println("simulating...");
        for (int i = 0; i < 30; i++) {
            fluid.simulateTimestep();
        }

        fluid.addEmitter(new BoxEmitter<ColorParticle>(200, true, new LVect3d(.4, .5, 0), new LVect3d(new LVect3d(-1.25, -.5, 0)), new LVect3d(.10, .10, .10)){

            @Override
            public ColorParticle constructParticle() {
                ColorParticle particle = new ColorParticle();
                particle.setColor(new Color(1, 1, 1));
                return particle;
            }
        });
        for (int i = 0; i < 70; i++) {
            fluid.simulateTimestep();
        }

        System.out.println("simulating: done");

        ColorIsosurface iso = new ColorIsosurface();
        iso.setCutoff(.7);
        IsoRenderer renderer = new IsoRenderer(iso, fluid);
        renderer.setTransformation(
                new LVect3d(.25, 0, 0),
                new LVect3d(1.5, 0, 0),
                new LVect3d(0, 0, 0.75));

        System.out.println("rendering...");
        BufferedImage image = renderer.createImage((int) (500 * 1.5), (int) (500 * 0.75));
        System.out.println("rendering: done");


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);
    }
}
