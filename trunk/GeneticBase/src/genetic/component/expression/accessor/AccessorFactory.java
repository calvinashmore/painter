/*
 * AccessorFactory.java
 * 
 * Created on Nov 3, 2007, 1:16:48 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package genetic.component.expression.accessor;

import genetic.util.BuildException;
import genetic.util.Factory;

/**
 *
 * @author Calvin Ashmore
 */
public class AccessorFactory implements Factory<Accessor> {

    public AccessorFactory() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Accessor shallowBuild(Class t) throws BuildException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
