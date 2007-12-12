/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.statementlist;

import genetic.GeneticComponent;

/**
 *
 * @author Calvin Ashmore
 */
public class StatementListBuilderImpl implements StatementListBuilder {

    public StatementList build(GeneticComponent parent) {
        return new StatementList(parent);
    }

}
