/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.icosilune.fnsupport.navigator;

import java.util.Collection;
import javax.swing.JComponent;
import javax.swing.JLabel;
import org.netbeans.spi.navigator.NavigatorPanel;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;

/**
 *
 * @author Calvin Ashmore
 */
public class FnNavigator implements NavigatorPanel {

    /** holds UI of this panel */
    private JComponent panelUI;
    /** template for finding data in given context.
     * Object used as example, replace with your own data source, for example JavaDataObject etc */
    private static final Lookup.Template MY_DATA = new Lookup.Template(Object.class);
    /** current context to work on */
    private Lookup.Result curContext;
    /** listener to context changes */
    private LookupListener contextL;
    
    /** public no arg constructor needed for system to instantiate provider well */
    public FnNavigator() {
    }

    public String getDisplayHint() {
        return "Basic dummy implementation of NavigatorPanel interface";
    }

    public String getDisplayName() {
        return "Fn Navigator";
    }

    public JComponent getComponent() {
        if (panelUI == null) {
            panelUI = new JLabel("Dummy label");
            // You can override requestFocusInWindow() on the component if desired.
        }
        return panelUI;
    }

    public void panelActivated(Lookup context) {
        // lookup context and listen to result to get notified about context changes
        curContext = context.lookup(MY_DATA);
        curContext.addLookupListener(getContextListener());
        // get actual data and recompute content
        Collection data = curContext.allInstances();
        setNewContent(data);
    }

    public void panelDeactivated() {
        curContext.removeLookupListener(getContextListener());
        curContext = null;
    }
    
    public Lookup getLookup () {
        // go with default activated Node strategy
        return null;
    }
    
    /************* non - public part ************/
    
    private void setNewContent (Collection newData) {
        // put your code here that grabs information you need from given
        // collection of data, recompute UI of your panel and show it.
        // Note - be sure to compute the content OUTSIDE event dispatch thread,
        // just final repainting of UI should be done in event dispatch thread.
        // Please use RequestProcessor and Swing.invokeLater to achieve this.
    }
    
    /** Accessor for listener to context */
    private LookupListener getContextListener () {
        if (contextL == null) {
            contextL = new ContextListener();
        }
        return contextL;
    }
    
    /** Listens to changes of context and triggers proper action */
    private class ContextListener implements LookupListener {
        
        public void resultChanged(LookupEvent ev) {
            Collection data = ((Lookup.Result)ev.getSource()).allInstances();
            setNewContent(data);
        }
        
    } // end of ContextListener
    
}

