/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.icosilune.fnsupport.api;

import fn.parser.ASTFnTopLevel;
import fn.parser.ParseException;

/**
 *
 * @author Calvin Ashmore
 */
public interface FnDataResult {

    public Boolean isValid();
    
    public ASTFnTopLevel getAST();
    public String getJavaCode();
    
    public ParseException getParseException();
    public Exception getOtherException();
}
