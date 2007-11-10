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
public class CellularAutomata1d2 implements java.io.Serializable {
    
    public CellCode code;
    public Buffer_d data;
    
    //public int inputSize;
    public int inputOffset;
    //public int colors;
    
    private int inputBuffer[];
    
    /** Creates a new instance of CellCheck */
    public CellularAutomata1d2() {
        // leave most things null for now
        code = new CellCode();
    }
    
    /*public void setInputSize(int inputSize) {
        this.inputSize = inputSize;
        code.inputs = inputSize;
    }*/
    
    public CellularAutomata1d2(Buffer_d data, int inputSize, int colors) {
        this.data = data;
        //this.inputSize = inputSize;
        //this.colors = colors;
        
        inputOffset = (inputSize-1)/2;
        inputBuffer = new int[2*inputSize];
        
        makeCode(2*inputSize,colors);
    }
    
    public CellularAutomata1d2(int inputSize, int colors, byte[] codedata) {
        inputOffset = (inputSize-1)/2;
        inputBuffer = new int[inputSize];
        
        code = new CellCode();
        code.inputs = inputSize;
        code.colors = colors;
        code.data = codedata;
    }
    
    private double get(int x, int y) {
        int x1 = x % data.getXRes();
        if(x1<0)
            x1 = x1+data.getXRes();
        
        return data.getValue(x1 ,y).val;
    }
    
    private double evaluate(int x, int y) {
        
        for(int i=0;i<code.inputs/2;i++) {
            inputBuffer[i] = (int) (get(x-inputOffset+i,y-1) * (code.colors-1));
            inputBuffer[i+code.inputs/2] = (int) (get(x-inputOffset+i,y-2) * (code.colors-1));
        }
        
        return code.evaluate(inputBuffer)/(code.colors-1.0);
    }
    
    public void fill() {
        for(int x=0;x<data.getXRes();x++)
        for(int y=0;y<data.getYRes();y++)
            data.setValue(x,y, new LDouble(0));
        
        //data.setValue(data.getXRes()/2,0,new LDouble(1));
        
        Random rand = new Random();
        
        for(int x=0;x<data.getXRes();x++)
        for(int y=0;y<2;y++)
            data.setValue(x,y, new LDouble( rand.nextInt(code.colors) / (code.colors-1.0) ));
        
        for(int y=2;y<data.getYRes();y++)
        for(int x=0;x<data.getXRes();x++)
            data.setValue(x,y, new LDouble(evaluate(x,y)));
    }

    private void makeCode(int inputSize, int colors) {
        
        boolean okay;
        do {
            code = new CellCode(inputSize,colors);
            fill();
            okay = true;
            
            // do tests:
            int y = 4*data.getYRes()/5;
            
            // test single row
            for(int xoffset=-2; xoffset<=2 && okay; xoffset++) {
                boolean same = true;
                for(int x=0;x<data.getXRes() && same;x++) {
                    if(get(x,y) != get(x+xoffset,y-1))
                        same = false;
                }
                if(same)
                    okay = false;
            }
            
            // test second row
            for(int xoffset=-2; xoffset<=2 && okay; xoffset++) {
                boolean same = true;
                for(int x=0;x<data.getXRes() && same;x++) {
                    if(get(x,y) != get(x+xoffset,y-2))
                        same = false;
                }
                if(same)
                    okay = false;
            }
            
        } while(!okay);
        
    }
}
