/*
 * ProgramMutator.java
 * 
 * Created on Nov 10, 2007, 4:03:30 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.program.mutator;

import genetic.GeneticTopLevel;
import genetic.Mutator;

/**
 *
 * @author Calvin Ashmore
 */
public class ProgramMutator extends Mutator<GeneticTopLevel> {

    public ProgramMutator() {
        getMutators().add(new MutateMethod());
    }
}
