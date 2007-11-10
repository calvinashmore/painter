/*
 * CellCode.java
 *
 * Created on March 4, 2006, 1:36 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.cellularautomata;

/**
 *
 * @author Calvin Ashmore
 */
public class CellCode implements java.io.Serializable{
    
    public int inputs;
    public int colors;
    
    public byte data[];
    
    //public byte[] getData() {return data;}
    
    /** Creates a new instance of CellCode */
    
    public CellCode() {}
    
    public CellCode(int inputs, int colors, byte[] data) {
        this.inputs = inputs;
        this.colors = colors;
        this.data = data;
    }
    
    public CellCode(int inputs, int colors) {
        this.inputs = inputs;
        this.colors = colors;
        
        int dataSize = (int)Math.pow(colors+1, inputs);
        data = new byte[ dataSize ];
        
        java.util.Random rand = new java.util.Random();
        rand.nextBytes(data);
        
        //for(int i=0;i<dataSize;i++)
        //    data[i] |= (byte)rand.nextInt();
    }
    
    public static int getSize(int inputs, int colors) {
        int dataSize = (int)Math.pow(colors+1, inputs);
        return dataSize;
    }
    
    public int evaluate(int inputValues[]) {
        int inputCode = 0;
        for(int i=0;i<inputs;i++)
            inputCode += inputValues[i] * (int)Math.pow(colors,i);
        return getCase(inputCode);
    }
    
    public int getCase(int caseCode) {
        // be lazy about it, for now
        return (data[caseCode]+256) % colors;
    }
}
