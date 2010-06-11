/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Calvin Ashmore
 */
public class MainView extends JPanel {

    private static MainView instance;

    public static MainView getInstance() {
        return instance;
    }
    private ControlPanel controlPanel;
    private PainterView painterView;

    public PainterView getPainterView() {
        return painterView;
    }

    public MainView() {
        instance = this;

        setLayout(new BorderLayout());
        add(controlPanel = new ControlPanel(), BorderLayout.SOUTH);
        add(painterView = new PainterView());
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.add(new MainView());
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
