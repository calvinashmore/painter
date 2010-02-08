/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

/**
 *
 * @author Calvin Ashmore
 */
public class Capture extends AbstractAction {

    public Capture() {
        super("Capture", new ImageIcon(Play.class.getClassLoader().getResource("assets/capture.png")));
        putValue(AbstractAction.SHORT_DESCRIPTION, "Captures and saves the current image");
    }

    public void actionPerformed(ActionEvent e) {
        
    }
}
