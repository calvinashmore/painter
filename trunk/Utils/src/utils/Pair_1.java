/*
 * UpdatePair.java
 *
 * Created on June 12, 2005, 6:15 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package utils;
import java.util.*;

/**
 *
 * @author Calvin Ashmore
 */
public class Pair_1<A,B>
{
    private A a;
    private B b;
    
    /** Creates a new instance of UpdatePair */
    public Pair_1(A a, B b)
    {
        this.a = a;
        this.b = b;
    }
    
    public A getLeft() {return a;}
    public B getRight() {return b;}
}
