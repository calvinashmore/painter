/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fn;

import fn.parser.ASTFnDefinition;
import fn.parser.ASTFnDefinition.TypeAndName;
import fn.parser.ASTType;
import jd.ClassDescriptor;
import jd.CodeBlockDescriptor;
import jd.CodeStringDescriptor;
import jd.MethodDescriptor;

/**
 *
 * @author Calvin Ashmore
 */
public class StatementFnNode extends ContextFnNode {

    public StatementFnNode(ASTFnDefinition fn) {
        super(fn);
    }

    @Override
    String getSuperclassName() {
        return "StatementFunction";
    }

    @Override
    boolean hasInputs() {
        return getFn().getTypeAndNames("exin").size() +
                getFn().getTypes("slin").size() > 0;
    }

    @Override
    MethodDescriptor make_getNumberInputs() {
        MethodDescriptor method = new MethodDescriptor("getNumberInputs");
        method.addModifier("public");
        method.addModifier("int");

        int numberInputs = getFn().getTypeAndNames("exin").size() +
                getFn().getTypes("slin").size();
        method.addToBlockBody(new CodeStringDescriptor("return " + numberInputs + ";"));
        return method;
    }

    @Override
    MethodDescriptor make_getInputName() {
        MethodDescriptor method = new MethodDescriptor("getInputName");
        method.addModifier("public");
        method.addModifier("String");
        method.addArgument("int", "i");

        // switch on parameters
        CodeBlockDescriptor block = new CodeBlockDescriptor();

        block.setBlockHeader("switch(i) {");
        int i = 0;
        for (TypeAndName input : getFn().getTypeAndNames("exin")) {
            block.addToBlockBody(new CodeStringDescriptor(
                    "case " + i + ": return \"" + input.getName() + "\";\n"));
            i++;
        }
        for (ASTType input : getFn().getTypes("slin")) {
            block.addToBlockBody(new CodeStringDescriptor(
                    "case " + i + ": return \"" + input.dumpTokens() + "\";\n"));
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
        method.addArgument("int", "i");

        // switch on parameters
        CodeBlockDescriptor block = new CodeBlockDescriptor();

        block.setBlockHeader("switch(i) {");
        int i = 0;
        for (TypeAndName input : getFn().getTypeAndNames("exin")) {
            block.addToBlockBody(new CodeStringDescriptor(
                    "case " + i + ": return new ExpressionInputSignature(" + input.getType().dumpTokens() + ".class);\n"));
            i++;
        }
        for (ASTType input : getFn().getTypes("slin")) {
            block.addToBlockBody(new CodeStringDescriptor(
                    "case " + i + ": return new StatementListInputSignature();\n"));
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

        int i = 0;
        for (TypeAndName input : getFn().getTypeAndNames("exin")) {
            sb.append("Expression ");
            sb.append(input.getName() + " = (Expression) inputs.get(" + i + ");\n");
            i++;
        }
        for (ASTType input : getFn().getTypes("slin")) {
            sb.append("StatementList ");
            sb.append(input.dumpTokens() + " = (StatementList) inputs.get(" + i + ");\n");
            i++;
        }

        return new CodeStringDescriptor(sb.toString());
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

    @Override
    ClassDescriptor make_class() {
        ClassDescriptor c = super.make_class();

        c.addMethod(make_exec());

        return c;
    }
}
