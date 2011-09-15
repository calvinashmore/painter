/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2;

import java.util.Iterator;
import utils.linear.Linear;

/**
 *
 * @author Calvin Ashmore
 */
public interface Layer<T extends Linear<T>, Coord extends CellCoordinate> extends Iterable<Coord>{
    
    void clear();
    
    Layer<T,Coord> copy();
    
    T getData(Coord coord);
    void setData(Coord coord, T data);
    
    Iterator<Coord> iterator();
    
}
