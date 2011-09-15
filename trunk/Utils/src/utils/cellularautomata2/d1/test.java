/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d1;

/**
 *
 * @author Calvin Ashmore
 */
public class test {
    public static void main(String args[]) {
        CellularAutomata1d CA = new CellularAutomata1d(null);
        CA.addLayer(Util.createRandomLayer(100));
    }
}
