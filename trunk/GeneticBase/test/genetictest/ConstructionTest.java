/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetictest;

import genetic.AllComponents;
import genetic.BuildException;
import genetic.component.context.ContextModel;
import genetic.Foundation;
import genetic.GeneticTopLevel;
import genetic.TypeSystem;
import genetic.component.accessor.Accessor;
import genetic.component.accessor.AllAccessors;
import genetic.component.command.AllCommands;
import genetic.component.command.Command;
import genetic.component.expression.function.AllExpressionFunctions;
import genetic.component.expression.function.AllExpressionFunctionsImpl;
import genetic.component.expression.function.ExpressionFunction;
import genetic.component.expression.function.ExpressionFunctionFactory;
import genetic.component.expression.function.ExpressionFunctionFactoryImpl;
import genetic.component.statement.function.AllStatementFunctions;
import genetic.component.statement.function.StatementFunction;
import genetic.foundation.GeneticFoundationImpl;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Calvin Ashmore
 */
public class ConstructionTest {

    /**
     * This test attempts to create a genetic program with a single method, that can only use NOOP statements.
     * @throws genetic.BuildException
     */
    @Test
    public void constructionTest1() throws BuildException {

        Foundation.setInstance(new GeneticFoundationImpl() {

            @Override
            public AllComponents<StatementFunction> getAllStatementFunctions() {
                return new AllComponents<StatementFunction>() {

                    public List<StatementFunction> allInstances(ContextModel cm) {
                        return Collections.<StatementFunction>singletonList(new NOOPStatement());
                    }
                };
            }
        });

        GeneticTopLevel top = Foundation.getInstance().getProgramBuilder().build();
        top.createMethod("myMethod");

        top.setup();
        top.callMethod("myMethod");
    }

    /**
     * This test attempts to create a genetic program with a single method, but it can only use an ExpressionStatement,
     * and may only use constant expression functions.
     * @throws genetic.BuildException
     */
    @Test
    public void constructionTest2() throws BuildException {

        Foundation.setInstance(new GeneticFoundationImpl() {

            @Override
            public AllComponents<StatementFunction> getAllStatementFunctions() {
                return new AllComponents<StatementFunction>() {

                    public List<StatementFunction> allInstances(ContextModel cm) {
                        return Collections.<StatementFunction>singletonList(new IntExpressionStatement());
                    }
                };
            }

            @Override
            public AllExpressionFunctions getAllExpressionFunctions() {
                return new AllExpressionFunctionsImpl() {

                    @Override
                    public List<ExpressionFunction> allInstances(ContextModel cm) {
                        return Collections.<ExpressionFunction>singletonList(getConstantFunction(Integer.TYPE));
                    }
                };
            }

            @Override
            public TypeSystem getTypeSystem() {
                return new IntTypeSystem();
            }
        });

        GeneticTopLevel top = Foundation.getInstance().getProgramBuilder().build();
        top.createMethod("myMethod");

        top.setup();
        top.callMethod("myMethod");
    }

    /**
     * This test attempts to create a genetic program with a single method, but it can only use an ExpressionStatement,
     * and may use constant and addition expression functions.
     * @throws genetic.BuildException
     */
    @Test
    public void constructionTest3() throws BuildException {

        Foundation.setInstance(new GeneticFoundationImpl() {

            @Override
            public AllComponents<StatementFunction> getAllStatementFunctions() {
                return new AllComponents<StatementFunction>() {

                    public List<StatementFunction> allInstances(ContextModel cm) {
                        return Collections.<StatementFunction>singletonList(new IntExpressionStatement());
                    }
                };
            }

            @Override
            public AllExpressionFunctions getAllExpressionFunctions() {
                return new AllExpressionFunctionsImpl() {

                    @Override
                    public List<ExpressionFunction> allInstances(ContextModel cm) {
                        List<ExpressionFunction> allFunctions = super.allInstances(cm);
                        allFunctions.add(new IntAdditionFunction());
                        return allFunctions;
                    }
                };
            }

            @Override
            public ExpressionFunctionFactory getExpressionFunctionFactory() {
                return new ExpressionFunctionFactoryImpl() {

                    @Override
                    public float getFunctionWeight(ContextModel cm, ExpressionFunction nf) {
                        if (nf instanceof IntAdditionFunction) {
                            return 5;
                        }
                        return super.getFunctionWeight(cm, nf);
                    }
                };
            }

            @Override
            public TypeSystem getTypeSystem() {
                return new IntTypeSystem();
            }
        });

        GeneticTopLevel top = Foundation.getInstance().getProgramBuilder().build();
        top.createMethod("myMethod");

        top.setup();
        top.callMethod("myMethod");
    }

    /**
     * This test attempts to create a genetic program with a single method that can use a variety of features.
     * Due to the random nature of its contents, the construction is run several times.
     * @throws genetic.BuildException
     */
    @Test
    public void constructionTest4() throws BuildException {

        Foundation.setInstance(new GeneticFoundationImpl() {

            @Override
            public AllComponents<StatementFunction> getAllStatementFunctions() {
                return new AllStatementFunctions() {

                    @Override
                    public List<StatementFunction> allInstances(ContextModel cm) {
                        List<StatementFunction> allFunctions = super.allInstances(cm);
                        allFunctions.add(new IntExpressionStatement());
                        allFunctions.add(new NOOPStatement());
                        return allFunctions;
                    }
                    
                };
            }

            @Override
            public AllComponents<Accessor> getAllAccessors() {
                return new AllAccessors() {

                    @Override
                    public List<Accessor> allInstances(ContextModel cm) {
                        List<Accessor> allInstances = super.allInstances(cm);
                        allInstances.add(new Accessor1());
                        allInstances.add(new Accessor2());
                        return allInstances;
                    }
                    
                };
            }


            @Override
            public AllComponents<Command> getAllCommands() {
                return new AllCommands() {

                    @Override
                    public List<Command> allInstances(ContextModel cm) {
                        List<Command> allInstances = super.allInstances(cm);
                        allInstances.add(new Command1());
                        allInstances.add(new Command2());
                        return allInstances;
                    }
                    
                };
            }
            
            @Override
            public AllExpressionFunctions getAllExpressionFunctions() {
                return new AllExpressionFunctionsImpl() {

                    @Override
                    public List<ExpressionFunction> allInstances(ContextModel cm) {
                        List<ExpressionFunction> allFunctions = super.allInstances(cm);
                        allFunctions.add(new IntAdditionFunction());
                        return allFunctions;
                    }
                };
            }

            @Override
            public TypeSystem getTypeSystem() {
                return new IntTypeSystem();
            }
        });

        for(int i=0; i<100; i++) {
            GeneticTopLevel top = Foundation.getInstance().getProgramBuilder().build();
            top.createMethod("myMethod");

            top.setup();
            top.callMethod("myMethod");
        }
    }
}
