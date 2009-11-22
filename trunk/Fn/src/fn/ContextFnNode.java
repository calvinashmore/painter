/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fn;

import fn.parser.ASTBlock;
import fn.parser.ASTFnDefinition;
import fn.parser.ASTFnDefinition.TypeAndName;
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
abstract public class ContextFnNode extends FnNode {

    public ContextFnNode(ASTFnDefinition fn) {
        super(fn);
    }

    @Override
    ClassDescriptor make_class() {
        ClassDescriptor c = super.make_class();

        if (hasContextVariables()) {
            c.addMethod(make_getNumberContextVariables());
            c.addMethod(make_getContextVariableIntendedName());
            c.addMethod(make_getContextVariableType());
        }

        return c;
    }

    String convertContextVariables(ASTBlock execBlock) {
        StringBuffer sb = new StringBuffer();
        List<String> cvNames = new ArrayList();
        //List<TypeAndName> cvs = new ArrayList<TypeAndName>();
        for (TypeAndName cv : getFn().getTypeAndNames("cvar")) {
            cvNames.add(cv.getName());
        }
        //cvs.add(cv)
        Token currentToken;
        if (execBlock.firstToken.next == execBlock.lastToken) {
            return "";
        }
        // first to last exclusive, ignore "{" "}"
        for (currentToken = execBlock.firstToken.next; currentToken.next != execBlock.lastToken; currentToken = currentToken.next) {
            // see if the context variable is used.
            if (cvNames.contains(currentToken.image)) {
                if (currentToken.next.image.equals("=")) {
                    String cvName = currentToken.image;
                    StringBuffer assignment = new StringBuffer();
                    Token assignToken;
                    for (assignToken = currentToken.next.next; !assignToken.image.equals(";"); assignToken = assignToken.next) {
                        assignment.append(assignToken.image + " ");
                    }
                    currentToken = assignToken;
                    sb.append(cvName + " = " + assignment + "; ");
                    sb.append("context.setVariable(" + "__" + cvName + ", " + cvName + ");");
                } else {
                    sb.append(currentToken.image);
                }
            } else {
                sb.append(currentToken.image);
            }
            if (currentToken.image.equals(";") || currentToken.image.equals("{") || currentToken.image.equals("}")) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }
        sb.append(currentToken.image);
        // Add the last token to the image to return.
        return sb.toString();
    }

    boolean hasContextVariables() {
        return getFn().getTypeAndNames("cvar").size() > 0;
    }

    CodeStringDescriptor make_contextVariableDeclarations() {
        StringBuffer sb = new StringBuffer();
        for (TypeAndName cv : getFn().getTypeAndNames("cvar")) {
            sb.append("final String __" + cv.getName() + " = getContextVariableActualName(\"" + cv.getName() + "\");\n");
            sb.append(cv.getType().dumpTokens() + " " + cv.getName() + ";\n");
        }
        return new CodeStringDescriptor(sb.toString());
    }

    public MethodDescriptor make_getContextVariableIntendedName() {
        MethodDescriptor method = new MethodDescriptor("getContextVariableIntendedName");
        method.addModifier("public");
        method.addModifier("String");
        method.addArgument("int", "i");
        // switch on parameters
        CodeBlockDescriptor block = new CodeBlockDescriptor();
        block.setBlockHeader("switch(i) {");
        int i = 0;
        for (TypeAndName contextVariable : getFn().getTypeAndNames("cvar")) {
            block.addToBlockBody(new CodeStringDescriptor("case " + i + ": return \"" + contextVariable.getName() + "\";\n"));
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
        method.addArgument("int", "i");
        // switch on parameters
        CodeBlockDescriptor block = new CodeBlockDescriptor();
        block.setBlockHeader("switch(i) {");
        int i = 0;
        for (TypeAndName contextVariable : getFn().getTypeAndNames("cvar")) {
            block.addToBlockBody(new CodeStringDescriptor("case " + i + ": return " + contextVariable.getType().dumpTokens() + ".class;\n"));
            i++;
        }
        block.addToBlockBody(new CodeStringDescriptor("default: return null;\n"));
        block.setBlockFooter("}");
        method.addToBlockBody(block);
        return method;
    }

    public MethodDescriptor make_getNumberContextVariables() {
        MethodDescriptor method = new MethodDescriptor("getNumberContextVariables");
        method.addModifier("public");
        method.addModifier("int");
        int numberContextVariables = getFn().getTypeAndNames("cvar").size();
        method.addToBlockBody(new CodeStringDescriptor("return " + numberContextVariables + ";"));
        return method;
    }
}
