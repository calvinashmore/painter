/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.painter.geneticsupport.nodes;

import genetic.GeneticTopLevel;
import genetic.component.method.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openide.nodes.Node;
import utils.Pair;

/**
 *
 * @author Calvin Ashmore
 */
public class ProgramNode extends GeneticNode<GeneticTopLevel> {

    private static final String IMAGE_ICON_BASE = "com/icosilune/painter/geneticsupport/nodes/program.png";
    
    public ProgramNode(GeneticTopLevel object) {
        super(object);
        setIconBaseWithExtension(IMAGE_ICON_BASE);
        setName("Program");
    }

    @Override
    protected Node createNode(Object obj) {
        Map.Entry<String, Method> methodSignature = (Map.Entry<String, Method>)obj;
        return new MethodNode(methodSignature.getKey(), methodSignature.getValue());
    }

    @Override
    protected List getGeneticChildren() {
        List<Map.Entry<String, Method>> children =
                new ArrayList<Map.Entry<String, Method>>(getComponent().getMethods().entrySet());
        return children;
    }
}
