/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fn;

import fn.parser.ASTBlock;
import fn.parser.ASTFnDefinition;
import fn.parser.ASTFnDefinition.TypeAndName;
import fn.parser.ASTType;
import fn.parser.Token;
import java.util.ArrayList;
import java.util.List;
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
        MethodDescriptor method = new MethodDescriptor("getNumberInputs");
        method.addModifier("public");
        method.addModifier("int");
        
        int numberInputs = getFn().getTypeAndNames("exin").size() +
                getFn().getTypes("slin").size();
        method.addToBlockBody(new CodeStringDescriptor("return "+numberInputs+";"));
        return method;
    }

    @Override
    MethodDescriptor make_getInputName() {
        MethodDescriptor method = new MethodDescriptor("getInputName");
        method.addModifier("public");
        method.addModifier("String");
        method.addArgument("int","i");
        
        // switch on parameters
        CodeBlockDescriptor block = new CodeBlockDescriptor();

        block.setBlockHeader("switch(i) {");
        int i=0;
        for (TypeAndName input : getFn().getTypeAndNames("exin")) {
            block.addToBlockBody(new CodeStringDescriptor(
                    "case "+i+": return \""+input.getName()+"\";\n"
                    ));
            i++;
        }
        for (ASTType input : getFn().getTypes("slin")) {
            block.addToBlockBody(new CodeStringDescriptor(
                    "case "+i+": return \""+input.dumpTokens()+"\";\n"
                    ));
            i++;
        }
        block.addToBlockBody(new CodeStringDescriptor("default: return null;\n"));
        block.setBlockFooter("}");
        method.addToBlockBody(block);
            
        return method;
    }

    @Override
    MethodDescriptor make_getInputType() {
        // this is totally different, than the super implementation
        // instead, it makes InputSignature getInputSignature(int i)
        
        MethodDescriptor method = new MethodDescriptor("getInputSignature");
        method.addModifier("public");
        method.addModifier("InputSignature");
        method.addArgument("int","i");
        
        // switch on parameters
        CodeBlockDescriptor block = new CodeBlockDescriptor();

        block.setBlockHeader("switch(i) {");
        int i=0;
        for (TypeAndName input : getFn().getTypeAndNames("exin")) {
            block.addToBlockBody(new CodeStringDescriptor(
                    "case "+i+": return new ExpressionInputSignature("+input.getType().dumpTokens()+".class);\n"
                    ));
            i++;
        }
        for (ASTType input : getFn().getTypes("slin")) {
            block.addToBlockBody(new CodeStringDescriptor(
                    "case "+i+": return new StatementListInputSignature();\n"
                    ));
            i++;
        }
        block.addToBlockBody(new CodeStringDescriptor("default: return null;\n"));
        block.setBlockFooter("}");
        method.addToBlockBody(block);

        return method;
    }

    @Override
    CodeStringDescriptor make_inputDeclarations() {
        StringBuffer sb = new StringBuffer();
        
        int i=0;
        for (TypeAndName input : getFn().getTypeAndNames("exin")) {
            sb.append("Expression ");
            sb.append(input.getName()+" = (Expression) inputs.get("+i+");\n");
            i++;
        }
        for (ASTType input : getFn().getTypes("slin")) {
            sb.append("StatementList ");
            sb.append(input.dumpTokens()+" = (StatementList) inputs.get("+i+");\n");
            i++;
        }
        
        return new CodeStringDescriptor(sb.toString());
    }
    
    CodeStringDescriptor make_contextVariableDeclarations() {
        StringBuffer sb = new StringBuffer();

        for (TypeAndName cv : getFn().getTypeAndNames("cvar")) {
            sb.append("String __"+cv.getName()+" = getContextVariableActualName(\""+cv.getName()+"\");\n");
            sb.append(cv.getType().dumpTokens()+" "+cv.getName()+";\n");
        }
        
        return new CodeStringDescriptor(sb.toString());
    }
    
    String convertContextVariables(ASTBlock execBlock) {
        
        StringBuffer sb = new StringBuffer();
        
        List<String> cvNames = new ArrayList();
        //List<TypeAndName> cvs = new ArrayList<TypeAndName>();
        for (TypeAndName cv : getFn().getTypeAndNames("cvar"))
            cvNames.add(cv.getName());
            //cvs.add(cv)
        
	Token currentToken;
        
        // first to last exclusive, ignore "{" "}"
	for(    currentToken = execBlock.firstToken.next;
                currentToken.next != execBlock.lastToken;
                currentToken = currentToken.next) {
            
            // see if the context variable is used.
            if(cvNames.contains(currentToken.image)) {
                if(currentToken.next.image.equals("=")) {
                    // assignment
                    String cvName = currentToken.image;
                    
                    // scan until we hit a ';'
                    StringBuffer assignment = new StringBuffer();
                    Token assignToken;
                    for(
                            assignToken = currentToken.next.next; 
                            !assignToken.image.equals(";");
                            assignToken=assignToken.next)
                        assignment.append(assignToken.image);
                    
                    // assign currentToken to after the semicolon
                    currentToken = assignToken;
                    
                    sb.append(cvName+" = "+assignment+"; ");
                    sb.append("context.setVariable(" +
                            "__"+cvName+", "+cvName+
                            ");");
                    
                } else {
                    // regular usage
                    // ignore
                    //sb.append("("++")");
                    sb.append(currentToken.image);
                }
            } else {
                sb.append(currentToken.image);
            }
            sb.append(" ");
        }
	sb.append(currentToken.image); // Add the last token to the image to return. 
	return sb.toString();
    }
    
    @Override
    MethodDescriptor make_exec() {
        MethodDescriptor method = new MethodDescriptor("execute");
        method.addModifier("public");
        method.addModifier("void");
        method.addArgument("Context", "context");
        method.addArgument("List<GeneticComponent>", "inputs");

        // we run the risk of dead assignments, but oh well.
        method.addToBlockBody(make_inputDeclarations());
        method.addToBlockBody(make_contextVariableDeclarations());
        
        // actual body for the execution
        method.addToBlockBody(new CodeStringDescriptor(
                convertContextVariables(getFn().getBlock("exec"))));
        
        return method;
    }
    
    boolean hasContextVariables() {
        return getFn().getTypeAndNames("cvar").size() > 0;
    }
    
    public MethodDescriptor make_getNumberContextVariables() {
        MethodDescriptor method = new MethodDescriptor("getNumberContextVariables");
        method.addModifier("public");
        method.addModifier("int");
        
        int numberContextVariables = getFn().getTypeAndNames("cvar").size();
        method.addToBlockBody(new CodeStringDescriptor("return "+numberContextVariables+";"));
        return method;
    }
    
    public MethodDescriptor make_getContextVariableIntendedName() {
        MethodDescriptor method = new MethodDescriptor("getContextVariableIntendedName");
        method.addModifier("public");
        method.addModifier("String");
        method.addArgument("int","i");
        
        // switch on parameters
        CodeBlockDescriptor block = new CodeBlockDescriptor();

        block.setBlockHeader("switch(i) {");
        int i=0;
        for (TypeAndName contextVariable : getFn().getTypeAndNames("cvar")) {
            block.addToBlockBody(new CodeStringDescriptor(
                    "case "+i+": return \""+contextVariable.getName()+"\";\n"
                    ));
            i++;
        }
        block.addToBlockBody(new CodeStringDescriptor("default: return null;\n"));
        block.setBlockFooter("}");
        method.addToBlockBody(block);
            
        return method;
    }
    
    public MethodDescriptor make_getContextVariableType() {
        MethodDescriptor method = new MethodDescriptor("getContextVariableType");
        method.addModifier("public");
        method.addModifier("Class");
        method.addArgument("int","i");
        
        // switch on parameters
        CodeBlockDescriptor block = new CodeBlockDescriptor();

        block.setBlockHeader("switch(i) {");
        int i=0;
        for (TypeAndName contextVariable : getFn().getTypeAndNames("cvar")) {
            block.addToBlockBody(new CodeStringDescriptor(
                    "case "+i+": return "+contextVariable.getType().dumpTokens()+".class;\n"
                    ));
            i++;
        }
        block.addToBlockBody(new CodeStringDescriptor("default: return null;\n"));
        block.setBlockFooter("}");
        method.addToBlockBody(block);

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
