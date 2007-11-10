package jd;

public abstract class JavaCodeDescriptor {
    public abstract String toString();

    protected static String delimitedList(Object[] l, String delimiter) {

	if (l.length == 0) 
	    return "";
	else if (l.length == 1)
	    return (String)l[0];
	else {
	    StringBuffer tempBuffer = new StringBuffer();
	    for(int i = 0; i < l.length - 1; i++) {
		tempBuffer.append((String)l[i] + delimiter);
	    }
	    tempBuffer.append((String)l[l.length - 1]);
	    return tempBuffer.toString();
	}
    }
}
