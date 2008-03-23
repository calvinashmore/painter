/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.icosilune.fnsupport.options;

import org.netbeans.modules.editor.options.BaseOptionsBeanInfo;

/**
 *
 * @author Calvin Ashmore
 */
public class FnOptionsBeanInfo extends BaseOptionsBeanInfo {

    public FnOptionsBeanInfo() {
    }
    
    protected @Override Class getBeanClass() {
        return FnOptions.class;
    }
}
