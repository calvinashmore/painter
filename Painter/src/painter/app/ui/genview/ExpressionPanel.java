/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview;

import genetic.component.expression.Expression;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Calvin Ashmore
 */
public class ExpressionPanel extends JPanel {

    private Expression expression;

    public ExpressionPanel(Expression expression) {
        this.expression = expression;

        add(new JLabel(expression.getFunction().getClass().getSimpleName()));
    }
}
