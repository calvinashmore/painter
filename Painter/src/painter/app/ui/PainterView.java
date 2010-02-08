/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui;

import java.awt.BorderLayout;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import painter.app.CanvasPanel;
import painter.app.DemoApplet;
import painter.app.PainterProgram;
import painter.app.PainterProgramQueue;

/**
 *
 * @author Calvin Ashmore
 */
public class PainterView extends JPanel {

    private static final int CANVAS_WIDTH = 1200;
    private static final int CANVAS_HEIGHT = 800;

    private CanvasPanel canvasPanel;
    //private JLabel captionLabel;
    private long calculationStart;
    private ScheduledExecutorService executor;
    private PainterProgramQueue queue;
    private PainterProgram currentProgram;
    private boolean running = false;

    public boolean isRunning() {
        return running;
    }

    public PainterView() {

        canvasPanel = new CanvasPanel(CANVAS_WIDTH, CANVAS_HEIGHT);
        //captionLabel = new JLabel("Loading...");

        queue = new PainterProgramQueue(canvasPanel.getCanvas());

        //JPanel controlPanel = new JPanel(new BorderLayout());
        //controlPanel.add(captionLabel, BorderLayout.CENTER);
        //controlPanel.add(mutateButton, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(canvasPanel, BorderLayout.CENTER);
        //add(controlPanel, BorderLayout.SOUTH);
    }

    public void start() {
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {

            public void run() {
                updateView();
            }
        }, 0, 200, TimeUnit.MILLISECONDS);
        canvasPanel.start();
        running = true;
    }

    public void stop() {
        executor.shutdown();
        canvasPanel.shutdown();

        if (currentProgram != null && currentProgram.isRunning()) {
            //System.out.println("Calling stop");
            currentProgram.stopPaint();
        }

        running = false;
    }

    private void updateView() {

        // attempt to start if we are shut down or haven't started yet
        if (currentProgram == null || !currentProgram.isRunning()) {
            startNew();

        } else {

            long beenCalculatingFor = System.currentTimeMillis() - calculationStart;

            if (beenCalculatingFor < 5000) {
                // less than 5 seconds
                //int seconds = (int) (beenCalculatingFor / 1000);
                //captionLabel.setText("Thinking... (" + seconds + ")");
            } else {
                // try to shut it down
                //captionLabel.setText("Starting new");
                startNew();
            }
        }
    }

    private void startNew() {
        // don't attempt to stop if it's null or already stopped
        if (currentProgram != null && currentProgram.isRunning()) {
            //System.out.println("Calling stop");
            currentProgram.stopPaint();

            // wait while it finishes
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(DemoApplet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        currentProgram = queue.pop();
        currentProgram.startPaint();
        calculationStart = System.currentTimeMillis();
    }
}
