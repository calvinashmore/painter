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
import genetic.component.expression.ExpressionFunctionFactory;
import genetic.component.expression.ExpressionMutator;
import genetic.component.statement.AllStatements;
import genetic.component.statement.StatementFactory;
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
    
    public ProgramMutator getProgramMutator() {return new ProgramMutator();}
    public MethodMutator getMethodMutator() {return new MethodMutator();}
    public StatementMutator getStatementMutator() {return new StatementMutator();}
    public StatementListMutator getStatementListMutator() {return new StatementListMutator();}
    public ExpressionMutator getExpressionMutator() {return new ExpressionMutator();}
    
    // BREEDERS
    
    public ProgramBreeder getProgramBreeder() {return new ProgramBreeder();}
    public MethodBreeder getMethodBreeder() {return new MethodBreeder();}
    public StatementBreeder getStatementBreeder() {return new StatementBreeder();}
    public StatementListBreeder getStatementListBreeder() {return new StatementListBreeder();}
    public ExpressionBreeder getExpressionBreeder() {return new ExpressionBreeder();}
}