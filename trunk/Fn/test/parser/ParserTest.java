/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

import fn.parser.ASTFnDefinition;
import fn.parser.ASTFnTopLevel;
import fn.parser.FnParser;
import fn.parser.ParseException;
import java.io.ByteArrayInputStream;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Calvin Ashmore
 */
public class ParserTest {
    
    @Test
    public void FnUnitTest1() throws ParseException {
        // try an Expression style fn:
        String file = 
                "fn MyFn {\n" +
                
                "  meta mymeta1 \"value\";\n" +
                "  meta mymeta2 new int[]{1,2,3};\n" +
                
                "  int wombat=1;\n" +
                "  String stuff;\n" +
                "  void doStuff() {System.out.println(stuff);}\n" +
                
                "  parameter Integer spoon;\n" +
                "  parameter String toast;\n" +
                
                "  interface Serializable;\n" +
                "  interface Clonable;\n" +
                
                "  fout Integer;\n" +
                
                "  eval {return 1;}\n" +
                "  init {spoon = 3; toast=\"howdy\";}\n" +
                
                "}";
        
        ByteArrayInputStream bis = new ByteArrayInputStream(file.getBytes());
        FnParser parser = new FnParser(bis);
        
        ASTFnDefinition fn = parser.FnDefinition();
        
        Assert.assertEquals( "MyFn",         fn.getName() );
        Assert.assertEquals( "\"value\"",    fn.getMeta().get("mymeta1").dumpTokens() );
        Assert.assertEquals( 
                "new int [ ] { 1 , 2 , 3 }", fn.getMeta().get("mymeta2").dumpTokens() );
        Assert.assertEquals( "int wombat = 1 ;",   fn.getLocalDeclarations().get(0).dumpTokens());
        Assert.assertEquals( "String stuff ;",   fn.getLocalDeclarations().get(1).dumpTokens());
        Assert.assertEquals( "void doStuff " +
                "( ) { System . out . println " +
                "( stuff ) ; }",               fn.getLocalDeclarations().get(2).dumpTokens());
        Assert.assertEquals( "spoon",        fn.getTypeAndNames("parameter").get(0).getName() );
        Assert.assertEquals( "Integer",      fn.getTypeAndNames("parameter").get(0).getType().dumpTokens() );
        Assert.assertEquals( "toast",        fn.getTypeAndNames("parameter").get(1).getName() );
        Assert.assertEquals( "String",       fn.getTypeAndNames("parameter").get(1).getType().dumpTokens() );
        Assert.assertEquals( "Serializable", fn.getTypes("interface").get(0).dumpTokens() );
        Assert.assertEquals( "Clonable",     fn.getTypes("interface").get(1).dumpTokens() );
        Assert.assertEquals( "Integer",      fn.getTypes("fout").get(0).dumpTokens() );
        Assert.assertEquals( "return 1 ;",   fn.getBlock("eval").dumpBlock() );
        Assert.assertEquals( "spoon = 3 ;\n" +
                "toast = \"howdy\" ;",      fn.getBlock("init").dumpBlock() );
    }
    
    @Test
    public void FnUnitTest2() throws ParseException {
        
        String file = 
                "package myPackage;\n" +
                "group MyGroup;\n" +
                "type Expression;\n" +
                "import java.util.*;\n" +
                "description \"my package description\";\n" +
                "// a line comment\n" +
                "/* a block comment\n" +
                "   extends lines */\n" +
                "fn MyFn {\n" +
                "  description \"my fn description\";\n" +
                "  fout Integer;\n" +
                "  in Integer x;\n" +
                "  in Integer y;\n" +
                "  eval {return x+y;}\n" +
                "}";
        
        ByteArrayInputStream bis = new ByteArrayInputStream(file.getBytes());
        FnParser parser = new FnParser(bis);
        
        ASTFnTopLevel top = parser.FnTopLevel();
        
        Assert.assertEquals("myPackage",    top.getPackage());
        Assert.assertEquals("MyGroup",      top.getGroup());
        Assert.assertEquals("Expression",   top.getType());
        Assert.assertEquals("java.util.*",  top.getUserImports().get(0));
        Assert.assertEquals("MyFn",         top.getFnDefinitions().get(0).getName());
        Assert.assertEquals("Integer",      top.getFnDefinitions().get(0).getTypes("fout").get(0).dumpTokens());
        Assert.assertEquals("\"my fn description\"",      top.getFnDefinitions().get(0).getExpressions("description").get(0).dumpTokens());
        Assert.assertEquals("\"my package description\"", top.getExpressions("description").get(0).dumpTokens());
    }
}
