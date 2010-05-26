package painter.app;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;
import painter.tools.canvas.CanvasImpl;

public class CanvasPanel extends JPanel {

    private static long CANVAS_REFRESH_INTERVAL = 50;
    private CanvasImpl canvas;
    private ScheduledExecutorService executor;

    public CanvasPanel(int width, int height) {
        super();
        canvas = new CanvasImpl(width, height);
        canvas.getGraphics().setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        setPreferredSize(new Dimension(width, height));
    }

    public void start() {
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {

            public void run() {
                repaint();
            }
        }, 0, CANVAS_REFRESH_INTERVAL, TimeUnit.MILLISECONDS);
    }

    public void shutdown() {
        executor.shutdown();
    }

    public CanvasImpl getCanvas() {
        return canvas;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //if (canvas != null) {
        //g.setColor(Color.WHITE);
        //g.fillRect(0, 0, RESOLUTION, RESOLUTION);
        g.drawImage(canvas.makeImage(), 0, 0, null);
    }
}
