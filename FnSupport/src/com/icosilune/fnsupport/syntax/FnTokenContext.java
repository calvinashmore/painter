/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.syntax;

import org.netbeans.editor.TokenContext;
import org.netbeans.editor.TokenContextPath;

/**
 *
 * @author Calvin Ashmore
 */
public class FnTokenContext extends TokenContext {

    public static final FnTokenContext context = new FnTokenContext();
    public static final TokenContextPath contextPath = context.getContextPath();

    public FnTokenContext() {
        super("fn-");
    }
}
