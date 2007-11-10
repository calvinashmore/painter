/*
 * MutateThread.java
 *
 * Created on June 3, 2006, 6:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.expression;

import genetic.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utils.linear.Color;
import utils.linear.Complex;
import utils.linear.LVect2d;
import utils.linear.LVect3d;

/**
 *
 * @author Calvin Ashmore
 */
public class ExpressionMutator {
    
    public static Expression mutate(ContextModel contextModel, Expression base) {
        Expression r = null;
        
        Random rand = new Random();
        
        boolean mutated = false;
        while(!mutated) {
            
            r = base.clone();
            int option = rand.nextInt(13);
            
            try{ switch(option) {
                case 0: mutated = expandConstant(contextModel, r); break;
                case 1: mutated = randomReplace(contextModel, r); break;
                case 2: mutated = randomReplaceWithConst(contextModel, r); break;
                case 3: mutated = randomReplaceWithVar(contextModel, r); break;
                case 4: mutated = randomReplaceWithConst(contextModel, r); break;
                case 5: mutated = randomReplaceWithVar(contextModel, r); break;
                case 6: mutated = mutateInsert(contextModel, r); break;
                case 7: mutated = mutateBranch(contextModel, r); break;
                case 8: mutated = mutateBridge(contextModel, r); break;
                case 9: mutated = collapseBinaryLeft(contextModel, r); break;
                case 10: mutated = collapseBinaryRight(contextModel, r); break;
                case 11: mutated = collapseBinaryLeft(contextModel, r); break;
                case 12: mutated = collapseBinaryRight(contextModel, r); break;
            }} catch(ExpressionException e) {mutated = false;}
        }
        
        // setup, now r is complete
        r.setup();
        
        return r;
    }
    
    public static boolean expandConstant(ContextModel contextModel, Expression target) throws ExpressionException {
        List<Expression> allNodes = ExpressionFunctionFactory.gatherNodes(target);
        List<Expression> constNodes = new ArrayList();
        
        for(Expression n : allNodes)
            if(n.getFunction().getClass().getName().contains("Constant"))
                constNodes.add(n);
        
        if(constNodes.isEmpty())
            return false;
        
        Random rand = new Random();
        
        Expression constNode = constNodes.get(rand.nextInt(constNodes.size()));
        Class returnClass = constNode.getOutputType();
        
        Expression replacement = new ExpressionFunctionFactory(contextModel).makeTree(returnClass);
        //Expression replacement = new Expression(new ExpressionFactory(contextModel).build(returnClass));
        //builder.buildNode(returnClass, target.getContextClass(), false, true, 3, 10, 1);
        
        for(Expression n : allNodes)
            for(int i=0; i<n.getInputs().size(); i++)
                if(n.getInputs().get(i) == constNode)
                    n.setInput(i, replacement);
        
        return true;
    }
    
    public static boolean randomReplace(ContextModel contextModel, Expression target) throws ExpressionException {
        List<Expression> allNodes = ExpressionFunctionFactory.gatherNodes(target);
        
        Random rand = new Random();
        
        Expression replaceNode = allNodes.get(rand.nextInt(allNodes.size()));
        Class returnClass = replaceNode.getOutputType();
        
        Expression replacement = new ExpressionFunctionFactory(contextModel).makeTree(returnClass);
        //new Expression(new ExpressionFactory(contextModel).build(returnClass));
        //builder.buildNode(returnClass, target.getContextClass(), false, false, 4, 20, 2);
        
        for(Expression n : allNodes)
            for(int i=0; i<n.getInputs().size(); i++)
                if(n.getInputs().get(i) == replaceNode)
                    n.setInput(i, replacement);
        
        return true;
    }
    
    public static boolean randomReplaceWithVar(ContextModel contextModel, Expression target) throws ExpressionException {
        List<Expression> allNodes = ExpressionFunctionFactory.gatherNodes(target);
     
        Random rand = new Random();
     
        Expression replaceNode = allNodes.get(rand.nextInt(allNodes.size()));
        Class returnClass = replaceNode.getOutputType();
     
        ExpressionFunctionFactory nff = new ExpressionFunctionFactory(contextModel);
        Expression replacement = new Expression(nff.build( nff.getVariableFunction(returnClass) ));
     
        //Expression replacement = new Expression(new ExpressionFactory(contextModel).build(returnClass));
        //builder.buildNode(returnClass, target.getContextClass(), false, false, 4, 20, 2);
     
        for(Expression n : allNodes)
            for(int i=0; i<n.getInputs().size(); i++)
                if(n.getInputs().get(i) == replaceNode)
                    n.setInput(i, replacement);
     
        return true;
    }
    
