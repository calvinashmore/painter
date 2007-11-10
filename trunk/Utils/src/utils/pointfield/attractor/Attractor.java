/*
 * Attractor.java
 *
 * Created on May 10, 2006, 1:48 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.pointfield.attractor;

import utils.pointfield.Quadtree;

/**
 *
 * @author gtg126z
 */
public class Attractor<Function extends AttractorFunction> {
    
    private int maxIterations;
    private int preIterations;
    private Function f;
    
    public Attractor() {
        maxIterations = 2000;
        preIterations = 1000;
    }
    
    public Quadtree makeQuadtree(Function f, APoint startPoint) {
        
        for(int i=0;i<1000;i++) {
            
            // The function!
            //attractor.setFunction( function );
            this.f = f;
            f.adjustParameters();
            
            double lyapunov = getLyapunov( startPoint );
            
            if(     lyapunov > f.getMinLyapunov() &&
                    lyapunov < f.getMaxLyapunov() ) {
                
                AttractorResult result = execute(startPoint.clone());
                Quadtree qtree = f.makeQuadtree();
                result.configureQuadtree(qtree);
                if(qtree.getNumberSmallCells() < f.getMinimumCells())
                    continue;
            
                /*
                System.out.println("done! (" + qtree.getNumberSmallCells() + " small cells!)");
                System.out.println("found after "+i+" tests!");
                System.out.println("Lyapunov value: "+lyapunov);
                */
                return qtree;
            }
        }
        
        /*
        System.out.println("**********");
        System.out.println("Failed to find match?");
        System.out.println("function: "+f);
        System.out.println("startPoint: "+startPoint.x + ", "+startPoint.y);
        System.out.println("**********");
        */
        
        return null;
    }
    
    public Quadtree makeQuadtreeRaw(Function f, APoint startPoint) {
        
        this.f = f;
        AttractorResult result = execute(startPoint.clone());
        Quadtree qtree = f.makeQuadtree();
        result.configureQuadtree(qtree);
        
        return qtree;
    }
    
    public AttractorResult execute(APoint start) {
        
        AttractorResult result = new AttractorResult(f,f.getIdealIterations() - preIterations);
        
        APoint a = start;
        APoint b = f.getNewPoint();
        APoint t = null;
                
        a.x = start.x;
        a.y = start.y;
        
        for(int i=0;i<f.getIdealIterations();i++) {
                        
            // apply function
            f.apply(a,b);
            
            // swap
            t = b;
            b = a;
            a = t;
            
            // store
            if(i >= preIterations) {
                a.index = (double)(i-preIterations) / (f.getIdealIterations()-preIterations);
                result.setValue(i-preIterations,a);
            }
        }
        return result;
    }
    
    public double getLyapunov(APoint start) {
        
        double sum = 0;
        APoint a = f.getNewPoint();
        APoint b = f.getNewPoint();
        APoint t = null;
        
        for(int i=0;i<maxIterations;i++) {
            
            if(i > preIterations)
                sum += Math.log( f.derivMagnitude(a) );
            
            // apply function
            f.apply(a,b);
            
            // swap
            t = b;
            b = a;
            a = t;
            
            // test
            if( a.bound() > 100 || a.diff(b) < .0001 )
                return -10000;
        }
        return sum / (maxIterations - preIterations);
    }
    
}
