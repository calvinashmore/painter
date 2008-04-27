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

    private static final String IMAGE_ICON_BASE = "com/icosilune/painter/geneticsupport/nodes/icons/method.png";
    private String methodName;

    public MethodNode(String methodName, Method component) {
        super(component);
        this.methodName = methodName;
        setIconBaseWithExtension(IMAGE_ICON_BASE);

        setName(methodName);
    }

    @Override
    public String getHtmlDisplayName() {
        Method method = getLookup().lookup(Method.class);
        String displayName = "<b>"+methodName + "</b>(";
        for (int i = 0; i < method.getNumberArguments(); i++) {
            if (i > 0) {
                displayName += ", ";
            }
            displayName += method.getArgumentType(i).getSimpleName() + " " + method.getArgumentName(i);
        }
        displayName += ")";
        return displayName;
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
