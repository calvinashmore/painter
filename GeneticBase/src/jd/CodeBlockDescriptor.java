package jd;

import java.util.*;
import java.io.*;

public class CodeBlockDescriptor extends NestableCodeDescriptor {
    
    protected String blockHeader;
    protected String blockFooter;
    protected LinkedList<NestableCodeDescriptor> blockBody = new LinkedList();

    public CodeBlockDescriptor() {
	blockHeader = null;
	blockFooter = null;
    }

    public CodeBlockDescriptor(String headerToSet, String footerToSet) {
	blockHeader = headerToSet;
	blockFooter = footerToSet;
    }

    public void setBlockHeader(String headerToSet) {
	blockHeader = headerToSet;
    }

    public void setBlockFooter(String footerToSet) {
	blockFooter = footerToSet;
    }

    public void addToBlockBody(NestableCodeDescriptor n) {
       blockBody.add(n);
    }

    public void addToBlockBody(NestableCodeDescriptor[] n) 
    {
	for(int i = 0; i < n.length; i++)
	    blockBody.add(n[i]);
    }

    public String toString(int nestLevel) {
	StringWriter tempBuffer = new StringWriter(1024);
	PrintWriter tempPrinter = new PrintWriter(tempBuffer);
	
	if (blockHeader != null) {
	    tempPrinter.print(leadingTabs(nestLevel));
	    tempPrinter.println(blockHeader);
	}

	ListIterator<NestableCodeDescriptor> iter = blockBody.listIterator();
	while(iter.hasNext()) {
	    NestableCodeDescriptor descriptor = iter.next();
            if(descriptor == null)
                continue; // ???
	    if (descriptor.getClass().getName().equals("jd.CodeSequenceDescriptor"))
		tempPrinter.println(descriptor.toString(nestLevel));
	    else
		tempPrinter.println(descriptor.toString(nestLevel + 1));
	}

	if (blockFooter != null) {
	    tempPrinter.print(leadingTabs(nestLevel));
	    tempPrinter.println(blockFooter);
	}
	return tempBuffer.toString();
    }
}
	    
			      
	    
