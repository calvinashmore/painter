/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.options;

import com.icosilune.fnsupport.editor.FnIndentEngine;
import org.netbeans.modules.editor.options.BaseOptions;

/**
 *
 * @author Calvin Ashmore
 */
public class FnOptions extends BaseOptions {

    public FnOptions() {
        super();
    }
    
    @Override
    protected Class getDefaultIndentEngineClass() {
        return FnIndentEngine.class;
    }
}
