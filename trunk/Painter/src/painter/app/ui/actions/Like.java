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
public class Like extends AbstractAction {

    public Like() {
        super("Like", new ImageIcon(Play.class.getClassLoader().getResource("assets/like.png")));
        putValue(AbstractAction.SHORT_DESCRIPTION, "Likes the current program, making its properties more likely to appear");
    }

    public void actionPerformed(ActionEvent e) {
        
    }
}
