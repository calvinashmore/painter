/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fntest;

import genetic.AllComponents;
import genetic.component.command.Command;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Calvin Ashmore
 */
public class CompilerCommandTest extends CompilerTestBase{

    private static int myInt = 0;
    public static void setMyInt(int value) {myInt = value;}
    
    @Test
    public void testGetArray() throws Exception {
        
        AllComponents<Command> group = 
                (AllComponents<Command>) CompileTool.instantiateFn("MyGroup", 
                "group MyGroup;\n" +
                "type Command;\n" +
                "import java.util.*;\n" +
                "import fntest.CompilerCommandTest;\n" +
                
                "fn Assigner {\n" +

                "  in Integer x;\n" + // in
                //"  in Integer y;\n" + // in
                "  exec {\n" +
                "    CompilerCommandTest.setMyInt(x);\n" +
                "  }\n" + // eval
                "}"
                );
        
        Command nf = group.allInstances(null).get(0);
        
        nf.execute(null, new Object[]{5});
        Assert.assertEquals( 5, myInt );
        
        nf.execute(null, new Object[]{15881});
        Assert.assertEquals( 15881, myInt );
        
    }
}
