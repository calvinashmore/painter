/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.foundation;

import genetic.AllComponents;
import genetic.component.command.Command;
import genetic.component.context.ContextModel;
import genetic.component.expression.ExpressionBuilder;
import genetic.component.expression.ExpressionBuilderImpl;
import genetic.component.expression.function.AllExpressionFunctions;
import genetic.component.expression.function.AllExpressionFunctionsImpl;
import genetic.component.expression.function.ExpressionFunction;
import genetic.component.expression.function.ExpressionFunctionFactory;
import genetic.component.expression.function.ExpressionFunctionFactoryImpl;
import genetic.component.statement.function.AllStatementFunctions;
import genetic.component.statement.function.CommandStatementFunction;
import genetic.component.statement.function.StatementFunction;
import genetic.component.statement.function.StatementFunctionFactory;
import genetic.component.statement.function.StatementFunctionFactoryImpl;
import genetic.foundation.GeneticFoundationImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
public class Foundation extends GeneticFoundationImpl {

    private TypeSystem typeSystem = new TypeSystem();

    @Override
    public TypeSystem getTypeSystem() {
        return typeSystem;
    }

    @Override
    public AllComponents<Command> getAllCommands() {
        return new painter.functions.commands.AllFn();
    }
    private AllComponents<ExpressionFunction> allExpressionFunctions = new library.expressions.functions.AllFn();

    @Override
    public AllExpressionFunctions getAllExpressionFunctions() {

        return new AllExpressionFunctionsImpl() {

            private List<ExpressionFunction> painterEFs;

            @Override
            public List<ExpressionFunction> allInstances(ContextModel cm) {
                if (painterEFs == null) {
                    painterEFs = new ArrayList<ExpressionFunction>(new painter.functions.expressions.AllFn().allInstances(cm));
                    painterEFs.addAll(allExpressionFunctions.allInstances(cm));
                }

                List<ExpressionFunction> allInstances = super.allInstances(cm);
                allInstances.addAll(painterEFs);
                return allInstances;
            }
        };
    }

    @Override
    public AllComponents<StatementFunction> getAllStatementFunctions() {
        return new AllStatementFunctions() {

            @Override
            public List<StatementFunction> allInstances(ContextModel cm) {
                List<StatementFunction> allInstances = super.allInstances(cm);
                allInstances.addAll(new library.statements.AllFn().allInstances(cm));
                allInstances.addAll(new painter.functions.statements.AllFn().allInstances(cm));
                return allInstances;
            }
        };
    }

    @Override
    public StatementFunctionFactory getStatementFunctionFactory() {
        return new StatementFunctionFactoryImpl() {

            @Override
            public double getWeight(ContextModel cm, StatementFunction sf) {
                if (sf instanceof CommandStatementFunction) {
                    //return 15;
                    return 2 * getAllCommands().allInstances(cm).size();
                    //if(sf.getClass().getName().contains("Loop"))
                    //    return 2;
                }
                return super.getWeight(cm, sf);
            }
        };
    }

    @Override
    public ExpressionFunctionFactory getExpressionFunctionFactory() {
        return new ExpressionFunctionFactoryImpl() {

            @Override
            public double getWeight(ContextModel cm, ExpressionFunction nf) {
                if (nf.getClass().getName().contains("Variable")) {
                    return 3;
                }
                return super.getWeight(cm, nf);
            }
        };
    }

    @Override
    public ExpressionBuilder getExpressionBuilder() {
        return new ExpressionBuilderImpl() {

            @Override
            protected int getTargetDepth() {
                return 5;
            }
        };
    }
}
