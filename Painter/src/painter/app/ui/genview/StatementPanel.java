/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview;

import genetic.GeneticComponent;
import genetic.component.expression.Expression;
import genetic.component.statement.Statement;
import genetic.component.statementlist.StatementList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Calvin Ashmore
 */
public class StatementPanel extends JPanel {

    private Statement statement;

    public StatementPanel(Statement statement) {
        this.statement = statement;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel(statement.getFunction().getName()));

        // TODO: Add parameters.

        for (int i = 0; i < statement.getFunction().getNumberInputs(); i++) {

            String name = statement.getFunction().getInputName(i);
            add(new JLabel(name + ": "));

            GeneticComponent input = statement.getInput(i);
            if (input instanceof StatementList) {
                add(new StatementListPanel((StatementList) input));
            } else if (input instanceof Expression) {
                add(new ExpressionPanel((Expression) input));
            }
        }
    }
}
