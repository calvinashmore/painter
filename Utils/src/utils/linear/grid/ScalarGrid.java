/*
 * ScalarGrid.java
 *
 * Created on February 20, 2005, 1:59 PM
 */

package utils.linear.grid;

import utils.linear.LDouble;
import utils.linear.LVect3d;
import utils.noise.PerlinNoise;

/**
 *
 * @author Calvin Ashmore
 */
public class ScalarGrid extends ArrayGrid<LDouble>
{
    public ScalarGrid(ArrayGrid<LDouble> lg)
    {
        super(lg.xres,lg.yres,new LDouble());
        for(int i=0;i<xres;i++)
        for(int j=0;j<yres;j++)
            values[i][j].val = lg.values[i][j].val;
    }
    
    public ScalarGrid(ScalarGrid sg)
    {
        super(sg.xres,sg.yres,new LDouble());
        for(int i=0;i<xres;i++)
        for(int j=0;j<yres;j++)
            values[i][j].val = sg.values[i][j].val;
    }
    public ScalarGrid(int sizex, int sizey)
    {
        super(sizex,sizey, new LDouble());
    }
    
    public double get(int x, int y)
    {
        return values[x][y].val;
    }
    
    public void set(int x, int y, double value)
    {
        values[x][y].val = value;
    }
    
    /*
    public void fillNoise(PerlinNoise N) {fillNoise(N, 0);}
    public void fillNoise(PerlinNoise N, double height)
    {
        for(int i=0;i<xres;i++)
        for(int j=0;j<yres;j++)
            values[i][j].val = N.eval(i,j, height);
    }
    
    public void addNoise(PerlinNoise N, double ratio)
    {
        ScalarGrid g = new ScalarGrid(xres,yres);
        g.multv(ratio);
        addv(g);
    }*/
    
    public double maxValue()
    {
        double mval = Double.MIN_VALUE;
        
        for(int i=0;i<xres;i++)
        for(int j=0;j<yres;j++)
            if(get(i,j) > mval)
                mval = get(i,j);
        return mval;
    }
    
    public double minValue()
    {
        double mval = Double.MAX_VALUE;
        
        for(int i=0;i<xres;i++)
        for(int j=0;j<yres;j++)
            if(get(i,j) < mval)
                mval = get(i,j);
        return mval;
    }
    
    public void scale01()
    {
        double max = maxValue();
        double min = minValue();
        double scale = 1.0/(max - min);
        
        for(int i=0;i<xres;i++)
        for(int j=0;j<yres;j++)
            set(i,j, (get(i,j) - min)*(scale));
    }
    
    public ArrayGrid<LVect3d> getNormals(double heightRatio)
    {
        ArrayGrid<LVect3d> r = new ArrayGrid<LVect3d>(xres,yres,new LVect3d());
        
        for(int i=0;i<xres;i++)
        for(int j=0;j<yres;j++)
        {
            double xval1, xval2;
            if(i==0) { xval1 = get(i,j); xval2 = get(i+1, j); }
            else if(i==xres-1) { xval1 = get(i-1,j); xval2 = get(i,j); }
            else { xval1 = get(i-1,j); xval2 = get(i+1, j); }
            
            double yval1, yval2;
            if(j==0) { yval1 = get(i,j); yval2 = get(i, j+1); }
            else if(j==yres-1) { yval1 = get(i,j-1); yval2 = get(i,j); }
            else { yval1 = get(i,j-1); yval2 = get(i, j+1); }
            
            LVect3d xv = new LVect3d( 1, (xval2-xval1)*heightRatio, 0 );
            LVect3d yv = new LVect3d( 0, (yval2-yval1)*heightRatio, 1 );
            r.values[i][j] = (LVect3d.cross(yv, xv)).normal();
        }
        
        return r;
    }
    
}
