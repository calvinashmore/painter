/* CodeStringDescriptor. Syntactic descriptor for a nested string. The
string might be a single line (like a field declaration) or have
complex multi-line structure (like an expanded macro template). */
package jd;

import java.util.*;
import java.io.*;

public class CodeStringDescriptor extends NestableCodeDescriptor {

    protected String codeString;

    public CodeStringDescriptor() {
        codeString = null;
    }

    public CodeStringDescriptor(String s) {
        codeString = s;
    }

    public void setCodeString(String codeStringToSet) {
        codeString = codeStringToSet;
    }

    /** Returns the codeString indented by nestLevel. In the event that
    the codeString consits of multiple lines, each line must be
    indented by nestLevel. */
    public String toString(int nestLevel) {
        BufferedReader bodyReader = new BufferedReader(new StringReader(codeString));
        StringWriter tempBuffer = new StringWriter();
        PrintWriter tempPrinter = new PrintWriter(tempBuffer);

        try {
            for (String bodyLine = bodyReader.readLine(); bodyLine != null; bodyLine = bodyReader.readLine()) {
                tempPrinter.println(leadingTabs(nestLevel) + bodyLine);
            }
        } catch (IOException e) {
            throw new JavaDescriptorError("IO error during CodeStringDescriptor.toString(int): ", e);
        }

        // return tempBuffer.toString();

        /* Return the code string, removing the last new line. */
        //return tempBuffer.getBuffer().substring(0, tempBuffer.getBuffer().length() -
        //        System.getProperty("line.separator").length());
        //return tempBuffer.getBuffer().toString();
        String result = tempBuffer.getBuffer().toString();
        if(result.endsWith(System.getProperty("line.separator")))
            return result.substring(0, result.length()-System.getProperty("line.separator").length());
        else return result;
    }
}
