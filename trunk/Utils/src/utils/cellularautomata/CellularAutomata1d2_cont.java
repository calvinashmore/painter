/*
 * CellCheck.java
 *
 * Created on March 4, 2006, 10:49 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package utils.cellularautomata;

import java.util.Random;
import utils.linear.LDouble;
import utils.linear.grid.Buffer_d;

/**
 *
 * @author Calvin Ashmore
 */
public class CellularAutomata1d2_cont implements java.io.Serializable {

    public Buffer_d data;
    public int inputSize;
    public int inputOffset;
    public double weights[];

    //private double inputBuffer[];
    /** Creates a new instance of CellCheck */
    public CellularAutomata1d2_cont() {
    // leave most things null for now
    //code = new CellCode();
    }

    /*public void setInputSize(int inputSize) {
    this.inputSize = inputSize;
    code.inputs = inputSize;
    }*/
    public CellularAutomata1d2_cont(Buffer_d data, int inputSize) {
        this.data = data;
        this.inputSize = inputSize;
        //this.colors = colors;

        inputOffset = (inputSize - 1) / 2;
        //inputBuffer = new double[inputSize];

        makeCode();
    }

    public CellularAutomata1d2_cont(int inputSize, double[] weights) {
        this.inputSize = inputSize;
        //this.colors = colors;

        inputOffset = (inputSize - 1) / 2;
        //inputBuffer = new double[inputSize];
        this.weights = weights;
    }

    private double get(int x, int y) {
        int x1 = x % data.getXRes();
        if (x1 < 0) {
            x1 = x1 + data.getXRes();
        }

        return data.getValue(x1, y).val;
    }

    private double evaluate(int x, int y) {

        double r = 0;
        for (int i = 0; i < inputSize; i++) {
            double v = get(x - inputOffset + i, y - 1);
            r += weights[i] * v;

            v = get(x - inputOffset + i, y - 2);
            r += weights[i + inputSize] * v;
        }

        r += weights[2 * inputSize];
        r /= inputSize;
        r -= Math.floor(r);

        return r;
    }

    public void fill() {
        for (int x = 0; x < data.getXRes(); x++) {
            for (int y = 0; y < data.getYRes(); y++) {
                data.setValue(x, y, new LDouble(0));
            }
        }

        //data.setValue(data.getXRes()/2,0,new LDouble(1));

        Random rand = new Random();

        for (int x = 0; x < data.getXRes(); x++) {
            for (int y = 0; y < 2; y++) {
                data.setValue(x, y, new LDouble(rand.nextDouble()));
            }
        }

        for (int y = 2; y < data.getYRes(); y++) {
            for (int x = 0; x < data.getXRes(); x++) {
                data.setValue(x, y, new LDouble(evaluate(x, y)));
            }
        }
    }

    private void randomizeWeights() {

        Random rand = new Random();

        weights = new double[2 * inputSize + 1];
        for (int i = 0; i < 2 * inputSize; i++) {
            weights[i] = rand.nextDouble() * 4 - 2;
        }
        weights[2 * inputSize] = rand.nextDouble() * 2 - 1;
    }

    public void makeCode() {

        boolean okay;
        do {
            randomizeWeights();
            fill();
            okay = true;

            // do tests:
            int y = 4 * data.getYRes() / 5;

            // test single row
            for (int xoffset = -2; xoffset <= 2 && okay; xoffset++) {
                boolean same = true;
                for (int x = 0; x < data.getXRes() && same; x++) {
                    if (Math.abs(get(x, y) - get(x + xoffset, y - 1)) > .01) {
                        same = false;
                    }
                }
                if (same) {
                    okay = false;
                }
            }

            // test second row
            for (int xoffset = -2; xoffset <= 2 && okay; xoffset++) {
                boolean same = true;
                for (int x = 0; x < data.getXRes() && same; x++) {
                    if (Math.abs(get(x, y) - get(x + xoffset, y - 2)) > .01) {
                        same = false;
                    }
                }
                if (same) {
                    okay = false;
                }
            }

        } while (!okay);
    }
}
