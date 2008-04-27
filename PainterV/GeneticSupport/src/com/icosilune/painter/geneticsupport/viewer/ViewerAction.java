/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.painter.geneticsupport.viewer;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;

/**
 *
 * @author Calvin Ashmore
 */
public class ViewerAction extends AbstractAction {

    public ViewerAction() {
        super(NbBundle.getMessage(ViewerAction.class, "CTL_ViewerAction"));
//        putValue(SMALL_ICON, new ImageIcon(Utilities.loadImage(GeneticBrowserTopComponent.ICON_PATH, true)));
    }

    public void actionPerformed(ActionEvent evt) {
        TopComponent win = ViewerTopComponent.findInstance();
        win.open();
        win.requestActive();
    }
}
