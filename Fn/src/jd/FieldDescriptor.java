package jd;

import java.util.*;

public class FieldDescriptor extends CodeStringDescriptor {

    public String fieldType;
    private LinkedList fieldNames = new LinkedList();
    private LinkedList fieldModifiers = new LinkedList();
    public String initializer;

    public FieldDescriptor() {
        fieldType = null;
        initializer = null;
    }

    public void addFieldModifier(String s) {
        fieldModifiers.add(s.intern());
    }

    public void addFieldModifiers(String[] s) {
        for (int i = 0; i < s.length; i++) {
            addFieldModifier(s[i].intern());
        }
    }

    public void addFieldName(String s) {
        fieldNames.add(s.intern());
    }

    public String[] getFieldNames() {
        Object[] objArray = fieldNames.toArray();
        String[] fNames = new String[objArray.length];
        System.arraycopy(objArray, 0, fNames, 0, objArray.length);
        return fNames;
    }

    @Override
    public int hashCode() {
        int hashValue = fieldType.hashCode();
        for (int i = 0; i < fieldNames.size(); i++) {
            hashValue += fieldNames.get(i).hashCode();
        }
        return hashValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        FieldDescriptor fieldDescriptorToCompare = (FieldDescriptor) obj;
        if (!fieldDescriptorToCompare.fieldType.equals(fieldType)) {
            return false;
        }

        String[] fieldNamesToCompare = fieldDescriptorToCompare.getFieldNames();
        if (fieldNamesToCompare.length != fieldNames.size()) {
            return false;
        }

        int i, j;
        for (i = 0; i < fieldNamesToCompare.length; i++) {
            for (j = 0; j < fieldNames.size(); j++) {
                if (fieldNamesToCompare[i].equals(fieldNames.get(j))) {
                    break;
                }
            }
            if (j >= fieldNames.size()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(int nestLevel) {
        codeString = fieldDeclarationString();
        return super.toString(nestLevel);
    }

    protected String fieldDeclarationString() {
        StringBuffer tempBuffer = new StringBuffer();

        tempBuffer.append(delimitedList(fieldModifiers.toArray(), " "));
        /* for(int i = 0; i < fieldModifiers.size(); i++) {
        tempBuffer.append((String)fieldModifiers.get(i));
        }*/
        if (fieldModifiers.size() != 0) {
            tempBuffer.append(" ");
        }


        tempBuffer.append(fieldType + " ");
        tempBuffer.append(delimitedList(fieldNames.toArray(), ", "));

        if (initializer != null) {
            tempBuffer.append(" = " + initializer);
        }
        tempBuffer.append(";");

        return tempBuffer.toString();
    }

    /* The code string should not be set directly on a
    FieldDescriptor. */
    @Override
    public void setCodeString(String codeStringToSet) {
        throw new JavaDescriptorError("setCodeString() should not be called on a FieldDescriptor.");
    }
}

