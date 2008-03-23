package com.icosilune.fnsupport.datatype;

import com.icosilune.fnsupport.editor.FnEditor;
import com.icosilune.fnsupport.api.FnDataResult;
import com.icosilune.fnsupport.api.FnProvider;
import fn.FnCompiler;
import fn.parser.ASTFnTopLevel;
import fn.parser.FnParser;
import fn.parser.ParseException;
import fn.parser.TokenMgrError;
import java.awt.EventQueue;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.text.StyledDocument;

class FnProviderImpl implements FnProvider {

    FnDataObject dataObject;

    FnProviderImpl(FnDataObject dataObject) {
        super();
        this.dataObject = dataObject;
    }

    //private FileObject getFile() {
    //    return dataObject.getPrimaryFile();
    //}
    public FnDataResult getResult() {
        if (EventQueue.isDispatchThread()) {
            throw new IllegalStateException("Do not call on event thread!");
        }

        FnDataResultImpl result = new FnDataResultImpl();

        //InputStream input = null;
        try {
            //FileObject file = dataObject.getPrimaryFile();
            //input = file.getInputStream();
            FnEditor editor = dataObject.getLookup().lookup(FnEditor.class);
            StyledDocument document = editor.getDocument();


            String txt;
            txt = document.getText(0, document.getLength());
            InputStream input = new ByteArrayInputStream(txt.getBytes());


            result.topLevel = new FnParser(input).FnTopLevel();
            result.codeString = new FnCompiler().compile(result.topLevel).toString();

            result.valid = true;
        } catch (ParseException ex) {
            result.parseException = ex;
            result.valid = false;
        } catch (TokenMgrError ex) {
            result.otherException = new Exception(ex);
            result.valid = false;
        } catch (Exception ex) {
            result.otherException = ex;
            result.valid = false;
        }

        return result;
    }

    private class FnDataResultImpl implements FnDataResult {

        ASTFnTopLevel topLevel = null;
        ParseException parseException = null;
        String codeString = null;
        Boolean valid = null;
        Exception otherException = null;

        public ASTFnTopLevel getASTFnTopLevel() {

            return topLevel;
        }

        public Boolean isValid() {
            return valid;
        }

        public ASTFnTopLevel getAST() {
            return topLevel;
        }

        public String getJavaCode() {
            return codeString;
        }

        public ParseException getParseException() {
            return parseException;
        }

        public Exception getOtherException() {
            return otherException;
        }
    }
}
