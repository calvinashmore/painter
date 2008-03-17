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
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

public class FnDataObject extends MultiDataObject {

    final InstanceContent ic;
    private AbstractLookup lookup;
    
    public FnDataObject(FileObject pf, FnDataLoader loader) throws DataObjectExistsException, IOException {
        super(pf, loader);
        CookieSet cookies = getCookieSet();
        //cookies.add((Node.Cookie) DataEditorSupport.create(this, getPrimaryEntry(), cookies));
        //cookies.add((Node.Cookie) FnOpenSupport.create(this, getPrimaryEntry()));
        
        ic = new InstanceContent();
        lookup = new AbstractLookup(ic);
        ic.add(FnEditor.create(this));
        //ic.add(FnOpenSupport.create(this, getPrimaryEntry());
        ic.add(this);
    }

    @Override
    protected Node createNodeDelegate() {
        return new FnDataNode(this, getLookup());
    }

    @Override
    public Lookup getLookup() {
        return lookup;
    }
    
    @Override
    public Node.Cookie getCookie(Class type) {
        Object o = lookup.lookup(type);
        return o instanceof Node.Cookie ? (Node.Cookie)o : null;
    }
}
