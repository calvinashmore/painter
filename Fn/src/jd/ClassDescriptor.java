/* Class that stores the description of a class. Unlike the reflection API, which supports getting information
at runtime about already compiled classes, this class is designed to facilitate the construction of class
declarations at runtime. */
package jd;

import java.util.*;
import java.io.*;

public class ClassDescriptor extends CodeBlockDescriptor {

    public String packageName;
    private List<String> imports = new LinkedList();
    public String className;
    private List<String> classModifiers = new LinkedList();
    private List<FieldDescriptor> fieldMembers = new LinkedList();
    private List<MethodDescriptor> methodMembers = new LinkedList();
    private List<ClassDescriptor> nestedClasses = new LinkedList();
    private List<NestableCodeDescriptor> miscMembers = new LinkedList();
    private Vector staticBlocks = new Vector();
    public String extendsClass;
    private List<String> interfaces = new LinkedList();
    private int nestLevel = 0;
    private boolean isNested = false;

    public void setIsNested(boolean isNested) {
        this.isNested = isNested;
        if (isNested) {
            nestLevel++;
        }
    }

    public void addPackageImport(String importPackage) {
        imports.add(importPackage);
    }

    public void addNestedClass(ClassDescriptor c) {
        nestedClasses.add(c);
    }

    public void addField(FieldDescriptor f) {
        fieldMembers.add(f);
    }

    public void addField(String[] fieldModifiers, String typeName, String fieldName, String initializer) {
        FieldDescriptor f = new FieldDescriptor();

        f.fieldType = typeName;
        f.addFieldName(fieldName);
        f.addFieldModifiers(fieldModifiers);
        f.initializer = initializer;
        fieldMembers.add(f);
    }

    public FieldDescriptor[] getFields() {
        LinkedList fieldArray = new LinkedList();
        FieldDescriptor tempField;
        FieldDescriptor currentField;

        ListIterator iter = fieldMembers.listIterator();
        while (iter.hasNext()) {
            currentField = (FieldDescriptor) iter.next();
            String[] fieldNames = currentField.getFieldNames();
            String fieldType = currentField.fieldType;
            tempField = new FieldDescriptor();
            for (int j = 0; j < fieldNames.length; j++) {
                tempField.fieldType = fieldType;
                tempField.addFieldName(fieldNames[j]);
            }
            fieldArray.add(tempField);
        }
        Object[] objArray = fieldArray.toArray();
        FieldDescriptor[] fdArray = new FieldDescriptor[objArray.length];
        System.arraycopy(objArray, 0, fdArray, 0, objArray.length);
        return fdArray;
    }

    public void addMethod(MethodDescriptor m) {
        methodMembers.add(m);
    }

    public void addClassModifier(String s) {
        classModifiers.add(s);
    }

    public void addInterface(String s) {
        interfaces.add(s);
    }

    public void addStaticBlock(CodeStringDescriptor desc) {
        CodeBlockDescriptor staticBlock = new CodeBlockDescriptor();
        staticBlock.setBlockHeader("static {");
        staticBlock.addToBlockBody(desc);
        staticBlock.setBlockFooter("}");
        staticBlocks.add(staticBlock);
    }

    @Override
    public String toString(int nestLevel) {
        StringWriter tempWriter = new StringWriter();
        PrintWriter tempPrinter = new PrintWriter(tempWriter);

        if (className == null) {
            throw new JavaDescriptorError("Attempt to call toString(int) on an instance of ClassDescriptor without a specified class name");
        }

        ListIterator iter;

        // First create the block header.
        if (!isNested) {
            // Add the package (with a newline) to the block header.
            if (packageName != null) {
                tempPrinter.println("package " + packageName + ";");
                tempPrinter.println();
            }

            // Add the package imports to the block header.
            if (imports.size() != 0) {
                iter = imports.listIterator();
                while (iter.hasNext()) {
                    tempPrinter.println("import " + (String) iter.next() + ";");
                }
                tempPrinter.println();
            }
        }

        // Output the class modifiers

        tempWriter.write(delimitedList(classModifiers.toArray(), " "));
        if (classModifiers.size() != 0) {
            tempWriter.write(" ");
        }

        //Output the class name 
        tempWriter.write("class " + className);

        if (extendsClass != null) {
            tempWriter.write(" extends " + extendsClass);
        }

        if (interfaces.size() != 0) {
            tempWriter.write(" implements " + delimitedList(interfaces.toArray(), ", "));
        }

        tempWriter.write(" {");
        blockHeader = tempWriter.toString();

        // Create the block footer. 
        blockFooter = "}";

        // Copy the fields and methods into the blockBody.
        blockBody.clear();
        blockBody.addAll(miscMembers);
        //blockBody.add(new BlanklineDescriptor());
        blockBody.addAll(nestedClasses);
        //blockBody.add(new BlanklineDescriptor());
        blockBody.addAll(fieldMembers);
        //blockBody.add(new BlanklineDescriptor());
        blockBody.addAll(staticBlocks);
        //blockBody.add(new BlanklineDescriptor());
        blockBody.addAll(methodMembers);

        // Return the string representation of this class.
        return super.toString(nestLevel);
    }

    /** Block headers should not be set directy on a
    ClassDescriptor. */
    @Override
    public void setBlockHeader(String headerToSet) {
        throw new JavaDescriptorError("setBlockHeader() should not be called on a ClassDescriptor.");
    }

    /** Block footers should not be set directy on a
    ClassDescriptor. */
    @Override
    public void setBlockFooter(String footerToSet) {
        throw new JavaDescriptorError("setBlockFooter() should not be called on a ClassDescriptor.");
    }

    /** The block body should not be set directly on a
    ClassDescriptor. /
    public void addToBlockBody(NestableCodeDescriptor n) {
    throw new JavaDescriptorError("addToBlockBody() should not be called on a ClassDescriptor.");
    }*/
    @Override
    public void addToBlockBody(NestableCodeDescriptor n) {
        miscMembers.add(n);
    }

    private void writeToFileHelper(File directory, String codeToWrite) {
        try {
            PrintStream classStream = new PrintStream(new FileOutputStream(new File(directory, className + ".java")));
            classStream.print(codeToWrite);
            classStream.close();
        } catch (IOException e) {
            throw new JavaDescriptorError("Error writing " + className + ".java", e);
        }
    }

    // If the generated java file is the same, don't replace (speeds up jikes compilation).
    public boolean writeToFile(File directory) {
        String newJavaCode = this.toString();
        BufferedReader classReader;
        try {
            classReader = new BufferedReader(new FileReader(new File(directory, className + ".java")));
        } catch (FileNotFoundException e) {
            writeToFileHelper(directory, newJavaCode);
            return true;
        }
        StringBuffer javaCode = new StringBuffer(8000);
        try {
            for (int c = classReader.read(); c != -1; c = classReader.read()) {
                javaCode.append((char) c);
            }
            classReader.close();
        } catch (IOException e) {
            // An IOException occured while trying to read the .java file. Report the error.
            throw new JavaDescriptorError("Error reading " + className + ".java", e);
        }
        if (!javaCode.toString().equals(newJavaCode)) {
            // code isn't equal - write the new code
            writeToFileHelper(directory, newJavaCode);
            return true;
        } else {
            return false;
        }
    }

    // code to test compiling as public static nested classes
    public void writeNestedClassToStream(PrintStream stream) {
        addClassModifier("static");
        stream.print(toString());
    }
}
	
