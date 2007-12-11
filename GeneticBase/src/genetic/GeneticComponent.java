/*
 * GeneticComponent.java
 *
 * Created on August 25, 2006, 4:56 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic;

/**
 *
 * @author gtg126z
 */
public interface GeneticComponent extends SetupComponent {
    
    public GeneticComponent getParent();
    public ContextModel getContextModel();
    
    public void setParent(GeneticComponent newParent);
    
    public GeneticComponent clone(GeneticComponent newParent) throws BuildException;
    public void removeVariable(String name);
    public boolean hasVariable(String name);
    public boolean hasMethod(String name);
}
