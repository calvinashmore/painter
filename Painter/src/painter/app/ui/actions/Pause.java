/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import painter.app.ui.MainView;

/**
 *
 * @author Calvin Ashmore
 */
public class Pause extends AbstractAction {

    private static final ImageIcon icon = new ImageIcon(Play.class.getClassLoader().getResource("assets/pause.png"));

    public Pause() {
        super("Pause", icon);
        putValue(AbstractAction.SHORT_DESCRIPTION, "Pauses Painter");
    }

    public void actionPerformed(ActionEvent e) {
        if (MainView.getInstance().getPainterView().isRunning()) {
            MainView.getInstance().getPainterView().stop();
        }
    }
}
