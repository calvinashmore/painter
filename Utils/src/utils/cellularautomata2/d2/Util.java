/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d2;

import java.util.Random;
import utils.linear.LDouble;

/**
 *
 * @author Calvin Ashmore
 */
public class Util {

    /**
     * Creates a new layer of specified size with values between 0-1 populated by Math.rand()
     * @param size
     * @return 
     */
    public static Layer2d createRandomLayer(int xsize, int ysize) {
        Layer2d layer = new Layer2d(xsize, ysize);
        for (CellCoordinate2d coord : layer) {
            layer.setData(coord, new LDouble(Math.random()));
        }
        return layer;
    }

    /**
     * Creates a layer of specified size with discrete random values between 0 and maxValue-1
     * @param size
     * @param maxValue
     * @return 
     */
    public static Layer2d createRandomLayer(int xsize, int ysize, int maxValue) {
        Random rand = new Random();
        Layer2d layer = new Layer2d(xsize, ysize);
        for (CellCoordinate2d coord : layer) {
            layer.setData(coord, new LDouble(rand.nextInt(maxValue)));
        }
        return layer;
    }

    /**
     * Creates a layer of zeroes, except for a 1 at 1/2 size
     * @param size
     * @param maxValue
     * @return
     */
    public static Layer2d createSingletonLayer(int xsize, int ysize) {
        Layer2d layer = createEmptyLayer(xsize, ysize);
        CellCoordinate2d c = new CellCoordinate2d(xsize / 2, ysize / 2);
        layer.setData(c, new LDouble(1));

        return layer;
    }

    /**
     * Creates a layer of zeroes, except for a 1 at 1/2 size
     * @param size
     * @param maxValue
     * @return
     */
    public static Layer2d createEmptyLayer(int xsize, int ysize) {
        Layer2d layer = new Layer2d(xsize, ysize);
        for (CellCoordinate2d coord : layer) {
            layer.setData(coord, new LDouble(0));
        }
        return layer;
    }
}
