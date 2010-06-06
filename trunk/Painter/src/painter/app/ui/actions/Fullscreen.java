/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import painter.app.ui.PainterView;

/**
 *
 * @author Calvin Ashmore
 */
public class Fullscreen extends AbstractAction {

    public Fullscreen() {
        super("Fullscreen", new ImageIcon(Play.class.getClassLoader().getResource("assets/capture.png")));
        putValue(AbstractAction.SHORT_DESCRIPTION, "Go to fullscreen mode");
    }

    public void actionPerformed(ActionEvent e) {
        PainterView.getInstance().toggleFullscreen();
    }
}
