/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import utils.linear.Linear;

/**
 * T represents the data type that is being used: this is typically LDouble, but can be something like a vector or a color, etc.
 * Type represents the structure of the CA, eg, 1d or 2d
 * @author Calvin Ashmore
 */
public abstract class CellularAutomata<T extends Linear<T>, Coord extends CellCoordinate> {

    private CellFunction<T, Coord> function;
    private List<Layer<T, Coord>> layers = new ArrayList<Layer<T, Coord>>();

    public CellularAutomata(CellFunction<T, Coord> function) {
        this.function = function;
    }

    public void addLayer(Layer<T, Coord> layer) {
        layers.add(layer);
    }
    
    public void addLayer() {
        Layer<T, Coord> newLayer = getLastLayer(0).copy();
        newLayer.clear();

        for(Coord coord : newLayer) {
            T data = function.evaluate(coord, this);
            newLayer.setData(coord, data);
        }

        layers.add(newLayer);
    }

    public void addLayers(int numberLayers) {
        for (int i = 0; i < numberLayers; i++) {
            addLayer();
        }
    }

    /**
     * This returns the last layer of the CA. 
     * @param index
     * @return 
     */
    public Layer<T, Coord> getLastLayer(int index) {
        return layers.get(layers.size() - 1 - index);
    }

    public List<Layer<T, Coord>> getLayers() {
        return layers;
    }
}
