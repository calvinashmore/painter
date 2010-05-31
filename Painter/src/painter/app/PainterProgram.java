/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app;

import genetic.BuildException;
import genetic.GeneticTopLevel;
import genetic.TerminationException;
import genetic.component.program.Program;
import painter.foundation.Foundation;
import painter.tools.canvas.Canvas;
import painter.tools.canvas.CanvasImpl;

/**
 *
 * @author Calvin Ashmore
 */
public class PainterProgram {

    private GeneticTopLevel program;
    private Thread executionThread;
    private static final String METHOD_NAME = "paint";
    private static int THREAD_COUNT = 0;
    private final Object lock = new Object();
    private long startTime;

    public GeneticTopLevel getProgram() {
        return program;
    }

    public static PainterProgram buildNew(Canvas canvas) throws BuildException {

        Foundation foundation = (Foundation) genetic.Foundation.getInstance();

        if (foundation == null) {
            foundation = new Foundation();
            genetic.Foundation.setInstance(foundation);
        }

        GeneticTopLevel program = foundation.getProgramBuilder().build();

        program.getContextModel().declareVariable("canvas", CanvasImpl.class, true);
        program.createMethod(METHOD_NAME);

        System.out.println("Setting up...");
        program.setup();

        program.getContext().setVariable("canvas", canvas);

        return new PainterProgram(program);
    }

    // forbid external creation
    private PainterProgram(GeneticTopLevel program) {
        this.program = program;
    }

    /**
     * This starts painting on the canvas in a new thread
     */
    public void startPaint() {
        String threadName = "Paint-" + THREAD_COUNT;
        THREAD_COUNT++;

        executionThread = new Thread(new Runnable() {

            public void run() {
                doPaint();
            }
        }, threadName);
        executionThread.start();
        this.startTime = System.currentTimeMillis();
    }

    public long getExecutionTime() {
        if (!isRunning()) {
            return -1;
        }
        return System.currentTimeMillis() - startTime;
    }

    /**
     * This actually does the work of the painting, and is run in its own thread.
     */
    private void doPaint() {
        synchronized (lock) {
            System.out.println("running.... (" + Thread.currentThread().getName() + ")");

            try {
                program.callMethod(METHOD_NAME);
            } catch (TerminationException ex) {
                // the program has been terminated. This is an expected occurrence if
                // the user forces it to stop, or if it has timed out.
                System.out.println("terminated (" + Thread.currentThread().getName() + ")");
            }

            System.out.println("done.... (" + Thread.currentThread().getName() + ")");
            lock.notifyAll();
        }
    }

    public boolean isRunning() {
        return executionThread.isAlive();
    }

    /**
     * This forces the paint program to shut down.
     */
    public void stopPaint() {
        System.out.println("stopping... (" + executionThread.getName() + ")");
        ((Program) program).terminate();
        executionThread.interrupt();
        System.out.println("continuing...");
    }
}
