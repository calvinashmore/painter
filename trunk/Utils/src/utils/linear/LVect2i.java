/*
 * LVect2i.java
 *
 * Created on October 11, 2006, 6:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.linear;

/**
 *
 * @author Calvin Ashmore
 */
public class LVect2i {
    
    public int x,y;
    
    public LVect2i() {x=0; y=0;}
    public LVect2i(LVect2i a) {this.x = a.x; this.y = a.y;}
    public LVect2i(int x, int y) {this.x=x; this.y=y;}
    
    public LVect2i zero() {return new LVect2i();}
    
    
    public LVect2i add(LVect2i a) {return new LVect2i(x+a.x, y+a.y);}
    public void addv(LVect2i a) {x += a.x; y += a.y;}
    
    public LVect2i sub(LVect2i a) {return new LVect2i(x-a.x, y-a.y);}
    public void subv(LVect2i a) {x -= a.x; y -= a.y;}
    
    public LVect2i mult(int c) {return new LVect2i(c*x, c*y);}
    public void multv(int c) {x *= c; y *= c;}
    
    public LVect2i normal() {return null;}
    public void normalv() {}

    public int dot(LVect2i v) {return v.x*x + v.y*y;}
    
    public double magnitude() {return Math.sqrt(x*x + y*y);}
    
    public String toString() {
        return "< "+ x + " , " + y + " >";
    }
    
    public static LVect2i parse(String s) {
        s = s.replaceAll("[<> ]","");
        String sa[] = s.split(",");
        return new LVect2i(
                Integer.parseInt(sa[0]),
                Integer.parseInt(sa[1])
                );
    }
}
