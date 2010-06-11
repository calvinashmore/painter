/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview;

import genetic.component.expression.Expression;
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
public class ExpressionPanel extends JPanel {

    private Expression expression;

    public ExpressionPanel(Expression expression) {
        this.expression = expression;

        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.ipadx = 3;
        constraints.ipady = 3;

        constraints.gridwidth = 2;
        add(new JLabel(expression.getFunction().getClass().getSimpleName()), constraints);

        int gridy = 1;
        if (expression.getFunction().getNumberParameters() > 0) {
            constraints.gridy = gridy++;
            add(new ParameterPanel(expression.getFunction()), constraints);
        }

        constraints.gridwidth = 1;

        for (int i = 0; i < expression.getFunction().getNumberInputs(); i++) {

            constraints.gridx = 0;
            constraints.gridy = gridy + i;
            constraints.fill = GridBagConstraints.NONE;

            String name = expression.getFunction().getInputName(i);
            add(new JLabel(name), constraints);

            constraints.gridx = 1;
            add(new JLabel(""+expression.getCachedInput(i)), constraints);

            constraints.gridx = 2;
            add(new ExpressionPanel(expression.getInput(i)), constraints);
        }

        setBorder(new CompoundBorder(new EmptyBorder(1, 1, 1, 1), new LineBorder(Color.LIGHT_GRAY)));
    }
}
