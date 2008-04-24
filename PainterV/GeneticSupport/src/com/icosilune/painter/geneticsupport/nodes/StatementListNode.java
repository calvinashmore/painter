/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.painter.geneticsupport.nodes;

import genetic.component.statement.Statement;
import genetic.component.statementlist.StatementList;
import java.util.List;
import org.openide.nodes.Node;

/**
 *
 * @author Calvin Ashmore
 */
public class StatementListNode extends GeneticNode<StatementList> {

    private static final String IMAGE_ICON_BASE = "com/icosilune/painter/geneticsupport/nodes/statementList.png";
    private String statementListName;

    public StatementListNode(StatementList body, String name) {
        super(body);
        this.statementListName = name;
        setIconBaseWithExtension(IMAGE_ICON_BASE);
    }

    @Override
    protected Node createNode(Object obj) {
        Statement statement = (Statement) obj;
        return new StatementNode(statement);
    }

    @Override
    protected List getGeneticChildren() {
        return getComponent().getStatements();
    }
}
