/*
 * FColorGrid.java
 *
 * Created on October 21, 2005, 9:36 AM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package utils.linear.grid;

import java.awt.image.*;
import utils.linear.Color;

/**
 *
 * @author Calvin Ashmore
 */
public class FColorGrid extends ColorGrid {
    
    private transient BufferedImage myImage;
    
    /** Creates a new instance of FColorGrid */
    public FColorGrid(BufferedImage image) {
        super(1,1);
        myImage = image;
        
        values = null;
        xres = image.getWidth();
        yres = image.getHeight();
    }
    
    public Color getValue(int x, int y) {
        int icolor = myImage.getRGB(x, y);
        return Color.fromRGB(icolor);
    }
    
    public void setValue(int x, int y, Color val) {
        throw new UnsupportedOperationException();
    }
    
}
