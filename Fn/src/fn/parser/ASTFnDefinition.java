/* Generated By:JJTree: Do not edit this line. ASTFnDefinition.java */
package fn.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ASTFnDefinition extends ASTFnParent {

    private String fnName;
    
    void setName(String fnName) {
        this.fnName = fnName;
    }
    public String getName() {
        return fnName;
    }
    
    private Map<String, ASTBlock> blocks = new HashMap<String, ASTBlock>();
    void addBlock(String id, ASTBlock block) {
        blocks.put(id, block);
    }
    public ASTBlock getBlock(String id) {return blocks.get(id);}
    
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
    
    private Map<String, List<ASTType>> types = new HashMap<String, List<ASTType>>();
    void addType(String id, ASTType type) {
        List<ASTType> typeList = types.get(id);
        if(typeList == null) {
            typeList = new ArrayList<ASTType>();
            types.put(id, typeList);
        }
        typeList.add(type);
    }
    public List<ASTType> getTypes(String id) {
        if(types.get(id) == null)
            return Collections.<ASTType>emptyList();
        return Collections.unmodifiableList(types.get(id));
    }
    
    public class TypeAndName {
        TypeAndName(ASTType type, String name) {
            this.type = type;
            this.name = name;
        }
        private ASTType type;
        private String name;
        public ASTType getType() {return type;}
        public String getName() {return name;}
    }
    
    private Map<String,List<TypeAndName>> typesAndNames = new HashMap<String, List<ASTFnDefinition.TypeAndName>>();
    void addTypeAndName(String id, ASTType type, String name) {
        List<TypeAndName> typeList = typesAndNames.get(id);
        if(typeList == null) {
            typeList = new ArrayList<TypeAndName>();
            typesAndNames.put(id, typeList);
        }
        typeList.add(new TypeAndName(type, name));
    }
    public List<TypeAndName> getTypeAndNames(String id) {
        if(typesAndNames.get(id) == null)
            return Collections.<TypeAndName>emptyList();
        return Collections.unmodifiableList(typesAndNames.get(id));
    }
    
    public ASTFnDefinition(int id) {
        super(id);
    }

    public ASTFnDefinition(FnParser p, int id) {
        super(p, id);
    }
}