    public static boolean randomReplaceWithConst(ContextModel contextModel, Expression target) throws ExpressionException {
        List<Expression> allNodes = ExpressionFunctionFactory.gatherNodes(target);
     
        Random rand = new Random();
     
        Expression replaceNode = allNodes.get(rand.nextInt(allNodes.size()));
        Class returnClass = replaceNode.getOutputType();
     
        ExpressionFunctionFactory nff = new ExpressionFunctionFactory(contextModel);
        Expression replacement = new Expression(nff.build( nff.getConstantFunction(returnClass) ));
     
        //Expression replacement = new Expression(new ExpressionFactory(contextModel).build(returnClass));
        //builder.buildNode(returnClass, target.getContextClass(), false, false, 4, 20, 2);
     
        for(Expression n : allNodes)
            for(int i=0; i<n.getInputs().size(); i++)
                if(n.getInputs().get(i) == replaceNode)
                    n.setInput(i, replacement);
     
        return true;
    }
    
    public static boolean mutateInsert(ContextModel contextModel, Expression target) throws ExpressionException {
        
        List<Expression> allNodes = ExpressionFunctionFactory.gatherNodes(target);
        Random rand = new Random();
        
        ExpressionFunctionFactory nff = new ExpressionFunctionFactory(contextModel);//builder.makeNFF(1);
        
        Expression insertNode;
        boolean found = false;
        
        for(int i=0;i<100 && !found; i++) {
            insertNode = allNodes.get(rand.nextInt(allNodes.size()));
            List<ExpressionFunction> insertables = nff.getOneToOneFunctions(insertNode.getOutputType());
            if(insertables.size() == 0)
                continue;
            
            //Class returnClass = insertables.get(rand.nextInt(insertables.size())).getClass();
            //Expression inserted = new ExpressionFactory(contextModel).makeTree(returnClass);
            ExpressionFunction insertNF = nff.build( insertables.get(rand.nextInt(insertables.size())).getClass() );
            Expression inserted = new Expression(insertNF);
            inserted.setInput(0, insertNode);
            
            for(Expression n : allNodes)
                for(int j=0; j<n.getInputs().size(); j++)
                    if(n.getInputs().get(j) == insertNode)
                        n.setInput(j, inserted);
            return true;
        }
        if(!found)
            return false;
        
        // should be unreachable
        return false;
    }
    
    public static boolean mutateBranch(ContextModel contextModel, Expression target) throws ExpressionException {
        
        List<Expression> allNodes = ExpressionFunctionFactory.gatherNodes(target);
        Random rand = new Random();
        
        ExpressionFunctionFactory nff = new ExpressionFunctionFactory(contextModel);//builder.makeNFF(1);
        
        Expression insertNode;
        boolean found = false;
        
        for(int i=0;i<100 && !found; i++) {
            insertNode = allNodes.get(rand.nextInt(allNodes.size()));
            List<ExpressionFunction> insertables = nff.getOneToBranchFunctions(insertNode.getOutputType());
            if(insertables.size() == 0)
                continue;
            
            //Class returnClass = insertables.get(rand.nextInt(insertables.size())).getClass();
            //Expression inserted = new ExpressionFactory(contextModel).makeTree(returnClass);
            ExpressionFunction insertNF = nff.build( insertables.get(rand.nextInt(insertables.size())).getClass() );
            Expression inserted = new Expression(insertNF);
            
            boolean hasInserted = false;
            for(int j = 0; j<inserted.getNumberInputs(); j++) {
                
                if(!hasInserted && inserted.getInputType(j) == insertNode.getOutputType()) {
                    inserted.setInput(j, insertNode);
                    hasInserted = true;
                } else {
                    inserted.setInput(j, nff.makeTree(inserted.getInputType(j)));
                    //builder.buildNode(inserted.getInputType(j),
                    // inserted.getInputContext(j,insertNode.getContextClass()), false, false, 2, 10, 1));
                }
            }
            
            if(!hasInserted)
                continue;
            
            for(Expression n : allNodes)
                for(int j=0; j<n.getInputs().size(); j++)
                    if(n.getInputs().get(j) == insertNode)
                        n.setInput(j, inserted);
            return true;
        }
        if(!found)
            return false;
        
        // should be unreachable
        return false;
    }
    
