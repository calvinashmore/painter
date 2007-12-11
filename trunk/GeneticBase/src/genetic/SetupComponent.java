/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

/**
 *
 * @author Calvin Ashmore
 */
public interface SetupComponent {
    public boolean isSetup();
    
    /**
     * Important note: All function components that implement this,
     * (specifically ExpressionFunction and StatementFunction) and set important
     * variables MUST test if they are already setup first before setting those
     * variables. setup() may be called multiple times after a component is already setup.
     * @throws genetic.util.BuildException
     */
    public void setup() throws BuildException;
}
