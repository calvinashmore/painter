/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.datatype;

import java.io.IOException;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.UniFileLoader;
import org.openide.util.NbBundle;

public class FnDataLoader extends UniFileLoader {

    public static final String REQUIRED_MIME = "text/x-fn";
    private static final long serialVersionUID = 1L;

    public FnDataLoader() {
        super("com.icosilune.fnsupport.datatype.FnDataObject");
    }

    @Override
    protected String defaultDisplayName() {
        return NbBundle.getMessage(FnDataLoader.class, "LBL_Fn_loader_name");
    }

    @Override
    protected void initialize() {
        super.initialize();
        getExtensions().addMimeType(REQUIRED_MIME);
    }

    protected MultiDataObject createMultiObject(FileObject primaryFile) throws DataObjectExistsException, IOException {
        return new FnDataObject(primaryFile, this);
    }

    @Override
    protected String actionsContext() {
        return "Loaders/" + REQUIRED_MIME + "/Actions";
    }
    
}
