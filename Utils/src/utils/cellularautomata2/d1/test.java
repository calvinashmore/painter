/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d1;

import utils.cellularautomata2.Layer;
import utils.linear.LDouble;

/**
 *
 * @author Calvin Ashmore
 */
public class test {
    public static void main(String args[]) {

//        RuleCA function = new RuleCA(3, 1);
//        System.out.println(function.getMaxCode());
//        function.setCode(30);

        ByteCA function = new ByteCA(3, 2, 3);
        function.setRandomCode();

        CellularAutomata1d CA = new CellularAutomata1d(function);
        CA.addLayer(Util.createRandomLayer(100,3));
        CA.addLayer(Util.createRandomLayer(100,3));
//        CA.addLayer(Util.createSingletonLayer(100));
        
        //CA.addLayer();
        CA.addLayers(5);

        for (Layer<LDouble, CellCoordinate1d> layer : CA.getLayers()) {
            for (CellCoordinate1d coord : layer) {
                LDouble bit = layer.getData(coord);
                if(bit.val == 0.0)
                    System.out.print(0);
                else if(bit.val == 1)
                    System.out.print(1);
                else if(bit.val == 2)
                    System.out.print(2);
            }
            System.out.println();
        }
    }
}
