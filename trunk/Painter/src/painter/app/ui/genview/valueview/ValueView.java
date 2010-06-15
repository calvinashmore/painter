/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview.valueview;

import javax.swing.JPanel;

/**
 *
 * @author Calvin Ashmore
 */
public class ValueView<ValueType> extends JPanel {

    private ValueType value;

    public ValueView(ValueType value) {
        this.value = value;
    }

    public ValueType getValue() {
        return value;
    }
}
