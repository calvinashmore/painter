/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import painter.app.CanvasPanel;
import painter.app.ProgramManager;

/**
 *
 * @author Calvin Ashmore
 */
public class PainterView extends JPanel {

//    private static final int CANVAS_WIDTH = 1550;
//    private static final int CANVAS_HEIGHT = 1025;

    private CanvasPanel canvasPanel;
    private boolean running = false;
    private ProgramManager manager;

    public boolean isRunning() {
        return running;
    }

    public PainterView() {

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

    @Override
    public void doLayout() {
        super.doLayout();
//        System.out.println("doLayout");
//        System.out.println(getSize());
        System.out.println("resizing: "+getSize());
        canvasPanel.setSize(getSize());
    }


}
