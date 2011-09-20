/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d2;

import java.util.Iterator;
import utils.cellularautomata2.Layer;
import utils.linear.LDouble;

/**
 *
 * @author Calvin Ashmore
 */
public class Layer2d implements Layer<LDouble, CellCoordinate2d> {

    private LDouble[][] grid;

    public Layer2d(int xres, int yres) {
        grid = new LDouble[xres][yres];
    }

    public void clear() {
        for (LDouble[] cols : grid) {
            for (LDouble v : cols) {
                v.val = 0;
            }
        }
    }

    public Layer<LDouble, CellCoordinate2d> copy() {
        int w = grid.length;
        int h = grid[0].length;
        Layer2d newLayer = new Layer2d(w, h);
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                newLayer.grid[x][y] = grid[x][y].clone();
            }
        }
        return newLayer;
    }

    public LDouble getData(CellCoordinate2d coord) {
        int w = grid.length;
        int h = grid[0].length;

        int x, y;
        // supid proof wrapping?
        x = (coord.x % w + w) % h;
        y = (coord.y % h + h) % h;

        return grid[x][y];
    }

    public void setData(CellCoordinate2d coord, LDouble data) {
        int w = grid.length;
        int h = grid[0].length;

        int x, y;
        // supid proof wrapping?
        x = (coord.x % w + w) % h;
        y = (coord.y % h + h) % h;

        grid[x][y] = data;
    }

    public Iterator<CellCoordinate2d> iterator() {
        return new Iterator<CellCoordinate2d>() {

            private int x, y;

            public boolean hasNext() {
                return x < grid.length && y < grid[0].length;
            }

            public CellCoordinate2d next() {
                CellCoordinate2d coord = new CellCoordinate2d(x, y);
                x++;
                if (x == grid.length) {
                    x = 0;
                    y++;
                }
                return coord;
            }

            public void remove() {
                throw new UnsupportedOperationException("Not supported.");
            }
        };
    }
}
