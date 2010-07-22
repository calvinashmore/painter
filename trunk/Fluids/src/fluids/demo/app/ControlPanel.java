/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.demo.app;

import fluids.Fluid;
import fluids.FluidCollisions;
import fluids.FluidDensityRelaxation;
import fluids.FluidElastics;
import fluids.FluidViscosity;
import fluids.Particle;
import fluids.applied.BoxEmitter;
import fluids.applied.CollidableBox;
import fluids.applied.CollidableSphere;
import fluids.applied.FieldForces;
import fluids.applied.SimpleEmitter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class ControlPanel extends JPanel {

    private Map<String, NTextField> fields;
    private Map<String, NCheckBox> checkBoxes;
    private JRadioButton emitterDroplet, emitterSheet, emitterFountain;

    public ControlPanel() {
        fields = new HashMap<String, NTextField>();
        checkBoxes = new HashMap<String, NCheckBox>();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(createDensityPanel());
        add(createViscosityPanel());
        add(createElasticityPanel());
        add(createForcesPanel());
        add(createCollisionsPanel());
        add(createEmittersPanel());
    }

    private Border createControlBorder() {
        return new CompoundBorder(
                new EmptyBorder(2, 2, 2, 2), new CompoundBorder(
                new LineBorder(new Color(128, 128, 128, 128), 1, true),
                new EmptyBorder(2, 2, 2, 2)));
    }

    private class NTextField extends JTextField {

        public NTextField(String name, String text) {
            super(text);
            fields.put(name, this);
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension dim = super.getPreferredSize();
            dim.width = Math.max(dim.width, 50);
            return dim;
        }
    }

    private class NCheckBox extends JCheckBox {

        public NCheckBox(final String name, String label, boolean selected) {
            super(label, selected);
            checkBoxes.put(name, this);

            addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    onCheckBox(name, isSelected());
                }
            });
        }
    }

    private void onCheckBox(String name, boolean enabled) {
        if ("density".equals(name)) {
            fields.get("restDensity").setEnabled(enabled);
            fields.get("stiffness").setEnabled(enabled);
            fields.get("nearStiffness").setEnabled(enabled);
        } else if ("viscosity".equals(name)) {
            fields.get("sigma").setEnabled(enabled);
            fields.get("beta").setEnabled(enabled);
        } else if ("elasticity".equals(name)) {
            fields.get("springTension").setEnabled(enabled);
            fields.get("plasticity").setEnabled(enabled);
            fields.get("yieldRatio").setEnabled(enabled);
        } else if ("gravity".equals(name)) {
            fields.get("gravityForce").setEnabled(enabled);
        } else if ("collisionFloor".equals(name) || "collisionSphereMiddle".equals(name)) {
            boolean either = true;
            if (!checkBoxes.get("collisionSphereMiddle").isSelected() && !checkBoxes.get("collisionFloor").isSelected()) {
                either = false;
            }
            fields.get("slidingFriction").setEnabled(either);
            fields.get("stickDistance").setEnabled(either);
            fields.get("stickForce").setEnabled(either);
        }
    }

    private JPanel createDensityPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(createControlBorder());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.ipadx = 4;
        constraints.ipady = 4;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(new JLabel("Density relaxation"), constraints);

        constraints.gridy++;
        panel.add(new NCheckBox("density", "enabled", true), constraints);

        constraints.gridwidth = 1;

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("rest density: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("restDensity", "10"), constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("stiffness: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("stiffness", ".004"), constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("near stiffness: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("nearStiffness", ".01"), constraints);

        return panel;
    }

    private JPanel createViscosityPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(createControlBorder());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.ipadx = 4;
        constraints.ipady = 4;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(new JLabel("Viscosity"), constraints);

        constraints.gridy++;
        panel.add(new NCheckBox("viscosity", "enabled", false), constraints);

        constraints.gridwidth = 1;

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("sigma: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("sigma", "10"), constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("beta: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("beta", ".5"), constraints);

        return panel;
    }

    private JPanel createElasticityPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(createControlBorder());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.ipadx = 4;
        constraints.ipady = 4;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(new JLabel("Elasticity"), constraints);

        constraints.gridy++;
        panel.add(new NCheckBox("elasticity", "enabled", false), constraints);

        constraints.gridwidth = 1;

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("spring tension: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("springTension", ".3"), constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("plasticity: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("plasticity", ".3"), constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("yield ratio: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("yieldRatio", ".1"), constraints);

        return panel;
    }

    private JPanel createForcesPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(createControlBorder());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.ipadx = 4;
        constraints.ipady = 4;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(new JLabel("Forces"), constraints);

        constraints.gridy++;
        panel.add(new NCheckBox("gravity", "gravity", true), constraints);

        constraints.gridwidth = 1;

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("force: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("gravityForce", ".03"), constraints);

        return panel;
    }

    private JPanel createCollisionsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(createControlBorder());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.ipadx = 4;
        constraints.ipady = 4;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(new JLabel("Collisions"), constraints);

        constraints.gridy++;
        panel.add(new NCheckBox("collisionFloor", "floor", true), constraints);

        constraints.gridy++;
        panel.add(new NCheckBox("collisionSphereMiddle", "sphere in middle", true), constraints);

        constraints.gridwidth = 1;

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("sliding friction: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("slidingFriction", ".3"), constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("stick distance: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("stickDistance", ".1"), constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("stick force: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("stickForce", ".01"), constraints);

        return panel;
    }

    private JPanel createEmittersPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(createControlBorder());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.ipadx = 4;
        constraints.ipady = 4;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(new JLabel("Emitter"), constraints);

        constraints.gridwidth = 1;

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("x position: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("emitterX", ".0"), constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("y position: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("emitterY", "-.8"), constraints);

        constraints.gridwidth = 2;
        ButtonGroup emitterGroup = new ButtonGroup();
//        JRadioButton button;
        constraints.gridx = 0;
        constraints.gridy++;
        panel.add(emitterDroplet = new JRadioButton("droplet", false), constraints);
        emitterGroup.add(emitterDroplet);
        constraints.gridy++;
        panel.add(emitterSheet = new JRadioButton("sheet", false), constraints);
        emitterGroup.add(emitterSheet);
        constraints.gridy++;
        panel.add(emitterFountain = new JRadioButton("fountain", true), constraints);
        emitterGroup.add(emitterFountain);

        constraints.gridwidth = 1;
        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("# particles: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("numberParticles", "200"), constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("x direction: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("emitterXDirection", "0"), constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        panel.add(new JLabel("y direction: "), constraints);
        constraints.gridx = 1;
        panel.add(new NTextField("emitterYDirection", "0"), constraints);

        return panel;
    }

    private double getDouble(String fieldName) {
        String text = fields.get(fieldName).getText();
        try {
            return Double.valueOf(text);
        } catch (NumberFormatException ex) {
            JOptionPane.showInternalMessageDialog(this, "The value " + text + " does not parse as a number", "error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public void applyFluid() {
        Fluid<Particle> fluid = Demo.getInstance().getFluid();

        if (checkBoxes.get("density").isSelected()) {
            double restDensity = getDouble("restDensity");
            double stiffness = getDouble("stiffness");
            double nearStiffness = getDouble("nearStiffness");
            fluid.setDensityRelaxation(new FluidDensityRelaxation<Particle>(restDensity, stiffness, nearStiffness));
        } else {
            fluid.setDensityRelaxation(null);
        }

        if (checkBoxes.get("viscosity").isSelected()) {
            double sigma = getDouble("sigma");
            double beta = getDouble("beta");
            fluid.setViscosity(new FluidViscosity<Particle>(sigma, beta));
        } else {
            fluid.setViscosity(null);
        }

        if (checkBoxes.get("elasticity").isSelected()) {
            double springTension = getDouble("springTension");
            double plasticity = getDouble("plasticity");
            double yieldRatio = getDouble("yieldRatio");
            fluid.setElastics(new FluidElastics<Particle>(springTension, plasticity, yieldRatio));
        } else {
            fluid.setElastics(null);
        }

        if (checkBoxes.get("gravity").isSelected()) {
            double gravityForce = getDouble("gravityForce");
            fluid.setForces(new FieldForces<Particle>(new LVect3d(0, gravityForce, 0)));
        } else {
            fluid.setForces(null);
        }

        if (checkBoxes.get("collisionSphereMiddle").isSelected() || checkBoxes.get("collisionFloor").isSelected()) {

            FluidCollisions collisions = new FluidCollisions();
            if (checkBoxes.get("collisionSphereMiddle").isSelected()) {
                collisions.addCollidable(new CollidableSphere(new LVect3d(0, 0, 0), .25));
            }
            if (checkBoxes.get("collisionFloor").isSelected()) {
                collisions.addCollidable(new CollidableBox(new LVect3d(0, 1.5, 0), 2, .52, 2));
            }
            double slidingFriction = getDouble("slidingFriction");
            double stickDistance = getDouble("stickDistance");
            double stickForce = getDouble("stickForce");
            collisions.setSlidingFriction(slidingFriction);
            collisions.setStickCoefficient(stickForce);
            collisions.setStickDistance(stickDistance);

            fluid.setCollisions(collisions);
        } else {
            fluid.setCollisions(null);
        }

        // emitters
        LVect3d velocity = new LVect3d(getDouble("emitterXDirection"), getDouble("emitterYDirection"), 0);
        LVect3d translation = new LVect3d(getDouble("emitterX"), getDouble("emitterY"), 0);
        LVect3d boxSize = new LVect3d(.1, .1, .1);
        boolean oneShot = true;
        int numberParticles = (int) getDouble("numberParticles");

        if (emitterFountain.isSelected()) {
            oneShot = false;
            numberParticles = 2;
        } else if (emitterSheet.isSelected()) {
            boxSize = new LVect3d(1, 1, .1);
        }

        SimpleEmitter emitter = new BoxEmitter(numberParticles, oneShot, velocity, translation, boxSize) {

            @Override
            public Particle constructParticle() {
                return new Particle();
            }
        };
        fluid.addEmitter(emitter);

    }
}
