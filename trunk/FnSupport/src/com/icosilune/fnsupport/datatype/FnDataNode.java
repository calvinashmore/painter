/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.datatype;

import com.icosilune.fnsupport.api.FnDataResult;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.openide.filesystems.FileChangeAdapter;
import org.openide.filesystems.FileChangeListener;
import org.openide.filesystems.FileEvent;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataNode;
import org.openide.loaders.DataObject;
import org.openide.nodes.Children;
import org.openide.util.Lookup;
import org.openide.util.Utilities;

public class FnDataNode extends DataNode implements FnResultListener, PropertyChangeListener {

    private static final String IMAGE_ICON_BASE = "com/icosilune/fnsupport/datatype/fn.png";
    private static final String ERROR_BADGE_PATH = "com/icosilune/fnsupport/datatype/errorbadge.png";

    public FnDataNode(FnDataObject obj) {
        this(obj, null);
    }
    private FileChangeListener fileListener;

    FnDataNode(FnDataObject obj, Lookup lookup) {
        super(obj, Children.LEAF, lookup);
        setIconBaseWithExtension(IMAGE_ICON_BASE);

        fileListener = new IconUpdateChecker();
        FileObject file = obj.getPrimaryFile();
        file.addFileChangeListener(FileUtil.weakFileChangeListener(fileListener, file));
    }

    public Image getIcon(int type) {
        Image original = super.getIcon(type);
        if (isValid()) {
            return original;
        } else {
            Image errorBadge = Utilities.loadImage(ERROR_BADGE_PATH);
            return Utilities.mergeImages(original, errorBadge, 5, 5);
        }
    }
    private Boolean valid;

    private boolean isValid() {
        return valid == null ? true : valid;
    }

    public void onResult(FnDataResult result) {
        Boolean newValid = result.isValid();
        if (valid != newValid) {
            fireIconChange();
        }
        valid = newValid;
    }

    private class IconUpdateChecker extends FileChangeAdapter {

        @Override
        public void fileChanged(FileEvent fe) {
            CheckTask checkTask = getDataObject().getLookup().lookup(CheckTask.class);
            if (checkTask != null) {
                checkTask.schedule(0);
            }
        }
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (DataObject.PROP_PRIMARY_FILE.equals(evt.getPropertyName())) {
            FileObject nue = (FileObject) evt.getNewValue();
            if (nue != null) {
                nue.addFileChangeListener(FileUtil.weakFileChangeListener(fileListener, nue));
            }
        }
    }
}
