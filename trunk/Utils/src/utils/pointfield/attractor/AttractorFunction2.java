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
abstract public class AttractorFunction2 extends AttractorFunction<APoint2d> {
    public APoint2d getNewPoint() {return new APoint2d();}
    public Quadtree makeQuadtree() {return new QT2d();}
}
