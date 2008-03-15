/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.editor;

import javax.swing.text.Document;
import org.netbeans.editor.Formatter;
import org.netbeans.editor.Syntax;
import org.netbeans.modules.editor.NbEditorKit;
import com.icosilune.fnsupport.syntax.FnSyntax;
import org.netbeans.editor.ext.java.JavaFormatter;

/**
 *
 * @author Calvin Ashmore
 */
public class FnEditorKit extends NbEditorKit {

    @Override
    public Syntax createSyntax(Document doc) {
        //return super.createSyntax(arg0);
        return new FnSyntax();
    }

    @Override
    public String getContentType() {
        return "text/x-fn";
    }

    @Override
    public Formatter createFormatter() {
        return new JavaFormatter(getClass());
    }
    
    
}
