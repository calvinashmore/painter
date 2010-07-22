/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.demo.app;

import fluids.Collidable;
import fluids.Emitter;
import fluids.Fluid;
import fluids.Particle;
import fluids.applied.CollidableBox;
import fluids.applied.CollidableSphere;
import fluids.applied.SimpleEmitter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class DisplayPanel extends JPanel {

    public DisplayPanel() {
        setPreferredSize(new Dimension(600, 600));
    }
    private List<Particle> particles = new ArrayList<Particle>();
    private boolean viewTop = false;

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        Fluid<Particle> fluid = Demo.getInstance().getFluid();
        if (fluid == null) {

            // fluid does not yet exist.
            g.setColor(Color.WHITE);
            g.drawString("No fluid yet", 10, 10);

        } else {

            particles.clear();
            particles.addAll(fluid.getAllParticles());

            if (viewTop) {

                // fluid exists, so display.
                //for (Particle particle : fluid.getAllParticles()) {
                for (Particle particle : particles) {
                    double x = getWidth() * (.5 + .5 * particle.getPosition().x);
                    double y = getHeight() * (.5 + .5 * particle.getPosition().z);

                    g.setColor(new Color(1, 1, 1, .5f));
                    g.fillOval((int) x, (int) y, 8, 8);
                }

            } else {

                // fluid exists, so display.
                //for (Particle particle : fluid.getAllParticles()) {
                for (Particle particle : particles) {
                    double x = getWidth() * (.5 + .5 * particle.getPosition().x);
                    double y = getHeight() * (.5 + .5 * particle.getPosition().y);

                    g.setColor(new Color(1, 1, 1, .5f));
                    g.fillOval((int) x, (int) y, 8, 8);
                }

                if (fluid.getCollisions() != null) {
                    for (Collidable collidable : fluid.getCollisions().getCollidables()) {
                        drawCollidable(collidable, g);
                    }
                }

                for (Emitter<Particle> emitter : fluid.getEmitters()) {
                    drawEmitter(emitter, g);
                }
            }
        }
    }

    private void drawEmitter(Emitter<Particle> emitter, Graphics g) {
        if (emitter instanceof SimpleEmitter) {
            SimpleEmitter em = (SimpleEmitter) emitter;
            LVect3d translation = em.getTranslation();

            int x = (int) (getWidth() * (.5 + .5 * translation.x));
            int y = (int) (getHeight() * (.5 + .5 * translation.y));

            g.setColor(Color.red);
            g.drawLine(x - 5, y, x + 5, y);
            g.drawLine(x, y - 5, x, y + 5);
        }
    }

    private void drawCollidable(Collidable collidable, Graphics g) {
        if (collidable instanceof CollidableSphere) {
            CollidableSphere sphere = (CollidableSphere) collidable;

            int irx = (int) (getWidth() * sphere.getRadius());
            int iry = (int) (getHeight() * sphere.getRadius());
            int x = (int) (getWidth() * (.5 + .5 * sphere.getCenter().x) - irx / 2);
            int y = (int) (getHeight() * (.5 + .5 * sphere.getCenter().y) - iry / 2);

            g.fillOval(x, y, irx, iry);

        } else if (collidable instanceof CollidableBox) {
            CollidableBox box = (CollidableBox) collidable;

            int dx = (int) (getWidth() * box.getDx());
            int dy = (int) (getHeight() * box.getDy());

            int x = (int) (getWidth() * (.5 + .5 * box.getCenter().x) - dx / 2);
            int y = (int) (getHeight() * (.5 + .5 * box.getCenter().y) - dy / 2);

            g.fillRect(x, y, dx, dy);
        }
    }

    void setViewTop(boolean selected) {
        this.viewTop = selected;
    }
}
