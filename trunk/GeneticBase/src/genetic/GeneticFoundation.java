/*
 * GeneticFoundation.java
 *
 * Created on Nov 4, 2007, 5:55:04 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

import genetic.component.expression.accessor.AccessorFactory;
import genetic.component.expression.accessor.AllAccessors;
import genetic.component.statement.command.AllCommands;
import genetic.component.statement.command.CommandFactory;
import genetic.component.expression.AllExpressionFunctions;
import genetic.component.expression.Expression;
import genetic.component.expression.ExpressionBreeder;
import genetic.component.expression.ExpressionFunctionFactory;
import genetic.component.expression.ExpressionMutator;
import genetic.component.method.Method;
import genetic.component.method.MethodBreeder;
import genetic.component.method.MethodMutator;
import genetic.component.program.Program;
import genetic.component.program.ProgramBreeder;
import genetic.component.program.ProgramMutator;
import genetic.component.statement.AllStatements;
import genetic.component.statement.Statement;
import genetic.component.statement.StatementBreeder;
import genetic.component.statement.StatementFactory;
import genetic.component.statement.StatementMutator;
import genetic.component.statementlist.StatementList;
import genetic.component.statementlist.StatementListBreeder;
import genetic.component.statementlist.StatementListMutator;
import genetic.util.Breeder;
import genetic.util.Mutator;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
public class GeneticFoundation {
    
    private static GeneticFoundation foundation;
    public static GeneticFoundation getFoundation() {return foundation;}
    
    public GeneticFoundation() {
        foundation = this;
    }
    
    private Random builderRandom = new Random();
    public Random getBuilderRandom() {return builderRandom;}
    
    // UNIVERSAL COMPONENT CONSTRUCTION
    
    public AllAccessors getAllAccessors() {return new AllAccessors();}
    public AllCommands getAllCommands() {return new AllCommands();}
    public AllExpressionFunctions getAllExpressionFunctions() {return new AllExpressionFunctions();}
    public AllStatements getAllStatements() {return new AllStatements();}

    // CONTEXTUAL COMPONENT FACTORIES
    
    public AccessorFactory getAccessorFactory() {return new AccessorFactory();}
    public CommandFactory getCommandFactory() {return new CommandFactory();}
    public ExpressionFunctionFactory getExpressionFunctionFactory() {return new ExpressionFunctionFactory();}
    public StatementFactory getStatementFactory() {return new StatementFactory();}
    
    // MUTATORS!
    
    public Mutator<Program> getProgramMutator() {return new ProgramMutator();}
    public Mutator<Method> getMethodMutator() {return new MethodMutator();}
    public Mutator<Statement> getStatementMutator() {return new StatementMutator();}
    public Mutator<StatementList> getStatementListMutator() {return new StatementListMutator();}
    public Mutator<Expression> getExpressionMutator() {return new ExpressionMutator();}
    
    // BREEDERS
    
    public Breeder<Program> getProgramBreeder() {return new ProgramBreeder();}
    public Breeder<Method> getMethodBreeder() {return new MethodBreeder();}
    public Breeder<Statement> getStatementBreeder() {return new StatementBreeder();}
    public Breeder<StatementList> getStatementListBreeder() {return new StatementListBreeder();}
    public Breeder<Expression> getExpressionBreeder() {return new ExpressionBreeder();}
}