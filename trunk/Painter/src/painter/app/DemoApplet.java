/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app;

import genetic.BuildException;
import genetic.GeneticTopLevel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import painter.foundation.Foundation;
import painter.tools.canvas.Canvas;

/**
 *
 * @author Calvin Ashmore
 */
public class DemoApplet extends JApplet {

    private static final int RESOLUTION = 500;
    private JLabel imageLabel;
    private JLabel captionLabel;
    private boolean isCalculating;
    private long calculationStart;
    private ScheduledExecutorService executor;
    private Thread calculateThread;

    @Override
    public void init() {
        super.init();


        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(RESOLUTION, RESOLUTION));
        captionLabel = new JLabel("Loading...");

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(imageLabel, BorderLayout.CENTER);
        getContentPane().add(captionLabel, BorderLayout.SOUTH);

        imageLabel.addMouseListener(new RefreshListener());

    }

    @Override
    public void start() {
        super.start();
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {

            public void run() {
                updateUI();
            }
        }, 0, 200, TimeUnit.MILLISECONDS);
    }

    @Override
    public void stop() {
        super.stop();
        executor.shutdown();
        
        // bad practice, I know
        if(isCalculating)
            calculateThread.stop();
    }

    private class RefreshListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            startCalculate();
        }
    }

    private void updateUI() {
        if (isCalculating) {

            long beenCalculatingFor = System.currentTimeMillis() - calculationStart;
            
            //if(beenCalculatingFor < 3000) {
            //    captionLabel.setText("Thinking...");
            //} else
            if(beenCalculatingFor < 5000) {
                int seconds = (int)(beenCalculatingFor/1000);
                captionLabel.setText("Thinking... ("+seconds+")");
            } else {
                // try to shut it down
                captionLabel.setText("I'm confused!");
                calculateThread.stop();
                isCalculating = false;
            }

        } else {
            captionLabel.setText("Click above to make an image");
        }
    }

    private void startCalculate() {
        
        // don't start calculating if already calculating.
        if(isCalculating)
            return;
        
        calculateThread =
                new Thread(new Runnable() {

            public void run() {
                doCalculate();
            }
        }, "Calculation Thread");
        calculateThread.start();
    }

    private void doCalculate() {
        isCalculating = true;
        calculationStart = System.currentTimeMillis();

        try {
            Canvas canvas = makeCanvas();
            imageLabel.setIcon(new ImageIcon(canvas.makeImage()));

        } catch (BuildException ex) {
        }

        isCalculating = false;
    }

    private Canvas makeCanvas() throws BuildException {

        Foundation foundation = (Foundation) genetic.Foundation.getInstance();

        if (foundation == null) {
            foundation = new Foundation();
            genetic.Foundation.setInstance(foundation);
        }

        GeneticTopLevel program = foundation.getProgramBuilder().build();

        program.getContextModel().declareVariable("canvas", Canvas.class, true);
        program.createMethod("doStuff");

        System.out.println("Setting up...");
        program.setup();

        Canvas canvas = new Canvas(500, 500);
        program.getContext().setVariable("canvas", canvas);

        System.out.println("Calling method...");
        program.callMethod("doStuff");
        System.out.println("Done!");

        return canvas;
    }
}
