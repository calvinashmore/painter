/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fntest;

import genetic.AllComponents;
import genetic.component.expression.function.ExpressionFunction;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Calvin Ashmore
 */
public class CompilerExpressionTest extends CompilerTestBase {

    @Test
    public void testAddInt() throws Exception {
        
        AllComponents<ExpressionFunction> group = 
                (AllComponents<ExpressionFunction>) CompileTool.instantiateFn("MyGroup", 
                "group MyGroup;\n" +
                "type Expression;\n" +
                "import java.util.*;\n" +
                
                "fn Add {\n" +

                "  fout Integer;\n" + // out
                "  in Integer x;\n" + // in
                "  in Integer y;\n" + // in
                "  eval {return x+y;}\n" + // eval
                "}"
                );
        
        ExpressionFunction nf = group.allInstances(null).get(0);
        Assert.assertEquals( 5 + 21,  nf.evaluate(null, new Object[]{ 5, 21}) );
        Assert.assertEquals(23 + 81,  nf.evaluate(null, new Object[]{23, 81}) );
    }
    
    @Test
    public void testAddFloat() throws Exception {
        
        AllComponents<ExpressionFunction> group = 
                (AllComponents<ExpressionFunction>) CompileTool.instantiateFn("MyGroup", 
                "group MyGroup;\n" +
                "type Expression;\n" +
                "import java.util.*;\n" +
                
                "fn Add {\n" +

                "  fout Float;\n" + // out
                "  in Float x;\n" + // in
                "  in Float y;\n" + // in
                "  eval {return x+y;}\n" + // eval
                "}"
                );
        
        ExpressionFunction nf = group.allInstances(null).get(0);
        Assert.assertEquals( 5f + 21f,  nf.evaluate(null, new Object[]{ 5f, 21f}) );
        Assert.assertEquals(23f + 81.5f,  nf.evaluate(null, new Object[]{23f, 81.5f}) );
    }
    
    @Test
    public void testDivFloat() throws Exception {
        
        AllComponents<ExpressionFunction> group = 
                (AllComponents<ExpressionFunction>) CompileTool.instantiateFn("MyGroup", 
                "group MyGroup;\n" +
                "type Expression;\n" +
                "import java.util.*;\n" +
                
                "fn Div {\n" +

                "  fout Float;\n" + // out
                "  in Float x;\n" + // in
                "  in Float y;\n" + // in
                "  eval {return x/y;}\n" + // eval
                "}"
                );
        
        ExpressionFunction nf = group.allInstances(null).get(0);
        Assert.assertEquals( 5f / 21f,  nf.evaluate(null, new Object[]{ 5f, 21f}) );
        Assert.assertEquals(23f / 81.5f,  nf.evaluate(null, new Object[]{23f, 81.5f}) );
    }
    
    @Test
    public void testNoArgs() throws Exception {
        
        AllComponents<ExpressionFunction> group = 
                (AllComponents<ExpressionFunction>) CompileTool.instantiateFn("MyGroup", 
                "group MyGroup;\n" +
                "type Expression;\n" +
                "import java.util.*;\n" +
                
                "fn NoArg {\n" +

                "  fout Float;\n" + // out
                "  eval {return 100f;}\n" + // eval
                "}"
                );
        
        ExpressionFunction nf = group.allInstances(null).get(0);
        Assert.assertEquals( 100f,  nf.evaluate(null, new Object[]{}) );
    }
    
}
