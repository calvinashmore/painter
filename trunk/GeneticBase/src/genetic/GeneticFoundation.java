/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

import genetic.component.expression.Expression;
import genetic.component.expression.ExpressionBuilder;
import genetic.component.accessor.Accessor;
import genetic.component.expression.function.AllExpressionFunctions;
import genetic.component.expression.function.ExpressionFunctionFactory;
import genetic.component.method.Method;
import genetic.component.program.Program;
import genetic.component.statement.Statement;
import genetic.component.statement.function.StatementFunctionFactory;
import genetic.component.command.Command;
import genetic.component.statement.StatementBuilder;
import genetic.component.statement.function.StatementFunction;
import genetic.component.statementlist.StatementList;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
public interface GeneticFoundation {

    Factory<Accessor> getAccessorFactory();

    AllComponents<Accessor> getAllAccessors();

    AllComponents<Command> getAllCommands();

    AllExpressionFunctions getAllExpressionFunctions();

    AllComponents<StatementFunction> getAllStatementFunctions();

    Random getBuilderRandom();

    Factory<Command> getCommandFactory();

    Breeder<Expression> getExpressionBreeder();

    ExpressionBuilder getExpressionBuilder();

    ExpressionFunctionFactory getExpressionFunctionFactory();

    Mutator<Expression> getExpressionMutator();

    Breeder<Method> getMethodBreeder();

    Mutator<Method> getMethodMutator();

    Breeder<Program> getProgramBreeder();

    Mutator<Program> getProgramMutator();

    Breeder<Statement> getStatementBreeder();
    
    StatementBuilder getStatementBuilder();

    StatementFunctionFactory getStatementFunctionFactory();

    Breeder<StatementList> getStatementListBreeder();

    Mutator<StatementList> getStatementListMutator();

    Mutator<Statement> getStatementMutator();

    TypeSystem getTypeSystem();

}
