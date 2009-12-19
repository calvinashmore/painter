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
public class ExpressionContextDependentFnNode extends ContextFnNode {

    public ExpressionContextDependentFnNode(ASTFnDefinition fn) {
        super(fn);
    }

    @Override
    String getSuperclassName() {
        return "ContextDependentExpressionFunction";
    }

    @Override
    ClassDescriptor make_class() {
        ClassDescriptor c = super.make_class();

        c.addMethod(make_eval());
        c.addMethod(make_getReturnType());

        c.addMethod(make_getContextNumberInputs());
        c.addMethod(make_getContextInputName());
        c.addMethod(make_getContextInputType());

        return c;
    }

    @Override
    MethodDescriptor make_eval() {
        MethodDescriptor method = new MethodDescriptor("evaluate");
        method.addModifier("public");
        method.addModifier(getFn().getTypes("fout").get(0).dumpTokens());
        method.addArgument("final Context", "context");
        method.addArgument("final Object[]", "inputs");
        method.addArgument("final List<Expression>", "contextExpressions");
        method.addThrowsClause("TerminationException");

        // we run the risk of dead assignments, but oh well.
        method.addToBlockBody(make_inputDeclarations());
        method.addToBlockBody(make_contextInputDeclarations());
        method.addToBlockBody(make_contextVariableDeclarations());

        // actual body for the evaluation
        //method.addToBlockBody(new CodeStringDescriptor(getFn().getBlock("eval").dumpBlock()));
        method.addToBlockBody(new CodeStringDescriptor(
                convertContextVariables(getFn().getBlock("eval"))));

        return method;
    }

    CodeStringDescriptor make_contextInputDeclarations() {
        StringBuffer sb = new StringBuffer();

        int i = 0;
        for (TypeAndName input : getFn().getTypeAndNames("exin")) {
            sb.append("final Expression ");
            sb.append(input.getName() + " = (Expression) contextExpressions.get(" + i + ");\n");
            i++;
        }
        return new CodeStringDescriptor(sb.toString());
    }

    MethodDescriptor make_getContextNumberInputs() {
        MethodDescriptor method = new MethodDescriptor("getNumberContextInputs");
        method.addModifier("public");
        method.addModifier("int");

        int numberParameters = getFn().getTypeAndNames("exin").size();
        method.addToBlockBody(new CodeStringDescriptor("return " + numberParameters + ";"));
        return method;
    }

    MethodDescriptor make_getContextInputName() {
        MethodDescriptor method = new MethodDescriptor("getContextInputName");
        method.addModifier("public");
        method.addModifier("String");
        method.addArgument("int", "i");

        // switch on input
        CodeBlockDescriptor block = new CodeBlockDescriptor();

        block.setBlockHeader("switch(i) {");
        int i = 0;
        for (TypeAndName input : getFn().getTypeAndNames("exin")) {
            block.addToBlockBody(new CodeStringDescriptor(
                    "case " + i + ": return \"" + input.getName() + "\";\n"));
            i++;
        }
        block.addToBlockBody(new CodeStringDescriptor("default: return null;\n"));
        block.setBlockFooter("}");
        method.addToBlockBody(block);

        return method;
    }

    MethodDescriptor make_getContextInputType() {
        MethodDescriptor method = new MethodDescriptor("getContextInputType");
        method.addModifier("public");
        method.addModifier("Class");
        method.addArgument("int", "i");

        // switch on parameters
        CodeBlockDescriptor block = new CodeBlockDescriptor();

        block.setBlockHeader("switch(i) {");
        int i = 0;
        for (TypeAndName input : getFn().getTypeAndNames("exin")) {
            block.addToBlockBody(new CodeStringDescriptor(
                    "case " + i + ": return " + input.getType().dumpTokens() + ".class;\n"));
            i++;
        }
        block.addToBlockBody(new CodeStringDescriptor("default: return null;\n"));
        block.setBlockFooter("}");
        method.addToBlockBody(block);

        return method;
    }
}
