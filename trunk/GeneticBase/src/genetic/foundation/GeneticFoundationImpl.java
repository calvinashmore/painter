/*
 * GeneticFoundation.java
 *
 * Created on Nov 4, 2007, 5:55:04 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.foundation;

import genetic.GeneticFoundation;
import genetic.component.expression.accessor.AccessorFactory;
import genetic.component.expression.accessor.AllAccessors;
import genetic.component.statement.command.AllCommands;
import genetic.component.statement.command.CommandFactory;
import genetic.component.expression.function.AllExpressionFunctionsImpl;
import genetic.component.expression.Expression;
import genetic.component.expression.ExpressionBreeder;
import genetic.component.expression.ExpressionBuilder;
import genetic.component.expression.ExpressionBuilderImpl;
import genetic.component.expression.function.ExpressionFunctionFactory;
import genetic.component.expression.function.ExpressionFunctionFactoryImpl;
import genetic.component.expression.mutator.ExpressionMutator;
import genetic.component.expression.function.AllExpressionFunctions;
import genetic.component.expression.accessor.Accessor;
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
import genetic.component.statement.command.Command;
import genetic.component.statementlist.StatementList;
import genetic.component.statementlist.StatementListBreeder;
import genetic.component.statementlist.StatementListMutator;
import genetic.util.AllComponents;
import genetic.util.Breeder;
import genetic.util.Factory;
import genetic.util.Mutator;
import genetic.util.TypeSystem;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
public class GeneticFoundationImpl implements GeneticFoundation {
    
    // STATIC INSTANCE
    
    private static GeneticFoundationImpl foundation;
    public static GeneticFoundationImpl getInstance() {return foundation;}
    
    public GeneticFoundationImpl() {
        foundation = this;
    }
    
    
    // RANDOM FOR BUILDING
    
    protected Random builderRandom = new Random();
    public Random getBuilderRandom() {return builderRandom;}
    
    
    // TYPE SYSTEM
    private TypeSystem defaultTypeSystem = new TypeSystem() {
        public List<Class> allTypes() {return Collections.<Class>emptyList();}
        public Object perturbValue(Object obj) {return obj;}
        public Object checkInvalid(Object obj) {return obj;}
        public Object createDefault(Class c) {return null;}
        public Object createRandom(Class c) {return null;}
    };
    public TypeSystem getTypeSystem() {return defaultTypeSystem;}
    
    
    // UNIVERSAL COMPONENT CONSTRUCTION
    
    public AllComponents<Accessor> getAllAccessors() {return new AllAccessors();}
    public AllComponents<Command> getAllCommands() {return new AllCommands();}
    public AllExpressionFunctions getAllExpressionFunctions() {return new AllExpressionFunctionsImpl();}
    public AllComponents<Statement> getAllStatements() {return new AllStatements();}
    
    
    // CONTEXTUAL COMPONENT FACTORIES
    
    public Factory<Accessor> getAccessorFactory() {return new AccessorFactory();}
    public Factory<Command> getCommandFactory() {return new CommandFactory();}
    public ExpressionFunctionFactory getExpressionFunctionFactory() {return new ExpressionFunctionFactoryImpl();}
    public ExpressionBuilder getExpressionBuilder() {return new ExpressionBuilderImpl();}
    public Factory<Statement> getStatementFactory() {return new StatementFactory();}
    
    
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