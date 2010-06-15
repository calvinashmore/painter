/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview;

import genetic.Parameterized;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Calvin Ashmore
 */
public class ParameterPanel extends JPanel {

    private Parameterized component;

    public ParameterPanel(Parameterized component) {
        this.component = component;

        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        add(contentPanel, BorderLayout.WEST);

        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        contentPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.ipadx = 5;
        constraints.ipady = 2;

        for (int i = 0; i < component.getNumberParameters(); i++) {
            constraints.gridy = i;

            constraints.gridx = 0;
            contentPanel.add(new JLabel(component.getParameterType(i).getSimpleName()), constraints);

            constraints.gridx = 1;
            contentPanel.add(new JLabel(component.getParameterName(i)), constraints);

            constraints.gridx = 2;
            contentPanel.add(new JLabel(""+component.getParameter(i)), constraints);
//            add(new JLabel(
//                    component.getParameterType(i).getSimpleName() + " " +
//                    component.getParameterName(i) + " = " + component.getParameter(i)));
        }

        setBorder(new CompoundBorder(new EmptyBorder(1, 1, 1, 1), new LineBorder(Color.BLUE)));
    }
}
