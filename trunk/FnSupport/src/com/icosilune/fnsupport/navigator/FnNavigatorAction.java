/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.navigator;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import org.openide.util.NbBundle;
import org.openide.util.Utilities;
import org.openide.windows.TopComponent;

/**
 * Action which shows FnNavigator component.
 */
public class FnNavigatorAction extends AbstractAction {

    public FnNavigatorAction() {
        super(NbBundle.getMessage(FnNavigatorAction.class, "CTL_FnNavigatorAction"));
        putValue(SMALL_ICON, new ImageIcon(Utilities.loadImage(FnNavigatorTopComponent.ICON_PATH, true)));
    }

    public void actionPerformed(ActionEvent evt) {
        TopComponent win = FnNavigatorTopComponent.findInstance();
        win.open();
        win.requestActive();
    }
}
