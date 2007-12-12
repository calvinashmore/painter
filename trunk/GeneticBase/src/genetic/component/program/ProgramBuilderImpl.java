/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.program;

import genetic.GeneticTopLevel;

/**
 *
 * @author Calvin Ashmore
 */
public class ProgramBuilderImpl implements ProgramBuilder {

    public GeneticTopLevel build() {
        return new Program();
    }

}
