/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fntest;

import fn.FnCompiler;
import fn.parser.ParseException;
import java.io.ByteArrayInputStream;
import jd.ClassDescriptor;
import org.junit.Test;

/**
 *
 * @author Calvin Ashmore
 */
public class CompilerTest {
    
    @Test
    public void testCompiler() throws ParseException {
        String file = 
                "package MyPackage;\n" +
                "group MyGroup;\n" +
                "type Expression;\n" +
                "import java.util.*;\n" +
                "// a line comment\n" +
                "/* a block comment\n" +
                "   extends lines */\n" +
                "fn MyFn {\n" +
                
                "  int toast = 1;\n" + // local
                "  String fnord;\n" +  // local
                "  void doStuff() {System.out.println(fnord+\" \"+toast);}\n" + // local
                
                "  parameter int toastParam;\n" + // parameter
                
                "  meta myMeta1 \"myMetaValue\";\n" + // meta
                "  meta myMeta2 new int[]{1,2,3};\n" + // meta
                
                "  init {fnord=\"I am initialized\"; toastParam1=200;}\n" + // init
                "  setup {doStuff();}\n" + // setup
                
                "  fout Integer;\n" + // out
                "  in Integer x;\n" + // in
                "  in Integer y;\n" + // in
                "  eval {return x+y;}\n" + // eval
                "}";
        
        ByteArrayInputStream bis = new ByteArrayInputStream(file.getBytes());
        FnCompiler compiler = new FnCompiler();
        ClassDescriptor result = compiler.compile(bis);
        
        System.out.println(result.toString());
    }
}
