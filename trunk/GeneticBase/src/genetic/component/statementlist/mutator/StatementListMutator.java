/*
 * StatementListMutator.java
 * 
 * Created on Nov 10, 2007, 5:02:23 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic.component.statementlist.mutator;

import genetic.component.statementlist.*;
import genetic.Mutator;

/**
 *
 * @author Calvin Ashmore
 */
public class StatementListMutator extends Mutator<StatementList> {

    public StatementListMutator() {
        getMutators().add(new InjectStatement());
        getMutators().add(new RemoveStatement());
        getMutators().add(new MutateStatement());
        getMutators().add(new ExtractVariable());
    }
}
