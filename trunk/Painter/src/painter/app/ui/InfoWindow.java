/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui;

import java.util.List;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import painter.app.PainterProgram;
import painter.app.ProgramManager;
import painter.app.ProgramPrinter;

/**
 *
 * @author Calvin Ashmore
 */
public class InfoWindow extends JFrame {

    private static InfoWindow instance;

    public static InfoWindow getInstance() {
        if (instance == null) {
            instance = new InfoWindow();
        }

        instance.updateInfo();
        return instance;
    }
    private JEditorPane pane;

    public InfoWindow() {
        super("Painter Program Info");

        pane = new JEditorPane();
        //add(new JScrollPane(pane));
        add(pane);
        pane.setEditable(false);
        updateInfo();

        pack();
    }

    private void updateInfo() {
        List<PainterProgram> programs = ProgramManager.getInstance().getPrograms();
        if (programs.size() == 0) {
            return;
        }
        PainterProgram program = programs.get(0);
        StringBuilder sb = new StringBuilder();
        ProgramPrinter.printProgram(sb, program.getProgram());
        pane.setText(sb.toString());
    }
}
