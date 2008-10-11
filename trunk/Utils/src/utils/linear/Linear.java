/*
 * Linear.java
 *
 * Created on February 20, 2005, 1:56 PM
 */

package utils.linear;

/**
 *
 * @author Calvin Ashmore
 */
public interface Linear<T> extends java.io.Serializable
{
    // Every implementation of Linear *ought*
    // to have a zero argument constructor, and a copy constructor
    
    public T zero();
    
    public T add(T a);
    public void addv(T a);
    
    public T sub(T a);
    public void subv(T a);
    
    public T mult(double c);
    public void multv(double c);
    
    public T normal();
    public void normalv();
    
    public double magnitude();
    
    public T clone();
    
    //T[] basis();
}
