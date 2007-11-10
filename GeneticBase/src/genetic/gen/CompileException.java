package genetic.gen;

public class CompileException extends Exception {
    public CompileException() {
	super();
    }
    
    public CompileException(String s) {
	super(s);
    }

    public CompileException(int lineNumber, String s) { super("line " + lineNumber + ": " + s); }
}
