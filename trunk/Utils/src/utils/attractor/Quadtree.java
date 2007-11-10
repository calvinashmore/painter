/*
 * Quadtree.java
 *
 * Created on May 10, 2006, 5:00 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.attractor;

import java.util.List;

/**
 *
 * @author gtg126z
 */
public class Quadtree {

    private final int maxDepth;
    
    /** Creates a new instance of Quadtree */
    public Quadtree() {
        maxDepth = 7; // ???
    }
    
    protected class TreeCell {
        private TreeCell c00, c10, c01, c11;
        private List contents;
        private int depth;
        
        
    }
}
