/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fn;

import fn.parser.ASTFnTopLevel;
import fn.parser.FnParser;
import fn.parser.ParseException;
import java.io.InputStream;
import jd.ClassDescriptor;

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

    public ClassDescriptor compile(InputStream input) throws ParseException {
        FnParser parser = new FnParser(input);

        ASTFnTopLevel n = parser.FnTopLevel();
        FnGroup group = makeGroup(n);
        ClassDescriptor c = group.make_class();

        return c;
    }
}
