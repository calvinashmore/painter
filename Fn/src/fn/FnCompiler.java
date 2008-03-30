/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fn;

import fn.parser.ASTFnTopLevel;
import fn.parser.FnParser;
import fn.parser.ParseException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import jd.ClassDescriptor;
import jd.CodeStringDescriptor;
import jd.MethodDescriptor;

/**
 *
 * @author Calvin Ashmore
 */
public class FnCompiler {

    FnGroup makeGroup(ASTFnTopLevel top) {
        String type = top.getType();

        if (type.equals("Accessor")) {
            return new AccessorFnGroup(top);
        } else if (type.equals("Command")) {
            return new CommandFnGroup(top);
        } else if (type.equals("Expression")) {
            return new ExpressionFnGroup(top);
        } else if (type.equals("Statement")) {
            return new StatementFnGroup(top);
        } else {
            throw new UnsupportedOperationException("top level \"" + top.getGroup() + "\" has invalid type: " + type);
        }
    }

    public ClassDescriptor compile(ASTFnTopLevel n) {
        FnGroup group = makeGroup(n);
        ClassDescriptor c = group.make_class();

        return c;
    }

    public ClassDescriptor compile(InputStream input) throws ParseException {
        FnParser parser = new FnParser(input);

        ASTFnTopLevel n = parser.FnTopLevel();
        FnGroup group = makeGroup(n);
        ClassDescriptor c = group.make_class();

        return c;
    }

    public ClassDescriptor compile(File input, File outputDirectory) throws ParseException, FileNotFoundException {
        ClassDescriptor classDescriptor = compile(new FileInputStream(input));
        classDescriptor.writeToFile(outputDirectory);
        return classDescriptor;
    }
    
    public void compileDirectory(File inputDirectory, File outputDirectory) {
        ClassDescriptor lastDescriptor = null;
        List<String> filenames = new ArrayList<String>();
        
        // go through files
        for(File file : inputDirectory.listFiles()) {
            if(file.getName().endsWith(".fn")) {
                try {
                    System.out.print("Compiling: "+file.getName()+"... ");
                    lastDescriptor = compile(file, outputDirectory);
                    System.out.println("OK");
                    filenames.add(lastDescriptor.getClassName());
                } catch(FileNotFoundException ex) {
                    System.out.println("Failed");
                    ex.printStackTrace();
                } catch(ParseException ex) {
                    System.out.println("Failed");
                    ex.printStackTrace();
                }
            }
        }
        
        String type = lastDescriptor.getInterface(0);
        type = type.substring(type.indexOf("<")+1, type.indexOf(">"));
        
        // build index file
        ClassDescriptor allFnDescriptor = new ClassDescriptor("AllFn");
        allFnDescriptor.setPackageName(lastDescriptor.getPackageName());
        allFnDescriptor.addClassModifier("public");
        allFnDescriptor.addInterface("AllComponents<"+type+">");
        allFnDescriptor.addImport("java.util.*");
        allFnDescriptor.addImport("genetic.*");
        allFnDescriptor.addImport("genetic.component.accessor.*");
        allFnDescriptor.addImport("genetic.component.command.*");
        allFnDescriptor.addImport("genetic.component.context.*");
        allFnDescriptor.addImport("genetic.component.expression.*");
        allFnDescriptor.addImport("genetic.component.expression.function.*");
        allFnDescriptor.addImport("genetic.component.method.*");
        allFnDescriptor.addImport("genetic.component.program.*");
        allFnDescriptor.addImport("genetic.component.statement.*");
        allFnDescriptor.addImport("genetic.component.statementlist.*");
        allFnDescriptor.addImport("genetic.component.statement.function.*");
        
        MethodDescriptor allInstances = new MethodDescriptor("allInstances");
        allInstances.addArgument("ContextModel","cm");
        allInstances.addModifier("public");
        allInstances.addModifier("List<"+type+">");
        
        String allInstancesContents="List<"+type+"> r = new ArrayList<"+type+">();\n";
        for(String filename: filenames)
            allInstancesContents += "r.addAll(new "+filename+"().allInstances(cm));\n";
        allInstancesContents += "return r;\n";
        allInstances.addToBlockBody(new CodeStringDescriptor(allInstancesContents));
        
        allFnDescriptor.addMethod(allInstances);
        
        allFnDescriptor.writeToFile(outputDirectory);
    }
    
    /**
     * Accepts arguments in pairs:
     * args[0] is the source directory for batch 1
     * args[1] is the out directory for batch 1, etc
     * @param args
     */
    public static void main(String args[]) {
        FnCompiler compiler = new FnCompiler();
        
        for(int i=0;i<args.length/2;i++) {
            String inDirectory = args[2*i];
            String outDirectory = args[2*i+1];
            //System.out.println(inDirectory);
            //System.out.println(outDirectory);
            compiler.compileDirectory(new File(inDirectory), new File(outDirectory));
        }
    }
}
