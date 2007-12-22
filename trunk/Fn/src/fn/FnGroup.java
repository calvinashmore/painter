/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fn;

import java.util.ArrayList;
import java.util.List;
import jd.Compilable;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class FnGroup<NodeType extends FnNode> implements Compilable{
    private List<NodeType> myNodes = new ArrayList<NodeType>();

}
