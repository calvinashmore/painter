/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.icosilune.fnsupport.api;

import org.openide.nodes.Node;

/**
 *
 * @author Calvin Ashmore
 */
public interface FnProvider extends Node.Cookie {
    
    public FnDataResult getResult();
}
