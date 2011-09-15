/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2;

import utils.linear.Linear;

/**
 *
 * @author Calvin Ashmore
 */
public interface CellFunction<T extends Linear<T>, Coord extends CellCoordinate> {
    
    public T evaluate(Coord coord, CellularAutomata<T, Coord> data);
}
