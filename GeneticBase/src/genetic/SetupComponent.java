/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic;

import genetic.util.BuildException;

/**
 *
 * @author Calvin Ashmore
 */
public interface SetupComponent {
    public boolean isSetup();
    public void setup() throws BuildException;
}
