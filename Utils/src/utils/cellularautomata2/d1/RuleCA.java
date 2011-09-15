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
 * @author Calvin Ashmore
 */
public class RuleCA extends Discrete1d {
    
    private final int depth, inputs;
    private int code;
    
    public RuleCA(int inputs, int depth) {
        super(inputs, depth);
        
        this.depth = depth;
        this.inputs = inputs;
    }
    
    public void setCode(int code) {this.code = code;}
    public int getMaxCode() {
        return 1 << (1 << (depth * inputs));
    }

    public void setRandomCode() {
        code = new Random().nextInt(getMaxCode());
    }

    @Override
    public LDouble evaluate(List<LDouble> data) {

        int index = 0;
        for (int i=0;i<data.size();i++) {
            LDouble v = data.get(i);
            if(v.val == 1)
                index |= 1 << i;
        }

        int value = (int) ((code >> index) & 1);

        return new LDouble(value);
    }
    
    
    
}
