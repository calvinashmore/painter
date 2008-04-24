/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.painter.geneticsupport.explorer;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;

/**
 * Action which shows GeneticBrowser component.
 */
public class GeneticBrowserAction extends AbstractAction {

    public GeneticBrowserAction() {
        super(NbBundle.getMessage(GeneticBrowserAction.class, "CTL_GeneticBrowserAction"));
//        putValue(SMALL_ICON, new ImageIcon(Utilities.loadImage(GeneticBrowserTopComponent.ICON_PATH, true)));
    }

    public void actionPerformed(ActionEvent evt) {
        TopComponent win = GeneticBrowserTopComponent.findInstance();
        win.open();
        win.requestActive();
    }
}
