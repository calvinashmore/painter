/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app;

import java.awt.BorderLayout;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import painter.app.ui.PainterView;

/**
 *
 * @author Calvin Ashmore
 */
public class DemoApplet extends JApplet {

//    private static final int RESOLUTION = 800;
//    private CanvasPanel canvasPanel;
//    private JLabel captionLabel;
//    private long calculationStart;
//    private ScheduledExecutorService executor;
//    private PainterProgramQueue queue;
//    private PainterProgram currentProgram;
//    private ProgramManager manager;
    private PainterView painterView;

    @Override
    public void init() {
        super.init();

//        canvasPanel = new CanvasPanel();
//        captionLabel = new JLabel("Loading...");
//
////        queue = new PainterProgramQueue(canvasPanel.getCanvas());
//
//        manager = new ProgramManager(canvasPanel);
//
//        JPanel controlPanel = new JPanel(new BorderLayout());
//        controlPanel.add(captionLabel, BorderLayout.CENTER);
//        //controlPanel.add(mutateButton, BorderLayout.EAST);
//
//        getContentPane().setLayout(new BorderLayout());
//        getContentPane().add(canvasPanel, BorderLayout.CENTER);
//        getContentPane().add(controlPanel, BorderLayout.SOUTH);
        painterView = new PainterView();
        getContentPane().add(painterView);
    }

    @Override
    public void start() {
        super.start();
        painterView.start();
//        manager.start();
////        executor = Executors.newSingleThreadScheduledExecutor();
////        executor.scheduleAtFixedRate(new Runnable() {
////
////            public void run() {
////                updateUI();
////            }
////        }, 0, 200, TimeUnit.MILLISECONDS);
//        canvasPanel.start();
    }

    @Override
    public void stop() {
        super.stop();
        painterView.stop();
//        executor.shutdown();
//        manager.shutdown();
//        canvasPanel.shutdown();
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
