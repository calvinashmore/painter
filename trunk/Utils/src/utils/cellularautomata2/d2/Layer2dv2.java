/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d2;

import java.util.Iterator;
import utils.cellularautomata2.Layer;
import utils.linear.LVect2d;

/**
 *
 * @author Calvin Ashmore
 */
public class Layer2dv2 implements Layer<LVect2d, CellCoordinate2d> {

    private LVect2d[][] grid;

    public Layer2dv2(int xres, int yres) {
        grid = new LVect2d[xres][yres];
    }

    public void clear() {
        for (LVect2d[] cols : grid) {
            for (LVect2d v : cols) {
                v.x = 0;
                v.y = 0;
            }
        }
    }

    public Layer<LVect2d, CellCoordinate2d> copy() {
        int w = grid.length;
        int h = grid[0].length;
        Layer2dv2 newLayer = new Layer2dv2(w, h);
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                newLayer.grid[x][y] = grid[x][y].clone();
            }
        }
        return newLayer;
    }

    public LVect2d getData(CellCoordinate2d coord) {
        int w = grid.length;
        int h = grid[0].length;

        int x, y;
        // supid proof wrapping?
        x = (coord.x % w + w) % h;
        y = (coord.y % h + h) % h;

        return grid[x][y];
    }

    public void setData(CellCoordinate2d coord, LVect2d data) {
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
