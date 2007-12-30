/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fntest;

import genetic.AllComponents;
import genetic.Context;
import genetic.component.accessor.Accessor;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Calvin Ashmore
 */
public class CompilerAccessorTest extends CompilerTestBase {

    public static class TestContext extends Context {
        public TestContext() {
            super(null);
        }
        
        private int[] data = {5,15,33,98,11,348,78};
        public int getData(int i) {
            i = i%data.length;
            if(i<0)
                i += data.length;
            
            return data[i];
        }
    }
    
    @Test
    public void testGetArray() throws Exception {
        
        AllComponents<Accessor> group = 
                (AllComponents<Accessor>) CompileTool.instantiateFn("MyGroup", 
                "group MyGroup;\n" +
                "type Accessor;\n" +
                "import java.util.*;\n" +
                "import fntest.CompilerAccessorTest;\n" +
                
                "fn AccessArray {\n" +

                "  fout Integer;\n" + // out
                "  in Integer x;\n" + // in
                //"  in Integer y;\n" + // in
                "  eval {\n" +
                "    CompilerAccessorTest.TestContext tc = (CompilerAccessorTest.TestContext)context;\n" +
                "    return tc.getData(x);\n" +
                "  }\n" + // eval
                "}"
                );
        
        Accessor nf = group.allInstances(null).get(0);
        
        //private int[] data = {5,15,33,98,11,348,78};
        Context context = new TestContext();
        Assert.assertEquals( 5,  nf.evaluate(context, new Object[]{0}) );
        Assert.assertEquals(15,  nf.evaluate(context, new Object[]{1}) );
        Assert.assertEquals(33,  nf.evaluate(context, new Object[]{2}) );
        Assert.assertEquals(98,  nf.evaluate(context, new Object[]{3}) );
        Assert.assertEquals(11,  nf.evaluate(context, new Object[]{4}) );
        Assert.assertEquals( 5,  nf.evaluate(context, new Object[]{7}) );
        Assert.assertEquals( 5,  nf.evaluate(context, new Object[]{-7}) );
    }
    
}
