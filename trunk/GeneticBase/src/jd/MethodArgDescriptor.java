/* MethodArgDescriptor. Descriptor for an argument in a method
   signature. */

package jd;

public class MethodArgDescriptor extends JavaCodeDescriptor {
    public String argType;
    public String argName;

    public MethodArgDescriptor() {
	argType = null;
	argName = null;
    }

    public MethodArgDescriptor(String argTypeToSet, String argNameToSet) {
	argType = argTypeToSet;
	argName = argNameToSet;
    }

    public String toString() {
	return argType + " " + argName;
    }
}


