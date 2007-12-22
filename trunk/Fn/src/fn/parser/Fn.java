/*
 * Fn.java
 *
 * Created on January 1, 2006, 11:30 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package fn.parser;

import java.io.*;
import java.util.*;
import jd.*;

public class Fn {
    
    public static void main(String args[]) {
        
        renderDirectory(new File("src/genetic/expressions/functions/src"));
        
        /*
        FnParser parser;
        String sourceFile = "src/gen/functions/test.fn";
        
        try{
            parser = new FnParser(new FileInputStream(sourceFile));

            ASTFnTopLevel n = parser.FnTopLevel();
            ClassDescriptor fn = n.compileToJava();
            fn.writeToFile(new File("src/gen/functions"));
        } catch(Exception e) {
            e.printStackTrace();
        } */
    }
    
    static public void renderDirectory(File directory) {
        
        List<String> classNames = new ArrayList();
        
        for(File file : directory.listFiles())
            if(file.getName().endsWith(".fn"))
                try {
                    //renderFile(file);
                    FnParser parser;
                    parser = new FnParser(new FileInputStream(file));
                    ASTFnTopLevel n = parser.FnTopLevel();
                    ClassDescriptor fn = n.compileToJava();
                    fn.writeToFile(new File("src/genetic/expressions/functions"));
                    
                    classNames.add(fn.className);
                }
                catch(Exception e) {
                    System.out.println("Fn: Failed to parse file " + file.getName());
                    e.printStackTrace();
                }
        
        ClassDescriptor allFn = new ClassDescriptor();
        allFn.className = "AllFn";
        allFn.packageName = "genetic.expressions.functions";
        allFn.addClassModifier("public");
        allFn.addInterface("FunctionGroup");
        allFn.addPackageImport("genetic.*");
        allFn.addPackageImport("genetic.expressions.*");
        allFn.addPackageImport("java.util.*");
        
        MethodDescriptor getFunctionsMeth = new MethodDescriptor();
        getFunctionsMeth.methodName = "getFunctions";
        getFunctionsMeth.addModifier("public");
        getFunctionsMeth.addModifier("List<ExpressionFunction>");
        getFunctionsMeth.addToBlockBody(new CodeStringDescriptor(
                "List<ExpressionFunction> functions = new LinkedList();"
                ));
        for(String className : classNames)
            getFunctionsMeth.addToBlockBody(new CodeStringDescriptor(
                    "functions.addAll( new "+className+"().getFunctions() );"
                    ));
        getFunctionsMeth.addToBlockBody(new CodeStringDescriptor(
                "return functions;"
                ));
        allFn.addMethod(getFunctionsMeth);
        
        MethodDescriptor buildMeth = new MethodDescriptor();
        buildMeth.methodName = "build";
        buildMeth.addModifier("public");
        buildMeth.addModifier("ExpressionFunction");
        buildMeth.addArgument("Class<? extends ExpressionFunction>","nfClass");
        buildMeth.addArgument("ExpressionFactory","nff");
        
        // go through sub groups and test this
        buildMeth.addToBlockBody(new CodeStringDescriptor(
                "ExpressionFunction r;"
                ));
        for(String className : classNames)
            buildMeth.addToBlockBody(new CodeStringDescriptor(
                    "if( (r = new "+className+"().build(nfClass,nff)) != null) return r;"
                    ));
        buildMeth.addToBlockBody(new CodeStringDescriptor(
                "return null;"
                ));
        
        allFn.addMethod(buildMeth);
        
        allFn.writeToFile(new File("src/genetic/expressions/functions"));
    }
    
    /*
    static public void renderFile(File file) throws Exception {
            FnParser parser;
            parser = new FnParser(new FileInputStream(file));
            ASTFnTopLevel n = parser.FnTopLevel();
            ClassDescriptor fn = n.compileToJava();
            fn.writeToFile(new File("src/gen/functions"));
    }*/
}
