/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.app;

import genetic.GeneticComponent;
import genetic.GeneticTopLevel;
import genetic.component.context.ContextModel;
import genetic.component.expression.Expression;
import genetic.component.expression.function.ConstantExpressionFunction;
import genetic.component.expression.function.ExpressionFunction;
import genetic.component.expression.function.VariableExpressionFunction;
import genetic.component.method.Method;
import genetic.component.statement.Statement;
import genetic.component.statement.function.CommandStatementFunction;
import genetic.component.statement.function.StatementFunction;
import genetic.component.statementlist.StatementList;
import java.util.Map.Entry;

/**
 *
 * @author Calvin Ashmore
 */
public class ProgramPrinter {

    // forbid construction of utility class
    private ProgramPrinter() {
    }

    public static void printProgram(StringBuilder sb, GeneticTopLevel program) {

        sb.append("program {\n");
        //program.getContextModel();
        printContextModel(sb, "    ", program.getContextModel());

        for (Entry<String, Method> entry : program.getMethods().entrySet()) {
            String methodName = entry.getKey();
            Method method = entry.getValue();
            printMethod(sb, methodName, "    ", method);
        }
        sb.append("}\n");
    }

    public static void printContextModel(StringBuilder sb, String indent, ContextModel cm) {
        for (String variable : cm.getMyVariables()) {
            sb.append(indent + cm.getType(variable).getSimpleName() + " " + variable + ";\n");
        }
    }

    public static void printMethod(StringBuilder sb, String methodName, String indent, Method method) {
        sb.append(indent + "method " + methodName + "(");
        for (int i = 0; i < method.getNumberArguments(); i++) {
            String argumentName = method.getArgumentName(i);
            Class argumentType = method.getArgumentType(i);
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(argumentType.getSimpleName() + " " + argumentName);
        }
        sb.append(") {\n");

        //printContextModel(sb, indent + "    ", method.getContextModel());
        printStatementList(sb, indent + "    ", method.getBody(), false);

        sb.append(indent + "}\n");
    }

    // NOTE: for print braces, assume that the last print did NOT end in a newline.
    public static void printStatementList(StringBuilder sb, String indent, StatementList sl, boolean printBraces) {
        //String indent1 = indent;
        if (printBraces) {
            sb.append("{\n");
            //indent1 = indent + "    ";
        }

        printContextModel(sb, indent, sl.getContextModel());
        for (Statement statement : sl.getStatements()) {
            printStatement(sb, indent, statement);
        }

        if (printBraces) {
            sb.append(indent + "}");
        }
    }

    private static void printStatement(StringBuilder sb, String indent, Statement statement) {
        StatementFunction function = statement.getFunction();

        String name = function.getClass().getSimpleName();
        if (function instanceof CommandStatementFunction) {
            CommandStatementFunction commandFunction = (CommandStatementFunction) function;
            name = commandFunction.getCommand().getClass().getSimpleName();
        }

        sb.append(indent + name + "(\n");

        for (int i = 0; i < function.getNumberInputs(); i++) {

            sb.append(indent+"    "+function.getInputName(i) + " = ");

            GeneticComponent input = statement.getInput(i);
            if (input instanceof Expression) {
                printExpression(sb, (Expression) input);

            } else if (input instanceof StatementList) {
                printStatementList(sb, indent + "        ", (StatementList) input, true);
            }

            if (i < function.getNumberInputs()-1) {
                sb.append(",\n");
            }
            //sb.append("\n");
        }

        sb.append(");\n");
    }

    private static void printExpression(StringBuilder sb, Expression expression) {
        ExpressionFunction ef = expression.getFunction();

        if (ef instanceof ConstantExpressionFunction) {
            ConstantExpressionFunction constant = (ConstantExpressionFunction) ef;
            sb.append(constant.evaluate(null, null));

        } else if (ef instanceof VariableExpressionFunction) {
            VariableExpressionFunction variable = (VariableExpressionFunction) ef;
            sb.append(variable.getVariableName());
        } else {

            String name = ef.getClass().getSimpleName();
            sb.append(name + "(");

            for (int i = 0; i < ef.getNumberInputs(); i++) {
                if (i > 0) {
                    sb.append(", ");
                }

                printExpression(sb, expression.getChildren().get(i));
            }

            sb.append(")");
        }
    }
}
