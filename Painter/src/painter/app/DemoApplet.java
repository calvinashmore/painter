/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app;

import genetic.BuildException;
import genetic.GeneticTopLevel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    private JButton mutateButton;
    private GeneticTopLevel currentProgram;

    @Override
    public void init() {
        super.init();

        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(RESOLUTION, RESOLUTION));
        captionLabel = new JLabel("Loading...");

        mutateButton = new JButton("mutate");
        mutateButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                startCalculate(true);
            }
        });

        JPanel controlPanel = new JPanel(new BorderLayout());
        controlPanel.add(captionLabel, BorderLayout.CENTER);
        controlPanel.add(mutateButton, BorderLayout.EAST);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(imageLabel, BorderLayout.CENTER);
        getContentPane().add(controlPanel, BorderLayout.SOUTH);

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
        if (isCalculating) {
            calculateThread.stop();
        }
    }

    private class RefreshListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            startCalculate(false);
        }
    }

    private void updateUI() {
        if (isCalculating) {

            long beenCalculatingFor = System.currentTimeMillis() - calculationStart;

            //if(beenCalculatingFor < 3000) {
            //    captionLabel.setText("Thinking...");
            //} else
            if (beenCalculatingFor < 7000) {
                int seconds = (int) (beenCalculatingFor / 1000);
                captionLabel.setText("Thinking... (" + seconds + ")");
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

    private void startCalculate(final boolean mutate) {

        // don't start calculating if already calculating.
        if (isCalculating) {
            return;
        }
        calculateThread =
                new Thread(new Runnable() {

            public void run() {
                doCalculate(mutate);
            }
        }, "Calculation Thread");
        calculateThread.start();
    }

    private void doCalculate(boolean mutate) {
        isCalculating = true;
        calculationStart = System.currentTimeMillis();

        try {
            if (mutate && currentProgram != null) {
                currentProgram = mutate(currentProgram);
            } else {
                currentProgram = makeProgram();
            }
            Canvas canvas = makeCanvas(currentProgram);
            imageLabel.setIcon(new ImageIcon(canvas.makeImage()));

        } catch (BuildException ex) {
        }

        isCalculating = false;
    }

    protected GeneticTopLevel mutate(GeneticTopLevel program) throws BuildException {
        Foundation foundation = (Foundation) genetic.Foundation.getInstance();
        foundation.getProgramMutator().mutate(program);

        System.out.println("Setting up...");
        program.setup();

        return program;
    }

    protected GeneticTopLevel makeProgram() throws BuildException {

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

        StringBuilder sb = new StringBuilder();
        ProgramPrinter.printProgram(sb, program);
        System.out.println(sb);

        return program;
    }

    protected Canvas makeCanvas(GeneticTopLevel program) throws BuildException {


        Canvas canvas = new Canvas(500, 500);
        program.getContext().setVariable("canvas", canvas);

        System.out.println("Calling method...");
        program.callMethod("doStuff");
        System.out.println("Done!");

        return canvas;
    }
}
