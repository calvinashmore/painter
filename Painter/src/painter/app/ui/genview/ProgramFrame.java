/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import painter.app.PainterProgram;
import painter.app.ProgramManager;

/**
 *
 * @author Calvin Ashmore
 */
public class ProgramFrame extends JFrame {

    public ProgramFrame() {

        List<PainterProgram> programs = ProgramManager.getInstance().getPrograms();
        if (programs.size() == 0) {
            return;
        }
        PainterProgram program = programs.get(0);
        ProgramPanel programPanel = new ProgramPanel(program.getProgram());

        add(new JScrollPane(programPanel));
        pack();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
