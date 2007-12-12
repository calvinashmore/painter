/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.program;

import genetic.Builder;
import genetic.GeneticTopLevel;

/**
 *
 * @author Calvin Ashmore
 */
public interface ProgramBuilder extends Builder<GeneticTopLevel> {
    public GeneticTopLevel build();
}
