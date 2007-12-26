/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fn;

import fn.parser.ASTFnDefinition;
import fn.parser.ASTFnDefinition.TypeAndName;
import jd.ClassDescriptor;
import jd.CodeBlockDescriptor;
import jd.CodeStringDescriptor;
import jd.MethodDescriptor;

/**
 *
 * @author Calvin Ashmore
 */
public class StatementFnNode extends FnNode {

    public StatementFnNode(ASTFnDefinition fn) {
        super(fn);
    }

    @Override
    String getSuperclassName() {
        return "StatementFunction";
    }
    
    
    @Override
    boolean hasInputs() {
        return  getFn().getTypeAndNames("exin").size() +
                getFn().getTypes("slin").size() > 0;
    }

    @Override
    MethodDescriptor make_getNumberInputs() {
        
    }

    @Override
    MethodDescriptor make_getInputName() {
        
    }

    @Override
    MethodDescriptor make_getInputType() {
        // this is totally different, than the super implementation
        // instead, it makes InputSignature getInputSignature(int i)
        
        MethodDescriptor method = new MethodDescriptor("getInputSignature");
        method.addModifier("public");
        method.addModifier("InputSignature");
        method.addArgument("int","i");
        
        
    }

    @Override
    CodeStringDescriptor make_inputDeclarations() {
        
    }
    
    
    boolean hasContextVariables() {
        return getFn( ).getTypeAndNames("cvar").size() > 0;
    }
    
    public MethodDescriptor make_getNumberContextVariables() {
        MethodDescriptor method = new MethodDescriptor("getNumberContextVariables");
        method.addModifier("public");
        method.addModifier("int");
        method.addArgument("int", "i");
        
        int numberContextVariables = getFn( ).getTypeAndNames("cvar").size();
        method.addToBlockBody(new CodeStringDescriptor("return "+numberContextVariables+";"));
        return method;
    }
    
    public MethodDescriptor make_getContextVariableIntendedName() {
        MethodDescriptor method = new MethodDescriptor("getContextVariableIntendedName");
        method.addModifier("public");
        method.addModifier("String");
        method.addArgument("int","i");
        
        if(getFn( ).getTypeAndNames("cvar").size() == 0) {
            // no parameters
            method.addToBlockBody(new CodeStringDescriptor("return null;"));
        } else {
            // switch on parameters
            CodeBlockDescriptor block = new CodeBlockDescriptor();
            
            block.setBlockHeader("switch(i) {");
            int i=0;
            for (TypeAndName parameter : getFn( ).getTypeAndNames("cvar")) {
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
    
    public MethodDescriptor make_getContextVariableType() {
        MethodDescriptor method = new MethodDescriptor("getContextVariableType");
        method.addModifier("public");
        method.addModifier("Class");
        method.addArgument("int","i");
        
        if(getFn( ).getTypeAndNames("cvar").size() == 0) {
            // no parameters
            method.addToBlockBody(new CodeStringDescriptor("return null;"));
        } else {
            // switch on parameters
            CodeBlockDescriptor block = new CodeBlockDescriptor();
            
            block.setBlockHeader("switch(i) {");
            int i=0;
            for (TypeAndName parameter : getFn( ).getTypeAndNames("cvar")) {
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

    @Override
    ClassDescriptor make_class() {
        ClassDescriptor c = super.make_class();
        
        c.addMethod(make_exec());
        
        if(hasContextVariables()) {
            c.addMethod(make_getNumberContextVariables());
            c.addMethod(make_getContextVariableIntendedName());
            c.addMethod(make_getContextVariableType());
        }
        
        return c;
    }

    
}
