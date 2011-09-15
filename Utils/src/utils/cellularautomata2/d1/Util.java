/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d1;

import java.util.Random;
import utils.linear.LDouble;

/**
 *
 * @author Calvin Ashmore
 */
public final class Util {
    private Util() {}
    
    /**
     * Creates a new layer of specified size with values between 0-1 populated by Math.rand()
     * @param size
     * @return 
     */
    public static Layer1d createRandomLayer(int size) {
        Layer1d layer = new Layer1d(size);
        for (CellCoordinate1d coord : layer) {
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
    public static Layer1d createRandomLayer(int size, int maxValue) {
        Random rand = new Random();
        Layer1d layer = new Layer1d(size);
        for (CellCoordinate1d coord : layer) {
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
    public static Layer1d createSingletonLayer(int size) {
        Layer1d layer = new Layer1d(size);
        for (CellCoordinate1d coord : layer) {
            layer.setData(coord, new LDouble(0));
        }
        CellCoordinate1d c = new CellCoordinate1d(size/2);
        layer.setData(c, new LDouble(1));

        return layer;
    }
}
