/* MethodDescriptor. Syntactic descriptor for a Java method. */
package jd;

import java.util.*;
import java.io.*;

public class MethodDescriptor extends CodeBlockDescriptor {

    private LinkedList methodModifiers = new LinkedList();
    private MethodArglistDescriptor methodArguments = new MethodArglistDescriptor();
    private HashSet localVarNames = new HashSet();
    public String methodName;

    /** The method body is maintained by super.blockBody. */
    public void addModifier(String s) {
        methodModifiers.add(s);
    }

    public void addArgument(MethodArgDescriptor a) {
        methodArguments.addArgument(a);
    }

    public void addArgument(String argumentType, String argumentName) {
        MethodArgDescriptor a = new MethodArgDescriptor();

        a.argType = argumentType;
        a.argName = argumentName;
        methodArguments.addArgument(a);
    }

    public void addLocalVariableDecl(FieldDescriptor field) {
        String fieldType;
        String[] fieldNames;

        addToBlockBody(field);
        fieldNames = field.getFieldNames();
        for (int j = 0; j < fieldNames.length; j++) {
            if (localVarNames.contains(fieldNames[j])) {
                throw new JavaDescriptorError("Variable " + fieldNames[j] + " multiply defined in MethodDescriptor " + methodName);
            } else {
                localVarNames.add(fieldNames[j]);
            }
        }
    }

    public String toString(int nestLevel) {
        blockHeader = methodSignatureString() + " {";
        blockFooter = "}";
        return super.toString(nestLevel);
    }

    protected String methodSignatureString() {
        StringWriter tempBuffer = new StringWriter();

        // Output the method modifiers and method name
        ListIterator iter = methodModifiers.listIterator();
        while (iter.hasNext()) {
            tempBuffer.write((String) iter.next() + " ");
        }

        tempBuffer.write(methodName);

        //Output the arglist
        tempBuffer.write(methodArguments.toString());

        return tempBuffer.toString();
    }

    /* Block headers should not be set directy on a
    MethodDescriptor. */
    public void setBlockHeader(String headerToSet) {
        throw new JavaDescriptorError("setBlockHeader() should not be called on a MethodDescriptor.");
    }

    /* Block footers should not be set directy on a
    MethodDescriptor. */
    public void setBlockFooter(String footerToSet) {
        throw new JavaDescriptorError("setBlockFooter() should not be called on a MethodDescriptor.");
    }
}

