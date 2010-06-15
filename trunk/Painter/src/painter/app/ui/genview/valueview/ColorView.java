/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview.valueview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Calvin Ashmore
 */
public class ColorView extends ValueView<utils.linear.Color> {

    public ColorView(utils.linear.Color value) {
        super(value);

        setLayout(new BorderLayout());

        JPanel midPanel = new JPanel();
        midPanel.setPreferredSize(new Dimension(50, 50));
        midPanel.setBorder(new LineBorder(Color.BLACK));
        midPanel.setBackground(new Color(value.toARGB()));
        add(midPanel, BorderLayout.CENTER);
        add(new JLabel(value.toString()), BorderLayout.SOUTH);
    }
}
