/*
 * CellularResult.java
 *
 * Created on September 27, 2005, 10:41 AM
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
public class CellularResult implements java.io.Serializable {
    
    private double F[];
    private LVect3d delta[];
    
    /** Creates a new instance of CellularResult */
    CellularResult(double F[], double delta[][]) {
        
        this.F = F;
        this.delta = new LVect3d[delta.length];
        
        for(int i=0;i<delta.length;i++)
            this.delta[i] = new LVect3d(delta[i][0], delta[i][1], delta[i][2]);
        
    }
    
    public double getF(int i) {if(i >= F.length) return 0; else return F[i];}
    public LVect3d getDelta(int i) {if(i >= F.length) return new LVect3d(); else return delta[i];}
}
