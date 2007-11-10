package jd;

import java.util.*;
import java.io.*;

public class CodeSequenceDescriptor extends NestableCodeDescriptor {
    private List sequence = new Vector(100);

    public CodeSequenceDescriptor() {}

    public void addToSequence(NestableCodeDescriptor n) {
	sequence.add(n);
    }
    
    public void addToSequence(NestableCodeDescriptor[] n) 
    {
	for(int i = 0; i < n.length; i++)
	    sequence.add(n[i]);
    }

    public String toString(int nestLevel) {
	// fixme: create a constant at the top of the jd class hierarchy with a default buffer value
	StringWriter tempBuffer = new StringWriter(1024);
	PrintWriter tempPrinter = new PrintWriter(tempBuffer);
	
	Iterator iter = sequence.iterator();
	while(iter.hasNext()) {
	    NestableCodeDescriptor descriptor = (NestableCodeDescriptor)iter.next();
	    if (descriptor.getClass().getName().equals("jd.CodeSequenceDescriptor"))
		tempPrinter.println(descriptor.toString(nestLevel));
	    else
		tempPrinter.println(descriptor.toString(nestLevel + 1));
	}

	return tempBuffer.toString();
    }

}
