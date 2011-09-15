/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d1;

import utils.cellularautomata2.CellFunction;
import utils.cellularautomata2.CellularAutomata;
import utils.cellularautomata2.Layer;
import utils.linear.LDouble;

/**
 *
 * @author Calvin Ashmore
 */
public class CellularAutomata1d extends CellularAutomata<LDouble, CellCoordinate1d> {

    public CellularAutomata1d(CellFunction<LDouble, CellCoordinate1d> function) {
        super(function);
    }
    
}
