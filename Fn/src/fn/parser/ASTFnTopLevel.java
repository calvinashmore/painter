// Parse node for the beat top level 
package fn.parser;

//import macro.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ASTFnTopLevel extends ASTFnParent {

    private String fnGroup;
    private String fnType;
    private String fnPackage;
    
    void setGroup(String group) {this.fnGroup = group;}
    void setType(String type) {this.fnType = type;}
    void setPackage(String p) {this.fnPackage = p;}

    public String getGroup() {return fnGroup;}
    public String getType() {return fnType;}
    public String getPackage() {return fnPackage;}
    
    private Map<String, List<ASTExpression>> expressions = new HashMap<String, List<ASTExpression>>();
    void addExpression(String id, ASTExpression expression) {
        List<ASTExpression> expressionList = expressions.get(id);
        if(expressionList == null) {
            expressionList = new ArrayList<ASTExpression>();
            expressions.put(id, expressionList);
        }
        expressionList.add(expression);
    }
    public List<ASTExpression> getExpressions(String id) {
        if(expressions.get(id) == null)
            return Collections.<ASTExpression>emptyList();
        return Collections.unmodifiableList(expressions.get(id));
    }
    
    private List<String> userImports = new ArrayList();

    // root node of the parse tree
    private static ASTFnTopLevel fnTopLevel;

    public ASTFnTopLevel(int id) {
      super(id);
      fnTopLevel = this;
    }

    public ASTFnTopLevel(FnParser p, int id) {
	super(p, id);
	fnTopLevel = this;
    }

    // Set accessor for user imports. 
    void addUserImport(String importName) {
        userImports.add(importName);
    }
    
    private List<ASTFnDefinition> allFn = new ArrayList<ASTFnDefinition>();
    void addFn(ASTFnDefinition fn) {
        allFn.add(fn);
    } 
    
    public List<ASTFnDefinition> getFnDefinitions() {
        return Collections.unmodifiableList(allFn);
    }

    public List<String> getUserImports() {
        return Collections.unmodifiableList(userImports);
    }

    /*public Iterator getUserImportClasses() {
        return userImportClasses.listIterator();
    }*/

    /* Public get accessor for the unique ASTFnTopLevel reference. */
    public static ASTFnTopLevel getFnTopLevel() {
        return fnTopLevel;
    }

}
