/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.statement;

import genetic.ContextModel;
import genetic.Foundation;
import genetic.GeneticComponent;
import genetic.GeneticTopLevel;
import genetic.component.expression.Expression;
import genetic.component.method.Method;
import genetic.component.statement.function.MethodStatementFunction;
import genetic.component.statement.function.StatementFunction;
import genetic.component.statementlist.StatementList;
import genetic.BuildException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
public class StatementBuilderImpl implements StatementBuilder {

    public List<String> getAllowableMethodCalls(GeneticComponent parent) {

        // traverse up until we reach the method that contains this
        GeneticComponent component = parent;
        while (!(component instanceof Method)) {
            component = component.getParent();
        }
        Method myMethod = (Method) component;

        GeneticTopLevel program = parent.getContextModel().getTopLevel();
        Map<String, Method> methods = program.getMethods();

        String myMethodName = null;
        for (Map.Entry<String, Method> entry : methods.entrySet()) {
            // entry.getValue() == method
            // entry.getKey() == name
            if(entry.getValue() == myMethod)
                myMethodName = entry.getKey();
        }

        List<String> methodNames = new ArrayList<String>();
        for (Map.Entry<String, Method> entry : methods.entrySet()) {
            // check for valid method names, ie
            // methods that do not cycle

            // this method does not use myMethod, so it is safe.
            // entry.getValue() == method
            // entry.getKey() == name
            if(!entry.getValue().hasMethod(myMethodName))
                methodNames.add(entry.getKey());
        }

        return methodNames;
    }

    public Statement buildStatement(ContextModel cm, GeneticComponent parent) throws BuildException {
        return buildStatement(cm, parent, false);
    }
    private static final int ATTEMPTS = 10;

    public Statement buildStatement(ContextModel cm, GeneticComponent parent, boolean seekTerminal) throws BuildException {

        BuildException lastException = null;
        for (int attempt = 0; attempt < ATTEMPTS; attempt++) {
            try {
                StatementFunction function = Foundation.getInstance().getStatementFunctionFactory().select(cm, seekTerminal);

                // SPECIAL CASE FOR METHOD STATEMENT FUNCTIONS!!!
                if (function instanceof MethodStatementFunction) {
                    MethodStatementFunction methodFunction = (MethodStatementFunction) function;
                    List<String> methodCalls = getAllowableMethodCalls(parent);
                    if (methodCalls.size() == 0) {
                        throw new BuildException("Attempting to construct a MethodStatementFunction, and there are no valid methods to call.");
                    }
                    String method = methodCalls.get(Foundation.getInstance().getBuilderRandom().nextInt(methodCalls.size()));
                    methodFunction.setMethodName(method);
                }

                Statement statement = new Statement(function, parent);
                for (int i = 0; i < function.getNumberInputs(); i++) {

                    StatementFunction.InputSignature inputSignature = function.getInputSignature(i);

                    if (inputSignature instanceof StatementFunction.ExpressionInputSignature) {
                        statement.setInput(i, makeExpression(statement, (StatementFunction.ExpressionInputSignature) inputSignature));
                    } else if (inputSignature instanceof StatementFunction.StatementListInputSignature) {
                        statement.setInput(i, makeStatementList(statement));
                    } else {
                        throw new BuildException("StatementFunction " + function + " has invalid input signature: " + inputSignature);
                    }
                }

                return statement;
            } catch (BuildException ex) {
                lastException = ex;
            }
        }
        throw new BuildException("Failed to construct Statement",lastException);
    }

    protected Expression makeExpression(Statement statement, StatementFunction.ExpressionInputSignature signature)
            throws BuildException {

        return Foundation.getInstance().getExpressionBuilder().makeTree(signature.getExpressionReturnType(), statement);
    }

    protected StatementList makeStatementList(Statement statement) throws BuildException {
        StatementList statementList = new StatementList(statement);

        StatementFunction function = statement.getFunction();
        for (int i = 0; i < function.getNumberContextVariables(); i++) {
            String contextVariableIntendedName = function.getContextVariableIntendedName(i);
            Class contextVariableType = function.getContextVariableType(i);

            statementList.getContextModel().declareVariable(contextVariableIntendedName, contextVariableType, true);
        }

        return statementList;
    }
}
