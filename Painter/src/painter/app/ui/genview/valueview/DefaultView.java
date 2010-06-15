/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview.valueview;

import javax.swing.JLabel;

/**
 *
 * @author Calvin Ashmore
 */
public class DefaultView extends ValueView<Object> {

    public DefaultView(Object value) {
        super(value);

        add(new JLabel("" + value));
    }
}
