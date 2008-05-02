/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fn;

import fn.parser.ASTExpression;
import fn.parser.ASTFnDefinition;
import fn.parser.ASTFnTopLevel;
import fn.parser.ASTLocalDeclaration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        
        addImport("java.util.*");
        addImport("genetic.*");
        addImport("genetic.component.accessor.*");
        addImport("genetic.component.command.*");
        addImport("genetic.component.context.*");
        addImport("genetic.component.expression.*");
        addImport("genetic.component.expression.function.*");
        addImport("genetic.component.method.*");
        addImport("genetic.component.program.*");
        addImport("genetic.component.statement.*");
        addImport("genetic.component.statementlist.*");
        addImport("genetic.component.statement.function.*");
    }
    
    
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
        
        if(!top.getExpressions("description").isEmpty()) {
            descriptor.addInterface("Described");
            descriptor.addMethod(make_getDescription());
        }
        
        descriptor.addMethod(make_allComponents());
        descriptor.addMethod(make_addGroupMeta());
        
        descriptor.addToBlockBody(make_localDeclarations());
        
        return descriptor;
    }
    
    MethodDescriptor make_addGroupMeta() {
        MethodDescriptor method = new MethodDescriptor("addGroupMeta");
        method.addModifier("private");
        method.addModifier("static");
        method.addModifier("void");
        method.addArgument("Metadata", "item");
        
        StringBuffer sb = new StringBuffer();
        Map<String, ASTExpression> meta = top.getMeta();
        for (Map.Entry<String, ASTExpression> entry : meta.entrySet()) {
            sb.append("item.addMeta(");
            sb.append(  "\""+entry.getKey()+"\", ");
            sb.append(  entry.getValue().dumpTokens());
            sb.append(");\n");
        }
        method.addToBlockBody(new CodeStringDescriptor(sb.toString()));
        return method;
    }
    
    CodeStringDescriptor make_localDeclarations() {
        StringBuffer sb = new StringBuffer();
        
        for(ASTLocalDeclaration local : top.getLocalDeclarations()) {
            //local.dump(sb, "");
            sb.append(local.dumpTokens());
        }
        
        return new CodeStringDescriptor(sb.toString());
    }
    
    MethodDescriptor make_getDescription() {
        MethodDescriptor method = new MethodDescriptor("getDescription");
        method.addModifier("public");
        method.addModifier("String");
        
        String contents = "return "+top.getExpressions("description").get(0).dumpTokens()+";";
        method.addToBlockBody(new CodeStringDescriptor(contents));
        
        return method;
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
