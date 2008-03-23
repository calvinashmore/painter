/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.icosilune.fnsupport.navigator;

import com.icosilune.fnsupport.api.FnDataResult;
import com.icosilune.fnsupport.api.FnResultListener;
import com.icosilune.fnsupport.datatype.FnDataObject;
import java.util.Collection;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.netbeans.spi.navigator.NavigatorPanel;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;

/**
 *
 * @author Calvin Ashmore
 */
public class FnNavigator implements NavigatorPanel, FnResultListener {

    /** holds UI of this panel */
    //private JComponent panelUI;
    /** template for finding data in given context.
     * Object used as example, replace with your own data source, for example JavaDataObject etc */
    private static final Lookup.Template MY_DATA = new Lookup.Template(FnDataObject.class);
    /** current context to work on */
    private Lookup.Result curContext;
    /** listener to context changes */
    private LookupListener contextL;
    
    private FnDataObject obj;
    
    private JTextArea myLabel;
    private JScrollPane myScrollPane;
    
    /** public no arg constructor needed for system to instantiate provider well */
    public FnNavigator() {
    }

    public String getDisplayHint() {
        return "Navigator for Fn data.";
    }

    public String getDisplayName() {
        return "Fn Navigator";
    }

    public JComponent getComponent() {
        if (myLabel == null) {
            myLabel = new JTextArea();//("Dummy label");
            myScrollPane = new JScrollPane(myLabel);
            // You can override requestFocusInWindow() on the component if desired.
        }
        return myScrollPane;//myLabel;
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
        if(obj != null) {
            obj.removeResultListener(this);
            obj = null;
        }
        
        curContext.removeLookupListener(getContextListener());
        curContext = null;
    }
    
    public Lookup getLookup () {
        // go with default activated Node strategy
        return null;
    }

    public void onResult(FnDataResult result) {
        StringBuffer sb = new StringBuffer();
        
        if(result.getParseException() != null) {
            sb.append("Parse Exception:\n");
            sb.append(result.getParseException());
        } else if(result.getOtherException() != null) {
            sb.append("Got Exception:\n");
            sb.append(result.getOtherException()+"\n");
            sb.append("Caused by:\n");
            for(StackTraceElement trace : result.getOtherException().getStackTrace())
                sb.append(trace+"\n");
        } else if(!result.isValid()) {
            sb.append("Invalid, but no exceptions?");
        } else {
            // result.isValid() == true
            sb.append("Fn is OK!\n");
            sb.append(result.getJavaCode());
        }
        
        myLabel.setText(sb.toString());
        //myLabel.setText("Parses OK: "+result.isValid()+" \n "+result.getParseException() + " \n "+ result.getOtherException());
    }
    
    /************* non - public part ************/
    
    private void setNewContent (Collection<FnDataObject> newData) {
        // put your code here that grabs information you need from given
        // collection of data, recompute UI of your panel and show it.
        // Note - be sure to compute the content OUTSIDE event dispatch thread,
        // just final repainting of UI should be done in event dispatch thread.
        // Please use RequestProcessor and Swing.invokeLater to achieve this.
        
        if(newData.isEmpty() && obj != null) {
            // dispose obj
            obj.removeResultListener(this);
            obj = null;
            return;
        }
        
        FnDataObject newObj = newData.iterator().next();
        if(newObj != obj) {
            
            if(obj != null) {
                // dispose old obj
                obj.removeResultListener(this);
            }
            
            obj = newObj;
            obj.addResultListener(this);
        }
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
            Collection<FnDataObject> data = ((Lookup.Result)ev.getSource()).allInstances();
            setNewContent(data);
        }
        
    } // end of ContextListener
    
}

