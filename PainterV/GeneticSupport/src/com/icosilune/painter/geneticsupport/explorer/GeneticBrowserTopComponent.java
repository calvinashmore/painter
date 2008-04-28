/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.painter.geneticsupport.explorer;

import com.icosilune.painter.geneticsupport.app.ApplicationInstance;
import com.icosilune.painter.geneticsupport.app.ProgramListener;
import com.icosilune.painter.geneticsupport.nodes.ProgramNode;
import genetic.GeneticTopLevel;
import java.awt.BorderLayout;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.swing.ActionMap;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 *
 * @author Calvin Ashmore
 */
public class GeneticBrowserTopComponent extends TopComponent
        implements ExplorerManager.Provider, ProgramListener {

    private static GeneticBrowserTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "GeneticBrowserTopComponent";
    private final ExplorerManager manager = new ExplorerManager();

    public GeneticBrowserTopComponent() {
        ApplicationInstance.getInstance().addProgramListener(this);
        
        setName(NbBundle.getMessage(GeneticBrowserTopComponent.class, "CTL_GeneticBrowserTopComponent"));
        setToolTipText(NbBundle.getMessage(GeneticBrowserTopComponent.class, "HINT_GeneticBrowserTopComponent"));
//        setIcon(Utilities.loadImage(ICON_PATH, true));

        ActionMap map = getActionMap();
        associateLookup(ExplorerUtils.createLookup(manager, map));

        setLayout(new BorderLayout());
        BeanTreeView view = new BeanTreeView();
        view.setRootVisible(true);

        // *************************
        /*Foundation foundation = (Foundation) genetic.Foundation.getInstance();

        if (foundation == null) {
            foundation = new Foundation();
            genetic.Foundation.setInstance(foundation);
        }

        GeneticTopLevel program = foundation.getProgramBuilder().build();

        program.getContextModel().declareVariable("canvas", Canvas.class, true);
        program.createMethod("doStuff");

        System.out.println("Setting up...");
        try {
            program.setup();
        } catch (BuildException ex) {
        }*/
        // *************************

        add(view, BorderLayout.CENTER);
    }

    public ExplorerManager getExplorerManager() {
        return manager;
    }

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link findInstance}.
     */
    public static synchronized GeneticBrowserTopComponent getDefault() {
        if (instance == null) {
            instance = new GeneticBrowserTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the GeneticBrowserTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized GeneticBrowserTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(GeneticBrowserTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof GeneticBrowserTopComponent) {
            return (GeneticBrowserTopComponent) win;
        }
        Logger.getLogger(GeneticBrowserTopComponent.class.getName()).warning(
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
            return GeneticBrowserTopComponent.getDefault();
        }
    }

    public void onProgramChange(GeneticTopLevel program) {
        manager.setRootContext( new ProgramNode(program) );
    }
}
