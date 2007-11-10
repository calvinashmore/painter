package jd;

import java.io.*;

public class JavaDescriptorError extends Error {
    public JavaDescriptorError() {
	super();
    }
    
    public JavaDescriptorError(String s) {
	super(s);
    }

    public JavaDescriptorError(String s, Throwable t) {
	super(fullErrorString(s, t));

    }

    protected static String fullErrorString(String s, Throwable t) {
	StringWriter tempWriter = new StringWriter();
	PrintWriter stackTrace = new PrintWriter(tempWriter);
	t.printStackTrace(stackTrace);
	return s + t.getMessage() + tempWriter;
    }
}



