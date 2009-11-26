/*
 * AttractorResult.java
 *
 * Created on May 10, 2006, 1:48 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.pointfield.attractor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.pointfield.Quadtree;

/**
 *
 * @author gtg126z
 */
public class AttractorResult<PointType extends APoint> {
    
    private List<PointType> values;
    //private int dims;
    //private int numberValues;
    
    private APoint minVals;
    private APoint maxVals;
    
    //private Quadtree<PointType> quadtree;
    
    // all attractor results have the following shared properties:
    // the attractors are N-dimensional, but always
    // the first two dims are the x and y coordinates.
    // the remaining values are information that the attractor simply carries.
    
    /** Creates a new instance of AttractorResult */
    public AttractorResult(AttractorFunction f, int numberValues) {
        //this.dims = dims;
        //this.numberValues = numberValues;
        values = new ArrayList(numberValues);
        
        for(int i=0;i<numberValues;i++)
            values.add(null);
        
        minVals = f.getNewPoint();
        maxVals = f.getNewPoint();
        
        minVals.setMaxValues();
        maxVals.setMinValues();
    }
    
    public void setValue(int index, APoint val) {
        values.set(index,(PointType) val.clone());
        minVals.minimize(val);
        maxVals.maximize(val);
    }

    public List<PointType> getValues() {
        return Collections.unmodifiableList(values);
    }
    
    public APoint getValue(int index) {
        return values.get(index);
    }
    
    public void configureQuadtree(Quadtree quadtree) {
        quadtree.setup( minVals.x, maxVals.x, minVals.y, maxVals.y );
        quadtree.setData(values);
    }
}
