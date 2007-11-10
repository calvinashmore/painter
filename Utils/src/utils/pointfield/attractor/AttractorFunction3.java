/*
 * AttractorFunction4.java
 *
 * Created on May 10, 2006, 1:55 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package utils.pointfield.attractor;

import utils.pointfield.Quadtree;

/**
 *
 * @author gtg126z
 */
abstract public class AttractorFunction3 extends AttractorFunction<APoint3d> {
    public APoint3d getNewPoint() {return new APoint3d();}
    public Quadtree makeQuadtree() {return new QT3d();}
}
