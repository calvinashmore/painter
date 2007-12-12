/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.statementlist;

import genetic.Builder;
import genetic.GeneticComponent;

/**
 *
 * @author Calvin Ashmore
 */
public interface StatementListBuilder extends Builder<StatementList>{
    public StatementList build(GeneticComponent parent);
}
