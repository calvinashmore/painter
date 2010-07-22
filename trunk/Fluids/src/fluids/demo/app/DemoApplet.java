/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fluids.demo.app;

import javax.swing.JApplet;

/**
 *
 * @author Calvin Ashmore
 */
public class DemoApplet extends JApplet {

    public DemoApplet() {
        Demo.getInstance();
        add(new DemoPanel());
    }

    @Override
    public void start() {
    }


}
