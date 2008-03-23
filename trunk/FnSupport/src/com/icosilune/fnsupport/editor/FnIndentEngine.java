/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.fnsupport.editor;

import java.io.IOException;
import java.io.Writer;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import org.openide.text.IndentEngine;

/**
 *
 * @author Calvin Ashmore
 */
public class FnIndentEngine extends IndentEngine {

    public FnIndentEngine() {
        System.out.println("intent engine constructed?");
    }

    
    
    public int indentLine(Document doc, int offset) {
        return offset;
    }

    public int indentNewLine(Document doc, int offset) {
        try {
            Element rootElem = doc.getDefaultRootElement();
            // Offset should be valid -&gt; no check for lineIndex -1
            int lineIndex = rootElem.getElementIndex(offset);
            String lineText;
            int whitespaceEndIndex;
            do {
                Element lineElem = rootElem.getElement(lineIndex);
                lineText = doc.getText(lineElem.getStartOffset(),
                        lineElem.getEndOffset() - lineElem.getStartOffset() - 1); // strip ending '\n'
                whitespaceEndIndex = 0;
                while (whitespaceEndIndex < lineText.length()) {
                    // Break on non-whitespace char
                    if (!Character.isWhitespace(lineText.charAt(whitespaceEndIndex))) {
                        lineIndex = 0; // stop outer loop
                        break;
                    }
                    whitespaceEndIndex++;
                }
                lineIndex--; // continue to search for previous non-whitespace line
            } while (lineIndex >= 0);

            String nlPlusIndent = "\n" + lineText.substring(0, whitespaceEndIndex);
            doc.insertString(offset, nlPlusIndent, null); // NOI18N
            offset += nlPlusIndent.length();
        } catch (BadLocationException ex) {
        // ignore
        }

        return offset;
    }

    public Writer createWriter(Document doc, int offset, Writer writer) {
        return new IndentWriter(writer);
    }

    private static final class IndentWriter extends Writer {

        private final Writer writer;

        IndentWriter(Writer writer) {
            this.writer = writer;
        }

        public void write(char[] cbuf, int off, int len) throws IOException {
            int lastOff = off;
            while (off <= len) {
                if (cbuf[off++] == '\n') {
                    writer.write(cbuf, lastOff, off - lastOff);
                    lastOff = off;
                    // Write extra indent
                    writer.write("    ");
                }
            }
        }

        public void flush() throws IOException {
            writer.flush();
        }

        public void close() throws IOException {
            writer.close();
        }
    }

    @Override
    protected boolean acceptMimeType(String mime) {
        return "text/x-fn".equals(mime);
    }
}
