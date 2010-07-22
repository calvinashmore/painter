/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fluids.demo.app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author Calvin Ashmore
 */
public class DemoPanel extends JPanel {

    private DisplayPanel display;
    private JButton play, stop;
    private ScheduledExecutorService executor;
//    private boolean isRunning = false;

    public DemoPanel() {
        setLayout(new BorderLayout());

        add(display = new DisplayPanel(), BorderLayout.CENTER);

        JPanel controls = new JPanel();
        add(controls, BorderLayout.SOUTH);


        play = new JButton("play");
        controls.add(play);
        play.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                onPlay();
            }
        });

        stop = new JButton("stop");
        controls.add(stop);
        stop.setEnabled(false);
        stop.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                onStop();
            }
        });

        JButton settings = new JButton("settings");
        controls.add(settings);
        settings.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Demo.getInstance().showControlPanel();
            }
        });
 
        final JCheckBox viewTop = new JCheckBox("view top");
        controls.add(viewTop);
        viewTop.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                display.setViewTop(viewTop.isSelected());
                display.repaint();
            }
        });
    }

    private void onPlay() {
        stop.setEnabled(true);
        play.setEnabled(false);
//        isRunning = true;

        setupFluid();

        executor = new ScheduledThreadPoolExecutor(1);
        executor.scheduleAtFixedRate(new Runnable() {

            public void run() {
                timestep();
            }
        }, 0, 50, TimeUnit.MILLISECONDS);
    }

    private void setupFluid() {
        Demo.getInstance().resetFluid();
    }
    final Object lock = new Object();

    private void timestep() {
        synchronized (lock) {
            Demo.getInstance().getFluid().simulateTimestep();
            display.repaint();
        }
    }

    private void onStop() {
        stop.setEnabled(false);
        play.setEnabled(true);
//        isRunning = false;
        executor.shutdown();
        executor = null;
    }
}
