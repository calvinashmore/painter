/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d1;

import java.util.ArrayList;
import java.util.List;
import utils.cellularautomata2.CellFunction;
import utils.cellularautomata2.CellularAutomata;
import utils.cellularautomata2.Layer;
import utils.linear.LDouble;

/**
 *
 * @author Calvin Ashmore
 */
public abstract class Discrete1d implements CellFunction<LDouble, CellCoordinate1d> {
    
    private int inputs;
    private int depth;

    /**
     * 
     * @param inputs: automatically centered (usually 3, min 2)
     * @param depth: how far back in the CA to search (min 1)
     */
    public Discrete1d(int inputs, int depth) {
        this.inputs = inputs;
        this.depth = depth;
        
        if(depth < 1 || inputs < 2)
            throw new IllegalArgumentException("badly termed CA function");
    }

    /**
     * subclasses implement this. 
     * @param data
     * @return 
     */
    public abstract LDouble evaluate(List<LDouble> data);
    
    public LDouble evaluate(CellCoordinate1d coord, CellularAutomata<LDouble, CellCoordinate1d> ca) {
        
        List<LDouble> data = new ArrayList<LDouble>();
        
        for(int layerId = 0; layerId < depth; layerId++) {
            Layer<LDouble, CellCoordinate1d> layer = ca.getLastLayer(layerId);
            
            for(int i=0;i<inputs;i++) {
                LDouble d = layer.getData(new CellCoordinate1d(i + coord.index - inputs/2));
                data.add(d);
            }
        }
        return evaluate(data);
    }
    
}
