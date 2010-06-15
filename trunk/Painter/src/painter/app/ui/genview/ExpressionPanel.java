/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview;

import genetic.component.expression.Expression;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
    private JButton expandButton;
    private boolean expanded = false;
    private VisualNodeView view;

    public ExpressionPanel(Expression expression) {
        this.expression = expression;

        setLayout(new BorderLayout());
        expandButton = new JButton("+");
        expandButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                onExpand();
            }
        });
        add(expandButton, BorderLayout.WEST);
//        add(new VisualNodeView(expression), BorderLayout.CENTER);
        view = new VisualNodeView(expression);

        setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3), new LineBorder(Color.GREEN)));
//        setBorder(new EmptyBorder(3, 3, 3, 3));
    }

    private void onExpand() {
        if (expanded) {
            // already expanded, so contract
            remove(view);
            expanded = false;
            expandButton.setText("+");
        } else {
            // contracted, so expand
            add(view, BorderLayout.CENTER);
            expanded = true;
            expandButton.setText("-");
        }
    }
}
