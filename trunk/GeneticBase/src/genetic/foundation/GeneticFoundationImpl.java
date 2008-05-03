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
import genetic.component.accessor.AccessorFactory;
import genetic.component.accessor.AllAccessors;
import genetic.component.command.AllCommands;
import genetic.component.command.CommandFactory;
import genetic.component.expression.function.AllExpressionFunctionsImpl;
import genetic.component.expression.Expression;
import genetic.component.expression.breeder.ExpressionBreeder;
import genetic.component.expression.ExpressionBuilder;
import genetic.component.expression.ExpressionBuilderImpl;
import genetic.component.expression.function.ExpressionFunctionFactory;
import genetic.component.expression.function.ExpressionFunctionFactoryImpl;
import genetic.component.expression.mutator.ExpressionMutator;
import genetic.component.expression.function.AllExpressionFunctions;
import genetic.component.accessor.Accessor;
import genetic.component.method.Method;
import genetic.component.method.breeder.MethodBreeder;
import genetic.component.method.mutator.MethodMutator;
import genetic.component.program.Program;
import genetic.component.program.breeder.ProgramBreeder;
import genetic.component.program.mutator.ProgramMutator;
import genetic.component.statement.function.AllStatementFunctions;
import genetic.component.statement.Statement;
import genetic.component.statement.breeder.StatementBreeder;
import genetic.component.statement.function.StatementFunctionFactory;
import genetic.component.statement.function.StatementFunctionFactoryImpl;
import genetic.component.statement.mutator.StatementMutator;
import genetic.component.command.Command;
import genetic.component.statement.StatementBuilder;
import genetic.component.statement.StatementBuilderImpl;
import genetic.component.statement.function.StatementFunction;
import genetic.component.statementlist.StatementList;
import genetic.component.statementlist.breeder.StatementListBreeder;
import genetic.component.statementlist.mutator.StatementListMutator;
import genetic.AllComponents;
import genetic.Breeder;
import genetic.Factory;
import genetic.GeneticTopLevel;
import genetic.Mutator;
import genetic.TypeSystem;
import genetic.component.method.MethodBuilder;
import genetic.component.method.MethodBuilderImpl;
import genetic.component.program.ProgramBuilder;
import genetic.component.program.ProgramBuilderImpl;
import genetic.component.statementlist.StatementListBuilder;
import genetic.component.statementlist.StatementListBuilderImpl;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
public class GeneticFoundationImpl implements GeneticFoundation {
    
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
    public AllComponents<StatementFunction> getAllStatementFunctions() {return new AllStatementFunctions();}
    
    
    // CONTEXTUAL COMPONENT FACTORIES
    
    public Factory<Accessor> getAccessorFactory() {return new AccessorFactory();}
    public Factory<Command> getCommandFactory() {return new CommandFactory();}
    public ExpressionFunctionFactory getExpressionFunctionFactory() {return new ExpressionFunctionFactoryImpl();}
    public ExpressionBuilder getExpressionBuilder() {return new ExpressionBuilderImpl();}
    public StatementFunctionFactory getStatementFunctionFactory() {return new StatementFunctionFactoryImpl();}
    public StatementBuilder getStatementBuilder() {return new StatementBuilderImpl();}
    public MethodBuilder getMethodBuilder() {return new MethodBuilderImpl();}
    public ProgramBuilder getProgramBuilder() {return new ProgramBuilderImpl();}
    public StatementListBuilder getStatementListBuilder() {return new StatementListBuilderImpl();}
    
    // MUTATORS!
    
    public Mutator<GeneticTopLevel> getProgramMutator() {return new ProgramMutator();}
    public Mutator<Method> getMethodMutator() {return new MethodMutator();}
    public Mutator<Statement> getStatementMutator() {return new StatementMutator();}
    public Mutator<StatementList> getStatementListMutator() {return new StatementListMutator();}
    public Mutator<Expression> getExpressionMutator() {return new ExpressionMutator();}
    
    
    // BREEDERS
    
    public Breeder<GeneticTopLevel> getProgramBreeder() {return new ProgramBreeder();}
    public Breeder<Method> getMethodBreeder() {return new MethodBreeder();}
    public Breeder<Statement> getStatementBreeder() {return new StatementBreeder();}
    public Breeder<StatementList> getStatementListBreeder() {return new StatementListBreeder();}
    public Breeder<Expression> getExpressionBreeder() {return new ExpressionBreeder();}
}