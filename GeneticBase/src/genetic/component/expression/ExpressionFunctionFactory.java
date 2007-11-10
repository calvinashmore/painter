/*
 * NodeFunctionFactory.java
 *
 * Created on September 23, 2005, 11:21 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package genetic.component.expression;


import genetic.*;
import java.util.*;
import java.lang.reflect.*;


//import functions.*;
import java.util.ArrayList;
//import gen.functions.AllFn;

//import utils.estimates.*;

/**
 *
 * @author gtg126z
 */
public class ExpressionFunctionFactory {
    
    //private static NodeFunctionFactory gNFF;
    //static NodeFunctionFactory getNFF() {return gNFF;}
    
    // ideally, would be able to do all of this at runtime, but oh well.
    // all node functions need a default constructor, I think
    private static List<ExpressionFunction> allFunctions;
    //List<Class<? extends NodeFunction>> allFunctions;
    //private Map<Class, List<Node>> allNodes;
    //private Map<Integer, Node> allNodesByID;
    //private Map<Class, Node> contextDirectNodes;
    //private static Map<Class, Context> contextTable;
    //private Map<Node, Pair<Node,Estimate>> matchMap;
    private Random myRand;
    
    private int numberNodes;
    private int numberNBNodes;
    private int targetDepth;
    private float reuseProbability = .33f;
    
    private ContextModel contextModel;
    
    //static {
    //    allFunctions = new AllExpressionFunctions().getFunctions();
    //}
    
    public Class<ExpressionFunction> getVariableFunction(Class type) {
        return AllExpressionFunctions.getVariableFunction(type);
    }
    
    public Class<ExpressionFunction> getConstantFunction(Class type) {
        return AllExpressionFunctions.getConstantFunction(type);
    }
    
    public static List<ExpressionFunction> allFunctions() {
        return Collections.unmodifiableList(allFunctions);
    }
    
    //public Node getContextDirectNode(Class c) {
    //    return contextDirectNodes.get(c);
    //}
    
    public ExpressionFunctionFactory() {
        
    }
    
    //public ExpressionFunctionFactory(ContextModel contextModel) {this(contextModel, 2);}
    
    /** Creates a new instance of NodeFunctionFactory */
    /*public ExpressionFunctionFactory(ContextModel contextModel, int targetDepth) {
        
        this.contextModel = contextModel;
        
        this.numberNodes = 0;
        this.numberNBNodes = 0;
        this.targetDepth = targetDepth;
        
        myRand = new Random();
    }*/
    
    public float getNFClassWeight(Class<? extends ExpressionFunction> nfClass) {
        
        return 1.0f;
    }
    
    public int getNumberNodes() {return numberNodes;}
    public int getNumberNBNodes() {return numberNBNodes;}
    
    public Expression makeTree(Class outputClass) throws ExpressionException {return makeTree(/*baseContextClass,*/ outputClass, 0);}
    
    public Expression makeTree(/*Class baseContextClass,*/ Class outputClass, int depth) throws ExpressionException {
        // would also want some space limiting parameters in here...
        
        // *** seek an appropriate function        
        ExpressionFunction nf = randomByOutput(outputClass, depth>=targetDepth);
        
        // *** if we are in too deep, seek a terminal function
        if( (depth >= targetDepth && nf != null && nf.getNumberInputs() != 0)) {
            int check = 10 + (int)Math.sqrt(numberNodes);
            
            for(int i=0; i<check && nf != null && nf.getNumberInputs() != 0; i++)
                nf = randomByOutput(outputClass, true);
        }
        
        if(nf == null)
            throw new ExpressionException("Cannot find builder with output: " + outputClass + " (" + depth +"/"+targetDepth+" deep)");
        
        
        // *** okay, we've found the nf we are looking for,
        // build a real one
        // the current nf is just a shallow copy
        nf = build(nf.getClass());
        
        Expression node = newNode(nf);
        
        // *** fill subchildren
        //Class inputClasses[] = node.getInputClasses();
        //if(inputClasses != null)
            for(int i=0; i<node.getNumberInputs(); i++) {
                node.assignChild(i, makeTree(node.getInputType(i), depth+1));
            }
        
        return node;
    }
    
    public ExpressionFunction randomByOutput(Class outputClass, boolean seekTerminal) {
        
        List<Class<? extends ExpressionFunction>> matches = new ArrayList<Class<? extends ExpressionFunction>>();
        for(ExpressionFunction nf : allFunctions)
            if(nf.getReturnType() == outputClass && 
                    (!seekTerminal || nf.getNumberInputs() == 0) )
                matches.add(nf.getClass());
        
        // if we are seeking a terminal, and there are no possible terminals, go ahead and
        // just select from all possible outputs
        if(matches.size() == 0 && seekTerminal)
            for(ExpressionFunction nf : allFunctions)
                if(nf.getReturnType() == outputClass)
                    matches.add(nf.getClass());
            
        
        if(matches.size() == 0) {
            System.out.println("Cannot match output class " + outputClass.getName());
            return null;
        }
            
        // select from this list, using weights
        float weightTotal = 0;
        for(Class<? extends ExpressionFunction> nfc : matches)
            weightTotal += getNFClassWeight(nfc);
        
        float target = myRand.nextFloat()*weightTotal;
        int index = 0;
        for(Class<? extends ExpressionFunction> nfc : matches) {
            target -= getNFClassWeight(nfc);
            if(target < 0)
                break;
            index++;
        }
        
        return shallowBuild(matches.get(index));
    }
    
