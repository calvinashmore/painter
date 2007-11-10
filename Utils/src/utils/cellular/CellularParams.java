/*
 * CellularParams.java
 *
 * Created on September 27, 2005, 10:02 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package utils.cellular;

import utils.linear.LVect3d;

/**
 *
 * @author gtg126z
 */
public class CellularParams implements java.io.Serializable {
    
    static final public int Poisson_count[] =
        {4,3,1,1,1,2,4,2,2,2,5,1,0,2,1,2,2,0,4,3,2,1,2,1,3,2,2,4,2,2,5,1,2,3,2,2,2,2,2,3,
         2,4,2,5,3,2,2,2,5,3,3,5,2,1,3,3,4,4,2,3,0,4,2,2,2,1,3,2,2,2,3,3,3,1,2,0,2,1,1,2,
         2,2,2,5,3,2,3,2,3,2,2,1,0,2,1,1,2,1,2,2,1,3,4,2,2,2,5,4,2,4,2,2,5,4,3,2,2,5,4,3,
         3,3,5,2,2,2,2,2,3,1,1,4,2,1,3,3,4,3,2,4,3,3,3,4,5,1,4,2,4,3,1,2,3,5,3,2,1,3,1,3,
         3,3,2,3,1,5,5,4,2,2,4,1,3,4,1,5,3,3,5,3,4,3,2,2,1,1,1,1,1,2,4,5,4,5,4,2,1,5,1,1,
         2,3,3,3,2,5,2,3,3,2,0,2,1,1,4,2,1,3,2,1,2,2,3,2,5,5,3,4,5,5,2,4,4,5,3,2,2,2,1,4,
         2,3,3,4,2,5,4,2,4,2,2,2,4,5,3,2};
         
    static final public double densityAdjustment = 0.398150;
    
    public LVect3d scale;
    public LVect3d translate;
    
    public int max_order;
         
    /** Creates a new instance of CellularParams */
    public CellularParams() {
        
        scale = new LVect3d(1,1,1);
        translate = new LVect3d(0,0,0);
        
        max_order = 4;
    }
    
}
