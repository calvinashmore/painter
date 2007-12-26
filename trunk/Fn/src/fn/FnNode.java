/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fn;

import fn.parser.ASTExpression;
import fn.parser.ASTFnDefinition;
import fn.parser.ASTFnDefinition.TypeAndName;
import fn.parser.ASTLocalDeclaration;
import fn.parser.ASTType;
import java.util.Map;
import jd.ClassDescriptor;
import jd.CodeBlockDescriptor;
import jd.CodeStringDescriptor;
import jd.MethodDescriptor;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class FnNode /*implements Compilable*/ {

    public FnNode(ASTFnDefinition fn) {
        this.fn = fn;
    }
    
    private ASTFnDefinition fn;
    protected ASTFnDefinition getFn() {return fn;}
    
    abstract String getSuperclassName();
    
    /**
     * The meta initializer is inserted into the constructor
     * @return
     */
    CodeStringDescriptor make_metaInitializer() {
        StringBuffer sb = new StringBuffer();

        Map<String, ASTExpression> meta = getFn().getMeta();
        for (Map.Entry<String, ASTExpression> entry : meta.entrySet()) {
            sb.append("addMeta(");
            sb.append(  "\""+entry.getKey()+"\", ");
            sb.append(  entry.getValue().dumpTokens());
            sb.append(");\n");
        }

        return new CodeStringDescriptor(sb.toString());
    }
    
    boolean hasParameters() {
        return getFn().getTypeAndNames("parameter").size() > 0;
    }
    
    // implements Parameterized
    MethodDescriptor make_getNumberParameters() {
        MethodDescriptor method = new MethodDescriptor("getNumberParameters");
        method.addModifier("public");
        method.addModifier("int");
        
        int numberParameters = getFn( ).getTypeAndNames("parameter").size();
        method.addToBlockBody(new CodeStringDescriptor("return "+numberParameters+";"));
        return method;
    }
    
    MethodDescriptor make_getParameter() {
        MethodDescriptor method = new MethodDescriptor("getParameter");
        method.addModifier("public");
        method.addModifier("Object");
        method.addArgument("int","i");
        
        if(getFn( ).getTypeAndNames("parameter").size() == 0) {
            // no parameters
            method.addToBlockBody(new CodeStringDescriptor("return null;"));
        } else {
            // switch on parameters
            CodeBlockDescriptor block = new CodeBlockDescriptor();
            
            block.setBlockHeader("switch(i) {");
            int i=0;
            for (TypeAndName parameter : getFn( ).getTypeAndNames("parameter")) {
                block.addToBlockBody(new CodeStringDescriptor(
                        "case "+i+": return "+parameter.getName()+";\n"
                        ));
                i++;
            }
            block.addToBlockBody(new CodeStringDescriptor("default: return null;\n }"));
            block.setBlockFooter("}");
            method.addToBlockBody(block);
        }
        return method;
    }
    
    MethodDescriptor make_getParameterName() {
        MethodDescriptor method = new MethodDescriptor("getParameterName");
        method.addModifier("public");
        method.addModifier("String");
        method.addArgument("int","i");
        
        if(getFn( ).getTypeAndNames("parameter").size() == 0) {
            // no parameters
            method.addToBlockBody(new CodeStringDescriptor("return null;"));
        } else {
            // switch on parameters
            CodeBlockDescriptor block = new CodeBlockDescriptor();
            
            block.setBlockHeader("switch(i) {");
            int i=0;
            for (TypeAndName parameter : getFn( ).getTypeAndNames("parameter")) {
                block.addToBlockBody(new CodeStringDescriptor(
                        "case "+i+": return \""+parameter.getName()+"\";\n"
                        ));
                i++;
            }
            block.addToBlockBody(new CodeStringDescriptor("default: return null;\n }"));
            block.setBlockFooter("}");
            method.addToBlockBody(block);
        }
        return method;
    }
    
    MethodDescriptor make_getParameterType() {
        MethodDescriptor method = new MethodDescriptor("getParameterType");
        method.addModifier("public");
        method.addModifier("Class");
        method.addArgument("int","i");
        
        if(getFn( ).getTypeAndNames("parameter").size() == 0) {
            // no parameters
            method.addToBlockBody(new CodeStringDescriptor("return null;"));
        } else {
            // switch on parameters
            CodeBlockDescriptor block = new CodeBlockDescriptor();
            
            block.setBlockHeader("switch(i) {");
            int i=0;
            for (TypeAndName parameter : getFn( ).getTypeAndNames("parameter")) {
                block.addToBlockBody(new CodeStringDescriptor(
                        "case "+i+": return "+parameter.getType().dumpTokens()+".class;\n"
                        ));
                i++;
            }
            block.addToBlockBody(new CodeStringDescriptor("default: return null;\n }"));
            block.setBlockFooter("}");
            method.addToBlockBody(block);
        }
        return method;
    }
    MethodDescriptor make_setParameter() {
        MethodDescriptor method = new MethodDescriptor("setParameter");
        method.addModifier("public");
        method.addModifier("void");
        method.addArgument("int","i");
        method.addArgument("Object","value");
        
        if(getFn( ).getTypeAndNames("parameter").size() == 0) {
            // no parameters
            method.addToBlockBody(new CodeStringDescriptor(""));
        } else {
            // switch on parameters
            CodeBlockDescriptor block = new CodeBlockDescriptor();
            
            block.setBlockHeader("switch(i) {");
            int i=0;
            for (TypeAndName parameter : getFn( ).getTypeAndNames("parameter")) {
                block.addToBlockBody(new CodeStringDescriptor(
                        "case "+i+": "+parameter.getName()+" = ("+parameter.getType()+") value; break;\n"
                        ));
                i++;
            }
            block.addToBlockBody(new CodeStringDescriptor("default: return null;\n }"));
            block.setBlockFooter("}");
            method.addToBlockBody(block);
        }
        return method;
    }
    
    /**
     * returns a code string descriptor to be added to the class descriptor proper.
     * this initializes the variables for the parameters.
     * @return
     */
    CodeStringDescriptor make_parameterDeclarations() {
        StringBuffer sb = new StringBuffer();
        
        for (TypeAndName parameter : getFn( ).getTypeAndNames("parameter")) {
            sb.append("private ");
            sb.append(parameter.getType().dumpTokens()+" ");
            sb.append(parameter.getName()+";");
        }        
        return new CodeStringDescriptor(sb.toString());
    }
    
    MethodDescriptor make_constructor() {
        MethodDescriptor constructor = new MethodDescriptor(getFn( ).getName());
        constructor.addModifier("public");
        
        constructor.addToBlockBody(make_metaInitializer());
        
        if(getFn( ).getBlock("init") != null)
            constructor.addToBlockBody(new CodeStringDescriptor(getFn( ).getBlock("init").dumpBlock()));
        
        return constructor;
    }
    
    MethodDescriptor make_setup() {
        MethodDescriptor method = new MethodDescriptor("setup");
        method.addModifier("public");
        method.addModifier("void");
        
        if(getFn( ).getBlock("setup") != null)
            method.addToBlockBody(new CodeStringDescriptor(getFn( ).getBlock("init").dumpBlock()));
        
        return method;
    }
    
    MethodDescriptor make_getReturnType() {
        MethodDescriptor method = new MethodDescriptor("getReturnType");
        method.addModifier("public");
        method.addModifier("Class");
        
        method.addToBlockBody(new CodeStringDescriptor(
                "return "+getFn( ).getTypes("out").get(0)+".class;"
                ));
        
        return method;
    }
    
    boolean hasInputs() {
        return getFn( ).getTypeAndNames("input").size() > 0;
    }
    
    MethodDescriptor make_getNumberInputs() {
        MethodDescriptor method = new MethodDescriptor("getNumberInputs");
        method.addModifier("public");
        method.addModifier("int");
        
        int numberParameters = getFn( ).getTypeAndNames("input").size();
        method.addToBlockBody(new CodeStringDescriptor("return "+numberParameters+";"));
        return method;
    }
    MethodDescriptor make_getInputName() {
        MethodDescriptor method = new MethodDescriptor("getInputName");
        method.addModifier("public");
        method.addModifier("String");
        method.addArgument("int","i");
        
        if(getFn( ).getTypeAndNames("input").size() == 0) {
            // no inputs
            method.addToBlockBody(new CodeStringDescriptor("return null;"));
        } else {
            // switch on input
            CodeBlockDescriptor block = new CodeBlockDescriptor();
            
            block.setBlockHeader("switch(i) {");
            int i=0;
            for (TypeAndName input : getFn( ).getTypeAndNames("input")) {
                block.addToBlockBody(new CodeStringDescriptor(
                        "case "+i+": return \""+input.getName()+"\";\n"
                        ));
                i++;
            }
            block.addToBlockBody(new CodeStringDescriptor("default: return null;\n }"));
            block.setBlockFooter("}");
            method.addToBlockBody(block);
        }
        return method;
    }
    MethodDescriptor make_getInputType() {
        MethodDescriptor method = new MethodDescriptor("getInputType");
        method.addModifier("public");
        method.addModifier("String");
        method.addArgument("int","i");
        
        if(getFn( ).getTypeAndNames("input").size() == 0) {
            // no parameters
            method.addToBlockBody(new CodeStringDescriptor("return null;"));
        } else {
            // switch on parameters
            CodeBlockDescriptor block = new CodeBlockDescriptor();
            
            block.setBlockHeader("switch(i) {");
            int i=0;
            for (TypeAndName input : getFn( ).getTypeAndNames("input")) {
                block.addToBlockBody(new CodeStringDescriptor(
                        "case "+i+": return \""+input.getType().dumpTokens()+"\";\n"
                        ));
                i++;
            }
            block.addToBlockBody(new CodeStringDescriptor("default: return null;\n }"));
            block.setBlockFooter("}");
            method.addToBlockBody(block);
        }
        return method;
    }
    
    MethodDescriptor make_eval() {
        MethodDescriptor method = new MethodDescriptor("evaluate");
        method.addModifier("public");
        method.addModifier( getFn( ).getTypes("out").get(0).dumpTokens() );
        method.addArgument("Context", "context");
        method.addArgument("Object[]", "inputs");

        // we run the risk of dead assignments, but oh well.
        method.addToBlockBody(make_localDeclarations());
        
        // actual body for the evaluation
        method.addToBlockBody(new CodeStringDescriptor(getFn( ).getBlock("eval").dumpBlock()));
        
        return method;
    }
    
    MethodDescriptor make_exec() {
        MethodDescriptor method = new MethodDescriptor("exectue");
        method.addModifier("public");
        method.addModifier("void");
        method.addArgument("Context", "context");
        method.addArgument("Object[]", "inputs");

        // we run the risk of dead assignments, but oh well.
        method.addToBlockBody(make_localDeclarations());
        
        // actual body for the execution
        method.addToBlockBody(new CodeStringDescriptor(getFn( ).getBlock("exec").dumpBlock()));
        
        return method;
    }
    
    CodeStringDescriptor make_localDeclarations() {
        StringBuffer sb = new StringBuffer();
        
        for(ASTLocalDeclaration local : getFn( ).getLocalDeclarations()) {
            local.dump(sb, "");
        }
        
        return new CodeStringDescriptor(sb.toString());
    }
    
    CodeStringDescriptor make_inputDeclarations() {
        StringBuffer sb = new StringBuffer();
        
        int i=0;
        for (TypeAndName input : getFn( ).getTypeAndNames("input")) {
            sb.append(input.getType().dumpTokens()+" ");
            sb.append(input.getName()+" = input["+i+"];\n");
            i++;
        }
        
        return new CodeStringDescriptor(sb.toString());
    }
    
    /**
     * This method declares the class and adds general boilerplate code.
     * It does not do several things, namely: parameters, inputs, locals, setup, and constructor.
     * It does.... add exec/eval or return type
     * @return
     */
    ClassDescriptor make_class() {
        ClassDescriptor fnClass = new ClassDescriptor(getFn( ).getName(), getSuperclassName());
        fnClass.addClassModifier("public");
        fnClass.addClassModifier("static");
        fnClass.setIsNested(true);
        
        for(ASTType iface : getFn( ).getTypes("interface"))
            fnClass.addInterface(iface.dumpTokens());
        
        fnClass.addToBlockBody(make_localDeclarations());
        
        if(hasParameters()) {
            fnClass.addMethod(make_getNumberParameters());
            fnClass.addMethod(make_getParameter());
            fnClass.addMethod(make_getParameterName());
            fnClass.addMethod(make_getParameterType());
            fnClass.addMethod(make_setParameter());
        }
        
        if(hasInputs()) {
            fnClass.addMethod(make_getNumberInputs());
            fnClass.addMethod(make_getInputName());
            fnClass.addMethod(make_getInputType());
        }
        
        fnClass.addMethod(make_setup());
        fnClass.addMethod(make_constructor());
        
        return fnClass;
    }
    
    //getNumberTypes(String id);
    //getType()
}
