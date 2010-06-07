/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import painter.app.CanvasPanel;
import painter.app.ProgramManager;

/**
 *
 * @author Calvin Ashmore
 */
public class PainterView extends JPanel {

    private static PainterView instance;

    public static PainterView getInstance() {
        return instance;
    }
//    private static final int CANVAS_WIDTH = 1550;
//    private static final int CANVAS_HEIGHT = 1025;
    private CanvasPanel canvasPanel;
    private boolean running = false;
    private ProgramManager manager;
    private JFrame fullscreenFrame;

    public boolean isRunning() {
        return running;
    }

    public PainterView() {
        instance = this;

        canvasPanel = new CanvasPanel();
        manager = new ProgramManager(canvasPanel);

        setLayout(new BorderLayout());
        add(canvasPanel, BorderLayout.CENTER);
    }

    public void start() {
        canvasPanel.start();
        running = true;
        manager.start();
    }

    public void stop() {
        manager.shutdown();
        canvasPanel.shutdown();

        running = false;
    }

    public void toggleFullscreen() {
        
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();


        if (fullscreenFrame == null) {
            if (!device.isFullScreenSupported()) {
                // fullscreen is not supported.
                // maybe put up a notice??
                return;
            }

            // going into fullscreen mode
            fullscreenFrame = new JFrame("painter fullscreen");
            fullscreenFrame.add(canvasPanel);
            fullscreenFrame.setUndecorated(true);


            device.setFullScreenWindow(fullscreenFrame);
            fullscreenFrame.setVisible(true);
            canvasPanel.setSize(fullscreenFrame.getSize());

            fullscreenFrame.setGlassPane(new FullscreenGlassPane());
            fullscreenFrame.getGlassPane().setVisible(true);
            fullscreenFrame.getGlassPane().requestFocus();

        } else {

            device.setFullScreenWindow(null);
            add(canvasPanel, BorderLayout.CENTER);
            canvasPanel.setSize(getSize());
            fullscreenFrame.setVisible(false);
            fullscreenFrame.dispose();
            fullscreenFrame = null;
        }
    }

    @Override
    public void doLayout() {
        super.doLayout();
//        System.out.println("doLayout");
//        System.out.println(getSize());
        System.out.println("resizing: " + getSize());
        canvasPanel.setSize(getSize());
    }
}
