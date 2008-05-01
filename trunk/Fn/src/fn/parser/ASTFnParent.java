/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fn.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class ASTFnParent extends FnParseNode {

    public ASTFnParent(FnParser p, int i) {
        super(p, i);
    }

    public ASTFnParent(int i) {
        super(i);
    }
    
    private List<ASTLocalDeclaration> localDeclarations = new ArrayList<ASTLocalDeclaration>();
    void addLocalDeclaration(ASTLocalDeclaration local) {
        localDeclarations.add(local);
    }
    public List<ASTLocalDeclaration> getLocalDeclarations() {return Collections.unmodifiableList(localDeclarations);}
    
    private Map<String, ASTExpression> meta = new HashMap<String, ASTExpression>();
    void addMeta(String name, ASTExpression expression) {meta.put(name, expression);}
    public Map<String, ASTExpression> getMeta() {return Collections.unmodifiableMap(meta);}
}
