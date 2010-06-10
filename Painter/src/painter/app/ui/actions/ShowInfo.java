/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package painter.app.ui.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import painter.app.ui.InfoWindow;
import painter.app.ui.genview.ProgramFrame;

/**
 *
 * @author Calvin Ashmore
 */
public class ShowInfo extends AbstractAction {

    public ShowInfo() {
        super("Show Info", new ImageIcon(Play.class.getClassLoader().getResource("assets/like.png")));
        putValue(AbstractAction.SHORT_DESCRIPTION, "Shows info for the currently running program");
    }

    public void actionPerformed(ActionEvent e) {
        InfoWindow.getInstance().setVisible(true);

        new ProgramFrame().setVisible(true);
    }

}
