/*
 * AttractorResult.java
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
public class AttractorResult {
    
    private double values[][];
    private int dims;
    private int numberValues;
    
    private double minVals[];
    private double maxVals[];
    
    // all attractor results have the following shared properties:
    // the attractors are N-dimensional, but always
    // the first two dims are the x and y coordinates.
    // the remaining values are information that the attractor simply carries.
    
    /** Creates a new instance of AttractorResult */
    public AttractorResult(int dims, int numberValues) {
        this.dims = dims;
        this.numberValues = numberValues;
        values = new double[dims][numberValues];
        
        minVals = new double[dims];
        maxVals = new double[dims];
        for(int j=0;j<dims;j++) {
            minVals[j] = Float.MAX_VALUE;
            maxVals[j] = Float.MIN_VALUE;
        }
    }
    
    public void setValue(int index, double vals[]) {
        for(int j=0;j<dims;j++) {
            values[j][index] = vals[j];
            if(vals[j] < minVals[j]) minVals[j] = vals[j];
            if(vals[j] > maxVals[j]) maxVals[j] = vals[j];
        }
    }
    
    public void makeQuadtree() {
        
    }
}
