/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.cellularautomata2.d1;

/**
 *
 * @author Calvin Ashmore
 */
public class RuleCA extends Discrete1d {
    
    private int colors, depth, inputs;
    private long code;
    
    public RuleCA(int inputs, int colors, int depth) {
        super(inputs, depth);
        
        this.colors = colors;
        this.depth = depth;
        this.inputs = inputs;
    }
    
    public void setCode(long code) {this.code = code;}
    public long getMaxCode() {
        
    }
    
    
    
}
