/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview;

import genetic.GeneticTopLevel;
import genetic.component.method.Method;
import java.util.Map.Entry;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Calvin Ashmore
 */
public class ProgramPanel extends JPanel {

    private GeneticTopLevel program;

    public ProgramPanel(GeneticTopLevel program) {
        this.program = program;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // first context model for whole

//        add(new ContextModelPanel(program.getContextModel()));

        for (Entry<String, Method> entry : program.getMethods().entrySet()) {
            addMethod(entry.getKey(), entry.getValue());
        }
    }

    private void addMethod(String methodName, Method method) {
        MethodPanel mp = new MethodPanel(methodName, method);
        add(mp);
    }
}
