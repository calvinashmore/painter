/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.datatype;

import fn.parser.ASTFnTopLevel;
import fn.parser.FnParser;
import fn.parser.ParseException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import org.openide.text.Annotation;
import org.openide.text.Line;
import org.openide.text.Line.Part;

/**
 *
 * @author Calvin Ashmore
 */
public class ValidityChecker {

    private FnEditor ed;

    public ValidityChecker(FnEditor ed) {
        this.ed = ed;
    }
    private static Logger LOG = Logger.getLogger(ValidityChecker.class.getName());

    public void check(StyledDocument doc) {

        if (doc == null) {
            // if parsing succeeds than there is no error
            FnErrorAnnotation.DEFAULT.detach();
            return;
        }

        String txt;
        try {
            txt = doc.getText(0, doc.getLength());
        } catch (BadLocationException ex) {
            LOG.log(Level.WARNING, null, ex);
            return;
        }
        InputStream input = new ByteArrayInputStream(txt.getBytes());

        FnParser parser = new FnParser(input);

        try {
            ASTFnTopLevel n = parser.FnTopLevel();
        } catch (ParseException ex) {
            int lineNumber = ex.currentToken.beginLine;
            int beginColumn = ex.currentToken.beginColumn;

            Line line = ed.getLineSet().getCurrent(lineNumber);

            FnErrorAnnotation.DEFAULT.setDescription(ex.getMessage());
            
            if (lineNumber == ex.currentToken.endLine) {
                int spanLength = ex.currentToken.endColumn - beginColumn;
                Part linePart = line.createPart(beginColumn, spanLength);
                FnErrorAnnotation.DEFAULT.attach(linePart);
            } else {
                FnErrorAnnotation.DEFAULT.attach(line);
            }
            return;
        }

        FnErrorAnnotation.DEFAULT.detach();
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
