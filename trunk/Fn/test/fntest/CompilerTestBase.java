/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fntest;

import org.junit.AfterClass;

/**
 *
 * @author Calvin Ashmore
 */
public class CompilerTestBase {

    @AfterClass
    public static void tearDown() {
        System.out.println("Tearing down");
        CompileTool.tearDown();
    }
}
