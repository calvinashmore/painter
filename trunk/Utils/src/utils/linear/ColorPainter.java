/*
 * ColorPainter.java
 *
 * Created on May 31, 2006, 3:08 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.linear;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Calvin Ashmore
 */
public class ColorPainter {
    
    private static final Color c1 = new Color(.176, .208, .522); // Ultramarine violet
    private static final Color c2 = new Color(.180, .286, .592); // Ultramarine blue
    private static final Color c3 = new Color(.059, .325, .647); // Phtalocyanine blue
    private static final Color c3a = new Color(.000, .549, .898); // 1/2
    private static final Color c4 = new Color(.051, .431, .400); // Phtalocyanine turquoise
    private static final Color c5 = new Color(.090, .400, .247); // Viridian
    private static final Color c6 = new Color(.039, .514, .224); // Permanant green, light
    private static final Color c6a = new Color(.416, .690, .043); // 1/2
    private static final Color c7 = new Color(1.100, .933, .000); // Cadmium yellow
    private static final Color c8 = new Color(.941, .506, .055); // Cadmium orange
    private static final Color c9 = new Color(.816, .169, .149); // Cadmium red-orange
    private static final Color c10 = new Color(.737, .165, .153); // Cadmium red
    private static final Color c11 = new Color(.741, .137, .196); // Alizarin crimson
    private static final Color c12 = new Color(.733, .157, .259); // Magenta
    private static final Color c12a = new Color(.357, .231, .478); // 1/2
    
    public static final List<Color> paintList = new ArrayList();
    static {
        paintList.add(c1);
        paintList.add(c2);
        paintList.add(c3);
        paintList.add(c3a);
        paintList.add(c4);
        paintList.add(c5);
        paintList.add(c6);
        paintList.add(c6a);
        paintList.add(c7);
        paintList.add(c8);
        paintList.add(c9);
        paintList.add(c10);
        paintList.add(c11);
        paintList.add(c12);
        paintList.add(c12a);
    }
    
    private static int getIWrap(int i) {
        return (i + paintList.size()) % paintList.size();
    }
    
    private static Color getIColor(double v) {
        return paintList.get( (int)(v*paintList.size()) );
    }
    
    public static double getHue(Color c) {
        double hsb[] = c.hsbvals();
        double hue = hsb[0];
        
        int index=0;
        // should count backwards
        // problem with values like 0 or 1
        for(Color paintColor : paintList) {
            if(paintColor.hsbvals()[0] < hue)
                break;
            index++;
        }
        
        double hue1 = paintList.get(index).hsbvals()[0];
        double hue2 = paintList.get((index+1)%paintList.size()).hsbvals()[0];
        
        // hue should be between hue1 and hue2
        
        double mod = (hue - hue1)/(hue2 - hue1);
        return (mod+index)/paintList.size();
    }
    
    public static Color getColor(double v) {
        v -= Math.floor(v);
        
        Color c1 = getIColor(v);
        int c1index = paintList.indexOf(c1);
        Color c0 = paintList.get( getIWrap(c1index-1) );
        Color c2 = paintList.get( getIWrap(c1index+1) );
        Color c3 = paintList.get( getIWrap(c1index+2) );
        
        v = v*paintList.size();
        v -= Math.floor(v);
        
        // now do a b-spline interpolation
        double v3 = v*v*v;
        double v2 = v*v;
        c0 = c0.mult( -v3+3*v2-3*v+1 );
        c1 = c1.mult( 3*v3-6*v2+4 );
        c2 = c2.mult( -3*v3+3*v2+3*v+1 );
        c3 = c3.mult( v3 );
        
        Color col = c0.add(c1).add(c2).add(c3).mult(1.0/6);
        return col;
    }
}
