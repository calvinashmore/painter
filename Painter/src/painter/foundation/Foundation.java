/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.foundation;

import genetic.AllComponents;
import genetic.BuildException;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import painter.foundation.warp.WarpFunction;

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
    private List<ExpressionFunction> painterEFs;
    private Map<Class, List<ExpressionFunction>> painterEFsByType;

    private List<ExpressionFunction> getPainterEFs() {
        if (painterEFs == null) {
            painterEFs = new ArrayList<ExpressionFunction>(new painter.functions.expressions.AllFn().allInstances(null));
            painterEFs.addAll(allExpressionFunctions.allInstances(null));
        }
        return painterEFs;
    }

    private List<ExpressionFunction> getWarpEFs(ContextModel cm) {
        List<ExpressionFunction> allWarps = new painter.functions.expressions.warp.AllFn().allInstances(cm);
        List<ExpressionFunction> validWarps = new ArrayList<ExpressionFunction>();
        for (ExpressionFunction warp : allWarps) {
            WarpFunction warpFunction = (WarpFunction) warp;
            if(warpFunction.setupVariable(cm))
                validWarps.add(warp);
        }
        return validWarps;
    }

    private List<ExpressionFunction> getWarpEFsByType(Class type, ContextModel cm) {
        List<ExpressionFunction> warps = getWarpEFs(cm);
        List<ExpressionFunction> warpsByType = new ArrayList<ExpressionFunction>();
        for (ExpressionFunction warp : warps) {
            if (warp.getReturnType() == type) {
                warpsByType.add(warp);
            }
        }
        return warpsByType;
    }

    private List<ExpressionFunction> getPainterEFsByType(Class type) {
        if (painterEFsByType == null) {
            painterEFsByType = new HashMap<Class, List<ExpressionFunction>>();
            for (ExpressionFunction expressionFunction : getPainterEFs()) {
                List<ExpressionFunction> typeList = painterEFsByType.get(expressionFunction.getReturnType());
                if (typeList == null) {
                    typeList = new ArrayList<ExpressionFunction>();
                    painterEFsByType.put(expressionFunction.getReturnType(), typeList);
                }
                typeList.add(expressionFunction);
            }
        }

        List<ExpressionFunction> types = painterEFsByType.get(type);
        if (types == null) {
            return Collections.emptyList();
        }
        return types;
    }

    @Override
    public AllExpressionFunctions getAllExpressionFunctions() {
        return new AllExpressionFunctionsImpl() {

            @Override
            public List<ExpressionFunction> allInstances(ContextModel cm) {
                List<ExpressionFunction> allInstances = super.allInstances(cm);
                allInstances.addAll(getPainterEFs());
                allInstances.addAll(getWarpEFs(cm));
                return allInstances;
            }

            @Override
            public List<ExpressionFunction> allFunctionsByType(Class type, ContextModel cm) throws BuildException {
                List<ExpressionFunction> allFunctionsByType = super.allFunctionsByType(type, cm);
                allFunctionsByType.addAll(getPainterEFsByType(type));
                allFunctionsByType.addAll(getWarpEFsByType(type, cm));
                return allFunctionsByType;
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
                //allInstances.addAll(new painter.functions.statements.AllFn().allInstances(cm));
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

            @Override
            public ExpressionFunction build(Class<? extends ExpressionFunction> t, ContextModel cm) throws BuildException {
                ExpressionFunction result = super.build(t, cm);
                if(result instanceof WarpFunction) {
                    WarpFunction warp = (WarpFunction) result;
                    if(!warp.setupVariable(cm))
                        throw new BuildException("Cannot find a variable of type "+warp.getVariableType()+" in context model");
                }
                return result;
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
