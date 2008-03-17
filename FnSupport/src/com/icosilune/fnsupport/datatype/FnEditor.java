/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.datatype;

import java.io.IOException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.StyledDocument;
import org.openide.cookies.EditCookie;
import org.openide.cookies.EditorCookie;
import org.openide.cookies.OpenCookie;
import org.openide.cookies.SaveCookie;
import org.openide.filesystems.FileLock;
import org.openide.filesystems.FileObject;
import org.openide.text.DataEditorSupport;
import org.openide.util.RequestProcessor;

/**
 *
 * @author Calvin Ashmore
 */
public class FnEditor extends DataEditorSupport
        implements OpenCookie, EditorCookie, EditCookie, DocumentListener, Runnable {

    private static RequestProcessor RP = new RequestProcessor("findError"); // NOI18N
    final RequestProcessor.Task findError;

    private FnEditor(FnDataObject obj) {
        super(obj, new MyEnv(obj));
        findError = RP.create(this, true);
        findError.setPriority(Thread.MIN_PRIORITY);
    }

    public static FnEditor create(FnDataObject obj) {
        return new FnEditor(obj);
    }

    @Override
    protected boolean notifyModified() {

        boolean retValue;
        retValue = super.notifyModified();
        if (retValue) {
            FnDataObject obj = (FnDataObject) getDataObject();
            obj.ic.add(env);
        }

        getDocument().addDocumentListener(this);
        findError.schedule(0);

        return retValue;
    }

    @Override
    protected void notifyUnmodified() {
        getDocument().removeDocumentListener(this);

        super.notifyUnmodified();

        FnDataObject obj = (FnDataObject) getDataObject();
        obj.ic.remove(env);
    }
    
    @Override
    public StyledDocument openDocument() throws IOException {
        StyledDocument doc = super.openDocument();
        checkErrors();
        return doc;
    }

    public void insertUpdate(DocumentEvent e) {
        findError.schedule(500);
    }

    public void removeUpdate(DocumentEvent e) {
        findError.schedule(500);
    }

    public void changedUpdate(DocumentEvent e) {
        findError.schedule(500);
    }

    public void run() {
        checkErrors();
    }
    
    private void checkErrors() {
        new ValidityChecker(this).check(getDocument());
    }

    private static final class MyEnv extends DataEditorSupport.Env
            implements SaveCookie {

        public MyEnv(FnDataObject obj) {
            super(obj);
        }

        public void save() throws IOException {
            FnEditor ed = (FnEditor) this.findCloneableOpenSupport();
            ed.saveDocument();
        }

        protected FileObject getFile() {
            return super.getDataObject().getPrimaryFile();
        }

        protected FileLock takeLock() throws IOException {
            return ((FnDataObject) super.getDataObject()).getPrimaryEntry().takeLock();
        }
    }
}
