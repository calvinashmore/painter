/*
 * Attractor.java
 *
 * Created on May 10, 2006, 1:48 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.attractor;

/**
 *
 * @author gtg126z
 */
public class Attractor<Function extends AttractorFunction> {
    
    private int maxIterations;
    private int preIterations;
    private int storeIterations;
    private Function f;
    
    public Attractor(Function f) {
        maxIterations = 1000;
        preIterations = 100;
        storeIterations = 1500;
    }
    
    public AttractorResult execute(double startVals[]) {
        
        AttractorResult result = new AttractorResult(f.dimension, storeIterations - preIterations);
        
        double a[] = new double[f.dimension];
        double b[] = new double[f.dimension];
                
        System.arraycopy(startVals,0,a,0,f.dimension);
        
        for(int i=0;i<storeIterations;i++) {
                        
            // apply function
            f.apply(a,b);
            
            // swap
            System.arraycopy(b,0,a,0,f.dimension);
            
            // store
            if(i > preIterations) {
                result.setValue(i-preIterations,a);
            }
        }
        return result;
    }
    
    public double getLyapunov(double startVals[]) {
        
        double sum = 0;
        double a[] = new double[f.dimension];
        double b[] = new double[f.dimension];
        
        double lastVals[] = new double[f.dimension];
        
        System.arraycopy(startVals,0,a,0,f.dimension);
        System.arraycopy(a,0,lastVals,0,f.dimension);
        
        for(int i=0;i<maxIterations;i++) {
            
            if(i > preIterations)
                sum += Math.log( f.derivMagnitude(a) );
            
            // apply function
            f.apply(a,b);
            
            // swap
            System.arraycopy(b,0,a,0,f.dimension);
            
            // test
            double maxdiff = 0;
            for(int j=0;j<f.dimension;j++) {
                // return severe negative Lyapunov if divergent or convergent
                if(a[j] < -100) return Float.MIN_VALUE;
                if(a[j] >  100) return Float.MIN_VALUE;
                maxdiff += Math.abs(a[j] - lastVals[j]);
            }
            if(maxdiff < .0001)
                return Float.MIN_VALUE;
            
            System.arraycopy(a,0,lastVals,0,f.dimension);
        }
        
        return sum;
    }
    
}
