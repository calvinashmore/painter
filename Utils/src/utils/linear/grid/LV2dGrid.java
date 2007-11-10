
package utils.linear.grid;

import utils.linear.LVect2d;

public class LV2dGrid extends ArrayGrid<LVect2d>
{
    public LV2dGrid(LV2dGrid vg)
    {
        super(vg.xres,vg.yres,new LVect2d());
        for(int i=0;i<xres;i++)
        for(int j=0;j<yres;j++)
            values[i][j] = new LVect2d(vg.values[i][j]);
    }
    public LV2dGrid(int sizex, int sizey)
    {
        super(sizex,sizey, new LVect2d());
    }
    
    public LVect2d get(int x, int y)
    {
        return values[x][y];
    }
    
    public void set(int x, int y, LVect2d value)
    {
        values[x][y] = value;
    }
    
    public ScalarGrid normalize()
    {
        ScalarGrid r = new ScalarGrid(xres,yres);
        for(int i=0;i<xres;i++)
        for(int j=0;j<yres;j++)
            r.set(i,j,values[i][j].magnitude());
        return r;
    }
}
