/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.editor;

import com.icosilune.fnsupport.datatype.*;
import com.icosilune.fnsupport.api.FnResultListener;
import com.icosilune.fnsupport.api.FnDataResult;
import fn.parser.ParseException;
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
import org.openide.text.Annotation;
import org.openide.text.DataEditorSupport;
import org.openide.text.Line;
import org.openide.text.Line.Part;

/**
 *
 * @author Calvin Ashmore
 */
public class FnEditor extends DataEditorSupport
        implements OpenCookie, EditorCookie, EditCookie, DocumentListener, FnResultListener {

    //private static RequestProcessor RP = new RequestProcessor("findError"); // NOI18N
    //final RequestProcessor.Task findError;
    private final CheckTask checkTask;

    private FnEditor(FnDataObject obj) {
        super(obj, new MyEnv(obj));
        checkTask = obj.getLookup().lookup(CheckTask.class);


    //findError = RP.create(this, true);
    //findError.setPriority(Thread.MIN_PRIORITY);
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
            obj.addEnv(env);
        }

        getDocument().addDocumentListener(this);
        checkTask.schedule(0);

        return retValue;
    }

    @Override
    protected void notifyUnmodified() {
        getDocument().removeDocumentListener(this);

        super.notifyUnmodified();

        FnDataObject obj = (FnDataObject) getDataObject();
        obj.removeEnv(env);
    }

    @Override
    public StyledDocument openDocument() throws IOException {
        StyledDocument doc = super.openDocument();
        checkTask.schedule(0);
        //checkErrors();
        return doc;
    }

    public void insertUpdate(DocumentEvent e) {
        checkTask.schedule(500);
    }

    public void removeUpdate(DocumentEvent e) {
        checkTask.schedule(500);
    }

    public void changedUpdate(DocumentEvent e) {
    //checkTask.schedule(500);
    }

    //public void run() {
    //    checkErrors();
    //}
    //private void checkErrors() {
    //    new ValidityChecker(this).check(getDocument());
    //}
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

    public void onResult(FnDataResult result) {

        ParseException ex = result.getParseException();

        if (ex != null) {

            int lineNumber = ex.currentToken.beginLine;
            int beginColumn = ex.currentToken.beginColumn;

            Line line = getLineSet().getCurrent(lineNumber);

            FnErrorAnnotation.DEFAULT.setDescription(ex.getMessage());

            if (lineNumber == ex.currentToken.endLine) {
                int spanLength = ex.currentToken.endColumn - beginColumn;
                Part linePart = line.createPart(beginColumn, spanLength);
                FnErrorAnnotation.DEFAULT.attach(linePart);
            } else {
                FnErrorAnnotation.DEFAULT.attach(line);
            }
        } else {
            FnErrorAnnotation.DEFAULT.detach();
        }

    }

    private static final class FnErrorAnnotation extends Annotation {

        static final FnErrorAnnotation DEFAULT = new FnErrorAnnotation();
        private String description;

        void setDescription(String description) {
            this.description = description;
        }

        public String getAnnotationType() {
            return "com-icosilune-fnsupport-annotation";
        }

        public String getShortDescription() {
            return description; //"fn-error";
        }
    }
}
