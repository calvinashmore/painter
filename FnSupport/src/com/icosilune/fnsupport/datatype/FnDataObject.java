/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.datatype;

import java.io.IOException;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.nodes.CookieSet;
import org.openide.nodes.Node;
import org.openide.util.Lookup;
import org.openide.text.DataEditorSupport;

public class FnDataObject extends MultiDataObject {

    public FnDataObject(FileObject pf, FnDataLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        CookieSet cookies = getCookieSet();
        cookies.add((Node.Cookie) DataEditorSupport.create(this, getPrimaryEntry(), cookies));
        //cookies.add((Node.Cookie) FnOpenSupport.create(this, getPrimaryEntry()));
    }

    @Override
    protected Node createNodeDelegate() {
        return new FnDataNode(this, getLookup());
    }

    @Override
    public Lookup getLookup() {
        return getCookieSet().getLookup();
    }
}
