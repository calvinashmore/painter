/* MethodDescriptor. Syntactic descriptor for a Java method. */
package jd;

import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class MethodDescriptor extends CodeBlockDescriptor {

    private List<String> methodModifiers = new LinkedList();
    private MethodArglistDescriptor methodArguments = new MethodArglistDescriptor();
    private HashSet<String> localVarNames = new HashSet();
    private String methodName;
    private List<String> methodThrows = new ArrayList<String>();

    public MethodDescriptor(String methodName) {
        this.methodName = methodName;
    }
    
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

    public void addThrowsClause(String exception) {
        methodThrows.add(exception);
    }

    @Override
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

        if(methodThrows.size() > 0) {
            tempBuffer.write(" throws ");
            tempBuffer.write(methodThrows.get(0));
            for(int i=1; i<methodThrows.size(); i++)
                tempBuffer.write(", "+methodThrows.get(i));
        }
        
        return tempBuffer.toString();
    }

    /** Block headers should not be set directy on a
    MethodDescriptor. */
    public void setBlockHeader(String headerToSet) {
        throw new JavaDescriptorError("setBlockHeader() should not be called on a MethodDescriptor.");
    }

    /** Block footers should not be set directy on a
    MethodDescriptor. */
    public void setBlockFooter(String footerToSet) {
        throw new JavaDescriptorError("setBlockFooter() should not be called on a MethodDescriptor.");
    }
}

