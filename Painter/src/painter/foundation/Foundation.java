/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package painter.foundation;

import genetic.foundation.GeneticFoundationImpl;

/**
 *
 * @author Calvin Ashmore
 */
public class Foundation extends GeneticFoundationImpl {

    private TypeSystem typeSystem = new TypeSystem();

    @Override
    public TypeSystem getTypeSystem() {
        return typeSystem;
    }
}
