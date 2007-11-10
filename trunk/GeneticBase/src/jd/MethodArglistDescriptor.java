/* MethodArglistDescriptor. Syntactic descriptor for the list of
   arguments in a method signature. */

package jd;

import java.util.*;
import java.io.*;


public class MethodArglistDescriptor extends JavaCodeDescriptor {
    private List methodArgs = new Vector();
    private Hashtable argIndexTable = new Hashtable();
    private int argIndexCounter = 0;
    
    public void addArgument(MethodArgDescriptor m) {
	methodArgs.add(m);
	argIndexTable.put(m.argName, new Integer(argIndexCounter++));
    }
    
    /* Returns an array of the MethodArgDescriptors stored in this MethodArglistDescriptor. */
    public Object[] getArguments() {
	return methodArgs.toArray();
    }

    public String toString() {
	StringWriter tempBuffer = new StringWriter();

	tempBuffer.write("(");
	LinkedList args = new LinkedList();
	ListIterator iter = methodArgs.listIterator();
	while(iter.hasNext()) {
	    args.add(((MethodArgDescriptor)iter.next()).toString());
	}

	tempBuffer.write(delimitedList(args.toArray(), ", "));
	tempBuffer.write(")");

	return tempBuffer.toString();
    }

    public int getArgIndex(String argName) 
    {
	Integer argIndexInt = (Integer)argIndexTable.get(argName);
	
	// fixme: change this to a specialized exception
	if (argIndexInt == null) throw new Error("Unknown argument name " + argName);
	return argIndexInt.intValue();
    }
}


