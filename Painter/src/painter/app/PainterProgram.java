/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app;

import genetic.BuildException;
import genetic.GeneticTopLevel;
import genetic.TerminationException;
import genetic.component.program.Program;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    //private boolean running;

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

//        StringBuilder sb = new StringBuilder();
//        ProgramPrinter.printProgram(sb, program);
//        System.out.println(sb);

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
        String threadName = "Paint-"+THREAD_COUNT;
        THREAD_COUNT++;

        executionThread = new Thread(new Runnable() {

            public void run() {
                doPaint();
            }
        }, threadName);
        executionThread.start();
    }

    /**
     * This actually does the work of the painting, and is run in its own thread.
     */
    private void doPaint() {
        synchronized(lock) {
        System.out.println("running.... ("+Thread.currentThread().getName()+")");
//        running = true;
        try {
            //while (true) {
            program.callMethod(METHOD_NAME);
            //}
        } catch (TerminationException ex) {
            // the program has been terminated. This is an expected occurrence if
            // the user forces it to stop, or if it has timed out.
            System.out.println("terminated ("+Thread.currentThread().getName()+")");
        }
//        running = false;
        System.out.println("done.... ("+Thread.currentThread().getName()+")");
        lock.notifyAll();
        }
    }

    public boolean isRunning() {
//        return running;
        return executionThread.isAlive();
    }

    /**
     * This forces the paint program to shut down.
     */
    public void stopPaint() {
        System.out.println("stopping... ("+executionThread.getName()+")");
//        executionThread.stop();
        ((Program) program).terminate();
        executionThread.interrupt();

        //synchronized(lock) {
//        try {
//            lock.wait();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(PainterProgram.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //}
        System.out.println("continuing...");
    }
}
