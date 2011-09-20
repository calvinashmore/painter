/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d2;

import utils.cellularautomata2.CellFunction;
import utils.cellularautomata2.CellularAutomata;
import utils.cellularautomata2.Layer;
import utils.linear.LDouble;

/**
 *
 * @author Calvin Ashmore
 */
public class Conway implements CellFunction<LDouble, CellCoordinate2d> {

    public LDouble evaluate(CellCoordinate2d coord, CellularAutomata<LDouble, CellCoordinate2d> data) {

        Layer<LDouble, CellCoordinate2d> layer = data.getLastLayer(0);

        int count = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                
                // don't count self
                if(dx==0 && dy==0)
                    continue;
                
                count += layer.getData(new CellCoordinate2d(dx + coord.x, dy + coord.y)).val;
            }
        }

        if (count < 2 || count > 3) {
            return new LDouble(0);
        }
        if (count == 3) {
            return new LDouble(1);
        } else {
            return layer.getData(coord); // last coordinate
        }
    }
}
