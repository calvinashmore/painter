/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.painter.geneticsupport.nodes;

import genetic.GeneticComponent;
import genetic.component.expression.Expression;
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
public class StatementNode extends GeneticNode<Statement> {

    private static final String IMAGE_ICON_BASE = "com/icosilune/painter/geneticsupport/nodes/icons/statement.png";
    private int index;
    
    public StatementNode(Statement statement, int index) {
        super(statement);
        setIconBaseWithExtension(IMAGE_ICON_BASE);
        this.index = index;
    }

    @Override
    public String getHtmlDisplayName() {
        Statement statement = getLookup().lookup(Statement.class);
        String name = statement.getFunction().getName();
        return "[<b>"+index+"</b>] "+name.substring(name.lastIndexOf(".")+1);
    }
    
    private Node createNode(GeneticComponent component, String inputName) {
        if (component instanceof Expression) {
            return new ExpressionNode((Expression) component, inputName);
        } else if (component instanceof StatementList) {
            return new StatementListNode((StatementList) component, inputName);
        } else {
            throw new IllegalArgumentException("child " + component + " is not an acceptable child for a StatementNode");
        }
    }

    @Override
    protected Node createNode(Object obj) {
        Pair<GeneticComponent, String> pair = (Pair<GeneticComponent, String>)obj;
        return createNode(pair.getLeft(), pair.getRight());
    }

    @Override
    protected List getGeneticChildren() {
        List<Pair<GeneticComponent, String>> pairs = new ArrayList<Pair<GeneticComponent, String>>();

        int numberInputs = getComponent().getFunction().getNumberInputs();
        for (int i = 0; i < numberInputs; i++) {
            pairs.add(new Pair(
                    getComponent().getInput(i),
                    getComponent().getFunction().getInputName(i)));
        }
        return pairs;
    }
}
