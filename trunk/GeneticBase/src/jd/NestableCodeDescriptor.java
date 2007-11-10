package jd;

public abstract class NestableCodeDescriptor extends JavaCodeDescriptor {

    public abstract String toString(int nestLevel);

    // The number of spaces corresponding to a tab.
    private final static String tabSpaces = "   ";

    public String toString() {
	return toString(0);
    }

    public static String leadingTabs(int tabCount) {
	StringBuffer tempBuffer = new StringBuffer();

	for(int i = 0; i < tabCount; i++) {
	    tempBuffer.append(tabSpaces);
	}
	return tempBuffer.toString();
    }
}
