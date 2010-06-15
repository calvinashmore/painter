/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app.ui.genview;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import painter.app.PainterProgram;
import painter.app.ProgramManager;

/**
 *
 * @author Calvin Ashmore
 */
public class ProgramFrame extends JFrame {

    private JScrollPane scrollPane;

    public ProgramFrame() {

        List<PainterProgram> programs = ProgramManager.getInstance().getPrograms();
        if (programs.size() == 0) {
            return;
        }
        PainterProgram program = programs.get(0);
        ProgramPanel programPanel = new ProgramPanel(program.getProgram());

        scrollPane = new JScrollPane(programPanel);
        add(scrollPane);
        pack();

        DragControl dragControl = new DragControl();
        getGlassPane().addMouseListener(dragControl);
        getGlassPane().addMouseMotionListener(dragControl);
        getGlassPane().setVisible(true);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private class DragControl implements MouseListener, MouseMotionListener {

//        private int mouseX, mouseY;
        private int lastMouseX, lastMouseY;

        public void mouseClicked(MouseEvent e) {
            redispatchMouseEvent(e);
        }

        public void mousePressed(MouseEvent e) {
            redispatchMouseEvent(e);

            lastMouseX = e.getX();
            lastMouseY = e.getY();
        }

        public void mouseReleased(MouseEvent e) {
            redispatchMouseEvent(e);
        }

        public void mouseEntered(MouseEvent e) {
            redispatchMouseEvent(e);
        }

        public void mouseExited(MouseEvent e) {
            redispatchMouseEvent(e);
        }

        public void mouseDragged(MouseEvent e) {
            redispatchMouseEvent(e);

            // quick check regarding scrollbars:
            Point glassPanePoint = e.getPoint();
            Container container = getContentPane();
            Component glassPane = getGlassPane();
            Point containerPoint = SwingUtilities.convertPoint(glassPane, glassPanePoint, container);
            Component underlyingComponent = SwingUtilities.getDeepestComponentAt(container, containerPoint.x, containerPoint.y);

            int mouseX = e.getX();
            int mouseY = e.getY();

            // don't drag if we're on the scrollbar.
            if (underlyingComponent instanceof JScrollBar) {
                lastMouseX = mouseX;
                lastMouseY = mouseY;
                
                return;
            }

            int deltaX = lastMouseX - mouseX;
            int deltaY = lastMouseY - mouseY;

            int xValue = scrollPane.getHorizontalScrollBar().getModel().getValue();
            int yValue = scrollPane.getVerticalScrollBar().getModel().getValue();
            scrollPane.getHorizontalScrollBar().getModel().setValue(xValue + deltaX);
            scrollPane.getVerticalScrollBar().getModel().setValue(yValue + deltaY);

            lastMouseX = mouseX;
            lastMouseY = mouseY;
        }

        public void mouseMoved(MouseEvent e) {
            redispatchMouseEvent(e);
        }
    }

    private void redispatchMouseEvent(MouseEvent e) {
        // this code is from:
        // http://java.sun.com/docs/books/tutorial/uiswing/components/rootpane.html

        Point glassPanePoint = e.getPoint();
        Container container = getContentPane();
        Component glassPane = getGlassPane();
        Point containerPoint = SwingUtilities.convertPoint(
                glassPane,
                glassPanePoint,
                container);

        if (containerPoint.y < 0) { //we're not in the content pane
            //Could have special code to handle mouse events over
            //the menu bar or non-system window decorations, such as
            //the ones provided by the Java look and feel.
        } else {
            //The mouse event is probably over the content pane.
            //Find out exactly which component it's over.
            Component component =
                    SwingUtilities.getDeepestComponentAt(
                    container,
                    containerPoint.x,
                    containerPoint.y);

            if (component != null) {
                //Forward events over the check box.
                Point componentPoint = SwingUtilities.convertPoint(
                        glassPane,
                        glassPanePoint,
                        component);
                component.dispatchEvent(new MouseEvent(component,
                        e.getID(),
                        e.getWhen(),
                        e.getModifiers(),
                        componentPoint.x,
                        componentPoint.y,
                        e.getClickCount(),
                        e.isPopupTrigger()));
            }
        }
    }
}
