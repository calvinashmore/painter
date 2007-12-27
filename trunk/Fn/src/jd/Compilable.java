// Compileable objects must implement a transform which generates implementation code. 

package jd;

public interface Compilable {

    public JavaCodeDescriptor compileToJava() throws CompileException;
}


