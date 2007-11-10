/*
 * GridSizeException.java
 *
 * Created on February 20, 2005, 3:17 PM
 */

package utils.linear.grid;

/**
 *
 * @author Calvin Ashmore
 */
public class GridSizeException extends RuntimeException{
    
    String text;
    
    public GridSizeException(String s) {text = s;}
    public GridSizeException() {text = null;}
    
    public String toString()
    {
        if(text != null)
            return "Grid size mismatch: "+text;
        else
            return "Grid size mismatch";
    }
}
