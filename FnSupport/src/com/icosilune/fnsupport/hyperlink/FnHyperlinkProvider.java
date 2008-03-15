/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.hyperlink;

import java.lang.ref.Reference;
import java.util.Set;
import javax.swing.text.Document;
import org.netbeans.lib.editor.hyperlink.spi.HyperlinkProviderExt;
import org.netbeans.lib.editor.hyperlink.spi.HyperlinkType;

/**
 *
 * @author Calvin Ashmore
 */
public class FnHyperlinkProvider implements HyperlinkProviderExt {

    private Reference<Document> lastDocument;
    private int startOffset;
    private int endOffset;
    private String identifier;

    public Set<HyperlinkType> getSupportedHyperlinkTypes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isHyperlinkPoint(Document arg0, int arg1, HyperlinkType arg2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int[] getHyperlinkSpan(Document arg0, int arg1, HyperlinkType arg2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void performClickAction(Document arg0, int arg1, HyperlinkType arg2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getTooltipText(Document arg0, int arg1, HyperlinkType arg2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