    public ExpressionFunction shallowBuild(Class<? extends ExpressionFunction> nfClass){
        
        try {
            return nfClass.newInstance();
        }
        catch(IllegalAccessException e) {}
        catch(InstantiationException e) {}
        
        throw new RuntimeException("Failed to instantiate class: "+nfClass.getName());
    }
    
    public ExpressionFunction build(Class<? extends ExpressionFunction> nfClass) throws ExpressionException{
        
        try {
            try{
                Constructor<? extends ExpressionFunction> c = nfClass.getConstructor(ContextModel.class);
                return c.newInstance(contextModel);
            } catch (NoSuchMethodException e) {}
            
            return nfClass.newInstance();
        }
        catch(IllegalAccessException e) {}
        catch(InstantiationException e) {}
        catch(InvocationTargetException e) {} 
        
        /*ExpressionFunction nf = new AllFn().build(nfClass,this);
        if(nf != null)
            return nf;*/
        
        throw new ExpressionException("Failed to instantiate class: "+nfClass.getName());
    }
    
    public Expression newNode(ExpressionFunction nf/*, Class contextClass*/) {
        return new Expression(/*numberNodes++,*/ nf);
    }
    
    public List<ExpressionFunction> getOneToOneFunctions(Class type) {
        List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
        for(ExpressionFunction nf : allFunctions) {
            if(nf.getReturnType() == type && nf.getNumberInputs() == 1 &&
                    nf.getInputType(0) == type)
                r.add(nf);
        }
        return r;
    }
    
    public List<ExpressionFunction> getOneToBranchFunctions(Class type) {
        List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
        for(ExpressionFunction nf : allFunctions) {
            if(nf.getReturnType() == type && nf.getNumberInputs() != 0)
                for(int i=0; i<nf.getNumberInputs(); i++)
                    if(nf.getInputType(i) == type && !r.contains(nf))
                        r.add(nf);
        }
        return r;
    }
    
    public List<ExpressionFunction> getOneToBranchFunctions(Class outtype, Class intype) {
        List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
        for(ExpressionFunction nf : allFunctions) {
            if(nf.getReturnType() == outtype && nf.getNumberInputs() != 0)
                for(int i=0; i<nf.getNumberInputs(); i++)
                    if(nf.getInputType(i) == intype && !r.contains(nf))
                        r.add(nf);
        }
        return r;
    }
    
    public static List<Expression> gatherNodes(Expression target) {
        List<Expression> gathered = new ArrayList<Expression>();
        
        gatherNodes(target, gathered);
        return gathered;
    }
    
    private static void gatherNodes(Expression target, List<Expression> current) {
        
        if(target == null)
            return;
        
        if(current.contains(target))
            return;
        
        current.add(target);
        
        //for(Expression n : target.getInputs())
        //    gatherNodes(n, current);
        for(int i=0; i<target.getNumberInputs(); i++)
            gatherNodes(target.getInput(i), current);
    }
    
    public static Expression removeVariable(Expression expression, String name) {
        
        Expression r = expression.clone();
        
        List<Expression> expressions = gatherNodes(r);
        for(Expression expression1 : expressions)
            if(expression1.getFunction() instanceof VariableExpressionFunction
                && ((VariableExpressionFunction)expression1.getFunction()).getVariableName().equals(name)) {
                // the expression is a variable, and the variable name matches the variable being removed
                // need to replace the NF with a constant
            
                String nfClassName = expression1.getFunction().getClass().getName().replace("Variable","Constant");
                
                ExpressionFunction constant;
                try { constant = (ExpressionFunction) Class.forName(nfClassName).newInstance(); }
                catch (InstantiationException ex) {throw new RuntimeException(ex);}
                catch (IllegalAccessException ex) {throw new RuntimeException(ex);}
                catch (ClassNotFoundException ex) {throw new RuntimeException(ex);}
                
                Expression replacement = new Expression(constant);
                
                for(Expression expression2 : expressions) {
                    List<Expression> subExpressions = expression2.getChildren();
                    for(int i=0;i<subExpressions.size();i++)
                        if(subExpressions.get(i) == expression1)
                            expression2.setInput(i, replacement);
                }
                if(r == expression1)
                    r = replacement;
            }
        
        return r;
    }
}
