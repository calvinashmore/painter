/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview;

import genetic.component.statement.Statement;
import genetic.component.statementlist.StatementList;
import java.awt.Color;
import javax.swing.BoxLayout;
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

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (Statement statement : sl.getStatements()) {
            StatementPanel statementPanel = new StatementPanel(statement);
            add(statementPanel);
        }

        setBorder(new CompoundBorder(new EmptyBorder(3, 15, 3, 3), new LineBorder(Color.BLACK)));
    }
}
