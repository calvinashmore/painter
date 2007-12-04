/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.statement.function;

import genetic.component.statement.*;
import genetic.Context;
import genetic.Foundation;
import genetic.GeneticComponent;
import genetic.GeneticTopLevel;
import genetic.component.expression.Expression;
import genetic.component.method.Method;
import genetic.util.BuildException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Calvin Ashmore
 */
public class MethodStatementFunction extends StatementFunction {

    //private Method method;
    private String methodName;
    private List<Expression> expressions;
    
    @Override
    public void setup() throws BuildException {
        
        GeneticTopLevel program = getContextModel().getTopLevel();
        Map<String, Method> methods = program.getMethods();
        
        if(methods.size() == 0)
            throw new BuildException("Program has no methods!");
        
        // traverse up until we reach the method that contains this
        GeneticComponent component = this;
        while(!(component instanceof Method))
            component = component.getParent();
        Method myMethod = (Method)component;
        
        String myMethodName = null;
        for(String name : methods.keySet()) {
            if(methods.get(name) == myMethod)
                myMethodName = name;
        }
        
        List<String> methodNames = new ArrayList<String>();
        for(String name : methods.keySet()) {
            // check for valid method names, ie
            // methods that do not cycle
            
            // this method does not use myMethod, so it is safe.
            if(!methods.get(name).hasMethod(myMethodName))
                methodNames.add(name);
        }
        
        if(methodNames.size() == 0)
            throw new BuildException("No non-cycling methods are available");
        
        Random rand = Foundation.getInstance().getBuilderRandom();
        methodName = methodNames.get(rand.nextInt(methodNames.size()));
        
        super.setup();
    }
    
    @Override
    public void execute(Context context) {
        
        List<Object> arguments = new ArrayList();
        for(Expression expression : expressions)
            arguments.add(expression.evaluate(context));
        
        Method method = getContextModel().getTopLevel().getMethods().get(methodName);
        method.execute(context, arguments);
    }

    @Override
    public boolean isNestingStatement() {
        return false;
    }

    @Override
    public boolean hasMethod(String name) {
        return name.equals(methodName);
    }

}
