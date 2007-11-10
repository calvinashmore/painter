/*
 * Grid.java
 *
 * Created on February 25, 2006, 12:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.linear.grid;

/**
 *
 * @author Calvin Ashmore
 */
public interface Grid<T/* extends Linear<T>*/>
        //extends Linear<Grid<T>> {
{
    public T getValue(int x, int y);
    public void setValue(int x, int y, T val);
    
    public int getXRes();
    public int getYRes();
    
    public T pointAverage(int x, int y);
    public T pointAverage(int x, int y, int r);
    public T pointAverage(int x, int y, int rx, int ry);
    
    public T pointGaussAverage(double x, double y, int radius, double sharpness);
    
    public T getValueWrap(int ix, int iy, GridWrapMethod xWrapMethod, GridWrapMethod yWrapMethod);
    public T evalScale(double x, double y, GridWrapMethod xWrapMethod, GridWrapMethod yWrapMethod, GridScaleMethod scaleMethod);
    
}
