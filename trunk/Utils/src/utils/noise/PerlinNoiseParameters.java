
package utils.noise;

import utils.*;
import utils.linear.LVect3d;

public class PerlinNoiseParameters implements java.io.Serializable
{
    public LVect3d scale;
    public LVect3d translate;

    //public double lambda;
    //public double omega;
    //public int octaves;

    //public boolean usePowers;

    public PerlinNoiseParameters()
    {
        scale = new LVect3d(1,1,1);
        translate = new LVect3d(0,0,0);
        //lambda = 2;
        //omega = .5;
        //octaves = 7;
        //usePowers = false;
    }
}