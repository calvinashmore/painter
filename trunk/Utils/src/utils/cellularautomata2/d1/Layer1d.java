/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d1;

import java.util.Arrays;
import java.util.Iterator;
import utils.cellularautomata2.Layer;
import utils.linear.LDouble;

/**
 *
 * @author Calvin Ashmore
 */
public class Layer1d implements Layer<LDouble, CellCoordinate1d> {

    private LDouble[] grid;
    
    public Layer1d(int size) {
        grid = new LDouble[size];
    }

    public void clear() {
        for (LDouble x : grid) {
            x.val = 0;
        }
    }

    public Layer<LDouble, CellCoordinate1d> copy() {
        Layer1d layer = new Layer1d(grid.length);
        for (int i=0;i<grid.length;i++) {
            layer.grid[i] = new LDouble(grid[i].val);
        }
        return layer;
    }

    private int wrapIndex(CellCoordinate1d coord) {
        int index = coord.index;
        if(index < 0)
            index += grid.length * (index/coord.index +1);
        return index % grid.length;
    }
    
    public LDouble getData(CellCoordinate1d coord) {
        return grid[wrapIndex(coord)];
    }

    public void setData(CellCoordinate1d coord, LDouble data) {
        grid[wrapIndex(coord)] = data;
    }

    public Iterator<CellCoordinate1d> iterator() {
        return new Iterator<CellCoordinate1d>() {

            int index = 0;
            
            public boolean hasNext() {
                return index < grid.length;
            }

            public CellCoordinate1d next() {
                return new CellCoordinate1d(index++);
            }

            public void remove() {
                throw new UnsupportedOperationException("Not supported.");
            }
        };
    }
}
