/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview;

import genetic.component.statement.Statement;
import genetic.component.statementlist.StatementList;
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
public class StatementListPanel extends JPanel {

    private StatementList sl;

    public StatementListPanel(StatementList sl) {
        this.sl = sl;

        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        constraints.ipadx = 3;
        constraints.ipady = 3;

        int index = 1;
        for (Statement statement : sl.getStatements()) {

            constraints.gridx = 0;
            constraints.gridy = index - 1;
            constraints.weightx = 0;
            constraints.fill = GridBagConstraints.NONE;
            add(new JLabel("" + index), constraints);

            constraints.gridx = 1;
            constraints.gridy = index - 1;
            constraints.weightx = 1;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            StatementPanel statementPanel = new StatementPanel(statement);
            add(statementPanel, constraints);

            index++;
        }

        setBorder(new CompoundBorder(new EmptyBorder(3, 15, 3, 3), new LineBorder(Color.BLACK, 2)));
    }
}
