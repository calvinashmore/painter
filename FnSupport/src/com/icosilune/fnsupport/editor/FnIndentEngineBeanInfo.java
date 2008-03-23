/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.editor;

import java.beans.BeanDescriptor;
import java.beans.SimpleBeanInfo;
import java.util.ResourceBundle;
import org.openide.util.NbBundle;

/**
 *
 * @author Calvin Ashmore
 */
public class FnIndentEngineBeanInfo extends SimpleBeanInfo {

    private BeanDescriptor beanDescriptor;

    public FnIndentEngineBeanInfo() {
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
        if (beanDescriptor == null) {
            beanDescriptor = new BeanDescriptor(FnIndentEngine.class);
            ResourceBundle bundle = NbBundle.getBundle(FnIndentEngine.class);
            beanDescriptor.setDisplayName(bundle.getString("LAB_MyIndentEngine"));
            beanDescriptor.setShortDescription(bundle.getString("HINT_MyIndentEngine"));
            beanDescriptor.setValue("global", Boolean.TRUE); // NOI18N
        }
        return beanDescriptor;
    }
}
