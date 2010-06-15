/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview;

import genetic.GeneticComponent;
import genetic.component.expression.Expression;
import genetic.component.statement.Statement;
import genetic.component.statementlist.StatementList;
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
public class StatementPanel extends JPanel {

    private Statement statement;

    public StatementPanel(Statement statement) {
        this.statement = statement;

        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0;
        constraints.ipadx = 3;
        constraints.ipady = 3;

        constraints.gridwidth = 2;
        add(new JLabel(statement.getFunction().getName()), constraints);

        int gridy = 1;
        if (statement.getFunction().getNumberParameters() > 0) {
            constraints.gridy = gridy++;
            add(new ParameterPanel(statement.getFunction()), constraints);
        }

        if (statement.getFunction().getNumberContextVariables() > 0) {
            constraints.gridy = gridy++;
            add(createContextVariablePanel(statement), constraints);
        }

        constraints.gridwidth = 1;
        for (int i = 0; i < statement.getFunction().getNumberInputs(); i++) {

            constraints.gridx = 0;
            constraints.gridy = gridy + i;
            constraints.weightx = 0;
            constraints.fill = GridBagConstraints.NONE;
            String name = statement.getFunction().getInputName(i);
            add(new JLabel(name), constraints);

            constraints.gridx = 1;
            constraints.weightx = 1;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            GeneticComponent input = statement.getInput(i);
            if (input instanceof StatementList) {
                add(new StatementListPanel((StatementList) input), constraints);
            } else if (input instanceof Expression) {
                add(new ExpressionPanel((Expression) input), constraints);
//                add(new VisualNodeView((Expression) input), constraints);
            }

        }
        setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3), new LineBorder(Color.GRAY)));
    }

    private JPanel createContextVariablePanel(Statement statement) {

        JPanel base = new JPanel();
        base.setLayout(new BorderLayout());
        JPanel content = new JPanel();
        base.add(content, BorderLayout.WEST);

        content.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.ipadx = 3;
        constraints.ipady = 3;

        for (int i = 0; i < statement.getFunction().getNumberContextVariables(); i++) {
            constraints.gridy = i;
            constraints.gridx = 0;
            content.add(new JLabel(statement.getFunction().getContextVariableType(i).getSimpleName()), constraints);

            constraints.gridx = 1;
            content.add(new JLabel(statement.getFunction().getContextVariableIntendedName(i)), constraints);
        }

        base.setBorder(new CompoundBorder(new EmptyBorder(1, 1, 1, 1), new LineBorder(Color.RED)));
        return base;
    }
}
