/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package painter.app.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import painter.app.ui.actions.Capture;
import painter.app.ui.actions.Fullscreen;
import painter.app.ui.actions.Pause;
import painter.app.ui.actions.Play;
import painter.app.ui.actions.ShowInfo;

/**
 *
 * @author Calvin Ashmore
 */
public class ControlPanel extends JPanel {

    private JButton playPause;
//    private JButton skip;
//    private JButton like;
//    private JButton dislike;
    private JButton capture;
    private JButton showInfo;
    private JButton fullscreen;

    public ControlPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        add(playPause = new JButton(new Play()));
        //add(skip = new JButton(new Skip()));
//        add(like = new JButton(new Like()));
//        add(dislike = new JButton(new Dislike()));
        add(capture = new JButton(new Capture()));
        add(capture = new JButton(new ShowInfo()));
        add(fullscreen = new JButton(new Fullscreen()));

        playPause.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                onPlayPause();
            }
        });
    }

    private void onPlayPause() {

        if(playPause.getAction() instanceof Pause) {
            playPause.setAction(new Play());
        } else {
            playPause.setAction(new Pause());
        }

        //System.out.println("playPause: isrunning: "+ MainView.getInstance().getPainterView().isRunning());
//        if(MainView.getInstance().getPainterView().isRunning()) {
//            playPause.setAction(new Pause());
//        } else {
//            playPause.setAction(new Play());
//        }
    }
}
