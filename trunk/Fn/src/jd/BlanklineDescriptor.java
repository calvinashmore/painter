package jd;

public class BlanklineDescriptor extends CodeStringDescriptor {

    /** Return a empty string. As with all CodeStringDescriptors, it is
    up to the caller to terminate the string with a newline if it
    is so desired. */
    @Override
    public String toString(int nestLevel) {
        return "";
    }

    /** The code string should not be set on BlanklineDescriptor. */
    @Override
    public void setCodeString(String codeStringToSet) {
        throw new JavaDescriptorError("setCodeString() should not be called on BlanklineDescriptor.");
    }
}

