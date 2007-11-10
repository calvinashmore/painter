/*
 * GeneticComponent.java
 *
 * Created on August 25, 2006, 4:56 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic;

import java.io.Serializable;

/**
 *
 * @author gtg126z
 */
public interface GeneticComponent extends Serializable {
    
    public GeneticComponent getParent();
    public ContextModel getContextModel();
    
    public void resetParent(GeneticComponent newParent);
    
    public GeneticComponent clone(GeneticComponent newParent);
    public void removeVariable(String name);
}
