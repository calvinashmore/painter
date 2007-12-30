/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fntest;

import genetic.AllComponents;
import genetic.Context;
import genetic.ContextModel;
import genetic.Foundation;
import genetic.GeneticComponent;
import genetic.GeneticTopLevel;
import genetic.component.expression.Expression;
import genetic.component.expression.function.ExpressionFunction;
import genetic.component.statement.Statement;
import genetic.component.statement.function.StatementFunction;
import genetic.component.statementlist.StatementList;
import genetic.foundation.GeneticFoundationImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Calvin Ashmore
 */
public class CompilerStatementTest {

    private int myValue;
    
    @Test
    public void conditionalTest() throws Exception {
        AllComponents<StatementFunction> group = 
                (AllComponents<StatementFunction>) CompileTool.instantiateFn("MyGroup", 
                "group MyGroup;\n" +
                "type Statement;\n" +
                "import java.util.*;\n" +

                "fn Conditional {\n" +

                "  exin Boolean condition;\n" +
                "  slin onIf;\n" +
                "  slin onElse;\n" +

                "  exec {\n" +
                "    if((Boolean)condition.evaluate(context))\n" +
                "      onIf.execute(context);\n" +
                "    else onElse.execute(context);\n" +
                "  }\n" + // eval
                "}"
                );
        
        Foundation.setInstance(new GeneticFoundationImpl());
        
        StatementFunction nf = group.allInstances(null).get(0);
        Statement testStatement = new Statement(nf, null) {
            @Override public ContextModel getContextModel() {
                return new ContextModel((GeneticTopLevel)null);
            }
        
        };
        
        Expression trueExpression = new Expression(new ExpressionFunction() {
            @Override public Object evaluate(Context context, Object[] inputs) {return true;}
            public Class getReturnType() {return Boolean.class;}
        }, testStatement);
        
        Expression falseExpression = new Expression(new ExpressionFunction() {
            @Override public Object evaluate(Context context, Object[] inputs) {return false;}
            public Class getReturnType() {return Boolean.class;}
        }, testStatement);
        
        StatementList sl1 = new StatementList(testStatement);
        sl1.setStatements(new Statement(new StatementFunction() {
            @Override public void execute(Context context, List<GeneticComponent> inputs) {
                myValue = 1;
            }
        } , sl1));
        
        StatementList sl2 = new StatementList(testStatement);
        sl2.setStatements(new Statement(new StatementFunction() {
            @Override public void execute(Context context, List<GeneticComponent> inputs) {
                myValue = 202;
            }
        } , sl2));
        
        nf.execute(null, Arrays.asList(new GeneticComponent[] {trueExpression, sl1, sl2}));
        Assert.assertEquals(1, myValue);
        
        nf.execute(null, Arrays.asList(new GeneticComponent[] {falseExpression, sl1, sl2}));
        Assert.assertEquals(202, myValue);
    }
    
    
    
    @Test
    public void loopTest() throws Exception {
        AllComponents<StatementFunction> group = 
                (AllComponents<StatementFunction>) CompileTool.instantiateFn("MyGroup", 
                "group MyGroup;\n" +
                "type Statement;\n" +
                "import java.util.*;\n" +

                "fn Conditional {\n" +

                "  parameter int iterations;\n" + 
                
                "  slin loopBody;\n" +
                "  cvar int i;\n" +

                "  exec {\n" +
                "    i = 0;\n" +
                "    while(i >= 0) {\n" +
                "      loopBody.execute(context);\n" +
                "      i = i+1;\n" +
                "    }\n" +
                "  }\n" + // eval
                "}"
                );
    }
}
