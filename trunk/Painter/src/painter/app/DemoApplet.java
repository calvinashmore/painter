/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app;

import java.awt.BorderLayout;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Calvin Ashmore
 */
public class DemoApplet extends JApplet {

    private static final int RESOLUTION = 800;
    private CanvasPanel canvasPanel;
    private JLabel captionLabel;
//    private long calculationStart;
//    private ScheduledExecutorService executor;
//    private PainterProgramQueue queue;
//    private PainterProgram currentProgram;
    private ProgramManager manager;

    @Override
    public void init() {
        super.init();

        canvasPanel = new CanvasPanel(1200, RESOLUTION);
        captionLabel = new JLabel("Loading...");

//        queue = new PainterProgramQueue(canvasPanel.getCanvas());

        manager = new ProgramManager(canvasPanel);

        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.add(captionLabel, BorderLayout.CENTER);
        //controlPanel.add(mutateButton, BorderLayout.EAST);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(canvasPanel, BorderLayout.CENTER);
        getContentPane().add(controlPanel, BorderLayout.SOUTH);
    }

    @Override
    public void start() {
        super.start();
        manager.start();
//        executor = Executors.newSingleThreadScheduledExecutor();
//        executor.scheduleAtFixedRate(new Runnable() {
//
//            public void run() {
//                updateUI();
//            }
//        }, 0, 200, TimeUnit.MILLISECONDS);
        canvasPanel.start();
    }

    @Override
    public void stop() {
        super.stop();
//        executor.shutdown();
        manager.shutdown();
        canvasPanel.shutdown();
    }
//
//    private void updateUI() {
//
//        // attempt to start if we are shut down or haven't started yet
//        if (currentProgram == null || !currentProgram.isRunning()) {
//            startNew();
//
//        } else {
//
//            long beenCalculatingFor = System.currentTimeMillis() - calculationStart;
//
//            if (beenCalculatingFor < 5000) {
//                // less than 5 seconds
//                int seconds = (int) (beenCalculatingFor / 1000);
//                captionLabel.setText("Thinking... (" + seconds + ")");
//            } else {
//                // try to shut it down
//                captionLabel.setText("Starting new");
//                startNew();
//            }
//        }
//    }
//
//    private void startNew() {
//        // don't attempt to stop if it's null or already stopped
//        if (currentProgram != null && currentProgram.isRunning()) {
//            //System.out.println("Calling stop");
//            currentProgram.stopPaint();
//
//            // wait while it finishes
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(DemoApplet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        currentProgram = queue.pop();
//        currentProgram.startPaint();
//        calculationStart = System.currentTimeMillis();
//    }
}
