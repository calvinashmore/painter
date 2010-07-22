/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.demo.app;

import fluids.Fluid;
import fluids.Particle;
import javax.swing.JFrame;

/**
 *
 * @author Calvin Ashmore
 */
public class Demo {

    private static final Demo instance = new Demo();
    private Fluid<Particle> fluid;
    private ControlPanel controlPanel;

    public Fluid<Particle> getFluid() {
        return fluid;
    }

    public void setFluid(Fluid<Particle> fluid) {
        this.fluid = fluid;
    }

    public static void main(String args[]) {
        instance.run();
    }

    public static Demo getInstance() {
        return instance;
    }

    private Demo() {
        controlPanelFrame = new JFrame("Particle controls");
        controlPanelFrame.add(controlPanel = new ControlPanel());
        controlPanelFrame.pack();
    }
    private JFrame controlPanelFrame;

    void showControlPanel() {
        controlPanelFrame.setVisible(true);
    }

    private void run() {
        JFrame frame1 = new JFrame("Particle view");
        frame1.add(new DemoPanel());
        frame1.pack();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);

    }

    void resetFluid() {
        fluid = new Fluid<Particle>(.1);
        fluid.setDt(.3);
        controlPanel.applyFluid();
    }
}