    public static boolean mutateBridge(ContextModel contextModel, Expression target) throws ExpressionException {
        
        List<Expression> allNodes = ExpressionFunctionFactory.gatherNodes(target);
        
        Random rand = new Random();
        
        ExpressionFunctionFactory nff = new ExpressionFunctionFactory(contextModel);//builder.makeNFF(1);
        
        Expression insertNode;
        boolean found = false;
        
        for(int i=0;i<100 && !found; i++) {
            insertNode = allNodes.get(rand.nextInt(allNodes.size())); // node to be replaced
            Expression bridgeNode = null; // node that is replacing
            
            // make sure no circular referencing
            for(int j=0;j<100 && bridgeNode==null;j++) {
                bridgeNode =  allNodes.get(rand.nextInt(allNodes.size()));
                if(ExpressionFunctionFactory.gatherNodes(bridgeNode).contains(insertNode))
                    bridgeNode = null;
            }
            if(bridgeNode == null)
                continue;
            
            List<ExpressionFunction> insertables = nff.getOneToBranchFunctions(insertNode.getOutputType(), bridgeNode.getOutputType());
            
            if(insertables.size() == 0)
                continue;
            
            //Class returnClass = insertables.get(rand.nextInt(insertables.size())).getClass();
            //Expression inserted = new ExpressionFactory(contextModel).makeTree(returnClass);
            ExpressionFunction insertNF = nff.build( insertables.get(rand.nextInt(insertables.size())).getClass() );
            Expression inserted = new Expression(insertNF);
            
            boolean hasInserted = false;
            for(int j = 0; j<inserted.getNumberInputs(); j++) {
                
                if(!hasInserted && inserted.getInputType(j) == insertNode.getOutputType()) {
                    inserted.setInput(j, bridgeNode);
                    hasInserted = true;
                } else
                    inserted.setInput(j, nff.makeTree(inserted.getInputType(j)));//builder.buildNode(inserted.getInputType(j),
                //inserted.getInputContext(j,insertNode.getContextClass()), false, false, 2, 10, 1));
            }
            
            if(!hasInserted)
                continue;
            
            for(Expression n : allNodes)
                for(int j=0; j<n.getInputs().size(); j++)
                    if(n.getInputs().get(j) == insertNode)
                        n.setInput(j, inserted);
            return true;
        }
        
        return false;
    }

    private static boolean collapseBinaryLeft(ContextModel contextModel, Expression target) {
        
        List<Expression> allNodes = ExpressionFunctionFactory.gatherNodes(target);
        Random rand = new Random();
        
        for(int i=0;i<100;i++) {
            Expression replaceNode = allNodes.get(rand.nextInt(allNodes.size())); // node to be replaced
            
            if(replaceNode.getNumberInputs() != 2)
                continue;
            
            Expression replacement = replaceNode.getInput(0);
            
            for(Expression n : allNodes)
                for(int j=0; j<n.getInputs().size(); j++)
                    if(n.getInputs().get(j) == replaceNode)
                        n.setInput(j, replacement);
            return true;
        }
        
        return false;
    }

    private static boolean collapseBinaryRight(ContextModel contextModel, Expression target) {
        List<Expression> allNodes = ExpressionFunctionFactory.gatherNodes(target);
        Random rand = new Random();
        
        for(int i=0;i<100;i++) {
            Expression replaceNode = allNodes.get(rand.nextInt(allNodes.size())); // node to be replaced
            
            if(replaceNode.getNumberInputs() != 2)
                continue;
            
            Expression replacement = replaceNode.getInput(1);
            
            for(Expression n : allNodes)
                for(int j=0; j<n.getInputs().size(); j++)
                    if(n.getInputs().get(j) == replaceNode)
                        n.setInput(j, replacement);
            return true;
        }
        
        return false;
    }
    
}
