/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.painter.geneticsupport.nodes;

import genetic.component.expression.Expression;
import java.util.ArrayList;
import java.util.List;
import org.openide.nodes.Node;
import utils.Pair;

/**
 *
 * @author Calvin Ashmore
 */
public class ExpressionNode extends GeneticNode<Expression> {

    private static final String IMAGE_ICON_BASE = "com/icosilune/painter/geneticsupport/nodes/icons/expression.png";
    private String name;

    public ExpressionNode(Expression expression, String name) {
        super(expression);
        this.name = name;

        setIconBaseWithExtension(IMAGE_ICON_BASE);
        setName(name);
    }

    @Override
    public String getHtmlDisplayName() {
        Expression expression = getLookup().lookup(Expression.class);
        String functionName = expression.getFunction().getClass().getName();
        functionName = functionName.substring(functionName.lastIndexOf(".")+1);
        return "<b>"+name+"</b> (<i>"+expression.getOutputType().getSimpleName()+"</i>) ["+functionName+"]";
    }
    
    @Override
    protected Node createNode(Object obj) {
        Pair<String, Expression> pair = (Pair<String, Expression>) obj;
        return new ExpressionNode(pair.getRight(), pair.getLeft());
    }

    @Override
    protected List getGeneticChildren() {
        List<Pair<String, Expression>> pairs = new ArrayList<Pair<String, Expression>>();

        int numberInputs = getComponent().getNumberInputs();
        for (int i = 0; i < numberInputs; i++) {
            pairs.add(new Pair<String, Expression>(getComponent().getInputName(i), getComponent().getInput(i)));
        }
        return pairs;
    }
}
