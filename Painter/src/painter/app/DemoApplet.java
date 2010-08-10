/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app;

import javax.swing.JApplet;
import painter.app.ui.MainView;

/**
 *
 * @author Calvin Ashmore
 */
public class DemoApplet extends JApplet {

    @Override
    public void init() {
        super.init();

        getContentPane().add(new MainView());
    }
}
