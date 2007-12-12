/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

/**
 *
 * @author Calvin Ashmore
 */
public class Foundation {
    private Foundation() {}
    
    private static GeneticFoundation foundation;
    public static void setInstance(GeneticFoundation foundation) {
        //if(Foundation.foundation != null)
        //    throw new IllegalStateException("setFoundation called when foundation was not null.");
        Foundation.foundation = foundation;
    }
    public static GeneticFoundation getInstance() {return foundation;}
}
