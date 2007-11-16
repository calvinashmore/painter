/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.expression;

import genetic.GeneticFoundation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calvin Ashmore
 */
public class ExpressionFunctionUtils {

    static public List<ExpressionFunction> getOneToOneFunctions(Class type) {
        List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
        List<ExpressionFunction> allFunctions = GeneticFoundation.getInstance().getAllExpressionFunctions().allInstances();
        for(ExpressionFunction nf : allFunctions) {
            if(nf.getReturnType() == type && nf.getNumberInputs() == 1 &&
                    nf.getInputType(0) == type)
                r.add(nf);
        }
        return r;
    }
    
    static public List<ExpressionFunction> getOneToBranchFunctions(Class type) {
        List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
        List<ExpressionFunction> allFunctions = GeneticFoundation.getInstance().getAllExpressionFunctions().allInstances();
        for(ExpressionFunction nf : allFunctions) {
            if(nf.getReturnType() == type && nf.getNumberInputs() != 0)
                for(int i=0; i<nf.getNumberInputs(); i++)
                    if(nf.getInputType(i) == type && !r.contains(nf))
                        r.add(nf);
        }
        return r;
    }
    
    static public List<ExpressionFunction> getOneToBranchFunctions(Class outtype, Class intype) {
        List<ExpressionFunction> r = new ArrayList<ExpressionFunction>();
        List<ExpressionFunction> allFunctions = GeneticFoundation.getInstance().getAllExpressionFunctions().allInstances();
        for(ExpressionFunction nf : allFunctions) {
            if(nf.getReturnType() == outtype && nf.getNumberInputs() != 0)
                for(int i=0; i<nf.getNumberInputs(); i++)
                    if(nf.getInputType(i) == intype && !r.contains(nf))
                        r.add(nf);
        }
        return r;
    }
}
