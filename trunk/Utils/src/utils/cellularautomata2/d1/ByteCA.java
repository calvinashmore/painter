/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d1;

import java.util.List;
import java.util.Random;
import utils.linear.LDouble;

/**
 *
 * @author Calvin
 */
public class ByteCA extends Discrete1d {

    private final int colors, depth, inputs;
    private byte[] code;

    public ByteCA(int colors, int depth, int inputs) {
        super(inputs, depth);
        this.colors = colors;
        this.depth = depth;
        this.inputs = inputs;

        int datasize = (int) Math.pow(colors, depth * inputs);
        code = new byte[datasize];
    }

    public byte[] getCode() {
        return code;
    }

    public void setRandomCode() {
        Random random = new Random();
        random.nextBytes(code);
    }

    @Override
    public LDouble evaluate(List<LDouble> data) {

        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            LDouble v = data.get(i);

            index += (int) v.val * Math.pow(colors, i);
        }

        int value = code[index];
        value %= colors;
        if (value < 0) {
            value += colors;
        }

        return new LDouble(value);
    }
}
