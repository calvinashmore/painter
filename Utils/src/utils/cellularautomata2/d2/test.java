/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d2;

import utils.linear.LDouble;

/**
 *
 * @author Calvin Ashmore
 */
public class test {

    public static void main(String args[]) {
        Conway conway = new Conway();

        CellularAutomata2d CA = new CellularAutomata2d(conway);
        int res = 7;
        Layer2d layer = Util.createEmptyLayer(res, res);
        layer.setData(new CellCoordinate2d(1, 2), new LDouble(1));
        layer.setData(new CellCoordinate2d(2, 2), new LDouble(1));
        layer.setData(new CellCoordinate2d(3, 2), new LDouble(1));
        layer.setData(new CellCoordinate2d(3, 3), new LDouble(1));
        layer.setData(new CellCoordinate2d(2, 4), new LDouble(1));
        CA.addLayer(layer);

        CA.addLayer();
        CA.addLayer();
        CA.addLayer();
        CA.addLayer();
        CA.addLayer();

        for (int x = 0; x < res; x++) {
            for (int y = 0; y < res; y++) {
                LDouble val = CA.getLastLayer(0).getData(new CellCoordinate2d(x, y));
                if (val.val == 0) {
                    System.out.print("0");
                } else {
                    System.out.print("1");
                }
            }
            System.out.println();
        }
    }
}
