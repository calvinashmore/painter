/*
 * ColorGrid.java
 *
 * Created on October 1, 2005, 1:22 AM
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
public class ColorGrid extends ArrayGrid<Color>{
    
    /** Creates a new instance of ColorGrid */
    public ColorGrid(int xres, int yres) {
        super(xres,yres, new Color());
    }
    
    public ColorGrid(ArrayGrid<Color> cg) {
        super(cg.xres,cg.yres, new Color());
        
        for(int x=0;x<xres;x++)
        for(int y=0;y<yres;y++)
            this.values[x][y] = new Color(cg.values[x][y]);
    }
    
    public Color maxColor() {
        
        Color col = new Color(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);
        
        for(int i=0;i<xres;i++)
        for(int j=0;j<yres;j++)
        {
            Color a = values[i][j];
            if(a.r > col.r)
                col.r = a.r;
            if(a.g > col.g)
                col.g = a.g;
            if(a.b > col.b)
                col.b = a.b;
        }
        return col;
    }
    
    public Color minColor() {
        
        Color col = new Color(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        
        for(int i=0;i<xres;i++)
        for(int j=0;j<yres;j++)
        {
            Color a = values[i][j];
            if(a.r < col.r)
                col.r = a.r;
            if(a.g < col.g)
                col.g = a.g;
            if(a.b < col.b)
                col.b = a.b;
        }
        return col;
    }
    
    public void balance() {
        
        Color min = minColor();
        Color max = maxColor();
        
        Color diff = max.sub(min);
        double mag = diff.magnitude();
        
        if(mag == 0)
            return;
        
        double invmag = 1/mag;
        
        for(int i=0;i<xres;i++)
        for(int j=0;j<yres;j++)
        {
            values[i][j].subv(min);
            values[i][j].multv(invmag);
        }
        
    }
    
    public BufferedImage makeImage() {
        
        BufferedImage img = new BufferedImage(xres,yres, BufferedImage.TYPE_INT_ARGB);
        
        for(int y=0; y<yres; y++)
        for(int x=0; x<xres; x++) {
            
            Color color = values[x][y];
            
            img.setRGB(x, y, color.toARGB());
        }
        
        return img;
    }
    
    public static ColorGrid decodeImage(BufferedImage img) {
        
        int xres = img.getWidth();
        int yres = img.getHeight();
        
        ColorGrid r = new ColorGrid(xres,yres);
        
        for(int y=0; y<yres; y++)
        for(int x=0; x<xres; x++) {
            
            int icolor = img.getRGB(x, y);
            Color color = Color.fromRGB(icolor);
            
            r.values[x][y] = color;
            
        }
        
        return r;
    }
}
