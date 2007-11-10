/*
 * Buffer.java
 *
 * Created on February 21, 2006, 11:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.linear.grid;

import utils.linear.Linear;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class Buffer<T extends Linear<T>>
        implements Grid<T>, java.io.Serializable {
    
    protected int xres, yres;
    protected int dataSize;
    
    public int getXRes() {return xres;}
    public int getYRes() {return yres;}
    
    protected double data[];
    
    /** Creates a new instance of Buffer */
    public Buffer(int xres, int yres, int dataSize) {
        this.xres = xres;
        this.yres = yres;
        this.dataSize = dataSize;
        
        data = new double[xres*yres*dataSize];
    }
    
    public abstract T getValue(int x, int y);
    public abstract void setValue(int x, int y, T value);
    
    
    public T pointAverage(int x, int y)
    {
        return pointAverage(x,y,1,1);
    }
    
    public T pointAverage(int x, int y, int r)
    {
        return pointAverage(x,y,r,r);
    }
    
    public T pointAverage(int x, int y, int rx, int ry)
    {
        int count = 0;
        T avg = getValue(0,0).zero();
        for(int xt = x - rx; xt <= x + rx; xt++)
        for(int yt = y - ry; yt <= y + ry; yt++)
        {
            if(xt < 0 || xt >= xres || yt < 0 || yt >= yres)
                continue;
            
            avg.addv(getValue(xt,yt));
            count++;
        }
        
        avg.multv(1.0/count);
        return avg;
    }
    
    public T pointGaussAverage(double x, double y, int radius, double sharpness)
    {
        double net = 0;
        T avg = getValue(0,0).zero();
        
        int ix = (int)x;
        int iy = (int)y;
        
        for(int xt = ix - radius; xt <= ix + radius; xt++)
        for(int yt = iy - radius; yt <= iy + radius; yt++)
        {
            if(xt < 0 || xt >= xres || yt < 0 || yt >= yres)
                continue;
            
            double dist2 = (xt-x)*(xt-x) + (yt-y)*(yt-y);
            double weight = Math.exp(-dist2*sharpness);
            
            avg.addv(getValue(xt,yt).mult(weight));
            net += weight;
        }
        
        avg.multv(1.0/net);
        return avg;
    }
        
    private double splineEval(double t, int lev)
    {
        switch(lev)
        {
            case -1: return (1/6.0)*(1 - 3*t + 3*t*t - t*t*t);
            case  0: return (1/6.0)*(4 - 6*t*t + 3*t*t*t);
            case  1: return (1/6.0)*(1 + 3*t + 3*t*t - 3*t*t*t);
            case  2: return (1/6.0)*(t*t*t);
        }
        return 0;
    }
    
    private int wrap(int ix, GridWrapMethod wrapMethod, int max) {
        //if(wrapMethod == GridWrapMethod.zero)
        //    return -1;
        if(wrapMethod == GridWrapMethod.extend) {
            if(ix < 0) return 0;
            else if(ix >= max) return max-1;
            else return ix;
        }
        else if(wrapMethod == GridWrapMethod.mirror) {
            ix = (ix / max)%2 == 0 ? ix % max : (max - 1 - ix) % max; 
            if(ix < 0)
                ix = (max + ix) % max;
            return ix;
        } else if(wrapMethod == GridWrapMethod.repeat) {
            ix %= max;
            if(ix < 0)
                ix = (max + ix) % max;
            return ix;
        } else return -1;
    }
    
    public T getValueWrap(int ix, int iy, GridWrapMethod xWrapMethod, GridWrapMethod yWrapMethod) {
        
        //try{
        
        ix = wrap(ix, xWrapMethod, xres);
        iy = wrap(iy, yWrapMethod, yres);
        if(ix < 0 || iy < 0)
            return getValue(0,0).zero();
        else
            return getValue(ix,iy);
        
        /*} catch(Exception e) {
            int foo = 1;
            return getValue(0,0).zero();
        }*/
    }
    
    public T evalScale(double x, double y, GridWrapMethod xWrapMethod, GridWrapMethod yWrapMethod, GridScaleMethod scaleMethod) {
        
        switch(scaleMethod) {
            case square: {
                int ix = (int)x;
                int iy = (int)y;
                
                return getValueWrap(ix,iy,xWrapMethod,yWrapMethod);
            }
            case linear: {
                
                int ix = (int)x;
                int iy = (int)y;
                
                if(x < 0) ix--;
                if(y < 0) iy--;

                double dx = x - ix;
                double dy = y - iy;
                
                T influence1 = getValueWrap(ix,iy, xWrapMethod, yWrapMethod).mult((1-dx)*(1-dy));
                T influence2 = getValueWrap(ix+1,iy, xWrapMethod, yWrapMethod).mult((dx)*(1-dy));
                T influence3 = getValueWrap(ix,iy+1, xWrapMethod, yWrapMethod).mult((1-dx)*(dy));
                T influence4 = getValueWrap(ix+1,iy+1, xWrapMethod, yWrapMethod).mult((dx)*(dy));
                return influence1.add(influence2).add(influence3).add(influence4);
            }
            case cubic: {
                
                int ix = (int)x;
                int iy = (int)y;
                
                if(x < 0) ix--;
                if(y < 0) iy--;

                double dx = x - ix;
                double dy = y - iy;
                
                T net = getValue(0,0).zero();
                
                for(int xx = -1; xx <= 2; xx++)
                    for(int yy = -1; yy <= 2; yy++)
                    {
                        T value = getValueWrap( ix + xx, iy + yy , xWrapMethod, yWrapMethod);
                        net.addv(value.mult( splineEval(dx, xx) * splineEval(dy, yy) ));
                    }
                return net;
            }
        }
        
        // unreachable
        return getValue(0,0).zero();
    }
}
