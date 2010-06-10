/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview;

import genetic.component.context.ContextModel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Calvin Ashmore
 */
public class ContextModelPanel extends JPanel {

    private ContextModel cm;

    public ContextModelPanel(ContextModel cm) {
        this.cm = cm;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (String variableName : cm.getMyVariables()) {
            String text = cm.getType(variableName).getSimpleName() + " " + variableName;
            add(new JLabel(text));
        }
    }
}
