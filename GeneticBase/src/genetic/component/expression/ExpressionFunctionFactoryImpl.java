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
import genetic.util.BuildException;
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
public class ExpressionFunctionFactoryImpl implements ExpressionFunctionFactory {
    
    //private static NodeFunctionFactory gNFF;
    //static NodeFunctionFactory getNFF() {return gNFF;}
    
    // ideally, would be able to do all of this at runtime, but oh well.
    // all node functions need a default constructor, I think
    private static List<ExpressionFunction> allFunctions;
    
    //private Random myRand;
    
    private int numberNodes;
    private int numberNBNodes;
    private int targetDepth;
    //private float reuseProbability = .33f;
    
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
    
    public ExpressionFunctionFactoryImpl() {
        
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
    
    //public int getNumberNodes() {return numberNodes;}
    //public int getNumberNBNodes() {return numberNBNodes;}
    
    
    public ExpressionFunction selectByOutput(Class outputClass, boolean seekTerminal) {
        
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
        double weightTotal = 0;
        for(Class<? extends ExpressionFunction> nfc : matches)
            weightTotal += getNFClassWeight(nfc);
        
        double target = GeneticFoundation.getInstance().getBuilderRandom().nextFloat()*weightTotal;
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
    
    public ExpressionFunction deepBuild(Class<? extends ExpressionFunction> nfClass) throws BuildException {
        
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
        
        throw new BuildException("Failed to instantiate class: "+nfClass.getName());
    }

}
