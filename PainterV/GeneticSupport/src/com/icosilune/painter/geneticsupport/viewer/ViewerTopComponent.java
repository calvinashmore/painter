/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.painter.geneticsupport.viewer;

import com.icosilune.painter.geneticsupport.app.ApplicationInstance;
import genetic.BuildException;
import genetic.GeneticTopLevel;
import java.awt.BorderLayout;
import java.io.Serializable;
import java.util.logging.Logger;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import painter.app.DemoApplet;
import painter.tools.canvas.Canvas;

/**
 *
 * @author Calvin Ashmore
 */
public class ViewerTopComponent extends TopComponent {

    private static ViewerTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "ViewerTopComponent";

    public ViewerTopComponent() {

        setName(NbBundle.getMessage(ViewerTopComponent.class, "CTL_ViewerTopComponent"));
        setToolTipText(NbBundle.getMessage(ViewerTopComponent.class, "HINT_ViewerTopComponent"));
//        setIcon(Utilities.loadImage(ICON_PATH, true));

        setLayout(new BorderLayout());

        DemoApplet applet = new DemoApplet() {

            @Override
            protected Canvas makeCanvas(GeneticTopLevel program) throws BuildException {

                ApplicationInstance.getInstance().setProgram(program);
                return super.makeCanvas(program);
            }
        };

        applet.init();
        applet.start();

        add(applet, BorderLayout.CENTER);
    }

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized ViewerTopComponent getDefault() {
        if (instance == null) {
            instance = new ViewerTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the ViewerTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized ViewerTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(ViewerTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof ViewerTopComponent) {
            return (ViewerTopComponent) win;
        }
        Logger.getLogger(ViewerTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID +
                "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    /** replaces this in object stream */
    @Override
    public Object writeReplace() {
        return new ResolvableHelper();
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    final static class ResolvableHelper implements Serializable {

        private static final long serialVersionUID = 1L;

        public Object readResolve() {
            return ViewerTopComponent.getDefault();
        }
    }
}
