/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

import genetic.component.expression.Expression;
import genetic.component.expression.ExpressionBuilder;
import genetic.component.expression.accessor.Accessor;
import genetic.component.expression.function.AllExpressionFunctions;
import genetic.component.expression.function.ExpressionFunctionFactory;
import genetic.component.method.Method;
import genetic.component.program.Program;
import genetic.component.statement.Statement;
import genetic.component.statement.command.Command;
import genetic.component.statementlist.StatementList;
import genetic.util.AllComponents;
import genetic.util.Breeder;
import genetic.util.Factory;
import genetic.util.Mutator;
import genetic.util.TypeSystem;
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

    AllComponents<Statement> getAllStatements();

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

    Factory<Statement> getStatementFactory();

    Breeder<StatementList> getStatementListBreeder();

    Mutator<StatementList> getStatementListMutator();

    Mutator<Statement> getStatementMutator();

    TypeSystem getTypeSystem();

}
