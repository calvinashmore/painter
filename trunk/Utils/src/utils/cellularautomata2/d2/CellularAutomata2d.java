/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d2;

import utils.cellularautomata2.CellFunction;
import utils.cellularautomata2.CellularAutomata;
import utils.linear.LDouble;

/**
 *
 * @author Calvin Ashmore
 */
public class CellularAutomata2d extends CellularAutomata<LDouble, CellCoordinate2d> {

    public CellularAutomata2d(CellFunction<LDouble, CellCoordinate2d> function) {
        super(function);
    }
}
