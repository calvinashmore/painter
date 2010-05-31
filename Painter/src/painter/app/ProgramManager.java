/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Calvin Ashmore
 */
public class ProgramManager {

    private static ProgramManager instance;

    public static ProgramManager getInstance() {
        return instance;
    }
    private List<PainterProgram> programs = new ArrayList<PainterProgram>();
    private PainterProgramQueue queue;
    private int simultaneousPrograms = 1;
    private int programDuration = 5000;
    private ScheduledExecutorService executor;

    public List<PainterProgram> getPrograms() {
        return programs;
    }

    public ProgramManager(CanvasPanel canvasPanel) {
        queue = new PainterProgramQueue(canvasPanel.getCanvas());
        instance = this;
    }

    public void start() {
        if (executor != null) {
            shutdown();
        }

        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {

            public void run() {
                updatePrograms();
            }
        }, 0, 200, TimeUnit.MILLISECONDS);
    }

    public void shutdown() {
        for (PainterProgram painterProgram : programs) {
            painterProgram.stopPaint();
        }
        executor.shutdown();
    }

    private void updatePrograms() {

        // clear out all stopped programs.
        // also programs that have lasted too long
        List<PainterProgram> toRemove = new ArrayList<PainterProgram>();
        for (PainterProgram painterProgram : programs) {
            if (!painterProgram.isRunning()) {
                toRemove.add(painterProgram);
            } else if (painterProgram.getExecutionTime() > programDuration) {
                painterProgram.stopPaint();

                // wait while it finishes
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DemoApplet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        programs.removeAll(toRemove);

        int toBuild = simultaneousPrograms - programs.size();
        // build one at a time.
        if (toBuild > 0) {
            PainterProgram program = queue.pop();
            program.startPaint();
            programs.add(program);
        }
    }
}
