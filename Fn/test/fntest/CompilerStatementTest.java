/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fntest;

import genetic.AllComponents;
import genetic.Foundation;
import genetic.GeneticComponent;
import genetic.GeneticFoundation;
import genetic.GeneticTopLevel;
import genetic.component.context.Context;
import genetic.component.expression.function.ExpressionFunction;
import genetic.component.method.Method;
import genetic.component.statement.Statement;
import genetic.component.statement.function.StatementFunction;
import genetic.component.statementlist.StatementList;
import genetic.foundation.GeneticFoundationImpl;
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
        
        ExpressionFunction efTrue = new ExpressionFunction() {
            @Override public Object evaluate(Context context, Object[] inputs) {return true;}
            public Class getReturnType() {return Boolean.class;}
        };
        
        ExpressionFunction efFalse = new ExpressionFunction() {
            @Override public Object evaluate(Context context, Object[] inputs) {return false;}
            public Class getReturnType() {return Boolean.class;}
        };
        
        StatementFunction testStatement = group.allInstances(null).get(0);
        
        GeneticFoundation f = Foundation.getInstance();
        GeneticTopLevel top = f.getProgramBuilder().build();
        Method myMethod = top.createMethod("myMethod");

        StatementList sl = myMethod.getBody();
        Statement statement = f.getStatementBuilder().buildEmptyStatement(testStatement,sl);
        sl.setStatements(statement);
        
        StatementList sl1, sl2;
        statement.setInput(1, sl1 = f.getStatementListBuilder().build(statement));
        statement.setInput(2, sl2 = f.getStatementListBuilder().build(statement));
        
        // should be called when true
        sl1.setStatements(f.getStatementBuilder().buildEmptyStatement(new StatementFunction() {
            @Override
            public void execute(Context context, List<GeneticComponent> inputs) {
                myValue = 1;
            }
        }, sl1));
        
        // should be called when false
        sl2.setStatements(f.getStatementBuilder().buildEmptyStatement(new StatementFunction() {
            @Override
            public void execute(Context context, List<GeneticComponent> inputs) {
                myValue = 202;
            }
        }, sl2));
        
        statement.setInput(0, f.getExpressionBuilder().newNode(efTrue, statement));
        top.callMethod("myMethod");
        Assert.assertEquals(1, myValue);
        
        statement.setInput(0, f.getExpressionBuilder().newNode(efFalse, statement));
        top.callMethod("myMethod");
        Assert.assertEquals(202, myValue);
    }
    
    
    @Test
    public void loopTest() throws Exception {
        AllComponents<StatementFunction> group = 
                (AllComponents<StatementFunction>) CompileTool.instantiateFn("MyGroup", 
                "group MyGroup;\n" +
                "type Statement;\n" +
                "import java.util.*;\n" +

                "fn Loop {\n" +
                "  parameter int iterations;\n" + 
                "  slin loopBody;\n" +
                "  cvar int i;\n" +
                "  exec {\n" +
                "    i = 0;\n" +
                "    while(i < iterations) {\n" +
                "      loopBody.execute(context);\n" +
                "      i = i+1;\n" +
                "    }\n" +
                "  }\n" + // eval
                "}" +
                
                "fn Printout {\n" +
                "  exec {\n" +
                "    StringBuffer sb = (StringBuffer)context.getVariable(\"stringBuffer\");\n" +
                "    sb.append(context.getVariable(\"i\"));\n" +
                "  }\n" + // eval
                "}"
                );
        
        Foundation.setInstance(new GeneticFoundationImpl());
        
        StatementFunction loopStatement = group.allInstances(null).get(0);
        StatementFunction printStatement = group.allInstances(null).get(1);
        
        GeneticFoundation f = Foundation.getInstance();
        GeneticTopLevel top = f.getProgramBuilder().build();
        Method myMethod = top.createMethod("myMethod");

        StatementList sl = myMethod.getBody();
        Statement statement = f.getStatementBuilder().buildEmptyStatement(loopStatement,sl);
        sl.setStatements(statement);
        
        StatementList sl1 = f.getStatementListBuilder().build(statement);
        statement.setInput(0, sl1);
        sl1.setStatements(f.getStatementBuilder().buildEmptyStatement(printStatement, sl1));
        
        top.getContextModel().declareVariable("stringBuffer", StringBuffer.class, true);
        
        top.setup();
        
        // fill our test string buffer by executing the genetic code
        StringBuffer sbTest = new StringBuffer();
        int iterations = 20;
        loopStatement.setParameter(0, iterations);
        top.getContext().setVariable("stringBuffer", sbTest);
        top.callMethod("myMethod");
        
        // fill the check string buffer by doing what the above does the conventional way
        StringBuffer sbCheck = new StringBuffer();
        for(int i=0; i<iterations; i++)
            sbCheck.append(i);
        
        Assert.assertEquals(sbTest.toString(), sbCheck.toString());
    }
}
