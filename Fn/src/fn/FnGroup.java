/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fn;

import fn.parser.ASTFnDefinition;
import fn.parser.ASTFnTopLevel;
import java.util.ArrayList;
import java.util.List;
import jd.ClassDescriptor;
import jd.CodeStringDescriptor;
import jd.MethodDescriptor;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class FnGroup<NodeType extends FnNode> {

    public FnGroup(ASTFnTopLevel top) {
        this.top = top;
        
        addImport("genetic.*");
        addImport("genetic.component.accessor.*");
        addImport("genetic.component.command.*");
        addImport("genetic.component.expression.*");
        addImport("genetic.component.expression.function.*");
        addImport("genetic.component.method.*");
        addImport("genetic.component.program.*");
        addImport("genetic.component.statement.*");
        addImport("genetic.component.statementlist.*");
        addImport("genetic.component.statement.function.*");
    }
    //private List<NodeType> myNodes = new ArrayList<NodeType>();

    //private String packageName;
    //public void setPackageName(String packageName) {
    //    this.packageName = packageName;
    //}
    
    private List<String> imports = new ArrayList<String>();
    
    private ASTFnTopLevel top;
    
    protected void addImport(String importName)  {imports.add(importName);}
    
    abstract FnNode getNode(ASTFnDefinition fn);
    String getGroupImplements() {return "AllComponents<"+getFnClassName()+">";} // "AllComponents<StatementFunction>", etc
    abstract String getFnClassName(); // StatementFunction, ExpressionFunction, Accessor, or Command
    
    ClassDescriptor make_class() {
        ClassDescriptor descriptor = new ClassDescriptor(top.getGroup());
        descriptor.addClassModifier("public");
        descriptor.addClassModifier("final");
        
        descriptor.setPackageName( top.getPackage() );
        
        descriptor.addInterface( getGroupImplements() );
        
        for(String s : imports)
            descriptor.addImport(s);
        
        for(String s : top.getUserImports())
            descriptor.addImport(s);
        
        for(ASTFnDefinition fn : top.getFnDefinitions()) {
            descriptor.addNestedClass( getNode(fn).make_class() );
        }
        
        descriptor.addMethod(make_allComponents());
        
        return descriptor;
    }
    
    MethodDescriptor make_allComponents() {
         //List<T> allInstances(ContextModel cm);
        MethodDescriptor method = new MethodDescriptor("allInstances");
        method.addModifier("public");
        method.addModifier("List<"+getFnClassName()+">");
        
        method.addToBlockBody(new CodeStringDescriptor("List<"+getFnClassName()+"> r = new ArrayList<"+getFnClassName()+">();\n"));
        for(ASTFnDefinition fn : top.getFnDefinitions()) {
            method.addToBlockBody( new CodeStringDescriptor("r.add(new "+fn.getName()+"());\n") );
            //descriptor.addNestedClass( getNode(fn).make_class() );
        }
        method.addToBlockBody(new CodeStringDescriptor("return r;\n"));
        
        method.addArgument("ContextModel", "cm");
        return method;
    }
}
