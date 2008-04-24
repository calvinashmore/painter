/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.painter.geneticsupport.nodes;

import genetic.component.method.Method;
import genetic.component.statementlist.StatementList;
import java.util.Collections;
import java.util.List;
import org.openide.nodes.Node;

/**
 *
 * @author Calvin Ashmore
 */
public class MethodNode extends GeneticNode<Method> {

    private static final String IMAGE_ICON_BASE = "com/icosilune/painter/geneticsupport/nodes/method.png";
    private String methodName;

    public MethodNode(String methodName, Method component) {
        super(component);
        this.methodName = methodName;
        setIconBaseWithExtension(IMAGE_ICON_BASE);
    }

    @Override
    protected Node createNode(Object obj) {
        StatementList sl = (StatementList) obj;
        return new StatementListNode(sl, "body");
    }

    @Override
    protected List getGeneticChildren() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return Collections.singletonList(getComponent().getBody());
    }
}
