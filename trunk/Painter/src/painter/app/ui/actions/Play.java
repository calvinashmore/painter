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
public class Play extends AbstractAction {

    private static final ImageIcon icon = new ImageIcon(Play.class.getClassLoader().getResource("assets/play.png"));

    public Play() {
        super("Play", icon);
        putValue(AbstractAction.SHORT_DESCRIPTION, "Resumes play");
    }

    public void actionPerformed(ActionEvent e) {
        if (!MainView.getInstance().getPainterView().isRunning()) {
            MainView.getInstance().getPainterView().start();
        }
    }
}
