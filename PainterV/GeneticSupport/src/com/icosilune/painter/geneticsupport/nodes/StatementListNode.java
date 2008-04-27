/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.painter.geneticsupport.nodes;

import genetic.component.statement.Statement;
import genetic.component.statementlist.StatementList;
import java.util.ArrayList;
import java.util.List;
import org.openide.nodes.Node;
import utils.Pair;

/**
 *
 * @author Calvin Ashmore
 */
public class StatementListNode extends GeneticNode<StatementList> {

    private static final String IMAGE_ICON_BASE = "com/icosilune/painter/geneticsupport/nodes/icons/statementList.png";
    private String statementListName;

    public StatementListNode(StatementList body, String name) {
        super(body);
        this.statementListName = name;
        setIconBaseWithExtension(IMAGE_ICON_BASE);

        setName(name);
    }

    @Override
    public String getHtmlDisplayName() {
        return "<b>" + statementListName + "</b>";
    }

    @Override
    protected Node createNode(Object obj) {
        Pair<Integer, Statement> pair = (Pair<Integer, Statement>) obj;
        return new StatementNode(pair.getRight(), pair.getLeft());
    }

    @Override
    protected List getGeneticChildren() {
        List<Pair<Integer, Statement>> pairs = new ArrayList<Pair<Integer, Statement>>();

        int i = 0;
        for (Statement statement : getComponent().getStatements()) {
            pairs.add(new Pair<Integer, Statement>(i, statement));
            i++;
        }

        return pairs;
    }
}
